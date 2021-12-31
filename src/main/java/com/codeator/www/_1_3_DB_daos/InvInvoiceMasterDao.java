/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
//import com.codeator.www._1_2_DB_entities.InvInvoiceMaster;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class InvInvoiceMasterDao<T> extends AbstractDao<T> {

    /*public List<InvInvoiceMaster> GetAllInvInvoiceMaster() {
        Query query = session.createQuery("SELECT p from InvInvoiceMaster p ORDER BY p.createdDate");
        List<InvInvoiceMaster> pList = query.getResultList();
        return pList;
    }

    public List<InvInvoiceMaster> GetInvInvoiceMasterByInternalId(String internalId) {
        Query query = session.createQuery("SELECT p from InvInvoiceMaster p where p.internalId=:internalId");
        query.setString("internalId", internalId);
        List<InvInvoiceMaster> pList = query.getResultList();
        return pList;
    }

    public long GetMaxInvoSp(String accountUnitCode) {
        Query query = session.createQuery("Select nvl(max(v.id.invoSp),0) from InvInvoiceMaster v where v.id.accountUnitCode=:accountUnitCode");
        query.setString("accountUnitCode", accountUnitCode);
        long maxRequireSp = GetQueryNumber(query);
        return maxRequireSp;
    }

    private long GetQueryNumber(Query query) {
        List<Long> list = query.getResultList();
        long number = 1;// no Employee saved in the system
        if (list.get(0) != null) {
            number = list.get(0) + 1;
        }
        //System.out.println(number);
        return number;
    }*/

}
