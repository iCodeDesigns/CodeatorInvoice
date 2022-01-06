/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.PurContractServiceType;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Moham
 */
public class PurContractServiceTypeDao<T> extends AbstractDao<T> {

    public long GetMaxServiceSeq() {
        Query query = session.createQuery("Select IFNULL(max(v.serviceSeq),0)+1 from PurContractServiceType v ");
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

    public List<PurContractServiceType> GetAllContractService() {
        Query query = session.createQuery("SELECT p from PurContractServiceType p ORDER BY p.serviceName");
        List<PurContractServiceType> pList = query.getResultList();
        return pList;
    }

    public List<PurContractServiceType> GetAllContractServicePerDept(String accUnitCode, String sectionNoOld, String depNoOld) {
        Query query = session.createQuery("SELECT p from PurContractServiceType p where p.invoAccUintDept.id.accUnitCode=:accUnitCode and p.invoAccUintDept.id.depNoOld=:depNoOld and p.invoAccUintDept.id.sectionNoOld=:sectionNoOld ORDER BY p.serviceName");
        query.setString("accUnitCode", accUnitCode);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        List<PurContractServiceType> pList = query.getResultList();
        return pList;
    }

    public List<PurContractServiceType> GetAllContractServicePerDeptAndSeq(String serviceSeq,String accUnitCode, String sectionNoOld, String depNoOld) {
        Query query = session.createQuery("SELECT p from PurContractServiceType p where p.serviceSeq=:serviceSeq and p.invoAccUintDept.id.accUnitCode=:accUnitCode and p.invoAccUintDept.id.depNoOld=:depNoOld and p.invoAccUintDept.id.sectionNoOld=:sectionNoOld ORDER BY p.serviceName");
        query.setString("serviceSeq", serviceSeq);
        query.setString("accUnitCode", accUnitCode);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        List<PurContractServiceType> pList = query.getResultList();
        return pList;
    }

    public List<PurContractServiceType> GetContractService(String serviceSeq) {
        Query query = session.createQuery("SELECT p from PurContractServiceType p where p.serviceSeq=:serviceSeq ORDER BY p.serviceName");
        query.setString("serviceSeq", serviceSeq);
        List<PurContractServiceType> pList = query.getResultList();
        return pList;
    }

}
