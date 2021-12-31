/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.AccAccountUnits;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class AccAccountUnitsDAO<T> extends AbstractDao<T> {

    public List<AccAccountUnits> GetAccAccountUnitsByAccCode(String accountUnitCode) {
        Query query = session.createQuery("SELECT p from AccAccountUnits p where p.accountUnitCode=:accountUnitCode");
        query.setString("accountUnitCode", accountUnitCode);
        List<AccAccountUnits> pList = query.getResultList();
        return pList;
    }

}
