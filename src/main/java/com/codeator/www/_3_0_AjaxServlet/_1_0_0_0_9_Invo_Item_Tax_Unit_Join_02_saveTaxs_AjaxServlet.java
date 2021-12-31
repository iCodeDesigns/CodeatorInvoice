/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoAccUintDept;
import com.codeator.www._1_2_DB_entities.InvoDeptTaxJoin;
import com.codeator.www._1_2_DB_entities.InvoDeptTaxJoinId;
import com.codeator.www._1_2_DB_entities.InvoTaxTypeDtl;
import com.codeator.www._1_2_DB_entities.PerDeptOld;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_3_DB_daos.InvoAccUintDeptDao;
import com.codeator.www._1_3_DB_daos.InvoDeptTaxJoinDAO;
import com.codeator.www._1_3_DB_daos.InvoTaxTypeDtlDAO;
import com.codeator.www._1_3_DB_daos.PerDeptOldDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_012_taxableItem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
public class _1_0_0_0_9_Invo_Item_Tax_Unit_Join_02_saveTaxs_AjaxServlet extends HttpServlet {

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
            PerEmploymentMaster employee_session = (PerEmploymentMaster) request.getSession().getAttribute("employee_session");
            if (employee_session == null) {
                throw new Exception();
            }
            //String locationCode = "0";
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            String json = "";
            if (br != null) {
                json = br.readLine();
                //System.out.println(json);
            }
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();

            // 3. Convert received JSON to Article
            _200_Submit_Documents_012_taxableItem[] taxesSelected = mapper.readValue(json, _200_Submit_Documents_012_taxableItem[].class);

            String sectionId = request.getParameter("sectionId");
            String deptId = request.getParameter("deptId");
            String accUnitId = request.getParameter("accUnitId");

            List<InvoAccUintDept> deptList = new InvoAccUintDeptDao<>().GetInvoAccUintInDeptAndUnit(accUnitId, sectionId, deptId);
            if (deptList.isEmpty()) {
                throw new Exception();
            }
            InvoAccUintDept deptOld = deptList.get(0);

            InvoDeptTaxJoinDAO dao = new InvoDeptTaxJoinDAO();
            List<InvoDeptTaxJoin> pList = dao.GetSelectedTaxInDept(accUnitId, sectionId, deptId);
            new HibernateSessionCon().beginTrans();
            for (InvoDeptTaxJoin p : pList) {
                dao.delete(p);
            }
            for (_200_Submit_Documents_012_taxableItem taxSelected : taxesSelected) {
                InvoDeptTaxJoin p = new InvoDeptTaxJoin();
                InvoDeptTaxJoinId id = new InvoDeptTaxJoinId(
                        Long.parseLong(taxSelected.getDeptId()),
                        Integer.parseInt(taxSelected.getSectionId()),
                        taxSelected.getTaxType(),
                        taxSelected.getSubType(),
                        accUnitId);
                System.out.println("/*/*/*/*/*/*/*/*" + taxSelected.getAccUnitId());
                p.setId(id);

                List<InvoTaxTypeDtl> subtypeList = new InvoTaxTypeDtlDAO<>().GetInvTaxSubtypeById(taxSelected.getTaxType(), taxSelected.getSubType());
                if (subtypeList.isEmpty()) {
                    throw new Exception();
                }
                InvoTaxTypeDtl invoTaxTypeDtl = subtypeList.get(0);
                p.setInvoTaxTypeDtl(invoTaxTypeDtl);
                p.setInvoAccUintDept(deptOld);

                p.setTaxNickname(taxSelected.getSubTypeNickName());
                p.setRate(BigDecimal.valueOf(taxSelected.getRate()));
                dao.insert(p);
            }
            new HibernateSessionCon().CommitTrans();
            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
            new HibernateSessionCon().RollBack();
            String message = e.getMessage();
            message = "Error";
            response.getWriter().write(message);
        }

        new HibernateSessionCon().closeConn();
        //new HibernateSessionCon().clearConn();
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
