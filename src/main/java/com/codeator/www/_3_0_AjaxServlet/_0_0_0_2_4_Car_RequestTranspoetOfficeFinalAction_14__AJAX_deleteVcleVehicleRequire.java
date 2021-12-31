/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_2_DB_entities.VcleEmployeeMaster;
import com.codeator.www._1_2_DB_entities.VcleRecordMovement;
import com.codeator.www._1_2_DB_entities.VcleRecordMovementJoin;
import com.codeator.www._1_2_DB_entities.VcleVehicleDriverJoin;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequire;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequireStatus;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequireStatusDt;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequireStatusDtId;
import com.codeator.www._1_3_DB_daos.VcleEmployeeMasterDao;
import com.codeator.www._1_3_DB_daos.VcleRecordMovementDAO;
import com.codeator.www._1_3_DB_daos.VcleVehicleDriverJoinDAO;
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
 * @author Mohamed
 */
public class _0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_14__AJAX_deleteVcleVehicleRequire extends HttpServlet {

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

            String GoingSp = request.getParameter("GoingSp");
            String causeOfIgnore = request.getParameter("causeOfIgnore");
            
            new HibernateSessionCon().beginTrans();
            List<VcleRecordMovement> tripsList = new VcleRecordMovementDAO().GetVcleRecordMovementByGopingSp(GoingSp);
            VcleRecordMovement vrm = tripsList.get(0);
            for (VcleRecordMovementJoin vrmj : vrm.getVcleRecordMovementJoins()) {
                VcleVehicleRequire v = vrmj.getVcleVehicleRequire();

                List<VcleVehicleRequireStatus> vvrsList = new VcleVehicleRequireStatusDao().GetVcleVehicleRequireByRequireStatus("26");
                if (vvrsList.isEmpty()) {
                    throw new Exception();
                }
                
                VcleVehicleRequireStatus vvrs = vvrsList.get(0);
                v.setVcleVehicleRequireStatus(vvrs);//update vcle_vcle_require with the final status
                VcleVehicleRequireStatusDtDao vvrsDao = new VcleVehicleRequireStatusDtDao();
                byte statusSeq = Byte.parseByte("" + vvrsDao.GetMaxStatusSeq("" + v.getRequireSp()));
                VcleVehicleRequireStatusDtId vvrsdi = new VcleVehicleRequireStatusDtId(v.getRequireSp(), statusSeq);
                VcleVehicleRequireStatusDt vvrsd = new VcleVehicleRequireStatusDt(vvrsdi, vvrs, v, employee_session, employee_session.getEmployeeNo(), causeOfIgnore,new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"),new DateOp().getSysDate());

                
                dao.update(v);
                dao.insert(vvrsd);                
                
                dao.delete(vrmj);
            }
            dao.delete(vrm);
            
            new HibernateSessionCon().CommitTrans();
            new HibernateSessionCon().clearConn();

            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error");
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
