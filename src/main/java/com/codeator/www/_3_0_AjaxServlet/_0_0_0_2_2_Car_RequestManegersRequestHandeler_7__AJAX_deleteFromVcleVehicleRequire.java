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
import com.codeator.www._1_2_DB_entities.VcleVehicleRequireStatusDtId;
import com.codeator.www._1_3_DB_daos.VcleVehicleRequireDao;
import com.codeator.www._1_3_DB_daos.VcleVehicleRequireStatusDao;
import com.codeator.www._1_3_DB_daos.VcleVehicleRequireStatusDtDao;
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
public class _0_0_0_2_2_Car_RequestManegersRequestHandeler_7__AJAX_deleteFromVcleVehicleRequire extends HttpServlet {

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
        VcleVehicleRequireDao dao = new VcleVehicleRequireDao();
        new HibernateSessionCon().OpenCon();
        try {
            PerEmploymentMaster employee_session = (PerEmploymentMaster) request.getSession().getAttribute("employee_session");
            if (employee_session == null) {
                throw new Exception();
            }
            String RequireSp = request.getParameter("RequireSp");
            String causeOfIgnore = request.getParameter("causeOfIgnore");
            List<VcleVehicleRequire> vList = dao.GetVcleVehicleRequireByRequireSp(RequireSp);
            VcleVehicleRequire v = vList.get(0);

            List<VcleVehicleRequireStatus> vvrsList = new VcleVehicleRequireStatusDao().GetVcleVehicleRequireByRequireStatus("3");
            if (vvrsList.isEmpty()) {
                throw new Exception();
            }
            VcleVehicleRequireStatus vvrs = vvrsList.get(0);

            v.setVcleVehicleRequireStatus(vvrs);

            VcleVehicleRequireStatusDtDao vvrsDao = new VcleVehicleRequireStatusDtDao();
            byte statusSeq = Byte.parseByte("" + vvrsDao.GetMaxStatusSeq("" + v.getRequireSp()));
            VcleVehicleRequireStatusDtId vvrsdi = new VcleVehicleRequireStatusDtId(v.getRequireSp(), statusSeq);
            VcleVehicleRequireStatusDt vvrsd = new VcleVehicleRequireStatusDt(vvrsdi, vvrs, v, employee_session, employee_session.getEmployeeNo(), causeOfIgnore, new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"), new DateOp().getSysDate());

            new HibernateSessionCon().beginTrans();
            dao.update(v);
            dao.insert(vvrsd);
            new HibernateSessionCon().CommitTrans();
            response.getWriter().write("Done");

            //الحذف
            /*String RequireSp = request.getParameter("RequireSp");
            List<VcleVehicleRequire> vList = dao.GetVcleVehicleRequireByRequireSp(RequireSp);
            VcleVehicleRequire v = vList.get(0);
            
            new HibernateSessionCon().beginTrans();
            dao.delete(v);
            new HibernateSessionCon().CommitTrans();
            
            response.getWriter().write("Done");**/
        } catch (Exception e) {
            e.printStackTrace();
            //System.err.println(" ---------- Error In Query -----------");
            new HibernateSessionCon().RollBack();
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
