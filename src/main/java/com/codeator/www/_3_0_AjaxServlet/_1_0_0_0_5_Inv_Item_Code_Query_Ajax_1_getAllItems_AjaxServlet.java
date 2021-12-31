/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvItemCode;
import com.codeator.www._1_2_DB_entities.InvoItemCode;
import com.codeator.www._1_3_DB_daos.InvoItemCodeDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_001_document;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_008_invoiceLine;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
public class _1_0_0_0_5_Inv_Item_Code_Query_Ajax_1_getAllItems_AjaxServlet extends HttpServlet {

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
            // logic Business
            //List<PhotoInsertDataJasonFileClass> articles = new LinkedList<PhotoInsertDataJasonFileClass>();

            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            String json = "";
            if (br != null) {
                json = br.readLine();
                //////System.out.println(json);
            }
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();

            // 3. Convert received JSON to Article
            List<InvoItemCode> iicList = new InvoItemCodeDAO().GetInvItemCode();
            _200_Submit_Documents_008_invoiceLine[] _200_Submit_Documents_008_invoiceLine_arr = new _200_Submit_Documents_008_invoiceLine[iicList.size()];

            int i = 0;
            for (InvoItemCode iic : iicList) {
                _200_Submit_Documents_008_invoiceLine _200_Submit_Documents_008_invoiceLine2 = new _200_Submit_Documents_008_invoiceLine();
                _200_Submit_Documents_008_invoiceLine2.setInternalCode(iic.getInternalItemCode());

                _200_Submit_Documents_008_invoiceLine2.setLineNumber(iic.getAItemName());
                //_200_Submit_Documents_008_invoiceLine2.setItemCode(iic.getEItemName());
                _200_Submit_Documents_008_invoiceLine2.setItemCode(iic.getItemCode());
                _200_Submit_Documents_008_invoiceLine2.setItemType(iic.getCodeType());
                _200_Submit_Documents_008_invoiceLine2.setDescription(iic.getAItemDesc());

                _200_Submit_Documents_008_invoiceLine_arr[i] = _200_Submit_Documents_008_invoiceLine2;
                i++;

            }
            json = mapper.writeValueAsString(_200_Submit_Documents_008_invoiceLine_arr);
            // success
            response.getWriter().write(json);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error");
        }
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
