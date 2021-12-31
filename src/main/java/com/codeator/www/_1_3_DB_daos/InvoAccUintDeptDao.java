/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.InvoAccUintDept;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Moham
 */
public class InvoAccUintDeptDao<T> extends AbstractDao<T> {

    public List<InvoAccUintDept> GetInvoAccUintInDept(String sectionNoOld, String depNoOld, String accUnitCode) {
        //SELECT i from InvoDeptTaxJoin i where i.invoTaxTypeDtl.invoTaxType.taxable=:taxable and i.id.depNoOld=:depNoOld and i.id.sectionNoOld=:sectionNoOld
        Query query = session.createQuery("SELECT i from InvoAccUintDept i where i.id.sectionNoOld=:sectionNoOld and i.id.depNoOld=:depNoOld AND i.id.accUnitCode=:accUnitCode");
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("depNoOld", depNoOld);
        query.setString("accUnitCode", accUnitCode);
        List<InvoAccUintDept> pList = query.getResultList();
        return pList;
    }

    public List<InvoAccUintDept> GetInvoAccUintInDeptAndUnit(String accUnitCode, String sectionNoOld, String depNoOld) {
        //SELECT i from InvoDeptTaxJoin i where i.invoTaxTypeDtl.invoTaxType.taxable=:taxable and i.id.depNoOld=:depNoOld and i.id.sectionNoOld=:sectionNoOld
        Query query = session.createQuery("SELECT i from InvoAccUintDept i where i.id.accUnitCode=:accUnitCode and i.id.sectionNoOld=:sectionNoOld and i.id.depNoOld=:depNoOld");
        query.setString("accUnitCode", accUnitCode);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("depNoOld", depNoOld);
        List<InvoAccUintDept> pList = query.getResultList();
        return pList;
    }

}
