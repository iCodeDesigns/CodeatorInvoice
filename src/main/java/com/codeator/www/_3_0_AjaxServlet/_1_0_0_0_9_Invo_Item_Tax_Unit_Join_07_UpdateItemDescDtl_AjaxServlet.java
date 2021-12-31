/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoDeptItemJoin;
import com.codeator.www._1_2_DB_entities.InvoDeptItemJoinDescDtl;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterItem;
import com.codeator.www._1_3_DB_daos.InvoDeptItemJoinDao;
import com.codeator.www._1_3_DB_daos.InvoDeptItemJoinDescDtlDAO;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterItemDAO;
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
public class _1_0_0_0_9_Invo_Item_Tax_Unit_Join_07_UpdateItemDescDtl_AjaxServlet extends HttpServlet {

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
            String itemSeq = request.getParameter("itemSeq");
            String aItemDesc = request.getParameter("aItemDesc");
            String eItemDesc = request.getParameter("eItemDesc");
            String itemBarcode = request.getParameter("itemBarcode");

            List<InvoDeptItemJoinDescDtl> invoDeptItemJoinDescDtl = new InvoDeptItemJoinDescDtlDAO().GetInvoItemCodeDescByDescSeq(itemSeq);
            if (invoDeptItemJoinDescDtl.isEmpty()) {
                throw new Exception();
            }
            
            List<InvoInvoiceMasterItem> invoInvoiceMasterItem = new InvoInvoiceMasterItemDAO().GetInvInvoiceMasterItemByItemDescSeq(itemSeq);
            if (!invoInvoiceMasterItem.isEmpty()) {
                throw new Exception("Item Desc In InvoItem");
            }

            InvoDeptItemJoinDescDtl idijdd = invoDeptItemJoinDescDtl.get(0);

            idijdd.setAItemDesc(aItemDesc);
            idijdd.setEItemDesc(eItemDesc);
            idijdd.setItemBarcode(itemBarcode);

            new HibernateSessionCon().beginTrans();
            new InvoDeptItemJoinDescDtlDAO().update(idijdd);

            new HibernateSessionCon().CommitTrans();
            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
            new HibernateSessionCon().RollBack();
            String message = e.getMessage();
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
