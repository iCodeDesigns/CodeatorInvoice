/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
//import com.codeator.www._1_2_DB_entities.InvTaxSubtype;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class InvTaxSubtypeDAO<T> extends AbstractDao<T> {

    /*public List<InvTaxSubtype> GetInvItemCode(String taxable, String accountUnitCode) {
        Query query = session.createQuery("SELECT i from InvTaxSubtype as i INNER JOIN i.invAccTaxSubtypeJoins as j where i.invTaxType.taxable=:taxable and j.accAccountUnits.accountUnitCode=:accountUnitCode ");
        query.setString("taxable", taxable);
        query.setString("accountUnitCode", accountUnitCode);
        List<InvTaxSubtype> pList = query.getResultList();
        return pList;
    }

    public List<InvTaxSubtype> GetInvTaxSubtypeById(String taxTypeCode, String taxSubtypeCode) {
        Query query = session.createQuery("SELECT i from InvTaxSubtype i where i.id.taxTypeCode=:taxTypeCode and i.id.taxSubtypeCode=:taxSubtypeCode");
        query.setString("taxTypeCode", taxTypeCode);
        query.setString("taxSubtypeCode", taxSubtypeCode);
        List<InvTaxSubtype> pList = query.getResultList();
        return pList;
    }*/

}
