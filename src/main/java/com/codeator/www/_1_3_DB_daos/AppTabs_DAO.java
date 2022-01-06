/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;


import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.AppTabs;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class AppTabs_DAO<T> extends AbstractDao<T> {

    public Integer getMaxID(String applicationId) {
        Query query = session.createQuery("SELECT IFNULL(max(p.id.tabId),0)+1 FROM AppTabs p where p.id.applicationId=" + applicationId + " "); //HQL
        List<Integer> pList = query.getResultList();
        Integer number = 0;
        for (Integer num : pList) {
            number = num;
        }
        return number;
    }

    public List<AppTabs> get_AllApplicationTabs() {
        Query query = session.createQuery("SELECT p FROM AppTabs p ORDER BY p.tabIndex "); //HQL
        List<AppTabs> pList = query.getResultList();
        return pList;
    }

    public List<AppTabs> get_ApplicationTabsByApplicationId(String applicationId) {
        Query query = session.createQuery("SELECT p FROM AppTabs p where p.id.applicationId=" + applicationId + " ORDER BY p.tabIndex "); //HQL
        List<AppTabs> pList = query.getResultList();
        return pList;
    }

    public List<AppTabs> get_ApplicationTabsById(String applicationId, String tabId) {
        Query query = session.createQuery("SELECT p FROM AppTabs p where p.id.applicationId=" + applicationId + " and p.id.tabId=" + tabId + " "); //HQL
        List<AppTabs> pList = query.getResultList();
        return pList;
    }

}
