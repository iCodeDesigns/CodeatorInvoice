/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.InvoDeptUnitJoin;
import com.codeator.www._1_2_DB_entities.InvoUnitType;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Moham
 */
public class InvoDeptUnitJoinDAO<T> extends AbstractDao<T> {

    public List<InvoDeptUnitJoin> GetSelectedUnitInDept(String accUnitCode, String sectionNoOld, String depNoOld) {
        Query query = session.createQuery("SELECT p from InvoDeptUnitJoin p where p.id.accUnitCode=:accUnitCode and p.id.sectionNoOld=:sectionNoOld and p.id.depNoOld=:depNoOld");
        query.setString("accUnitCode", accUnitCode);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("depNoOld", depNoOld);
        List<InvoDeptUnitJoin> pList = query.getResultList();
        return pList;
    }

    public List<InvoDeptUnitJoin> GetInvoUnitTypeInDept(String accUnitCode, String sectionNoOld, String depNoOld) {
        //SELECT i from InvoDeptTaxJoin i where i.invoTaxTypeDtl.invoTaxType.taxable=:taxable and i.id.depNoOld=:depNoOld and i.id.sectionNoOld=:sectionNoOld
        Query query = session.createQuery("SELECT i from InvoDeptUnitJoin i where i.id.accUnitCode=:accUnitCode and i.id.sectionNoOld=:sectionNoOld and i.id.depNoOld=:depNoOld");
        query.setString("accUnitCode", accUnitCode);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("depNoOld", depNoOld);
        List<InvoDeptUnitJoin> pList = query.getResultList();
        return pList;
    }

    public List<InvoUnitType> GetNotSelectedUnitInDept(String accUnitCode, String sectionNoOld, String depNoOld) {
        Query query = session.createQuery("SELECT i from InvoUnitType i where (i.unitType) not in (Select p.id.unitType from InvoDeptUnitJoin p where p.id.accUnitCode=:accUnitCode and p.id.sectionNoOld=:sectionNoOld and p.id.depNoOld=:depNoOld)");
        query.setString("accUnitCode", accUnitCode);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("depNoOld", depNoOld);
        List<InvoUnitType> pList = query.getResultList();
        return pList;
    }

}
