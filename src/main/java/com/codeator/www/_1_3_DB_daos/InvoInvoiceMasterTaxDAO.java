/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterTax;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class InvoInvoiceMasterTaxDAO<T> extends AbstractDao<T> {

    public List<InvoInvoiceMasterTax> GetInvoInvoiceMasterTaxByinvoSpAndSectionAndDept(String invoSp,String accUnitCode, String depNoOld, String sectionNoOld, String invoSpItem) {
        Query query = session.createQuery("SELECT p from InvoInvoiceMasterTax p where p.id.invoSp=:invoSp and p.id.accUnitCode=:accUnitCode and p.id.depNoOld=:depNoOld and p.id.sectionNoOld=:sectionNoOld and p.id.invoSpItem=:invoSpItem ");
        query.setString("invoSp", invoSp);
        query.setString("accUnitCode", accUnitCode);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("invoSpItem", invoSpItem);
        List<InvoInvoiceMasterTax> pList = query.getResultList();
        return pList;
    }

}
