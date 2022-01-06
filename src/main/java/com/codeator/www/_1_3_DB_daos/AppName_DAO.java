/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.AppName;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Adam
 */
public class AppName_DAO<T> extends AbstractDao<T> {

    public Integer getMaxID() {
        Query query = session.createQuery("SELECT IFNULL(max(p.applicationId),0)+1 FROM AppName p  "); //HQL
        List<Integer> pList = query.getResultList();
        Integer number = 0;
        for (Integer num : pList) {
            number = num;
        }
        return number;
    }

    public List<AppName> getAll_ApplicationName() {
        Query query = session.createQuery("SELECT p FROM AppName p ORDER BY p.applicationIndex "); //HQL
        List<AppName> pList = query.getResultList();
        return pList;
    }


    public List<AppName> getAll_ApplicationName_ById(String applicationId) {
        Query query = session.createQuery("SELECT p FROM AppName p where p.applicationId=" + applicationId + "  "); //HQL
        List<AppName> pList = query.getResultList();
        return pList;
    }

}
