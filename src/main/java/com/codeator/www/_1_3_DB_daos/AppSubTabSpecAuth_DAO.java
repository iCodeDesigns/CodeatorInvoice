/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;


import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.AppSubTabSpecAuth;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Support
 */
public class AppSubTabSpecAuth_DAO<T> extends AbstractDao<T> {

    public synchronized List<AppSubTabSpecAuth> getEmpSubTabSpecAuth(String employeeId, String applicationId, String tabId, String subTabId) {
        Query query = session.createQuery("SELECT p FROM AppSubTabSpecAuth p where p.id.tabId=" + tabId + " and p.id.subTabId=" + subTabId + " and p.id.applicationId=" + applicationId + " and p.id.employeeId=" + employeeId + " "); //HQL
        List<AppSubTabSpecAuth> pList = query.getResultList();
        return pList;
    }

    public List<AppSubTabSpecAuth> getEmpSubTabSpecAuth(String employeeId) {
        Query query = session.createQuery("SELECT p FROM AppSubTabSpecAuth p where p.id.employeeId=" + employeeId + " "); //HQL
        List<AppSubTabSpecAuth> pList = query.getResultList();
        return pList;
    }
    
    public List<AppSubTabSpecAuth> getEmpSubTabSpecAuthAvailableToGive(String employeeId) {
        Query query = session.createQuery("SELECT p FROM AppSubTabSpecAuth p where p.primaryAuthPass=2 and p.id.employeeId=" + employeeId + " "); //HQL
        List<AppSubTabSpecAuth> pList = query.getResultList();
        return pList;
    }

}
