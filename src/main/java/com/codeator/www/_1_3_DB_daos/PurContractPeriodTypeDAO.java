/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.PurContractPeriodType;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Moham
 */
public class PurContractPeriodTypeDAO<T> extends AbstractDao<T> {

    public List<PurContractPeriodType> GetAllContractService() {
        Query query = session.createQuery("SELECT p from PurContractPeriodType p ORDER BY p.periodType");
        List<PurContractPeriodType> pList = query.getResultList();
        return pList;
    }

    public List<PurContractPeriodType> GetContractServiceById(String periodType) {
        Query query = session.createQuery("SELECT p from PurContractPeriodType p where p.periodType=:periodType ORDER BY p.periodType");
        query.setString("periodType", periodType);
        List<PurContractPeriodType> pList = query.getResultList();
        return pList;
    }

}
