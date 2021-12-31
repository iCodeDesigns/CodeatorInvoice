/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequire;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequireStatus;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequireStatusDt;
import com.codeator.www._1_3_DB_daos.PerEmploymentMasterDao;
import com.codeator.www._1_3_DB_daos.VcleVehicleRequireDao;
import com.codeator.www._1_3_DB_daos.VcleVehicleRequireStatusDao;
import com.codeator.www._1_4_GeneralsModules.EnumDataBaseValues;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Support
 */
public class _0_0_0_2_1_Car_Request_4__AJAX_getVcleVehicleRequires extends HttpServlet {

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
        /**
         * ***
         * تم إضافة حالة جديدة في ال vcle_vcle_require_status رقم الحالة هو 26
         * وهي إلغاء بعد التفعيل ولم يتم التعامل معها في هذا ال AJAX
         */
        try {
            PerEmploymentMaster employee_session = (PerEmploymentMaster) request.getSession().getAttribute("employee_session");
            if (employee_session == null) {
                throw new Exception();
            }
            List<PerEmploymentMaster> pList = new PerEmploymentMasterDao().GetEmployeesByEmployee_ID("" + employee_session.getEmployeeId());
            employee_session = pList.get(0);

            String HTML_DIV = "";
            List<VcleVehicleRequireStatus> vvrsList = null;
            List<VcleVehicleRequire> vList = new VcleVehicleRequireDao().GetVcleVehicleRequireByDepNoOld("" + pList.get(0).getPerDeptOld().getId().getDepNoOld());
            if (vList.size() > 0) {
                int i = 0;
                //if Employee Logeed IN.
                i = (vList.size() > 10) ? vList.size() - 10 : 0;
                for ( /* i = init Up */; i < vList.size(); i++) {
                    VcleVehicleRequire v = vList.get(i);
                    String Time = new DateOp().Date2String(new DateOp().String2Date(v.getRequireDateTime(), "yyy-MM-dd HH:mm:ss"), "hh:mm a");
                    HTML_DIV += "<tr>\n"
                            + "      <td>" + v.getRequireDate() + "</td>\n"
                            + "      <td>" + Time + "</td>\n"
                            + "      <td><button type=\"button\" class=\"btn btn-custon-four btn-success\" href=\"#\" data-toggle=\"modal\" onclick=\"getVcleVcleRequestDetail(" + v.getRequireSp() + ");\" data-target=\".RequestDetails\" style=\"background: #77bbff;border-color: #77bbff;\"><i class=\"fa fa-search adminpro-checked-pro\" aria-hidden=\"true\"></i> تفاصيل الطلب</button></td>\n";
                    byte RequireStatus = v.getVcleVehicleRequireStatus().getRequireStatus();
                    byte RespType = v.getVcleVehicleRequireStatus().getRespType();//1- Dept 2- نقل                                                                
                    String Fafa = v.getVcleVehicleRequireStatus().getRequireStatusFafa();
                    String Color = v.getVcleVehicleRequireStatus().getRequireStatusColor();

                    /*عمود المدير*/
                    HTML_DIV += "<td>";
                    if (RequireStatus == 1) {
                        HTML_DIV += "  <button type=\"button\" class=\"btn btn-custon-rounded-three btn-warning\" ><i class=\"fa fa-exclamation\" aria-hidden=\"true\"></i> معلقة</button>\n";
                    } else if (RequireStatus < 11) {
                        String extra_btn = (RequireStatus == 3) ? "onclick='getRMRK(" + v.getRequireSp() + "," + v.getVcleVehicleRequireStatus().getRequireStatus() + ");' href=\"#\" data-toggle=\"modal\" data-target=\".rmrk\" " : "";
                        HTML_DIV += "<button type=\"button\" " + extra_btn + " class=\"btn btn-custon-rounded-three\" style=\"color: white;background-color: " + Color + "\"><i class=\"fa " + Fafa + "\" aria-hidden=\"true\"></i> " + v.getVcleVehicleRequireStatus().getRequireStatusNm() + "</button>";
                    } else if (RequireStatus > 10) { // حالة القبول من المدير وتواجد الطلب بالنقل
                        vvrsList = new VcleVehicleRequireStatusDao().GetVcleVehicleRequireByRequireStatus("2");
                        if (vvrsList.isEmpty()) {
                            throw new Exception();
                        }
                        VcleVehicleRequireStatus vvrs = vvrsList.get(0);
                        String fafa = vvrs.getRequireStatusFafa();
                        String color = vvrs.getRequireStatusColor();
                        HTML_DIV += "<button type=\"button\" class=\"btn btn-custon-rounded-three\" style=\"color: white;background-color :" + color + "\"><i class=\"fa " + fafa + "\" aria-hidden=\"true\"></i> " + vvrs.getRequireStatusNm() + "</button>";

                    }
                    HTML_DIV += "</td>";

                    /*عمود النقل*/
                    HTML_DIV += "<td>";
                    if (RequireStatus == 2) {
                        HTML_DIV += "<button type=\"button\" class=\"btn btn-custon-rounded-three btn-warning\" ><i class=\"fa fa-exclamation\" aria-hidden=\"true\"></i> معلقة</button>\n";
                    } else if (RequireStatus < 21 && RequireStatus > 10) {
                        String extra_btn = (RequireStatus == 13) ? "onclick='getRMRK(" + v.getRequireSp() + "," + v.getVcleVehicleRequireStatus().getRequireStatus() + ");' href=\"#\" data-toggle=\"modal\" data-target=\".rmrk\" " : "";
                        HTML_DIV += "<button type=\"button\" " + extra_btn + " class=\"btn btn-custon-rounded-three\" style=\"color: white;background-color: " + Color + "\"><i class=\"fa " + Fafa + "\" aria-hidden=\"true\"></i> " + v.getVcleVehicleRequireStatus().getRequireStatusNm() + "</button>";
                    } else if (RequireStatus > 20) { // حالة القبول من النقل وتواجد الطلب بالتفعيل
                        vvrsList = new VcleVehicleRequireStatusDao().GetVcleVehicleRequireByRequireStatus("12");
                        if (vvrsList.isEmpty()) {
                            throw new Exception();
                        }
                        VcleVehicleRequireStatus vvrs = vvrsList.get(0);
                        String fafa = vvrs.getRequireStatusFafa();
                        String color = vvrs.getRequireStatusColor();
                        HTML_DIV += "<button type=\"button\" class=\"btn btn-custon-rounded-three\" style=\"color: white;background-color :" + color + "\"><i class=\"fa " + fafa + "\" aria-hidden=\"true\"></i> " + vvrs.getRequireStatusNm() + "</button>";
                    }
                    HTML_DIV += "</td>";

                    /*عمود التفعيل*/
                    HTML_DIV += "<td>";
                    if (RequireStatus == 12) {
                        HTML_DIV += "<button type=\"button\" class=\"btn btn-custon-rounded-three btn-warning\"><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i>معلقة تفعيل</button>";
                    } else if (RequireStatus > 20) {
                        String extra_btn = (RequireStatus == 23) ? "onclick='getRMRK(" + v.getRequireSp() + "," + v.getVcleVehicleRequireStatus().getRequireStatus() + ");' href=\"#\" data-toggle=\"modal\" data-target=\".rmrk\" " : "";

                        HTML_DIV += "<button type=\"button\" " + extra_btn + " class=\"btn btn-custon-rounded-three\" style=\"color: white;background-color: " + Color + "\"><i class=\"fa " + Fafa + "\" aria-hidden=\"true\"></i> " + v.getVcleVehicleRequireStatus().getRequireStatusNm() + "</button>";
                    }
                    HTML_DIV += "</td>";
                }
            } else {
                HTML_DIV += "<tr>\n"
                        + "     <td colspan=\"6\">لا توجد طلبات مرسلة</td>\n"
                        + "  </tr> ";
            }
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

}
