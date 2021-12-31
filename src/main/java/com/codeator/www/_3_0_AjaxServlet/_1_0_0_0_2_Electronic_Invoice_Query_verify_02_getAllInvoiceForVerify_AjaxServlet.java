/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.alahram.constants.InvoiceDocumentConstants;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMaster;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterItem;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterStatus;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterTax;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterDao;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterItemDAO;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterStatusDAO;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterTaxDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_001_document;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_003_receiver;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_004_address;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_008_invoiceLine;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_009_unitValue;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_010_discount;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_012_taxableItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
public class _1_0_0_0_2_Electronic_Invoice_Query_verify_02_getAllInvoiceForVerify_AjaxServlet extends HttpServlet {

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
        new HibernateSessionCon().clearConn();
        try {
            PerEmploymentMaster employee_session = (PerEmploymentMaster) request.getSession().getAttribute("employee_session");
            if (employee_session == null) {
                throw new Exception();
            }
            // logic Business
            //List<PhotoInsertDataJasonFileClass> articles = new LinkedList<PhotoInsertDataJasonFileClass>();

            /*BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            String json = "";
            if (br != null) {
                json = br.readLine();
                //System.out.println(json);
            }
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();*/
            // 3. Convert received JSON to Article
            String deptId = request.getParameter("deptId");
            String sectionId = request.getParameter("sectionId");
            String accUnitId = request.getParameter("accUnitId");
            String documentStatus_screen = request.getParameter("documentStatus");

            List<String> documentStatus = new ArrayList<String>();/* {
                {
                    //add("6");//تمت المراجعة
                    add(documentStatus_screen);//تمت المراجعة

                    add("10");// invalid
                    add("16");//مرتجع مراجعة
                }
            };*/

            if (documentStatus_screen.equals("7")) {
                documentStatus.add("7");
                documentStatus.add("16");
            } else {
                documentStatus.add("6");
                documentStatus.add("10");

            }
            _200_Submit_Documents_001_document[] _200_Submit_Documents_001_document_arr
                    = new _1_0_0_0_2_Electronic_Invoice_Query_Ajax_0_getAllInvoice_Class()
                            .getMultiInvoices(deptId, sectionId, accUnitId, documentStatus, "internalId");

            if (documentStatus_screen.equals("7")) {
                InvoInvoiceMasterStatusDAO dao = new InvoInvoiceMasterStatusDAO();
                int i = 0;
                for (_200_Submit_Documents_001_document submit_Documents_001_document : _200_Submit_Documents_001_document_arr) {
                    String deptId_temp = submit_Documents_001_document.getDeptOld();
                    String sectionId_temp = submit_Documents_001_document.getSectionOld();
                    String accUnitId_temp = submit_Documents_001_document.getAccUnitId();
                    String invoSp_temp = submit_Documents_001_document.getInvSp();

                    System.out.println("deptId_temp : " + deptId_temp);
                    System.out.println("sectionId_temp : " + sectionId_temp);
                    System.out.println("accUnitId_temp : " + accUnitId_temp);
                    System.out.println("invoSp_temp : " + invoSp_temp);

                    List<InvoInvoiceMasterStatus> pList = dao.documentsLastVerifyLog(accUnitId_temp, deptId_temp, sectionId_temp, invoSp_temp, documentStatus_screen);

                    if (pList.isEmpty()) {
                        _200_Submit_Documents_001_document_arr[i].setEmployeeNameWhoLastVerify(null);
                        _200_Submit_Documents_001_document_arr[i].setEmployeeNoWhoLastVerify(null);
                    } else {
                        InvoInvoiceMasterStatus invoiceLastVerifyLog = pList.get(0);

                        boolean allowUnVerify = invoiceLastVerifyLog.getPerEmploymentMaster().getEmployeeId() == employee_session.getEmployeeId();
                        _200_Submit_Documents_001_document_arr[i].setAllowUnVerify("" + allowUnVerify);
                        _200_Submit_Documents_001_document_arr[i].setEmployeeNameWhoLastVerify(invoiceLastVerifyLog.getPerEmploymentMaster().getEmpAname());
                        _200_Submit_Documents_001_document_arr[i].setEmployeeNoWhoLastVerify("" + invoiceLastVerifyLog.getPerEmploymentMaster().getEmployeeId());
                    }
                    i++;
                }
            }
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();
            String json = "";
            json = mapper.writeValueAsString(_200_Submit_Documents_001_document_arr);
            //System.out.println("json : " + json);
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
