/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvItemCode;
import com.codeator.www._1_2_DB_entities.InvoDeptItemJoin;
import com.codeator.www._1_2_DB_entities.InvoDeptItemJoinDescDtl;
import com.codeator.www._1_3_DB_daos.InvoItemCodeDAO;
import com.codeator.www._1_3_DB_daos.InvoDeptItemJoinDao;
import com.codeator.www._1_3_DB_daos.InvoDeptItemJoinDescDtlDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_008_invoiceLine;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._201_itemDescDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
public class _1_0_0_0_9_Invo_Item_Tax_Unit_Join_05_getAllItemsDtl_AjaxServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected synchronized void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        new HibernateSessionCon().OpenCon();
        try {

            String deptId = request.getParameter("deptId");
            String sectionId = request.getParameter("sectionId");
            String accUnitId = request.getParameter("accUnitId");
            //String locationCode = "0";
            /*BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            String json = "";
            if (br != null) {
                json = br.readLine();
                //System.out.println(json);
            }
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();

            // 3. Convert received JSON to Article
            _0_0_0_4_0_0_PerDecisionSheet_1_JasonFile perDecisionSheet_1_JasonFile = mapper.readValue(json, _0_0_0_4_0_0_PerDecisionSheet_1_JasonFile.class);
             */

            List<InvoDeptItemJoin> pList = new InvoDeptItemJoinDao().GetAllInvoDeptItemJoin(accUnitId, sectionId, deptId);
            //List<InvoDeptItemJoin> pList = new InvoDeptItemJoinDao().GetAllInvoDeptItemJoinWhichHaveDtl(sectionId, deptId);
            _200_Submit_Documents_008_invoiceLine[] _200_Submit_Documents_008_invoiceLine = new _200_Submit_Documents_008_invoiceLine[pList.size()];

            int i = 0;
            for (InvoDeptItemJoin invoDeptItemJoin : pList) {
                _200_Submit_Documents_008_invoiceLine items = new _200_Submit_Documents_008_invoiceLine();

                items.setItemCode(invoDeptItemJoin.getInvoItemCode().getItemCode());
                items.setDescription(invoDeptItemJoin.getInvoItemCode().getAItemName());

                List<_201_itemDescDetails> itemDescDetails = new ArrayList<>();
                //List<InvoDeptItemJoinDescDtl> vList = new InvoDeptItemJoinDescDtlDAO().GetInvoItemCodeDescByItemCode(itemCode, deptId, sectionId);
                Set<InvoDeptItemJoinDescDtl> join_dtl = invoDeptItemJoin.getInvoDeptItemJoinDescDtls();
                if (join_dtl.isEmpty()) {
                    _201_itemDescDetails itemDesc_dtl1 = new _201_itemDescDetails(Long.parseLong("0"), "-", "-", "-");
                    itemDescDetails.add(itemDesc_dtl1);
                } else {
                    for (InvoDeptItemJoinDescDtl dtl : join_dtl) {

                        _201_itemDescDetails itemDesc_dtl = new _201_itemDescDetails(dtl.getItemSeq(), dtl.getAItemDesc(), dtl.getEItemDesc(), dtl.getItemBarcode());
                        itemDesc_dtl.setSectionNoOld("" + dtl.getInvoDeptItemJoin().getId().getSectionNoOld());
                        itemDesc_dtl.setDepNoOld("" + dtl.getInvoDeptItemJoin().getId().getDepNoOld());
                        itemDesc_dtl.setAccUnit(dtl.getInvoDeptItemJoin().getId().getAccUnitCode());
                        
                        itemDescDetails.add(itemDesc_dtl);
                    }
                }

                items.setItemDescDetails(itemDescDetails);
                _200_Submit_Documents_008_invoiceLine[i] = items;
                i++;

            }
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(_200_Submit_Documents_008_invoiceLine);
            //System.out.println(pList.size());
            // success
            response.setContentType("application/json");
            response.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error");
        }

        new HibernateSessionCon().clearConn();
        new HibernateSessionCon().closeConn();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
