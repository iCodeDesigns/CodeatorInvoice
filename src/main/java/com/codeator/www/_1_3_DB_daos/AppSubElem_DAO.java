/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;


import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.AppSubElem;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Support
 */
public class AppSubElem_DAO<T> extends AbstractDao<T> {

    public Integer getMaxID(String applicationId, String tabId, String subTabId) {
        Query query = session.createQuery("SELECT nvl(max(p.id.elementId),0)+1 FROM AppSubElem p where p.id.applicationId=" + applicationId + " and p.id.tabId=" + tabId + " and p.id.subTabId=" + subTabId + " "); //HQL
        List<Integer> pList = query.getResultList();
        Integer number = 0;
        for (Integer num : pList) {
            number = num;
        }
        return number;
    }

    public List<AppSubElem> getAll_ApplicationNameElementBySubTab(String applicationId, String tabId, String subTabId) {
        Query query = session.createQuery("SELECT p FROM AppSubElem p where p.id.applicationId=" + applicationId + " and p.id.tabId=" + tabId + " and p.id.subTabId=" + subTabId + " ORDER BY p.id.elementId "); //HQL
        List<AppSubElem> pList = query.getResultList();
        return pList;
    }

    public List<AppSubElem> getAll_ApplicationNameElementById(String applicationId, String tabId, String subTabId, String elementId) {
        Query query = session.createQuery("SELECT p FROM AppSubElem p where p.id.elementId=" + elementId + " and p.id.applicationId=" + applicationId + " and p.id.tabId=" + tabId + " and p.id.subTabId=" + subTabId + " ORDER BY p.id.elementId "); //HQL
        List<AppSubElem> pList = query.getResultList();
        return pList;
    }
    
    public List<AppSubElem> getApplicationNameElementByNameInSubTab(String applicationId, String tabId, String subTabId, String elementName) {
        Query query = session.createQuery("SELECT p FROM AppSubElem p where p.elementName='" + elementName + "' and p.id.applicationId=" + applicationId + " and p.id.tabId=" + tabId + " and p.id.subTabId=" + subTabId + " ORDER BY p.id.elementId "); //HQL
        List<AppSubElem> pList = query.getResultList();
        return pList;
    }
}
