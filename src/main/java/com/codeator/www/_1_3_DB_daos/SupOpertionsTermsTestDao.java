/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.SupOpertionsTermsTest;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class SupOpertionsTermsTestDao<T> extends AbstractDao<T> {

    public List<SupOpertionsTermsTest> GetSupOpertionsTermsTestBy(String supplierId, String operationId) {
        Query query = session.createQuery("SELECT p from SupOpertionsTermsTest p where p.id.supplierId=:supplierId and p.id.operationId=:operationId ORDER BY p.id.termId ");
        query.setString("supplierId", supplierId);
        query.setString("operationId", operationId);
        List<SupOpertionsTermsTest> pList = query.getResultList();
        return pList;
    }
    
}
