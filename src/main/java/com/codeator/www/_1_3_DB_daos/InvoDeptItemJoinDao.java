/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.InvoDeptItemJoin;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Moham
 */
public class InvoDeptItemJoinDao<T> extends AbstractDao<T> {

    public List<InvoDeptItemJoin> GetAllInvoDeptItemJoinWhichHaveDtl(String accUnitCode, String sectionNoOld, String depNoOld) {
        Query query = session.createQuery("SELECT p from InvoDeptItemJoin p where p.id.itemCode In (Select c.invoDeptItemJoin.id.itemCode from InvoDeptItemJoinDescDtl c where c.invoDeptItemJoin.id.accUnitCode=:accUnitCode and c.invoDeptItemJoin.id.depNoOld=:depNoOld and c.invoDeptItemJoin.id.sectionNoOld=:sectionNoOld) ORDER BY p.invoItemCode.AItemName ");
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("depNoOld", depNoOld);
        query.setString("accUnitCode", accUnitCode);
        List<InvoDeptItemJoin> pList = query.getResultList();
        return pList;
    }

    public List<InvoDeptItemJoin> GetAllInvoDeptItemJoinWhichHaveDtlwithitem(String accUnitCode, String sectionNoOld, String depNoOld, String itemCode) {
        Query query = session.createQuery("SELECT p from InvoDeptItemJoin p where p.id.itemCode In (Select c.invoDeptItemJoin.id.itemCode from InvoDeptItemJoinDescDtl c where c.invoDeptItemJoin.id.accUnitCode=:accUnitCode and c.invoDeptItemJoin.id.depNoOld=:depNoOld and c.invoDeptItemJoin.id.sectionNoOld=:sectionNoOld and c.invoDeptItemJoin.id.itemCode=:itemCode) ORDER BY p.invoItemCode.AItemName ");
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("depNoOld", depNoOld);
        query.setString("itemCode", itemCode);
        query.setString("accUnitCode", accUnitCode);
        List<InvoDeptItemJoin> pList = query.getResultList();
        return pList;
    }

    public List<InvoDeptItemJoin> GetAllInvoDeptItemJoin(String accUnitCode, String sectionNoOld, String depNoOld) {
        Query query = session.createQuery("SELECT p from InvoDeptItemJoin p where p.id.accUnitCode=:accUnitCode and p.id.sectionNoOld=:sectionNoOld and p.id.depNoOld=:depNoOld ORDER BY p.invoItemCode.AItemName ");
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("depNoOld", depNoOld);
        query.setString("accUnitCode", accUnitCode);
        List<InvoDeptItemJoin> pList = query.getResultList();
        return pList;
    }

    public List<InvoDeptItemJoin> GetInvoDeptItemJoinById(String itemCode, String accUnitCode, String depNoOld, String sectionNoOld) {
        Query query = session.createQuery("SELECT p from InvoDeptItemJoin p where p.id.accUnitCode=:accUnitCode and p.id.itemCode=:itemCode and p.id.depNoOld=:depNoOld and p.id.sectionNoOld=:sectionNoOld  ");
        query.setString("itemCode", itemCode);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("depNoOld", depNoOld);
        query.setString("accUnitCode", accUnitCode);
        List<InvoDeptItemJoin> pList = query.getResultList();
        return pList;
    }

}
