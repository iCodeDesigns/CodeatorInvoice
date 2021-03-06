/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.PerDeptOld;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequire;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequireStatus;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequireStatusDt;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequireStatusDtId;
import com.codeator.www._1_2_DB_entities.VcleVehicleType;
import com.codeator.www._1_3_DB_daos.PerDeptOldDao;
import com.codeator.www._1_3_DB_daos.PerEmploymentMasterDao;
import com.codeator.www._1_3_DB_daos.VcleVehicleRequireDao;
import com.codeator.www._1_3_DB_daos.VcleVehicleRequireStatusDao;
import com.codeator.www._1_3_DB_daos.VcleVehicleRequireStatusDtDao;
import com.codeator.www._1_3_DB_daos.VcleVehicleTypeDao;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mahmoud
 */
public class _0_0_0_2_1_Car_Request_1__AJAX_addToVcleVehicleRequire extends HttpServlet {

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
        VcleVehicleRequireStatusDtDao vvrsDao = new VcleVehicleRequireStatusDtDao();
        try {
            PerEmploymentMaster employee_session = (PerEmploymentMaster) request.getSession().getAttribute("employee_session");
            if (employee_session == null) {
                throw new Exception();
            }
            String requireDate = request.getParameter("requireDate");
            String requireStartHour = request.getParameter("requireStartHour");
            String requireDateTime = requireDate + " " + requireStartHour + ":00";

            String RequireEndHour = (request.getParameter("RequireEndHour") == null || request.getParameter("RequireEndHour").equals("")) ? "????????????" : request.getParameter("RequireEndHour");

            String driverPlace = (request.getParameter("driverPlace") == null || request.getParameter("driverPlace").equals("")) ? "????????" : request.getParameter("driverPlace");
            String requirePlace = request.getParameter("requirePlace");
            String requireType = request.getParameter("requireType"); // requireType = ?????????? ???? ???????? ???? ??????????
            ////////////////////////////////////////////////
            String EmployeeId = request.getParameter("EmployeeId");
            List<PerEmploymentMaster> plist = new PerEmploymentMasterDao().GetEmployeesByEmployee_ID(EmployeeId);
            PerEmploymentMaster pem = plist.get(0);
            ///////////////////////////////////////////////
            String DepNoOld = request.getParameter("DepNoOld");
            String SectionNoOld = request.getParameter("SectionNoOld");
            List<PerDeptOld> pdlist = new PerDeptOldDao().GetDeptByDept_ID(SectionNoOld, DepNoOld);
            PerDeptOld pdo = pdlist.get(0);
            ///////////////////////////////////////////////
            String VcleType = request.getParameter("VcleType");
            List<VcleVehicleType> vList = new VcleVehicleTypeDao().GetVehicleByVehicleType(VcleType);
            VcleVehicleType vvt = vList.get(0);
            /////////////////////////////////////////////
            String guestNo = request.getParameter("guestNo");
            String no_of_days = request.getParameter("no_of_days");

            long requireSp = dao.GetMaxRequireSp();
            //////System.out.println(requireSp);
            ////////////////////////////////////////////////

            List<VcleVehicleRequireStatus> vvrsList = new VcleVehicleRequireStatusDao().GetVcleVehicleRequireByRequireStatus("1");
            if (vvrsList.isEmpty()) {
                throw new Exception();
            }
            VcleVehicleRequireStatus vvrs = vvrsList.get(0);
            VcleVehicleRequire vvr = new VcleVehicleRequire(requireSp, vvt, vvrs, pem, pdo, Byte.parseByte(requireType));

            vvr.setCurrDate(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));

            vvr.setRequireDate(new DateOp().String2Date(requireDate, "yyyy-MM-dd"));

            vvr.setRequireDateTime(requireDateTime);

            vvr.setGuestNo(Byte.parseByte(guestNo));

            vvr.setDriverPlace(driverPlace);

            vvr.setRequirePlace(requirePlace);//. ???? ??????

            vvr.setRequireEndHour(RequireEndHour);

            byte statusSeq = Byte.parseByte("" + vvrsDao.GetMaxStatusSeq("" + requireSp));
            VcleVehicleRequireStatusDtId vvrsdi = new VcleVehicleRequireStatusDtId(requireSp, statusSeq);
            VcleVehicleRequireStatusDt vvrsd = new VcleVehicleRequireStatusDt(vvrsdi, vvrs, vvr, employee_session, employee_session.getEmployeeNo(), "", new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"), new DateOp().getSysDate());

            new HibernateSessionCon().beginTrans();
            dao.save(vvr);
            dao.save(vvrsd);
            new HibernateSessionCon().CommitTrans();

            response.getWriter().write("Done");

        } catch (Exception e) {
            e.printStackTrace();
            //System.err.println(" ---------- Error In Query -----------");
            new HibernateSessionCon().RollBack();
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
