/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos_mysql;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mySqlMainDao.AbstractDao;
import static com.codeator.www._1_1_DB_mySqlMainDao.HibernateSessionConMySql.session;
import com.codeator.www._1_2_DB_entities_mysql.CalenderAlertNotifications;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mahmoud
 */
public class CalenderAlertNotificationsDao<T> extends AbstractDao<T> {

    public long GetMaxCalenderAlertNotificationsID() {
        Query query = session.createQuery("Select max(c.calId) from CalenderAlertNotifications c ");
        long maxRequireSp = GetQueryNumber(query);
        return maxRequireSp;
    }

    private long GetQueryNumber(Query query) {
        List<Integer> list = query.getResultList();
        long number = 1;// no Employee saved in the system
        if (list.get(0) != null) {
            number = list.get(0) + 1;
        }
        return number;
    }

    public List<CalenderAlertNotifications> GetAllDNotificationsByEmpId(String empId) {
        Query query = session.createQuery("SELECT c from CalenderAlertNotifications c where c.calStatus='active' and c.employees.empId='" + empId + "' and c.calDateTime>='" + new DateOp().getCustomSysDate("yyyy-MM-dd") + " 00:00:00' order by c.calDateTime ");
        List<CalenderAlertNotifications> dList = query.getResultList();
        return dList;
    }

    public List<CalenderAlertNotifications> GetNotificationsByID(String c_id) {
        Query query = session.createQuery("SELECT c from CalenderAlertNotifications c where c.calId='" + c_id + "'");
        List<CalenderAlertNotifications> dList = query.getResultList();
        return dList;
    }
}
