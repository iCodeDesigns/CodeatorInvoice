/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.PerDeptOld;
import com.codeator.www._1_2_DB_entities.PerSectionOld;
import com.codeator.www._1_3_DB_daos.PerDeptOldDao;
import com.codeator.www._1_3_DB_daos.PerSectionOldDao;
import com.codeator.www._1_3_DB_daos.VcleVehicleRequireDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
public class _0_0_2_0_0_Transportation_Main_DashBoard_Ajax_3_getdataAnalysis_AjaxServlet extends HttpServlet {

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
            String searchLevel = request.getParameter("searchLevel");
            String sectionOrDept = request.getParameter("sectionOrDept");
            String DashTimeView = request.getParameter("DashTimeView");
            String from_year = request.getParameter("from_year");
            String month = request.getParameter("month");
            String requireType = request.getParameter("requireType");
            String VcleType = request.getParameter("VcleType");
            String HQL = "";
            if (!requireType.equals("All")) {
                HQL += "and p.requireType = " + requireType + "";
            }
            if (!VcleType.equals("All")) {
                HQL += "and p.vcleVehicleType.vcleType = " + VcleType + "";
            }

            if (!sectionOrDept.equals("All") && DashTimeView.equals("YearMonth")) {
                // التقسيمات شهرية على مدار سنة واحدة
                // العرض لإدارة واحدة أو قسم واحد
                drawYearMonthByPart(request, response, searchLevel, sectionOrDept, from_year, requireType, VcleType, HQL);
            } else {
                switch (DashTimeView) {
                    case "Year":
                        drawYearByAll(request, response, searchLevel, sectionOrDept, from_year, requireType, VcleType, HQL);
                        break;
                    case "Month":
                        drawMonthByAll(request, response, searchLevel, sectionOrDept, from_year, month, requireType, VcleType, HQL);
                        break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
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

    private void drawYearMonthByPart(HttpServletRequest request, HttpServletResponse response, String searchLevel, String sectionOrDept, String from_year, String requireType, String VcleType, String HQL) throws IOException {
        List<_0_0_0_0_0_All_bars_class1> mainData = new LinkedList<_0_0_0_0_0_All_bars_class1>();
        _0_0_0_0_0_All_bars_class1 s = new _0_0_0_0_0_All_bars_class1();

        request.getSession().setAttribute("_0_0_2_0_0_Loading_1", "0");

        List<String> parts = new DateOp().monthArabic;
        s.setParts(parts);

        //***** Get All Genders
        List<_0_0_0_0_0_single_bar_class2> GenderList = new LinkedList<_0_0_0_0_0_single_bar_class2>();
        if (searchLevel.equals("Section")) {
            List<PerSectionOld> pList = new PerSectionOldDao().GetSectionsBySectionNoOld(sectionOrDept);
            int i = 0;
            int size = pList.size() * parts.size();
            for (PerSectionOld gender : pList) {
                _0_0_0_0_0_single_bar_class2 Gender = new _0_0_0_0_0_single_bar_class2();

                String gender_name = gender.getSectionName();

                List<String> values = new LinkedList<String>();
                for (int m = 0; m < parts.size(); m++) {
                    new HibernateSessionCon().clearConn();
                    String SectionId = "" + gender.getSectionNoOld();
                    String Month = "" + (m + 1);
                    Month = (Month.length() > 1) ? Month : "0" + Month;
                    String yearMonthFrom = from_year + "-" + Month + "-01";
                    String yearMonthTo;
                    int MonthEnd = Integer.parseInt(Month) + 1;
                    int YearEnd = Integer.parseInt(from_year) + 1;
                    if (Month.equals("12")) {
                        yearMonthTo = YearEnd + "-01-01";
                    } else {
                        yearMonthTo = from_year + "-" + MonthEnd + "-01";
                    }

                    // تظبيط اليوم الأخير من كل شهر
                    long val = new VcleVehicleRequireDao<>().getReuiredTripsCount(SectionId, yearMonthFrom, yearMonthTo, HQL);
                    values.add("" + val);

                    i++;
                    String message = "" + (int) ((i * 100.0) / size);
                    request.getSession().setAttribute("_0_0_2_0_0_Loading_1", message);
                }
                if (values.isEmpty()) {
                    continue;
                }
                Gender.setData_name(gender_name);
                Gender.setValues(values);
                GenderList.add(Gender);
            }
        } else if (searchLevel.equals("Dept")) {
            List<PerDeptOld> pList = new PerDeptOldDao<>().GetDeptByDept_ID(sectionOrDept.split("-")[0], sectionOrDept.split("-")[1]);
            int i = 0;
            int size = pList.size() * parts.size();
            for (PerDeptOld gender : pList) {
                _0_0_0_0_0_single_bar_class2 Gender = new _0_0_0_0_0_single_bar_class2();

                String gender_name = gender.getDepName();

                List<String> values = new LinkedList<String>();
                for (int m = 0; m < parts.size(); m++) {
                    new HibernateSessionCon().clearConn();
                    String DeptId = "" + gender.getId().getDepNoOld();
                    String SectionId = "" + gender.getId().getSectionNoOld();
                    String Month = "" + (m + 1);
                    Month = (Month.length() > 1) ? Month : "0" + Month;
                    String yearMonthFrom = from_year + "-" + Month + "-01";
                    String yearMonthTo;
                    int MonthEnd = Integer.parseInt(Month) + 1;
                    int YearEnd = Integer.parseInt(from_year) + 1;
                    if (Month.equals("12")) {
                        yearMonthTo = YearEnd + "-01-01";
                    } else {
                        yearMonthTo = from_year + "-" + MonthEnd + "-01";
                    }
                    long val = new VcleVehicleRequireDao<>().getReuiredTripsCountForDept(SectionId, DeptId, yearMonthFrom, yearMonthTo,HQL);
                    values.add("" + val);

                    i++;
                    String message = "" + (int) ((i * 100.0) / size);
                    request.getSession().setAttribute("_0_0_2_0_0_Loading_1", message);
                }
                if (values.isEmpty()) {
                    continue;
                }
                Gender.setData_name(gender_name);
                Gender.setValues(values);
                GenderList.add(Gender);
            }
        }

        s.setData_list(GenderList);
        // 2. initiate jackson mapper
        ObjectMapper mapper = new ObjectMapper();

        // 4. Set response type to JSON
        response.setContentType("application/json");
        mainData.add(s);

        String json = mapper.writeValueAsString(mainData);
        //System.out.println(json);
        // 6. Send List<Article> as JSON to client
        mapper.writeValue(response.getOutputStream(), mainData);
    }

    private void drawYearByAll(HttpServletRequest request, HttpServletResponse response, String searchLevel, String sectionOrDept, String from_year, String requireType, String VcleType, String HQL) throws JsonProcessingException, IOException {
        List<_0_0_0_0_0_All_bars_class1> mainData = new LinkedList<_0_0_0_0_0_All_bars_class1>();
        _0_0_0_0_0_All_bars_class1 s = new _0_0_0_0_0_All_bars_class1();

        request.getSession().setAttribute("_0_0_2_0_0_Loading_1", "0");

        List<String> parts = new ArrayList<>();
        parts.add("الرحلات بكل إدارة لسنة (" + from_year + ")");
        s.setParts(parts);
        //***** Get All Genders
        List<_0_0_0_0_0_single_bar_class2> GenderList = new LinkedList<_0_0_0_0_0_single_bar_class2>();
        if (searchLevel.equals("Section") && sectionOrDept.equals("All")) {
            List<PerSectionOld> psoList = new PerSectionOldDao().GetAllSections();
            for (PerSectionOld p : psoList) {
                _0_0_0_0_0_single_bar_class2 Gender = new _0_0_0_0_0_single_bar_class2();

                String gender_name = p.getSectionName();

                List<String> values = new LinkedList<String>();
                new HibernateSessionCon().clearConn();
                String SectionId = "" + p.getSectionNoOld();

                // تظبيط اليوم الأخير من كل شهر
                String yearMonthFrom = from_year + "-01-01";
                String yearMonthTo = from_year + "-12-31";
                long val = new VcleVehicleRequireDao<>().getReuiredTripsCount(SectionId, yearMonthFrom, yearMonthTo, HQL);
                values.add("" + val);

                if (val == 0) {
                    continue;
                }

                Gender.setValues(values);
                GenderList.add(Gender);
                Gender.setData_name(gender_name);
            }
        } else if (searchLevel.equals("Dept") && sectionOrDept.equals("All")) {
            List<PerDeptOld> psoList = new PerDeptOldDao().GetAllDept();
            for (PerDeptOld p : psoList) {
                if (p.getDepName().equals("بدون")) {
                    continue;
                }
                _0_0_0_0_0_single_bar_class2 Gender = new _0_0_0_0_0_single_bar_class2();

                String gender_name = p.getDepName();

                List<String> values = new LinkedList<String>();
                new HibernateSessionCon().clearConn();
                String SectionId = "" + p.getId().getSectionNoOld();
                String DeptId = "" + p.getId().getDepNoOld();

                // تظبيط اليوم الأخير من كل شهر
                String yearMonthFrom = from_year + "-01-01";
                String yearMonthTo = from_year + "-12-31";
                long val = new VcleVehicleRequireDao<>().getReuiredTripsCountForDept(SectionId, DeptId, yearMonthFrom, yearMonthTo, HQL);
                values.add("" + val);

                if (val == 0) {
                    continue;
                }

                Gender.setValues(values);
                GenderList.add(Gender);
                Gender.setData_name(gender_name);
            }
        }

        s.setData_list(GenderList);
        // 2. initiate jackson mapper
        ObjectMapper mapper = new ObjectMapper();

        // 4. Set response type to JSON
        response.setContentType(
                "application/json");
        mainData.add(s);

        String json = mapper.writeValueAsString(mainData);

        //System.out.println(json);
        // 6. Send List<Article> as JSON to client

        mapper.writeValue(response.getOutputStream(), mainData);
    }

    private void drawMonthByAll(HttpServletRequest request, HttpServletResponse response, String searchLevel, String sectionOrDept, String from_year, String month, String requireType, String VcleType, String HQL) throws IOException {
        List<_0_0_0_0_0_All_bars_class1> mainData = new LinkedList<_0_0_0_0_0_All_bars_class1>();
        _0_0_0_0_0_All_bars_class1 s = new _0_0_0_0_0_All_bars_class1();

        request.getSession().setAttribute("_0_0_2_0_0_Loading_1", "0");

        List<String> parts = new ArrayList<>();
        String Month_name = new DateOp().monthArabic.get(Integer.parseInt(month) - 1);
        parts.add("الرحلات بكل إدارة بشهر (" + Month_name + ") -  لسنة(" + from_year + ")");
        s.setParts(parts);
        //***** Get All Genders
        List<_0_0_0_0_0_single_bar_class2> GenderList = new LinkedList<_0_0_0_0_0_single_bar_class2>();
        if (searchLevel.equals("Section") && sectionOrDept.equals("All")) {
            List<PerSectionOld> psoList = new PerSectionOldDao().GetAllSections();
            for (PerSectionOld p : psoList) {
                _0_0_0_0_0_single_bar_class2 Gender = new _0_0_0_0_0_single_bar_class2();

                String gender_name = p.getSectionName();

                List<String> values = new LinkedList<String>();
                new HibernateSessionCon().clearConn();
                String SectionId = "" + p.getSectionNoOld();

                // تظبيط اليوم الأخير من كل شهر
                month = (month.length() > 1) ? month : "0" + month;
                String yearMonthFrom = from_year + "-" + month + "-01";
                String yearMonthTo;
                int MonthEnd = Integer.parseInt(month) + 1;
                int YearEnd = Integer.parseInt(from_year) + 1;
                if (month.equals("12")) {
                    yearMonthTo = YearEnd + "-01-01";
                } else {
                    yearMonthTo = from_year + "-" + MonthEnd + "-01";
                }

                long val = new VcleVehicleRequireDao<>().getReuiredTripsCount(SectionId, yearMonthFrom, yearMonthTo, HQL);
                values.add("" + val);

                if (val == 0) {
                    continue;
                }

                Gender.setData_name(gender_name);
                Gender.setValues(values);
                GenderList.add(Gender);
            }
        } else if (searchLevel.equals("Dept") && sectionOrDept.equals("All")) {
            List<PerDeptOld> psoList = new PerDeptOldDao().GetAllDept();
            for (PerDeptOld p : psoList) {
                if (p.getDepName().equals("بدون")) {
                    continue;
                }
                _0_0_0_0_0_single_bar_class2 Gender = new _0_0_0_0_0_single_bar_class2();

                String gender_name = p.getDepName();

                List<String> values = new LinkedList<String>();
                new HibernateSessionCon().clearConn();
                String SectionId = "" + p.getId().getSectionNoOld();
                String DeptId = "" + p.getId().getDepNoOld();

                // تظبيط اليوم الأخير من كل شهر
                month = (month.length() > 1) ? month : "0" + month;
                String yearMonthFrom = from_year + "-" + month + "-01";
                String yearMonthTo;
                int MonthEnd = Integer.parseInt(month) + 1;
                int YearEnd = Integer.parseInt(from_year) + 1;
                if (month.equals("12")) {
                    yearMonthTo = YearEnd + "-01-01";
                } else {
                    yearMonthTo = from_year + "-" + MonthEnd + "-01";
                }
                long val = new VcleVehicleRequireDao<>().getReuiredTripsCountForDept(SectionId, DeptId, yearMonthFrom, yearMonthTo, HQL);
                values.add("" + val);

                if (val == 0) {
                    continue;
                }

                Gender.setValues(values);
                GenderList.add(Gender);
                Gender.setData_name(gender_name);
            }
        }

        s.setData_list(GenderList);
        // 2. initiate jackson mapper
        ObjectMapper mapper = new ObjectMapper();

        // 4. Set response type to JSON
        response.setContentType(
                "application/json");
        mainData.add(s);

        String json = mapper.writeValueAsString(mainData);

        //System.out.println(json);
        // 6. Send List<Article> as JSON to client

        mapper.writeValue(response.getOutputStream(), mainData);
    }

}
