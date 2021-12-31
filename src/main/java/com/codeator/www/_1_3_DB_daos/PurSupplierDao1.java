/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.PurSupplier;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class PurSupplierDao1<T> extends AbstractDao<T> {

    public List<PurSupplier> GetPurSupplierBySuppCode(String suppCode) {
        Query query = session.createQuery("SELECT p from PurSupplier p where p.suppCode=:suppCode");
        query.setString("suppCode", suppCode);
        List<PurSupplier> pList = query.getResultList();
        return pList;
    }

    public List<PurSupplier> GetPurSupplierByNameByDealerType(String suppName, String dealerType) {
        Query query = session.createQuery("SELECT p from PurSupplier p where (p.suppName LIKE :suppName OR p.suppNickname LIKE :suppNickname) AND p.dealerType=:dealerType ORDER BY p.suppName ");
        query.setString("suppName", "%" + suppName + "%");
        query.setString("suppNickname", "%" + suppName + "%");
        query.setString("dealerType", dealerType);
        List<PurSupplier> pList = query.getResultList();
        return pList;
    }

    public List<PurSupplier> GetPurSupplierByName(String suppName) {
        Query query = session.createQuery("SELECT p from PurSupplier p where p.suppName LIKE :suppName ORDER BY p.suppName ");
        query.setString("suppName", "%" + suppName + "%");
        List<PurSupplier> pList = query.getResultList();
        return pList;
    }

    public List<PurSupplier> GetPurSupplierById(String id, String supplierType) {
        Query query;//select * from per_employment_masters WHERE REPLACE(national_no,'-','') like '2520320010102' or REPLACE(national_no,'/','') like '2520320010102';
        if (supplierType.equals("B")) {
            query = session.createQuery("SELECT p from PurSupplier p where "
                    + "   REGEXP_REPLACE(p.taxCardNo,'\\D','') LIKE :taxCardNo "
                    + "OR REGEXP_REPLACE(p.taxFileNo,'\\D','') LIKE :taxFileNo "
                    + "ORDER BY p.suppName ");
            query.setString("taxCardNo", "%" + id + "%");
            query.setString("taxFileNo", "%" + id + "%");
        } else {
            query = session.createQuery("SELECT p from PurSupplier p where p.identNo LIKE :identNo ORDER BY p.suppName ");
            query.setString("identNo", "%" + id + "%");
        }
        List<PurSupplier> pList = query.getResultList();
        return pList;
    }

}
