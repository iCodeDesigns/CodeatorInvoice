/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterItem;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class InvoInvoiceMasterItemDAO<T> extends AbstractDao<T> {

    public int GetMaxInvoSpItem(String accUnitCod, String depNoOld, String sectionNoOld, String invoSp) {//
        Query query = session.createQuery("Select IFNULL(max(v.id.invoSpItem),0)+1 from InvoInvoiceMasterItem v where v.id.accUnitCode=:accUnitCod and v.id.depNoOld=:depNoOld and v.id.sectionNoOld=:sectionNoOld and v.id.invoSp=:invoSp");
        query.setString("accUnitCod", accUnitCod);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("invoSp", invoSp);
        int maxRequireSp = GetQueryNumber(query);
        return maxRequireSp;
    }

    private int GetQueryNumber(Query query) {
        List<Integer> list = query.getResultList();
        int number = 1;// no Employee saved in the system
        if (list.get(0) != null) {
            number = list.get(0);
        }
        //System.out.println(number);
        return number;
    }

    public List<InvoInvoiceMasterItem> GetInvInvoiceMasterItemByinvoSpAndDeptAndSection(String invoSp,String accUnitCode, String depNoOld, String sectionNoOld) {
        Query query = session.createQuery("SELECT p from InvoInvoiceMasterItem p where p.id.invoSp=:invoSp and p.id.accUnitCode=:accUnitCode and p.id.depNoOld=:depNoOld and p.id.sectionNoOld=:sectionNoOld");
        query.setString("invoSp", invoSp);
        query.setString("accUnitCode", accUnitCode);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        List<InvoInvoiceMasterItem> pList = query.getResultList();
        return pList;
    }
    
    
    public List<InvoInvoiceMasterItem> GetInvInvoiceMasterItemByItemDescSeq(String itemSeq) {
        Query query = session.createQuery("SELECT p from InvoInvoiceMasterItem p where p.invoDeptItemJoinDescDtl.itemSeq=:itemSeq");
        query.setString("itemSeq", itemSeq);
        List<InvoInvoiceMasterItem> pList = query.getResultList();
        return pList;
    }
    
}
