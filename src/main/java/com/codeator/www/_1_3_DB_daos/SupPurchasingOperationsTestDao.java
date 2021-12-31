/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.SupPurchasingOperationsTest;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class SupPurchasingOperationsTestDao<T> extends AbstractDao<T> {

    public List<SupPurchasingOperationsTest> GetSupPurchasingOperationsTestBysupplierId(String supplierId) {
        Query query = session.createQuery("SELECT p from SupPurchasingOperationsTest p where p.id.supplierId=:supplierId ORDER BY p.id.operationId ");
        query.setString("supplierId", supplierId);
        List<SupPurchasingOperationsTest> pList = query.getResultList();
        return pList;
    }
    
}
