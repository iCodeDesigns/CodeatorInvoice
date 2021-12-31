/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.PurSuppWorkDtl;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class PurSuppWorkDtlDao<T> extends AbstractDao<T> {

    public long GetMaxsuppSeqBr() {
        Query query = session.createQuery("Select nvl(max(v.id.suppSeqBr),0) from PurSuppWorkDtl v");
        long maxRequireSp = GetQueryNumber(query);
        return maxRequireSp;
    }

    private long GetQueryNumber(Query query) {
        List<Long> list = query.getResultList();
        long number = 1;// no Employee saved in the system
        if (list.get(0) != null) {
            number = list.get(0) + 1;
        }
        //System.out.println(number);
        return number;
    }

    public List<PurSuppWorkDtl> GetAllPurSupplierWorkDtl(String depNoOld, String sectionNoOld) {
        Query query = session.createQuery("SELECT p from PurSuppWorkDtl p ORDER BY p.purSuppWork.suppName, p.suppNameBr ");
        List<PurSuppWorkDtl> pList = query.getResultList();
        return pList;
    }

    public List<PurSuppWorkDtl> GetPurSupplierWorkDtlBySuppSeq(String suppSeq) {
        Query query = session.createQuery("SELECT p from PurSuppWorkDtl p where p.purSuppWork.suppSeq=:suppSeq ORDER BY p.suppNameBr ");
        query.setString("suppSeq", suppSeq);
        List<PurSuppWorkDtl> pList = query.getResultList();
        return pList;
    }

    public List<PurSuppWorkDtl> GetPurSupplierWorkDtlBySuppSeqBr(String suppSeqBr) {
        Query query = session.createQuery("SELECT p from PurSuppWorkDtl p where p.suppSeqBr=:suppSeqBr ORDER BY p.suppNameBr ");
        query.setString("suppSeqBr", suppSeqBr);
        List<PurSuppWorkDtl> pList = query.getResultList();
        return pList;
    }

    public List<PurSuppWorkDtl> GetPurSupplierWorkDtlBySuppSeqAndDept(String suppSeq, String depNoOld, String sectionNoOld, String accUnitCode) {
        Query query = session.createQuery("SELECT p from PurSuppWorkDtl p where p.purSuppWork.suppSeq=:suppSeq and p.invoAccUintDept.id.depNoOld=:depNoOld and p.invoAccUintDept.id.sectionNoOld=:sectionNoOld and p.invoAccUintDept.id.accUnitCode=:accUnitCode ORDER BY p.suppNameBr ");
        query.setString("suppSeq", suppSeq);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("accUnitCode", accUnitCode);
        List<PurSuppWorkDtl> pList = query.getResultList();
        return pList;
    }

}
