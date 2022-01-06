/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.InvoDeptItemJoinDescDtl;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Moham
 */
public class InvoDeptItemJoinDescDtlDAO<T> extends AbstractDao<T> {

    public long GetMaxsuppSeqBr() {
        Query query = session.createQuery("Select IFNULL(max(v.itemSeq),0)+1 from InvoDeptItemJoinDescDtl v");
        long maxRequireSp = GetQueryNumber(query);
        return maxRequireSp;
    }

    private long GetQueryNumber(Query query) {
        List<Long> list = query.getResultList();
        long number = 1;// no Employee saved in the system
        if (list.get(0) != null) {
            number = list.get(0);
        }
        //System.out.println(number);
        return number;
    }

    public List<InvoDeptItemJoinDescDtl> GetInvoItemCodeDescByItemCode(String itemCode, String accUnitCode, String depNoOld, String sectionNoOld) {
        Query query = session.createQuery("SELECT p from InvoDeptItemJoinDescDtl p where p.invoDeptItemJoin.id.itemCode=:itemCode and p.invoDeptItemJoin.id.accUnitCode=:accUnitCode and p.invoDeptItemJoin.id.depNoOld=:depNoOld and p.invoDeptItemJoin.id.sectionNoOld=:sectionNoOld ");
        query.setString("itemCode", itemCode);
        query.setString("accUnitCode", accUnitCode);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        List<InvoDeptItemJoinDescDtl> pList = query.getResultList();
        return pList;
    }

    public List<InvoDeptItemJoinDescDtl> GetInvoItemCodeDescByDescSeq(String itemSeq) {
        Query query = session.createQuery("SELECT p from InvoDeptItemJoinDescDtl p where p.itemSeq=:itemSeq ");
        query.setString("itemSeq", itemSeq);
        List<InvoDeptItemJoinDescDtl> pList = query.getResultList();
        return pList;
    }

    public List<InvoDeptItemJoinDescDtl> GetInvoItemCodeDescByItemSeqAndItemCode(String itemSeq, String itemCode) {
        Query query = session.createQuery("SELECT p from InvoDeptItemJoinDescDtl p where p.itemSeq=:itemSeq and p.invoDeptItemJoin.id.itemCode=:itemCode");
        query.setString("itemSeq", itemSeq);
        query.setString("itemCode", itemCode);
        List<InvoDeptItemJoinDescDtl> pList = query.getResultList();
        return pList;
    }

}
