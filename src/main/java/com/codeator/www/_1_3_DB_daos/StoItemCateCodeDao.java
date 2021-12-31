/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.StoItemCateCode;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mohamed
 */
public class StoItemCateCodeDao<T> extends AbstractDao<T> {

    public List<StoItemCateCode> GetAllStoItemCateCode() {
        Query query = session.createQuery("SELECT p from StoItemCateCode p where p.cateCode!=30 ORDER BY p.cateCode");
        List<StoItemCateCode> pList = query.getResultList();
        return pList;
    }
    
}
