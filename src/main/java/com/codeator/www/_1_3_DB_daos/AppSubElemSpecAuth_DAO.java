/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;


import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.AppSubElemSpecAuth;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Support
 */
public class AppSubElemSpecAuth_DAO<T> extends AbstractDao<T> {

    public List<AppSubElemSpecAuth> getEmpSubTabElementsSpecAuth(String employeeId, String applicationId, String tabId, String subTabId, String elementId) {
        Query query = session.createQuery("SELECT p FROM AppSubElemSpecAuth p where p.id.elementId=" + elementId + " and p.id.tabId=" + tabId + " and p.id.subTabId=" + subTabId + " and p.id.applicationId=" + applicationId + " and p.id.employeeId=" + employeeId + " "); //HQL
        List<AppSubElemSpecAuth> pList = query.getResultList();
        return pList;
    }

    public List<AppSubElemSpecAuth> getEmpSubTabElementsSpecAuthInSubTab(String employeeId, String applicationId, String tabId, String subTabId) {
        Query query = session.createQuery("SELECT p FROM AppSubElemSpecAuth p where p.id.tabId=" + tabId + " and p.id.subTabId=" + subTabId + " and p.id.applicationId=" + applicationId + " and p.id.employeeId=" + employeeId + " "); //HQL
        List<AppSubElemSpecAuth> pList = query.getResultList();
        return pList;
    }

    public List<AppSubElemSpecAuth> getEmpSubTabElementsSpecAuth(String employeeId) {
        Query query = session.createQuery("SELECT p FROM AppSubElemSpecAuth p where p.id.employeeId=" + employeeId + " "); //HQL
        List<AppSubElemSpecAuth> pList = query.getResultList();
        return pList;
    }

    public List<AppSubElemSpecAuth> getEmpSubTabElementsSpecAuthAvailableToGive(String employeeId) {
        Query query = session.createQuery("SELECT p FROM AppSubElemSpecAuth p where p.primaryAuthPass=2 and p.id.employeeId=" + employeeId + " "); //HQL
        List<AppSubElemSpecAuth> pList = query.getResultList();
        return pList;
    }

    public List<AppSubElemSpecAuth> getEmpSubTabElementsSpecAuthInSubTab(String employeeId, String AccessServletName) {
        Query query = session.createQuery("SELECT p FROM AppSubElemSpecAuth p where p.appSubElem.appSubTab.subTabAccessservlet='" + AccessServletName + "' and p.id.employeeId=" + employeeId + " "); //HQL
        List<AppSubElemSpecAuth> pList = query.getResultList();
        return pList;
    }

}
