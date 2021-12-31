/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
//import com.codeator.www._1_2_DB_entities.InvInvoiceMasterItemTax;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class InvInvoiceMasterItemTaxDAO<T> extends AbstractDao<T> {
    
    /*public List<InvInvoiceMasterItemTax> GetInvInvoiceMasterItemTaxByinvoSpAndaccountUnitCode(String invoSp,String accountUnitCode,String invoSpItem) {
        Query query = session.createQuery("SELECT p from InvInvoiceMasterItemTax p where p.id.invoSp=:invoSp and p.id.accountUnitCode=:accountUnitCode and p.id.invoSpItem=:invoSpItem ");
        query.setString("invoSp", invoSp);
        query.setString("accountUnitCode", accountUnitCode);
        query.setString("invoSpItem", invoSpItem);
        List<InvInvoiceMasterItemTax> pList = query.getResultList();
        return pList;
    }*/
    
}
