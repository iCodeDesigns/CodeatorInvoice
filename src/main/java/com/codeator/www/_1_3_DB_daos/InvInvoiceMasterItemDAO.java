/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
//import com.codeator.www._1_2_DB_entities.InvInvoiceMasterItem;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class InvInvoiceMasterItemDAO<T> extends AbstractDao<T> {

    /*public int GetMaxInvoSpItem(String accountUnitCode, String invoSp) {//
        Query query = session.createQuery("Select IFNULL(max(v.id.invoSpItem),0) from InvInvoiceMasterItem v where v.id.accountUnitCode=:accountUnitCode and v.id.invoSp=:invoSp");
        query.setString("accountUnitCode", accountUnitCode);
        query.setString("invoSp", invoSp);
        int maxRequireSp = GetQueryNumber(query);
        return maxRequireSp;
    }

    private int GetQueryNumber(Query query) {
        List<Integer> list = query.getResultList();
        int number = 1;// no Employee saved in the system
        if (list.get(0) != null) {
            number = list.get(0) + 1;
        }
        //System.out.println(number);
        return number;
    }

    public List<InvInvoiceMasterItem> GetInvInvoiceMasterItemByinvoSpAndaccountUnitCode(String invoSp,String accountUnitCode) {
        Query query = session.createQuery("SELECT p from InvInvoiceMasterItem p where p.id.invoSp=:invoSp and p.id.accountUnitCode=:accountUnitCode");
        query.setString("invoSp", invoSp);
        query.setString("accountUnitCode", accountUnitCode);
        List<InvInvoiceMasterItem> pList = query.getResultList();
        return pList;
    }*/
}
