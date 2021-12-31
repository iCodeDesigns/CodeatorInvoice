/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.InvoUnitType;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class InvoUnitTypeDAO<T> extends AbstractDao<T> {

    public List<InvoUnitType> GetInvoUnitType() {
        Query query = session.createQuery("SELECT i from InvoUnitType i");
        List<InvoUnitType> pList = query.getResultList();
        return pList;
    }

    

    public List<InvoUnitType> GetInvoUnitTypeByUnitTypeCode(String unitType) {
        Query query = session.createQuery("SELECT i from InvoUnitType i where i.unitType=:unitType ");
        query.setString("unitType", unitType);
        List<InvoUnitType> pList = query.getResultList();
        return pList;
    }

}
