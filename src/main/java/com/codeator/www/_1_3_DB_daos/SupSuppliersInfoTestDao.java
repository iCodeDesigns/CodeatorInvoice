/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.SupSuppliersInfoTest;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class SupSuppliersInfoTestDao<T> extends AbstractDao<T> {

    public long GetCountRecords() {
        javax.persistence.Query query = session.createQuery("SELECT COUNT(p.supplierId) from SupSuppliersInfoTest p");
        long maxRequireSp = GetQueryLongNumber(query);
        return maxRequireSp;
    }

    private long GetQueryLongNumber(javax.persistence.Query query) {
        List<Long> list = query.getResultList();
        long number = 1;// no Employee saved in the system
        if (list.get(0) != null) {
            number = list.get(0);
        }
        //System.out.println(number);
        return number;
    }

    public List<SupSuppliersInfoTest> GetAllSupSuppliersInfoTest(int start_record, int end_record) {
        Query query = session.createQuery("SELECT p from SupSuppliersInfoTest p ORDER BY p.supplierId");
        query.setFirstResult(start_record);
        query.setMaxResults(end_record);
        List<SupSuppliersInfoTest> pList = query.getResultList();
        return pList;
    }

}
