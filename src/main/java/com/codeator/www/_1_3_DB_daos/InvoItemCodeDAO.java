/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.InvoItemCode;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class InvoItemCodeDAO<T> extends AbstractDao<T> {

    public List<InvoItemCode> GetInvItemCode() {
        Query query = session.createQuery("SELECT p from InvoItemCode p order by p.AItemName ");
        List<InvoItemCode> pList = query.getResultList();
        return pList;
    }

    public List<InvoItemCode> GetInvItemCodeByItemCode(String itemCode) {
        Query query = session.createQuery("SELECT p from InvoItemCode p where p.itemCode=:itemCode");
        query.setString("itemCode", itemCode);
        List<InvoItemCode> pList = query.getResultList();
        return pList;
    }

    public List<InvoItemCode> GetInvItemCodeForDept(String depNoOld, String sectionNoOld) {
        Query query = session.createQuery("SELECT p from InvoItemCode as p INNER JOIN p.invoDeptItemJoins as i where i.id.depNoOld=:depNoOld and i.id.sectionNoOld=:sectionNoOld order by i.invoItemCode.AItemName ");
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        List<InvoItemCode> pList = query.getResultList();
        return pList;
    }

    public List<InvoItemCode> GetInvItemCodeForDeptAndCodeType(String accUnitCode, String depNoOld, String sectionNoOld, String codeType) {
        Query query = session.createQuery("SELECT p from InvoItemCode as p INNER JOIN p.invoDeptItemJoins as i where i.id.depNoOld=:depNoOld and i.id.sectionNoOld=:sectionNoOld and i.id.accUnitCode=:accUnitCode and i.invoItemCode.codeType=:codeType ORDER BY i.invoItemCode.AItemName");
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("accUnitCode", accUnitCode);
        query.setString("codeType", codeType);
        List<InvoItemCode> pList = query.getResultList();
        return pList;
    }

}
