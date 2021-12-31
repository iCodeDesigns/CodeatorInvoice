/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
import com.codeator.www._1_2_DB_entities.MainframeSuppMobawaba;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Moham
 */
public class MainframeSuppMobawaba_DAO<T> extends AbstractDao<T> {

    public List<MainframeSuppMobawaba> GetByTaxCardNoIsNull() {
        Query query = session.createQuery("SELECT p from MainframeSuppMobawaba p where p.taxCardNo IS NULL and (p.chkMoved IS NULL OR p.chkMoved=0) ORDER BY p.mainFrameCode ");
        List<MainframeSuppMobawaba> pList = query.getResultList();
        return pList;
    }

    public List<MainframeSuppMobawaba> GetByTaxCardNoIsNotNull() {
        Query query = session.createQuery("SELECT p from MainframeSuppMobawaba p where p.taxCardNo IS NOT NULL and (p.chkMoved IS NULL OR p.chkMoved=0) ORDER BY p.mainFrameCode ");
        List<MainframeSuppMobawaba> pList = query.getResultList();
        return pList;
    }

    public List<MainframeSuppMobawaba> GetByMainFrameCode(String mainFrameCode) {
        Query query = session.createQuery("SELECT p from MainframeSuppMobawaba p Where (p.chkMoved IS NULL OR p.chkMoved=0) and p.mainFrameCode=:mainFrameCode  ORDER BY p.mainFrameCode");
        query.setString("mainFrameCode", mainFrameCode);
        List<MainframeSuppMobawaba> pList = query.getResultList();
        return pList;
    }

    public List<MainframeSuppMobawaba> GetAll() {
        Query query = session.createQuery("SELECT p from MainframeSuppMobawaba p Where (p.chkMoved IS NULL OR p.chkMoved=0)  ORDER BY p.mainFrameCode");
        List<MainframeSuppMobawaba> pList = query.getResultList();
        return pList;
    }

}
