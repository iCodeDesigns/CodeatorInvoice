/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_0_SystemFilter;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_3_DB_daos.PerEmploymentMasterDao;
import com.codeator.www._6_1_Json_entities.PerDeptOld;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Moham
 */
public class _00010_Login_BusinessRule {

    long max_min_to_wait = 30;
    //-- users Login Data
    /**
     * userId - Login Time
     */
    private static Set<_00000_LoginSessions> Login_Sessions = new HashSet<_00000_LoginSessions>();

    /**
     * لا تسمج بتواجد أكثر من سيشن للبوزر الواحد
     *
     * @param currentSession : the running Session
     * @param employee_session : current user Data
     */
    boolean founded = false;

    public void loginControl(HttpSession currentSession, String host, String ip, PerEmploymentMaster employee_session) {
//        List<_00000_LoginSessions> sessionsFounded = Login_Sessions.stream()
//                .filter(p -> p.getPerUsers().getUserId() == employee_session.getUserId()).collect(Collectors.toList());    
        founded = false;
        boolean deleted = Login_Sessions.removeIf(p -> {
            if (p.getPerUsers().getEmployeeId() == employee_session.getEmployeeId()) {
                founded = true;
            }
            if (p.getPerUsers().getEmployeeId() == employee_session.getEmployeeId() && !p.getSession().getId().equals(currentSession.getId())) {
                try {
                    p.getSession().invalidate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;//delete from list
            } else {
                return false;//dont' delete from list
            }
        });
        if (!founded || deleted) {
            addNewSystemSession(currentSession, host, ip, employee_session);
        }

    }

    public void logOutControl(HttpSession currentSession) {
        boolean deleted = Login_Sessions.removeIf(p -> p.getSession().getId().equals(currentSession.getId()));
    }

    private void addNewSystemSession(HttpSession currentSession, String host, String ip, PerEmploymentMaster employee_session) {
        try {
            _00000_LoginSessions newEmplSession = new _00000_LoginSessions();
            newEmplSession.setPerUsers(employee_session);
            newEmplSession.setLoginTime(new Date());
            newEmplSession.setSession(currentSession);
            newEmplSession.setHost(host);
            newEmplSession.setIp(ip);
            Login_Sessions.add(newEmplSession);

        } catch (Exception e) {

            System.out.println(" --- >> Hash Set Adding Error : " + e.getMessage());
        }
    }

    /**
     * هتحذف المستخدمين اللي سايبين السيستم مفتوح فوق وقت معين
     */
    public void removeUnActiveSessions() {

        Login_Sessions.removeIf(p -> {

            DateOp dateOp = new DateOp();
            Date lastActiveTime = (Date) p.getSession().getAttribute("LastActiveTime");
            Date currentTime = dateOp.getSysDate();
            long unAccessedSessionMin = dateOp.differentsBetweenTwoDatesInMinuts(currentTime, lastActiveTime);
            if (unAccessedSessionMin >= max_min_to_wait) {
                try {
                    p.getSession().invalidate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            } else {
                return false;
            }

        });
    }

    /**
     * هل السيشن بتاعت اليوزر لسه متأكتفة ولى سايبها
     *
     * @param request الريكويست الحالي لليوزر للتأكد من ان السيشن بتاعته شغالة
     * @param employee_session بيانات المستخدم
     * @return true : لسه شغالة | false : سابها ومشي
     */
    public boolean sessionStillHot(HttpServletRequest request, PerEmploymentMaster employee_session) {
        //printUsersSessions();
        //-- إزالة المستخدمين اللي فاتحين السيستم ومش شغالين
        removeUnActiveSessions();

        //sessionStatus || true : session is active -- false : session not active
        boolean sessionStatus;
        if (employee_session == null) {
            sessionStatus = false;
        } else {
            sessionStatus = !Login_Sessions.removeIf(p -> {

                if (employee_session.getEmployeeId() == p.getPerUsers().getEmployeeId()) {
                    DateOp dateOp = new DateOp();

                    Date lastActiveTime = (Date) request.getSession().getAttribute("LastActiveTime");
                    Date currentTime = dateOp.getSysDate();
                    long unAccessedSessionMin = dateOp.differentsBetweenTwoDatesInMinuts(currentTime, lastActiveTime);
                    if (unAccessedSessionMin >= max_min_to_wait) {
                        try {
                            p.getSession().invalidate();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            });

        }

        return sessionStatus;
    }

    /**
     *
     */
    private static int iterate = 0;

    public static void printUsersSessions() {
        int i = 0;
        DateOp dateOp = new DateOp();
        System.out.println(" Function Call (" + (++iterate) + ")");
        System.out.println("   -- Number Of Users (" + Login_Sessions.size() + ") --");
        System.out.println("   -----------------------------------------------------");
        Login_Sessions.forEach(user_session -> {
            Date lastActiveTime = (Date) user_session.getSession().getAttribute("LastActiveTime");
            Date currentTime = dateOp.getSysDate();
            long unAccessedSessionMin = dateOp.differentsBetweenTwoDatesInMinuts(currentTime, lastActiveTime);
            System.out.println("     --    Session ID : " + user_session.getSession().getId());
            System.out.println("     --       User ID : " + user_session.getPerUsers().getEmployeeId());
            System.out.println("     --     User Name : " + user_session.getPerUsers().getEmpAname());
            System.out.println("     --    LogIn Time : " + dateOp.Date2String(user_session.getLoginTime(), "yyyy-MM-dd HH:mm:ss"));
            System.out.println("     -- In Active For : " + unAccessedSessionMin);
            System.out.println("     --          Host : " + user_session.getHost());
            System.out.println("     --            IP : " + user_session.getIp());
            System.out.println("     --------------------------------------------------------------------------------------------");
        });
        System.out.println("$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%");
        System.out.println("$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%");
        System.out.println("$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%$%");
    }

    // Query For Users Online
    /**
     *
     * @return
     */
    private Set<Long> getUserIdList() {
        Set<Long> userIdList = new HashSet<>(0);
        for (_00000_LoginSessions Login_Session : Login_Sessions) {
            userIdList.add(Login_Session.getPerUsers().getEmployeeId());
        }
        return userIdList;
    }

    private com.codeator.www._6_1_Json_entities.PerEmploymentMaster users;

    /**
     * هات مجموعة اليوزرز اللي مسجلين دخولهم فالسيستم
     *
     * @return
     */
    public List<com.codeator.www._6_1_Json_entities.PerEmploymentMaster> getUsersSessions() {
        new HibernateSessionCon().OpenCon();
        Set<Long> userIdList = getUserIdList();
        List<com.codeator.www._6_1_Json_entities.PerEmploymentMaster> usersList = new ArrayList<>();
        if (!userIdList.isEmpty()) {
            List<PerEmploymentMaster> pList = new PerEmploymentMasterDao<>().GetEmployeesByEmployeeIDs(userIdList);

            pList.forEach(perUsers -> {
                users = new com.codeator.www._6_1_Json_entities.PerEmploymentMaster();
                users.setEmployeeId(perUsers.getEmployeeId());
                users.setEmpAname(perUsers.getEmpAname());

                PerDeptOld perDepartments = new PerDeptOld();
                perDepartments.setDepName((perUsers.getPerDeptOld() == null) ? "" : perUsers.getPerDeptOld().getDepName());
                users.setPerDeptOld(perDepartments);

                List<_00000_LoginSessions> user_login_session = Login_Sessions.stream()
                        .filter(p -> p.getPerUsers().getEmployeeId() == perUsers.getEmployeeId()).collect(Collectors.toList());
                users.setBirthDate(user_login_session.get(0).getLoginTime());
                users.setEmpEname(user_login_session.get(0).getIp());
                users.setEmployeeNo(user_login_session.get(0).getHost());
                usersList.add(users);
            });

            new HibernateSessionCon().clearConn();
            new HibernateSessionCon().closeConn();
        }
        return usersList;
    }
}
