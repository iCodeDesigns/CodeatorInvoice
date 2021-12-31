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
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Support
 */
public class _0_0_0_2_6_Car_Request_FromTransportaionOffice_3__AJAX_addToVcleVehicleRequire extends HttpServlet {

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
        try {
            String AddType = request.getParameter("AddType");

            PerEmploymentMaster employee_session = (PerEmploymentMaster) request.getSession().getAttribute("employee_session");
            if (employee_session == null) {
                throw new Exception();
            }

            DateOp dop = new DateOp();
            String requireDate = request.getParameter("requireDate");
            String requireStartHour = request.getParameter("requireStartHour");
            String requireDateTime = requireDate + " " + requireStartHour + ":00";

            // check DateTime Not In The Past
            long diff = dop.differentsBetweenTwoDatesInMinuts(dop.String2Date(requireDateTime, "yyyy-MM-dd HH:mm:ss"), dop.getSysDate());
            if (diff < 0) {
                //throw new Exception("InThePast");
            }
            String RequireEndHour = (request.getParameter("RequireEndHour") == null || request.getParameter("RequireEndHour").equals("")) ? "العودة" : request.getParameter("RequireEndHour");

            String driverPlace = (request.getParameter("driverPlace") == null || request.getParameter("driverPlace").equals("")) ? "جراج" : request.getParameter("driverPlace");
            String requirePlace = request.getParameter("requirePlace");
            String requireType = request.getParameter("requireType"); // requireType = مذكرة أو دوري أو طوارئ
            ////////////////////////////////////////////////
            String EmployeeId = request.getParameter("EmployeeId");
            List<PerEmploymentMaster> plist = new PerEmploymentMasterDao().GetEmployeesByEmployee_ID(EmployeeId);
            PerEmploymentMaster pem = plist.get(0);
            ///////////////////////////////////////////////
            String checkSearchStatus = request.getParameter("checkSearchStatus");
            String DepNoOld = "";
            String SectionNoOld = "";
            if (checkSearchStatus.equals("byDept")) {
                DepNoOld = request.getParameter("DepNoOld");
                String DepNoOld_Arr[] = DepNoOld.split("-");
                DepNoOld = DepNoOld_Arr[1];
                SectionNoOld = DepNoOld_Arr[0];
            } else if (checkSearchStatus.equals("byEmp")){
                DepNoOld = request.getParameter("DepNoOld");
                String DepNoOld_Arr[] = DepNoOld.split("-");
                DepNoOld = DepNoOld_Arr[1];
                SectionNoOld = DepNoOld_Arr[0];
            }
            //String SectionNoOld = request.getParameter("SectionNoOld");
            
            List<PerDeptOld> pdlist = new PerDeptOldDao().GetDeptByDept_ID(SectionNoOld,DepNoOld);
            PerDeptOld pdo = pdlist.get(0);
            ///////////////////////////////////////////////
            String VcleType = request.getParameter("VcleType");
            List<VcleVehicleType> vList = new VcleVehicleTypeDao().GetVehicleByVehicleType(VcleType);
            VcleVehicleType vvt = vList.get(0);
            /////////////////////////////////////////////
            String guestNo = request.getParameter("guestNo");

            long requireSp = dao.GetMaxRequireSp();
            //System.out.println(requireSp);
            ////////////////////////////////////////////////

            List<VcleVehicleRequireStatus> vvrsList = null;
            if (AddType.equals("Normal")) {
                vvrsList = new VcleVehicleRequireStatusDao().GetVcleVehicleRequireByRequireStatus("11");
            } else {
                vvrsList = new VcleVehicleRequireStatusDao().GetVcleVehicleRequireByRequireStatus("23");
            }

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

            vvr.setRequirePlace(requirePlace);//. خط سير

            vvr.setRequireEndHour(RequireEndHour);

            //// vcle_vcle_require_status_dtl
            VcleVehicleRequireStatusDtDao vvrsDao = new VcleVehicleRequireStatusDtDao();
            byte statusSeq = Byte.parseByte("" + vvrsDao.GetMaxStatusSeq("" + requireSp));
            VcleVehicleRequireStatusDtId vvrsdi = new VcleVehicleRequireStatusDtId(requireSp, statusSeq);
            VcleVehicleRequireStatusDt vvrsd = new VcleVehicleRequireStatusDt(vvrsdi, vvrs, vvr, employee_session, employee_session.getEmployeeNo(), null, new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"), new DateOp().getSysDate());

            new HibernateSessionCon().beginTrans();
            //Master
            dao.insert(vvr);

            //Detail One
            vvrsList = new VcleVehicleRequireStatusDao().GetVcleVehicleRequireByRequireStatus("11");
            if (vvrsList.isEmpty()) {
                throw new Exception();
            }
            vvrs = vvrsList.get(0);
            vvrsd.setVcleVehicleRequireStatus(vvrs);

            dao.insert(vvrsd);

            //Detail One
            if (AddType.equals("Reject")) {
                String rmrk = request.getParameter("rmrk");
                vvrsList = new VcleVehicleRequireStatusDao().GetVcleVehicleRequireByRequireStatus("23");
                if (vvrsList.isEmpty()) {
                    throw new Exception();
                }
                vvrs = vvrsList.get(0);
                vvrsd.setVcleVehicleRequireStatus(vvrs);
                vvrsd.setRmrk(rmrk);
                dao.insert(vvrsd);
            }

            new HibernateSessionCon().CommitTrans();

            response.getWriter().write("Done");

        } catch (Exception e) {
            e.printStackTrace();
            //System.err.println(" ---------- Error In Query -----------");
            new HibernateSessionCon().RollBack();
            String Message = e.getMessage();
            if (Message.equals("InThePast")) {
                response.getWriter().write("لا يمكن اختيار توقيت بالماضي");
            } else {
                response.getWriter().write("Error");
            }

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
