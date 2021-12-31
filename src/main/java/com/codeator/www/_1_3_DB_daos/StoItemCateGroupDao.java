/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.StoItemCateGroup;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class StoItemCateGroupDao<T> extends AbstractDao<T> {

    public List<StoItemCateGroup> GetAllStoItemCateGroup(String cateCode) {
        Query query = session.createQuery("SELECT p from StoItemCateGroup p where p.id.cateCode=:cateCode ORDER BY p.id.groupCode ");
        query.setString("cateCode", cateCode);
        List<StoItemCateGroup> pList = query.getResultList();
        return pList;
    }
    
}
