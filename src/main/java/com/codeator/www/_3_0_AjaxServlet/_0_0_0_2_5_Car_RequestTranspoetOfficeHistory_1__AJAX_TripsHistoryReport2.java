/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.VcleRecordMovement;
import com.codeator.www._1_3_DB_daos.VcleRecordMovementDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mahmoud
 */
public class _0_0_0_2_5_Car_RequestTranspoetOfficeHistory_1__AJAX_TripsHistoryReport2 extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");new HibernateSessionCon().OpenCon();
        try {
            String from_date = request.getParameter("from_date");
            String to_date = request.getParameter("to_date");

            String BoardNumber = request.getParameter("BoardNumber");
            String carSearch = request.getParameter("carSearch");

            String driver_id = request.getParameter("driver_id");
            String driverSearch = request.getParameter("driverSearch");

            String fullSearch = request.getParameter("fullSearch");
            String AllSearchCar = request.getParameter("AllSearchCar");
            String AllSearchDriver = request.getParameter("AllSearchDriver");
//dd-MMM-yyyy
            Date FromDate = new DateOp().String2Date(from_date, "yyyy-MM-dd");
            Date ToDate = new DateOp().String2Date(to_date, "yyyy-MM-dd");

            String HQL = " v.goingDate>='" + new DateOp().Date2String(FromDate, "dd-MMM-yyyy") + "'";
            HQL += " AND v.goingDate<='" + new DateOp().Date2String(ToDate, "dd-MMM-yyyy") + "'";
            /*String HQL = "v.goingDate>='" + from_date + "'";
            HQL += " AND v.goingDate<='" + to_date + "'";*/

            String Title = "";
            if (carSearch.equals("true")) {
                HQL += " AND v.vcleVehicleMaster.boardNumber='" + BoardNumber + "'";
                Title = "رقم السيارة";
            } else if (driverSearch.equals("true")) {
                HQL += " AND v.perEmploymentMaster.employeeId='" + driver_id + "'";
                Title = "إسم الموظف";
            } else if (fullSearch.equals("true")) {
                if (AllSearchCar.equals("true")) {
                    Title = "رقم السيارة";
                } else if (AllSearchDriver.equals("true")) {
                    Title = "إسم الموظف";
                }
            }

            String HTML_DIV = getUpperTableText(Title);
            List<VcleRecordMovement> vList = new VcleRecordMovementDAO().GetVcleRecordMovementCustomQuery(HQL);
            if (vList.isEmpty()) {
                HTML_DIV += "<tr>\n"
                        + "    <td>لا توجد بيانات</td>\n"
                        + "    <td></td>\n"
                        + "  </tr>";
            } else {
                //int i = 0;
                Set<String> boardNumber = new HashSet<>();
                Set<String> DriverId = new HashSet<>();
                for (VcleRecordMovement v : vList) {

                    //System.out.println(i);
                    boolean Driver = false;
                    boolean Car = false;
                    if (driverSearch.equals("true")) {
                        Driver = true;
                    } else if (carSearch.equals("true")) {
                        Car = true;
                    } else if (fullSearch.equals("true")) {
                        if (AllSearchCar.equals("true")) {
                            Car = true;
                        } else if (AllSearchDriver.equals("true")) {
                            Driver = true;
                        }
                    }

                    if (Driver) {
                        if (DriverId.add(v.getPerEmploymentMaster().getEmployeeNo())) {
                            getNumberOfTripsOfThisDriverInPeriod(v.getPerEmploymentMaster().getEmployeeNo(), FromDate, ToDate);
                            String Yes_NO = (numberOfUnBack2 == 0) ? "لا" : "نعم";
                            String color = (numberOfUnBack2 == 0) ? "" : "style='background-color: #92f1fb;'";
                            HTML_DIV += "<tr " + color + ">\n"
                                    + "     <td>" + v.getPerEmploymentMaster().getEmployeeNo() + "</td>\n"
                                    + "     <td>" + v.getPerEmploymentMaster().getEmpAname() + "</td>\n"
                                    + "     <td>" + numberOfTrips2 + "</td>\n"
                                    + "     <td>" + Yes_NO + "</td>\n"
                                    + "     <td><button type=\"button\" onclick=\"getTripsOfThisDriver('" + v.getPerEmploymentMaster().getEmployeeNo() + "','" + from_date + "','" + to_date + "');\" class=\"btn btn-custon-rounded-three btn-success\" href=\"#\" data-toggle=\"modal\" data-target=\"#Ra7alatOfCar\"><i class=\"fa fa-info adminpro-checked-pro\" aria-hidden=\"true\"></i> الرحلات التابعة للسائق ( " + v.getPerEmploymentMaster().getEmpAname() + " )</button></td>\n"
                                    + " </tr>";
                        }
                    } else if (Car) {
                        if (boardNumber.add(v.getVcleVehicleMaster().getBoardNumber())) {
                            getNumberOfTripsOfThisCarInPeriod(v.getVcleVehicleMaster().getBoardNumber(), FromDate, ToDate);
                            String Yes_NO = (numberOfUnBack == 0) ? "لا" : "نعم";
                            String color = (numberOfUnBack == 0) ? "" : "style='background-color: #ffadad;'";
                            HTML_DIV += "<tr " + color + ">\n"
                                    + "     <td>" + v.getVcleVehicleMaster().getBoardNumber() + "</td>\n"
                                    + "     <td>" + numberOfTrips + "</td>\n"
                                    + "     <td>" + Yes_NO + "</td>\n"
                                    + "     <td><button type=\"button\" onclick=\"getTripsOfThisCar('" + v.getVcleVehicleMaster().getBoardNumber() + "','" + from_date + "','" + to_date + "');\" class=\"btn btn-custon-rounded-three btn-success\" href=\"#\" data-toggle=\"modal\" data-target=\"#Ra7alatOfCar\"><i class=\"fa fa-info adminpro-checked-pro\" aria-hidden=\"true\"></i> الرحلات التابعة للسيارة ( " + v.getVcleVehicleMaster().getBoardNumber() + " )</button></td>\n"
                                    + " </tr>";
                        }
                    }
                }
            }
            HTML_DIV += getLowerTableText();
            response.getWriter().write(HTML_DIV);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error");
            System.err.println(" ---------- Error In Update -----------");
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

    private String getUpperTableText(String Title) {
        if (Title.equals("رقم السيارة")) {
            return "<thead>\n"
                    + "                                                                        <tr>     \n"
                    + "                                                                            <th style=\"text-align: center;\">" + Title + "</th>\n"
                    + "                                                                            <th style=\"text-align: center;\">عدد الرحلات</th>\n"
                    + "                                                                            <th style=\"text-align: center;\">هل السيارة بالخارج</th>\n"
                    + "                                                                            <th style=\"text-align: center;\">الرحلات التابعة لها</th>\n"
                    + "                                                                        </tr>\n"
                    + "                                                                    </thead>                                                                                            \n"
                    + "                                                                    <tbody>";
        } else {
            return "<thead>\n"
                    + "                                                                        <tr>     \n"
                    + "                                                                            <th style=\"text-align: center;\">رقم الموظف</th>\n"
                    + "                                                                            <th style=\"text-align: center;\">" + Title + "</th>\n"
                    + "                                                                            <th style=\"text-align: center;\">عدد الرحلات</th>\n"
                    + "                                                                            <th style=\"text-align: center;\">هل الموظف بالخارج</th>\n"
                    + "                                                                            <th style=\"text-align: center;\">الرحلات التابعة لها</th>\n"
                    + "                                                                        </tr>\n"
                    + "                                                                    </thead>                                                                                            \n"
                    + "                                                                    <tbody>";
        }
    }

    private String getLowerTableText() {
        return "</tbody>";
    }

    int numberOfTrips = 0;
    int numberOfUnBack = 0;

    private void getNumberOfTripsOfThisCarInPeriod(String BoardNumber, Date FromDate, Date ToDate) {
        numberOfTrips = 0;
        numberOfUnBack = 0;
        String HQL = " v.goingDate>='" + new DateOp().Date2String(FromDate, "dd-MMM-yyyy") + "'";
        HQL += " AND v.goingDate<='" + new DateOp().Date2String(ToDate, "dd-MMM-yyyy") + "'";
        HQL += " AND v.vcleVehicleMaster.boardNumber='" + BoardNumber + "'";
        List<VcleRecordMovement> Ra7alatList = new VcleRecordMovementDAO().GetVcleRecordMovementCustomQuery(HQL);
        numberOfTrips = Ra7alatList.size();
        HQL += " AND v.comingDate=null";
        Ra7alatList = new VcleRecordMovementDAO().GetVcleRecordMovementCustomQuery(HQL);
        numberOfUnBack = Ra7alatList.size();

    }

    int numberOfTrips2 = 0;
    int numberOfUnBack2 = 0;

    private void getNumberOfTripsOfThisDriverInPeriod(String employeeNo, Date FromDate, Date ToDate) {
        numberOfTrips2 = 0;
        numberOfUnBack2 = 0;
        String HQL = " v.goingDate>='" + new DateOp().Date2String(FromDate, "dd-MMM-yyyy") + "'";
        HQL += " AND v.goingDate<='" + new DateOp().Date2String(ToDate, "dd-MMM-yyyy") + "'";
        HQL += " AND v.perEmploymentMaster.employeeNo='" + employeeNo + "'";
        List<VcleRecordMovement> Ra7alatList = new VcleRecordMovementDAO().GetVcleRecordMovementCustomQuery(HQL);
        numberOfTrips2 = Ra7alatList.size();
        HQL += " AND v.comingDate=null";
        Ra7alatList = new VcleRecordMovementDAO().GetVcleRecordMovementCustomQuery(HQL);
        numberOfUnBack2 = Ra7alatList.size();

    }
}
