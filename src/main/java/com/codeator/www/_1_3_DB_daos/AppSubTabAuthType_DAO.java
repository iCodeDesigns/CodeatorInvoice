/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.AppSubTabAuthType;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Moham
 */
public class AppSubTabAuthType_DAO <T> extends AbstractDao<T> {

    public List<AppSubTabAuthType> getAllApplicationSubTabAuthType() {
        Query query = session.createQuery("SELECT p FROM AppSubTabAuthType p "); //HQL
        List<AppSubTabAuthType> pList = query.getResultList();
        return pList;
    }
    
    public List<AppSubTabAuthType> getApplicationSubTabAuthTypeById(String authTypeId) {
        Query query = session.createQuery("SELECT p FROM AppSubTabAuthType p where p.authTypeId="+authTypeId+""); //HQL
        List<AppSubTabAuthType> pList = query.getResultList();
        return pList;
    }
    
}
