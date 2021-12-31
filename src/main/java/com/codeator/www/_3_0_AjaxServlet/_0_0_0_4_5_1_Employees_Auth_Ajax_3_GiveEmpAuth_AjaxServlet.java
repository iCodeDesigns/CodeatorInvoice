/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.AppSubTab;
import com.codeator.www._1_2_DB_entities.AppSubTabSpecAuth;
import com.codeator.www._1_2_DB_entities.AppSubTabSpecAuthId;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_3_DB_daos.AppSubTabSpecAuth_DAO;
import com.codeator.www._1_3_DB_daos.AppSubTab_DAO;
import com.codeator.www._1_3_DB_daos.PerEmploymentMasterDao;
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
public class _0_0_0_4_5_1_Employees_Auth_Ajax_3_GiveEmpAuth_AjaxServlet extends HttpServlet {

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

            String employeeId = request.getParameter("employeeId");
            String sectionId = request.getParameter("sectionId");
            String deptId = request.getParameter("deptId");
            String accUnitId = request.getParameter("accUnitId");
            String subTabId[] = request.getParameterValues("sub_tab_id");
            String AuthChecked[] = request.getParameterValues("AuthChecked");
            //String primaryAuthPass[] = request.getParameterValues("primaryAuthPass");
            if (subTabId.length == 0 || AuthChecked.length == 0 /*|| primaryAuthPass.length == 0*/) {
                throw new Exception();
            }
            List<PerEmploymentMaster> pList = new PerEmploymentMasterDao().GetEmployeesByEmployee_IDInJavaUsers(employeeId, accUnitId, deptId, sectionId);
            if (pList.isEmpty()) {
                throw new Exception();
            }
            PerEmploymentMaster pem = pList.get(0);

            new HibernateSessionCon().beginTrans();

            for (int i = 0; i < AuthChecked.length; i++) {
                if (AuthChecked[i].equals("false")) {
                    /**
                     * delete UnAuthurized Screens
                     */
                    String ID[] = subTabId[i].split("-");
                    String applicationId_St = ID[0];
                    String tabId_Str = ID[1];
                    String subTabId_Str = ID[2];
                    List<AppSubTabSpecAuth> screenAuthList = new AppSubTabSpecAuth_DAO().getEmpSubTabSpecAuth("" + pem.getEmployeeId(), applicationId_St, tabId_Str, subTabId_Str);
                    if (screenAuthList.isEmpty()) {
                        continue;
                    }
                    AppSubTabSpecAuth astsa = screenAuthList.get(0);
                    new AppSubTab_DAO().delete(astsa);

                }
            }
            new HibernateSessionCon().CommitTrans();
            new HibernateSessionCon().beginTrans();
            for (int i = 0; i < subTabId.length; i++) {
                if (AuthChecked[i].equals("true")) {

                    String ID[] = subTabId[i].split("-");
                    String applicationId_St = ID[0];
                    String tabId_Str = ID[1];
                    String subTabId_Str = ID[2];
                    AppSubTabSpecAuthId Id = new AppSubTabSpecAuthId(Integer.parseInt(subTabId_Str), pem.getEmployeeId(), Short.parseShort(applicationId_St), Integer.parseInt(tabId_Str));

                    List<AppSubTab> astList = new AppSubTab_DAO().get_ApplicationSubTabsById(applicationId_St, tabId_Str, subTabId_Str);
                    if (astList.isEmpty()) {
                        throw new Exception();
                    }
                    AppSubTab ast = astList.get(0);
                    AppSubTabSpecAuth astsa = new AppSubTabSpecAuth(Id, pem, ast, Byte.parseByte("1"/*primaryAuthPass[i]*/));
                    /**
                     * Who Do that
                     */
                    List<PerEmploymentMaster> pList2 = new PerEmploymentMasterDao().GetEmployeesByEmployee_ID(employee_session.getEmployeeNo());
                    if (pList2.isEmpty()) {
                        throw new Exception();
                    }
                    PerEmploymentMaster pem2 = pList2.get(0);

                    astsa.setPerEmploymentMasterByEmployeeIdAction(pem2);
                    astsa.setActionDate(new DateOp().getSysDate());
                    astsa.setActionDateDetails(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));
                    new AppSubTab_DAO().update(astsa);
                }
            }

            new HibernateSessionCon().CommitTrans();

            response.getWriter().write("Success");
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
