/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.AppSubTab;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class AppSubTab_DAO<T> extends AbstractDao<T> {

    public Integer getMaxID(String applicationId, String tabId) {
        Query query = session.createQuery("SELECT nvl(max(p.id.subTabId),0)+1 FROM AppSubTab p where p.id.applicationId=" + applicationId + " and p.id.tabId=" + tabId + " "); //HQL
        List<Integer> pList = query.getResultList();
        Integer number = 0;
        for (Integer num : pList) {
            number = num;
        }
        return number;
    }

    public List<AppSubTab> get_AllApplicationSubTabs() {
        Query query = session.createQuery("SELECT p FROM AppSubTab p ORDER BY p.subTabIndex "); //HQL
        List<AppSubTab> pList = query.getResultList();
        return pList;
    }

    public List<AppSubTab> get_ApplicationSubTabsByApplicationId(String applicationId, String tabId) {
        Query query = session.createQuery("SELECT p FROM AppSubTab p where p.id.applicationId=" + applicationId + " and p.id.tabId=" + tabId + " ORDER BY p.subTabIndex "); //HQL
        List<AppSubTab> pList = query.getResultList();
        return pList;
    }

    public List<AppSubTab> get_ApplicationSubTabsByApplicationIdExceptAuthType1(String applicationId, String tabId) {
        Query query = session.createQuery("SELECT p FROM AppSubTab p where p.appSubTabAuthType.authTypeId!=1 and p.id.applicationId=" + applicationId + " and p.id.tabId=" + tabId + " ORDER BY p.subTabIndex "); //HQL
        List<AppSubTab> pList = query.getResultList();
        return pList;
    }

    public List<AppSubTab> get_ApplicationSubTabsByApplicationIdWithAuthType1(String applicationId, String tabId, String subTabId) {
        Query query = session.createQuery("SELECT p FROM AppSubTab p where p.appSubTabAuthType=1 and p.id.applicationId=" + applicationId + " and p.id.tabId=" + tabId + " and p.id.subTabId=" + subTabId + " ORDER BY p.subTabIndex "); //HQL
        List<AppSubTab> pList = query.getResultList();
        return pList;
    }

    public List<AppSubTab> get_ApplicationSubTabsById(String applicationId, String tabId, String subTabId) {
        Query query = session.createQuery("SELECT p FROM AppSubTab p where p.id.applicationId=" + applicationId + " and p.id.tabId=" + tabId + " and p.id.subTabId=" + subTabId + " "); //HQL
        List<AppSubTab> pList = query.getResultList();
        return pList;
    }

    public List<AppSubTab> getAllApplicationSubTabs() {
        Query query = session.createQuery("SELECT p FROM AppSubTab p ORDER BY p.subTabAccessservlet "); //HQL
        List<AppSubTab> pList = query.getResultList();
        return pList;
    }

    public List<AppSubTab> getAllApplicationSubTabsAvailableToGive(String employeeId) {
        Query query = session.createQuery("SELECT p FROM AppSubTab p INNER JOIN p.appSubTabSpecAuths as f where f.perEmploymentMasterByEmployeeId.employeeId=" + employeeId + " and f.primaryAuthPass=2 ORDER BY p.subTabIndex "); //HQL
        List<AppSubTab> pList = query.getResultList();
        return pList;
    }

    public synchronized List<AppSubTab> getApplicationSubTabByAccessServlet(String subTabAccessservlet) {
        ////System.out.println("SELECT p FROM ApplicationSubTab p where p.subTabAccessservlet='" + subTabAccessservlet + "' ");
        Query query = session.createQuery("SELECT p FROM AppSubTab p where p.subTabAccessservlet='" + subTabAccessservlet + "' "); //HQL
        List<AppSubTab> pList = query.getResultList();
        return pList;
    }

}
