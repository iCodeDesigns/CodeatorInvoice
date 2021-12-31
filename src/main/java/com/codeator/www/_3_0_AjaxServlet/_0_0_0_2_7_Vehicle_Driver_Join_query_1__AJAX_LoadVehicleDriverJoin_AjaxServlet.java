/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.VcleVehicleDriverJoin;
import com.codeator.www._1_3_DB_daos.VcleVehicleDriverJoinDAO;
import java.io.IOException;
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
public class _0_0_0_2_7_Vehicle_Driver_Join_query_1__AJAX_LoadVehicleDriverJoin_AjaxServlet extends HttpServlet {

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
            String searchType = request.getParameter("searchType");
            String EmployeeId = request.getParameter("EmployeeId");
            String BoardNumber = request.getParameter("BoardNumber");
            String ModelCode = request.getParameter("ModelCode");
            String VcleType1 = request.getParameter("VcleType");
            String HTML_TEXT = "";
            request.getSession().setAttribute("_0_0_0_2_7_Loading", 10);

            List<VcleVehicleDriverJoin> pList = null;
            switch (searchType) {
                case "All":
                    pList = new VcleVehicleDriverJoinDAO().GetAllVcleVehicleDriverJoin();
                    break;
                case "Driver":
                    pList = new VcleVehicleDriverJoinDAO().GetVcleVehicleDriverJoinByemployeeId(EmployeeId);
                    break;
                case "CarNumber":
                    pList = new VcleVehicleDriverJoinDAO().GetVcleVehicleDriverJoinByboardNumber(BoardNumber);
                    break;
                case "CarModel":
                    String ModelCode_Arr[] = ModelCode.split("-");
                    ModelCode = ModelCode_Arr[0];
                    String MarkType = ModelCode_Arr[1];
                    String VcleType = ModelCode_Arr[2];
                    pList = new VcleVehicleDriverJoinDAO().GetVcleVehicleDriverJoinByModelCode(ModelCode, MarkType, VcleType);
                    break;
                case "CarType":
                    pList = new VcleVehicleDriverJoinDAO().GetVcleVehicleDriverJoinByVcleType(VcleType1);
                    break;
                default:
                    break;
            }

            int size = pList.size();
            int i = 0;
            if (pList.isEmpty()) {
                HTML_TEXT = "<tr>\n"
                        + "    <td colspan=\"6\" style=\"align-items: center;\">لا توجد بيانات</td>\n"
                        + "</tr>";
            } else {
                for (VcleVehicleDriverJoin p : pList) {
                    String Rmrk = p.getRmrk();
                    HTML_TEXT += "<tr>\n"
                            + "                    <td style=\"font-weight: bold;\">" + p.getPerEmploymentMaster().getEmployeeNo() + "</td>\n"
                            + "                    <td style=\"font-weight: bold;\">" + p.getPerEmploymentMaster().getEmpAname() + "</td>\n"
                            + "                    <td style=\"font-weight: bold;\">" + p.getVcleVehicleMaster().getVcleVehicleType().getVcleTypeName() + "</td>\n"
                            + "                    <td style=\"font-weight: bold;\">" + p.getVcleVehicleMaster().getVcleVehicleModel().getVcleMarkType().getMarkName() + " - " + p.getVcleVehicleMaster().getVcleVehicleModel().getModelName() + "</td>\n"
                            + "                    <td style=\"font-weight: bold;\">" + p.getBoardNumber() + "</td>\n";
                    if (Rmrk == null) {
                        HTML_TEXT += "                    <td style=\"font-weight: bold;\"></td>\n";
                    } else {
                        HTML_TEXT += "                    <td style=\"font-weight: bold;\">" + p.getRmrk() + "</td>\n";
                    }
                    HTML_TEXT += "                </tr>";
                    
                    int message = (int) ((i * 100.0) / size);
                    if (message > 10) {
                        request.getSession().setAttribute("_0_0_0_2_7_Loading", message);
                    }

                    i++;
                }
            }
            response.getWriter().write(HTML_TEXT);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error");
        }

        new HibernateSessionCon().closeConn();
        request.getSession().removeAttribute("_0_0_0_2_7_Loading");
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
