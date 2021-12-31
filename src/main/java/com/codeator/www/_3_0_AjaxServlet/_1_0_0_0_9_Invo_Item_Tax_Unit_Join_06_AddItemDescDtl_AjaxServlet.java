/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvItemCode;
import com.codeator.www._1_2_DB_entities.InvoAccUintDept;
import com.codeator.www._1_2_DB_entities.InvoDeptItemJoin;
import com.codeator.www._1_2_DB_entities.InvoDeptItemJoinDescDtl;
import com.codeator.www._1_2_DB_entities.InvoDeptItemJoinId;
import com.codeator.www._1_2_DB_entities.InvoItemCode;
import com.codeator.www._1_2_DB_entities.PerDeptOld;
import com.codeator.www._1_3_DB_daos.InvoAccUintDeptDao;
import com.codeator.www._1_3_DB_daos.InvoItemCodeDAO;
import com.codeator.www._1_3_DB_daos.InvoDeptItemJoinDao;
import com.codeator.www._1_3_DB_daos.InvoDeptItemJoinDescDtlDAO;
import com.codeator.www._1_3_DB_daos.PerDeptOldDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
public class _1_0_0_0_9_Invo_Item_Tax_Unit_Join_06_AddItemDescDtl_AjaxServlet extends HttpServlet {

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
            String itemCode = request.getParameter("itemCode");
            String aItemDesc = request.getParameter("aItemDesc");
            String eItemDesc = request.getParameter("eItemDesc");
            String itemBarcode = request.getParameter("itemBarcode");

            new HibernateSessionCon().beginTrans();
            List<InvoDeptItemJoin> InvoDeptItemJoinList = new InvoDeptItemJoinDao().GetInvoDeptItemJoinById(itemCode,accUnitId, deptId, sectionId);

            InvoDeptItemJoin invoDeptItemJoin;
            if (!InvoDeptItemJoinList.isEmpty() && (aItemDesc.equals("") && eItemDesc.equals(""))) {
                throw new Exception("alreadyExist");
            } else if (!InvoDeptItemJoinList.isEmpty()) {
                invoDeptItemJoin = InvoDeptItemJoinList.get(0);
            } else {
                System.out.println("//////////////////////////////////////////////////////////////////////");
                InvoDeptItemJoinId id = new InvoDeptItemJoinId(Integer.parseInt(sectionId), Integer.parseInt(deptId), itemCode, accUnitId);

                List<InvoAccUintDept> PerDeptOldList = new InvoAccUintDeptDao().GetInvoAccUintInDeptAndUnit(accUnitId, sectionId, deptId);
                InvoAccUintDept dept = PerDeptOldList.get(0);

                List<InvoItemCode> InvItemCodeList = new InvoItemCodeDAO().GetInvItemCodeByItemCode(itemCode);
                InvoItemCode item = InvItemCodeList.get(0);

                invoDeptItemJoin = new InvoDeptItemJoin(id, item, dept);

                InvoDeptItemJoinDao dao = new InvoDeptItemJoinDao();
                dao.save(invoDeptItemJoin);
            }

            /////////////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////////////////
            ///////////////////////          Detail        /////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////////////////
            if (!aItemDesc.equals("") || !eItemDesc.equals("")) {
                long itemSeq = new InvoDeptItemJoinDescDtlDAO<>().GetMaxsuppSeqBr();
                InvoDeptItemJoinDescDtl invoDeptItemJoinDescDtl = new InvoDeptItemJoinDescDtl(itemSeq, invoDeptItemJoin);

                invoDeptItemJoinDescDtl.setAItemDesc(aItemDesc);
                invoDeptItemJoinDescDtl.setEItemDesc(eItemDesc);
                invoDeptItemJoinDescDtl.setItemBarcode(itemBarcode);
                invoDeptItemJoinDescDtl.setAItemDesc(aItemDesc);

                invoDeptItemJoinDescDtl.setInvoDeptItemJoin(invoDeptItemJoin);

                //new HibernateSessionCon().beginTrans();
                new InvoDeptItemJoinDescDtlDAO().insert(invoDeptItemJoinDescDtl);
            }

            new HibernateSessionCon().CommitTrans();
            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
            new HibernateSessionCon().RollBack();
            String message = e.getMessage();
            if (message.equals("alreadyExist")) {
                message = "هذا الصنف مسجل بالفعل لدى الادارة";
            } else {
                message = "Error";
            }
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
