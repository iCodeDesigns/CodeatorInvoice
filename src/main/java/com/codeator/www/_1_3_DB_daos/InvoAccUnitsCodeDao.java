/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.InvoAccUnitsCode;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Moham
 */
public class InvoAccUnitsCodeDao<T> extends AbstractDao<T> {

    public List<InvoAccUnitsCode> GetInvoAccUnitsCode(String accUnitCode) {
        Query query = session.createQuery("SELECT p from InvoAccUnitsCode p WHERE p.accUnitCode=:accUnitCode ");
        query.setString("accUnitCode", accUnitCode);
        List<InvoAccUnitsCode> pList = query.getResultList();
        return pList;
    }

    public List<InvoAccUnitsCode> GetInvoAccUnitsCodeDistinctFromInvoiceMaster() {
        Query query = session.createQuery("SELECT p from InvoAccUnitsCode p WHERE p.accUnitCode IN (Select distinct(c.id.accUnitCode) From InvoInvoiceMaster c) and p.accUnitCode!='80'");
        List<InvoAccUnitsCode> pList = query.getResultList();
        return pList;
    }

}
