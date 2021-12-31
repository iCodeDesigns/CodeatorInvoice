/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.AccCurrencyCode;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class AccCurrencyCodeDAO<T> extends AbstractDao<T> {

    public List<AccCurrencyCode> GetAccCurrencyCode() {
        Query query = session.createQuery("SELECT p from AccCurrencyCode p ORDER BY p.currencyCode");
        List<AccCurrencyCode> pList = query.getResultList();
        return pList;
    }

    public List<AccCurrencyCode> GetAccCurrencyCodeByCode(String currencySymbol) {
        //System.out.println(currencySymbol);
        Query query = session.createQuery("SELECT p from AccCurrencyCode p where p.currencySymbol=:currencySymbol");
        query.setString("currencySymbol", currencySymbol);
        List<AccCurrencyCode> pList = query.getResultList();
        return pList;
    }

}
