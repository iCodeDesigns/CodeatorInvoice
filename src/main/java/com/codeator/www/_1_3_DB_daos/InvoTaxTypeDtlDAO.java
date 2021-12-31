/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.InvoTaxTypeDtl;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class InvoTaxTypeDtlDAO<T> extends AbstractDao<T> {

    public List<InvoTaxTypeDtl> GetInvItemCode(String taxable, String accountUnitCode) {
        Query query = session.createQuery("SELECT i from InvoTaxTypeDtl as i INNER JOIN i.invAccTaxSubtypeJoins as j where i.invTaxType.taxable=:taxable and j.accAccountUnits.accountUnitCode=:accountUnitCode ");
        query.setString("taxable", taxable);
        query.setString("accountUnitCode", accountUnitCode);
        List<InvoTaxTypeDtl> pList = query.getResultList();
        return pList;
    }

    public List<InvoTaxTypeDtl> GetInvTaxSubtypeById(String taxType, String taxSubtype) {
        Query query = session.createQuery("SELECT i from InvoTaxTypeDtl i where i.id.taxType=:taxType and i.id.taxSubtype=:taxSubtype");
        query.setString("taxType", taxType);
        query.setString("taxSubtype", taxSubtype);
        List<InvoTaxTypeDtl> pList = query.getResultList();
        return pList;
    }

    public List<InvoTaxTypeDtl> GetInvoItemCodeByDeptAndSection(String taxable, String sectionNoOld, String depNoOld) {
        Query query = session.createQuery("SELECT i from InvoTaxTypeDtl as i INNER JOIN i.invoDeptTaxJoins as j where i.invoTaxType.taxable=:taxable and j.id.depNoOld=:depNoOld and j.id.sectionNoOld=:sectionNoOld");
        query.setString("taxable", taxable);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        List<InvoTaxTypeDtl> pList = query.getResultList();
        return pList;
    }
    
    public List<InvoTaxTypeDtl> GetInvoItemCodeByTaxble(String taxable) {
        Query query = session.createQuery("SELECT i from InvoTaxTypeDtl i where i.invoTaxType.taxable=:taxable and i.id.taxSubtype IN (SELECT j.id.taxSubtype From InvoInvoiceMasterTax j )");
        query.setString("taxable", taxable);
        List<InvoTaxTypeDtl> pList = query.getResultList();
        return pList;
    }

}
