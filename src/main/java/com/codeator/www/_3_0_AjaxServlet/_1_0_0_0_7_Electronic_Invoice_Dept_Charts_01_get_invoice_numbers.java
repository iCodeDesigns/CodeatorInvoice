/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoDocumentStatus;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMaster;
import com.codeator.www._1_3_DB_daos.InvInvoiceMasterDao;
import com.codeator.www._1_3_DB_daos.InvoDocumentStatusDAO;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterDao;
import com.codeator.www._5_0_DashboardsModulesBean._01_invoice_json_charts;
import com.codeator.www._5_0_DashboardsModulesBean._02_invoice_json_charts;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
public class _1_0_0_0_7_Electronic_Invoice_Dept_Charts_01_get_invoice_numbers extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        new HibernateSessionCon().OpenCon();
        try {
            String sectionOld = request.getParameter("sectionOld");
            String deptOld = request.getParameter("deptOld");
            String accUnitCode = request.getParameter("accUnitCode");

            String docStatus = request.getParameter("docStatus");
            String searchType = request.getParameter("searchType");
            String date = request.getParameter("date");
            String month = request.getParameter("month");
            String year = request.getParameter("year");
            String values_search = request.getParameter("values_search");
            String From = "", To = "";
            if (searchType.equals("d")) {
                From = date;
                To = date;
            } else if (searchType.equals("m")) {
                System.out.println(month);
                From = month + "-01";

                String temp_year = month.split("-")[0];
                int temp_month = Integer.parseInt(month.split("-")[1]);

                if (temp_month == 12) {
                    temp_month = 1;
                } else {
                    temp_month++;
                }
                month = (temp_month < 10) ? "0" + temp_month : "" + temp_month;
                To = temp_year + "-" + month + "-01";
            } else if (searchType.equals("y")) {
                System.out.println(year);
                From = year + "-01-01";
                String temp_year = "" + (Integer.parseInt(year) + 1);

                To = temp_year + "-01-01";
            }

            List<InvoDocumentStatus> docStatusList = null;
            if (docStatus.equals("All")) {
                docStatusList = new InvoDocumentStatusDAO<>().GetInvoDocumentStatus();
            } else {
                docStatusList = new InvoDocumentStatusDAO<>().GetInvoDocumentStatusByDocStatus(docStatus);
            }

            _01_invoice_json_charts[] all_data = new _01_invoice_json_charts[docStatusList.size()];
            int i = 0;
            for (InvoDocumentStatus status : docStatusList) {
                /**
                 * بيانات كل داتا على حدى
                 */
                _01_invoice_json_charts data = new _01_invoice_json_charts();

                data.setData_name(status.getDocStatusName());

                List<InvoInvoiceMaster> pList = null;

                List<_02_invoice_json_charts> all_bars_data = new ArrayList<>();
                if (searchType.equals("y")) {

                    String From_temp = From.split("-")[0];
                    data.setTitle_extra("لعام " + From_temp);
                    List<String> FromDate = new ArrayList<>();
                    List<String> ToDate = new ArrayList<>();
                    FromDate.add(From);
                    ToDate.add(From_temp + "-02-01");

                    FromDate.add(From_temp + "-02-01");
                    ToDate.add(From_temp + "-03-01");

                    FromDate.add(From_temp + "-03-01");
                    ToDate.add(From_temp + "-04-01");

                    FromDate.add(From_temp + "-04-01");
                    ToDate.add(From_temp + "-05-01");

                    FromDate.add(From_temp + "-05-01");
                    ToDate.add(From_temp + "-06-01");

                    FromDate.add(From_temp + "-06-01");
                    ToDate.add(From_temp + "-07-01");

                    FromDate.add(From_temp + "-07-01");
                    ToDate.add(From_temp + "-08-01");

                    FromDate.add(From_temp + "-08-01");
                    ToDate.add(From_temp + "-09-01");

                    FromDate.add(From_temp + "-09-01");
                    ToDate.add(From_temp + "-10-01");

                    FromDate.add(From_temp + "-10-01");
                    ToDate.add(From_temp + "-11-01");

                    FromDate.add(From_temp + "-11-01");
                    ToDate.add(From_temp + "-12-01");

                    FromDate.add(From_temp + "-12-01");
                    ToDate.add(To);

                    for (int j = 0; j < FromDate.size(); j++) {
                        pList = new InvoInvoiceMasterDao().GetAllInvInvoiceMasterByDeptAndSectionAndDocumentStatusInPeriod(deptOld, sectionOld, accUnitCode, "" + status.getDocStatus(), FromDate.get(j), ToDate.get(j), false);
                        /**
                         * مقاطع محور الاكس
                         */

                        _02_invoice_json_charts bars_data = new _02_invoice_json_charts();

                        String Mon_name = new DateOp().Date2String(new DateOp().String2Date(FromDate.get(j), "yyyy-MM-dd"), "MMM");;

                        bars_data.setX_axis_title(Mon_name);
                        if (values_search.equals("counter")) {
                            bars_data.setValue("" + pList.size());
                        } else {
                            double sum = 0.0;
                            for (InvoInvoiceMaster invoInvoiceMaster : pList) {
                                sum += invoInvoiceMaster.getTotalAmount().doubleValue();
                            }
                            bars_data.setValue("" + sum);
                        }
                        all_bars_data.add(bars_data);
                    }

                } else {
                    if (searchType.equals("d")) {
                        data.setTitle_extra("ليوم " + From);
                        pList = new InvoInvoiceMasterDao().GetAllInvInvoiceMasterByDeptAndSectionAndDocumentStatusInPeriod(deptOld, sectionOld, accUnitCode, "" + status.getDocStatus(), From, To, true);
                    } else {
                        String Mon_name = new DateOp().Date2String(new DateOp().String2Date(From, "yyyy-MM-dd"), "yyyy-MMM");;
                        data.setTitle_extra("لشهر " + Mon_name);
                        pList = new InvoInvoiceMasterDao().GetAllInvInvoiceMasterByDeptAndSectionAndDocumentStatusInPeriod(deptOld, sectionOld, accUnitCode, "" + status.getDocStatus(), From, To, false);
                    }
                    /**
                     * مقاطع محور الاكس
                     */

                    _02_invoice_json_charts bars_data = new _02_invoice_json_charts();

                    bars_data.setX_axis_title(From);
                    if (values_search.equals("counter")) {
                        bars_data.setValue("" + pList.size());
                    } else {
                        double sum = 0.0;
                        for (InvoInvoiceMaster invoInvoiceMaster : pList) {
                            sum += invoInvoiceMaster.getTotalAmount().doubleValue();
                        }
                        bars_data.setValue("" + sum);
                    }
                    all_bars_data.add(bars_data);
                }

                data.setX_axis_data(all_bars_data);

                all_data[i] = data;
                i++;
            }


            /*List<PerGovernorateCode> PerGovernorateCodeList = new PerGovernorateCodeDAO().GetPerGovernorateCodeByCountry(countryCode);
            _200_Submit_Documents_004_address[] country_gov_list = new _200_Submit_Documents_004_address[PerGovernorateCodeList.size()];
            int i = 0;
            for (PerGovernorateCode p : PerGovernorateCodeList) {
                _200_Submit_Documents_004_address country_gov = new _200_Submit_Documents_004_address();

                country_gov.setCountryCode(p.getId().getCountryCode());
                country_gov.setCountry(p.getPerCountryCode().getACountryName());

                country_gov.setGovernate(p.getAGovName());
                country_gov.setGovernateCode(p.getId().getGovCode());

                country_gov_list[i] = country_gov;
                i++;
            }*/
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(all_data);
            //System.out.println(pList.size());
            // success
            response.setContentType("application/json");
            response.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error");
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
