/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.StoItemCateGroupSecDtl;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mahmoud
 */
public class StoItemCateGroupSecDtlDao<T> extends AbstractDao<T> {

    public List<StoItemCateGroupSecDtl> GetItemName(String itemDigital) {
        Query query = session.createQuery("SELECT s from StoItemCateGroupSecDtl s WHERE s.itemDigital='" + itemDigital + "' ");
        List<StoItemCateGroupSecDtl> vList = query.getResultList();
        return vList;
    }
}
