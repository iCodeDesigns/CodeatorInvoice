/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class StoResponsibilityDeptDao<T> extends AbstractDao<T> {
    
    public long GetCountDeptRespsByRespTypeActNot9(String HQL) {
        Query query = session.createQuery("SELECT count(*) from StoResponsibilityDept s WHERE "+HQL+" and s.qty>0 and s.recvType in (1, 2, 3, 7) ");
        List<Long> pList = query.getResultList();
        return pList.get(0);
    }
    
}
