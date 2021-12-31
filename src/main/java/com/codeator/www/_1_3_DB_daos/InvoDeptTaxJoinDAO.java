/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.InvoDeptTaxJoin;
import com.codeator.www._1_2_DB_entities.InvoTaxTypeDtl;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class InvoDeptTaxJoinDAO<T> extends AbstractDao<T> {

    public List<InvoDeptTaxJoin> GetSelectedTaxInDept(String accUnitCode, String sectionNoOld, String depNoOld) {
        Query query = session.createQuery("SELECT p from InvoDeptTaxJoin p where p.id.accUnitCode=:accUnitCode and p.id.sectionNoOld=:sectionNoOld and p.id.depNoOld=:depNoOld");
        query.setString("accUnitCode", accUnitCode);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("depNoOld", depNoOld);
        List<InvoDeptTaxJoin> pList = query.getResultList();
        return pList;
    }

    public List<InvoDeptTaxJoin> GetTaxInDeptByTaxSubType(String taxType, String taxSubtype, String accUnitCode, String sectionNoOld, String depNoOld) {
        Query query = session.createQuery("SELECT p from InvoDeptTaxJoin p where p.id.accUnitCode=:accUnitCode and p.id.sectionNoOld=:sectionNoOld and p.id.depNoOld=:depNoOld and p.id.taxType=:taxType and p.id.taxSubtype=:taxSubtype");
        query.setString("accUnitCode", accUnitCode);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("depNoOld", depNoOld);
        query.setString("taxType", taxType);
        query.setString("taxSubtype", taxSubtype);
        List<InvoDeptTaxJoin> pList = query.getResultList();
        return pList;
    }

    public List<InvoTaxTypeDtl> GetNotSelectedTaxInDept(String accUnitCode, String sectionNoOld, String depNoOld) {
        Query query = session.createQuery("SELECT i from InvoTaxTypeDtl i where (i.id.taxType , i.id.taxSubtype) not in (Select p.id.taxType , p.id.taxSubtype from InvoDeptTaxJoin p where p.id.accUnitCode=:accUnitCode and p.id.sectionNoOld=:sectionNoOld and p.id.depNoOld=:depNoOld)");
        query.setString("accUnitCode", accUnitCode);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("depNoOld", depNoOld);
        List<InvoTaxTypeDtl> pList = query.getResultList();
        return pList;
    }

    public List<InvoDeptTaxJoin> GetInvoItemCodeByDeptAndSection(String taxable,String accUnitCode, String sectionNoOld, String depNoOld) {
        Query query = session.createQuery("SELECT i from InvoDeptTaxJoin i where i.invoTaxTypeDtl.invoTaxType.taxable=:taxable and i.id.accUnitCode=:accUnitCode and i.id.depNoOld=:depNoOld and i.id.sectionNoOld=:sectionNoOld");
        query.setString("taxable", taxable);
        query.setString("accUnitCode", accUnitCode);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        List<InvoDeptTaxJoin> pList = query.getResultList();
        return pList;
    }

}
