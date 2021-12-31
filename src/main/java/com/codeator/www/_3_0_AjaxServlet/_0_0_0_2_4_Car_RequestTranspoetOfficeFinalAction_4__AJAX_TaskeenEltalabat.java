/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_2_DB_entities.VcleRecordMovement;
import com.codeator.www._1_2_DB_entities.VcleRecordMovementJoin;
import com.codeator.www._1_2_DB_entities.VcleVehicleMaster;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequire;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequireStatus;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequireStatusDt;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequireStatusDtId;
import com.codeator.www._1_3_DB_daos.PerEmploymentMasterDao;
import com.codeator.www._1_3_DB_daos.VcleRecordMovementDAO;
import com.codeator.www._1_3_DB_daos.VcleRecordMovementJoinDao;
import com.codeator.www._1_3_DB_daos.VcleVehicleMasterDao;
import com.codeator.www._1_3_DB_daos.VcleVehicleRequireDao;
import com.codeator.www._1_3_DB_daos.VcleVehicleRequireStatusDao;
import com.codeator.www._1_3_DB_daos.VcleVehicleRequireStatusDtDao;
import java.io.IOException;
import java.io.PrintWriter;
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
public class _0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_4__AJAX_TaskeenEltalabat extends HttpServlet {

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
            PerEmploymentMaster employee_session = (PerEmploymentMaster) request.getSession().getAttribute("employee_session");
            if (employee_session == null) {
                throw new Exception();
            }

            String[] Final_RequireSP_id = request.getParameterValues("Final_RequireSP_id");// أرقام الطلبات
            String EmployeeId = request.getParameter("EmployeeId");//إسم السائق
            String BoardNumber = request.getParameter("BoardNumber");// رقم السيارة
            String RequestGuestNumber = request.getParameter("RequestGuestNumber");// عدد الركاب

            VcleRecordMovementDAO vrmDAO = new VcleRecordMovementDAO();
            long goingSp = vrmDAO.GetMaxGoingSp() + 1;

            List<VcleVehicleMaster> vList = new VcleVehicleMasterDao().GetVehiclesCarsByBoardDigital(BoardNumber);
            VcleVehicleMaster vvm = vList.get(0);
            ////////////////////////////////////////////////////////
            VcleRecordMovement vrm = new VcleRecordMovement(goingSp, vvm);
            List<PerEmploymentMaster> pList = new PerEmploymentMasterDao().GetEmployeesByEmployee_ID(EmployeeId);
            if (pList.isEmpty()) {
                throw new Exception("NoEmpDriver");
            }
            PerEmploymentMaster p = pList.get(0);
            vrm.setPerEmploymentMaster(p);
            //Going DateTime
            String dateTimePicker = request.getParameter("dateTimePicker");            
            //System.out.print("////////////"+dateTimePicker);
            //2020-12-14T09:55
            String dateTime_arr[] = dateTimePicker.split("T");
            String date = dateTime_arr[0];
            String Time = dateTime_arr[1] + new DateOp().getCustomSysDate(":ss");
            String dateTime = date + " " + Time;
            try {
                Date dateTime_date = new DateOp().String2Date(dateTime, "yyyy-MM-dd HH:mm:ss");
                vrm.setGoingDate(dateTime_date);
            } catch (Exception e) {
                throw new Exception("InvalidDateTime");
            }            
            vrm.setGoingDateHour(dateTime);

            String goingCountNumberStatus = request.getParameter("goingCountNumberStatus");// حالة العداد
            if (goingCountNumberStatus.equals("true")) {
                //dont add goingCountNumber
                vrm.setChkMov("1");
            } else {
                String goingCountNumber = request.getParameter("goingCountNumber");
                vrm.setChkMov("0");
                vrm.setGoingCountNumber(Long.parseLong(goingCountNumber));
            }

            new HibernateSessionCon().beginTrans();
            List<VcleVehicleRequireStatus> vvrsList = new VcleVehicleRequireStatusDao().GetVcleVehicleRequireByRequireStatus("22");
            if (vvrsList.isEmpty()) {
                throw new Exception();
            }
            VcleVehicleRequireStatus vvrs = vvrsList.get(0);
            for (String requireSP : Final_RequireSP_id) {
                List<VcleVehicleRequire> vvrList = new VcleVehicleRequireDao().GetVcleVehicleRequireByRequireSp(requireSP);
                if (vvrList.isEmpty()) {
                    continue;
                }
                VcleVehicleRequire vvr = vvrList.get(0);
                vvr.setVcleVehicleRequireStatus(vvrs);

                VcleVehicleRequireStatusDtDao vvrsDao = new VcleVehicleRequireStatusDtDao();
                byte statusSeq = Byte.parseByte("" + vvrsDao.GetMaxStatusSeq("" + vvr.getRequireSp()));
                VcleVehicleRequireStatusDtId vvrsdi = new VcleVehicleRequireStatusDtId(vvr.getRequireSp(), statusSeq);
                VcleVehicleRequireStatusDt vvrsd = new VcleVehicleRequireStatusDt(vvrsdi, vvrs, vvr, employee_session, employee_session.getEmployeeNo(), "", new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"), new DateOp().getSysDate());

                vrmDAO.update(vvr);
                vrmDAO.insert(vvrsd);
            }

            //new HibernateSessionCon().CommitTrans();
            //new HibernateSessionCon().beginTrans();
            vrmDAO.save(vrm);
            //System.out.println("Length : " + Final_RequireSP_id.length);
            for (String requireSP : Final_RequireSP_id) {
                //System.out.println("OUT >> " + requireSP);
                List<VcleVehicleRequire> vvrList = new VcleVehicleRequireDao().GetVcleVehicleRequireByRequireSp(requireSP);
                VcleVehicleRequire vvrCopy = vvrList.get(0);
                VcleRecordMovementJoin vrmJoin = new VcleRecordMovementJoin(vvrCopy, vrm, false);
                new VcleRecordMovementJoinDao().save(vrmJoin);
            }
            new HibernateSessionCon().CommitTrans();
            new HibernateSessionCon().clearConn();
            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
            if(e.getMessage().equals("InvalidDateTime")){
                response.getWriter().write("برجاء ملئ التاريخ بشكل كامل");
            }else if (e.getMessage().equals("NoEmpDriver")) {
                response.getWriter().write("هذا السائق غير مسكن بنظام شئون العاملين");
            } else {
                response.getWriter().write("Error");

            }
            System.err.println(" ---------- Error In Query -----------");
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
