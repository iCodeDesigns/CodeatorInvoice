/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.PurSuppWork;
import com.codeator.www._1_2_DB_entities.PurSupplier;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class PurSuppWorkDao<T> extends AbstractDao<T> {

    public long GetMaxInvoSp() {
        Query query = session.createQuery("Select IFNULL(max(v.id.suppSeq),0)+1 from PurSuppWork v");
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

    public List<PurSuppWork> GetPurSupplierWorkByName(String suppName, String supplierType) {
        Query query;//select * from per_employment_masters WHERE REPLACE(national_no,'-','') like '2520320010102' or REPLACE(national_no,'/','') like '2520320010102';
        switch (supplierType) {
            case "B":
                query = session.createQuery("SELECT p from PurSuppWork p where p.suppName LIKE :suppName AND "
                        + "   (REGEXP_REPLACE(p.taxCardNo,'\\D','') != null "
                        + " OR REGEXP_REPLACE(p.taxFileNo,'\\D','') != null) "
                        + " ORDER BY p.suppName ");
                break;
            case "P":
                query = session.createQuery("SELECT p from PurSuppWork p where p.suppName LIKE :suppName AND p.identNo!=null ORDER BY p.suppName ");
                break;
            default:
                query = session.createQuery("SELECT p from PurSuppWork p where p.suppName LIKE :suppName AND p.passportNum!=null ORDER BY p.suppName ");
                break;
        }
        query.setString("suppName", "%" + suppName + "%");
        List<PurSuppWork> pList = query.getResultList();
        return pList;
    }

    public List<PurSuppWork> GetAllPurSupplierWork() {
        Query query = session.createQuery("SELECT p from PurSuppWork p ORDER BY p.suppName ");
        List<PurSuppWork> pList = query.getResultList();
        return pList;
    }

    public List<PurSuppWork> GetAllPurSupplierWorkWhichHaveDtl(String depNoOld, String sectionNoOld, String accUnitCode) {
        Query query = session.createQuery("SELECT p from PurSuppWork p where p.suppSeq In (Select c.purSuppWork.suppSeq from PurSuppWorkDtl c where c.invoAccUintDept.id.depNoOld=:depNoOld and c.invoAccUintDept.id.sectionNoOld=:sectionNoOld and c.invoAccUintDept.id.accUnitCode=:accUnitCode) ORDER BY p.suppName ");
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("accUnitCode", accUnitCode);
        List<PurSuppWork> pList = query.getResultList();
        return pList;
    }

    public List<PurSuppWork> GetPurSupplierWorkById(String id, String supplierType) {
        Query query;//select * from per_employment_masters WHERE REPLACE(national_no,'-','') like '2520320010102' or REPLACE(national_no,'/','') like '2520320010102';
        switch (supplierType) {
            case "B":
                query = session.createQuery("SELECT p from PurSuppWork p where "
                        + "   REGEXP_REPLACE(p.taxCardNo,'\\D','') LIKE :taxCardNo "
                        + "OR REGEXP_REPLACE(p.taxFileNo,'\\D','') LIKE :taxFileNo "
                        + "ORDER BY p.suppName ");
                query.setString("taxCardNo", "%" + id + "%");
                query.setString("taxFileNo", "%" + id + "%");
                break;
            case "P":
                query = session.createQuery("SELECT p from PurSuppWork p where p.identNo LIKE :identNo ORDER BY p.suppName ");
                query.setString("identNo", "%" + id + "%");
                break;
            default:
                query = session.createQuery("SELECT p from PurSuppWork p where p.passportNum LIKE :passportNum ORDER BY p.suppName ");
                query.setString("passportNum", "%" + id + "%");
                break;
        }
        List<PurSuppWork> pList = query.getResultList();
        return pList;
    }

    public List<PurSuppWork> GetPurSupplierWorkByTaxCardNo(String taxCardNo) {
        Query query;//select * from per_employment_masters WHERE REPLACE(national_no,'-','') like '2520320010102' or REPLACE(national_no,'/','') like '2520320010102';

        query = session.createQuery("SELECT p from PurSuppWork p where "
                + "   REGEXP_REPLACE(p.taxCardNo,'\\D','') LIKE :taxCardNo "
                + "ORDER BY p.suppName ");
        query.setString("taxCardNo", "%" + taxCardNo + "%");
        List<PurSuppWork> pList = query.getResultList();
        return pList;
    }

    public List<PurSuppWork> GetPurSupplierWorkByIdentNo(String identNo) {
        Query query;//select * from per_employment_masters WHERE REPLACE(national_no,'-','') like '2520320010102' or REPLACE(national_no,'/','') like '2520320010102';

        query = session.createQuery("SELECT p from PurSuppWork p where p.identNo LIKE :identNo ORDER BY p.suppName ");
        query.setString("identNo", "%" + identNo + "%");
        List<PurSuppWork> pList = query.getResultList();
        return pList;
    }

    public List<PurSuppWork> GetPurSupplierById(String suppSeq) {
        Query query = session.createQuery("SELECT p from PurSuppWork p where p.suppSeq=:suppSeq ORDER BY p.suppName ");
        query.setString("suppSeq", suppSeq);
        List<PurSuppWork> pList = query.getResultList();
        return pList;
    }

    public List<PurSuppWork> GetPurSupplierWorkByTaxCardNoForAnotherSupplier(String taxCardNo, String suppSeq) {
        Query query;//select * from per_employment_masters WHERE REPLACE(national_no,'-','') like '2520320010102' or REPLACE(national_no,'/','') like '2520320010102';

        query = session.createQuery("SELECT p from PurSuppWork p where p.suppSeq!=:suppSeq AND "
                + "   REGEXP_REPLACE(p.taxCardNo,'\\D','') LIKE :taxCardNo "
                + "ORDER BY p.suppName ");
        query.setString("suppSeq", suppSeq);
        query.setString("taxCardNo", "%" + taxCardNo + "%");
        List<PurSuppWork> pList = query.getResultList();
        return pList;
    }

    public List<PurSuppWork> GetPurSupplierWorkByIdentNoForAnotherSupplier(String identNo, String suppSeq) {
        Query query;//select * from per_employment_masters WHERE REPLACE(national_no,'-','') like '2520320010102' or REPLACE(national_no,'/','') like '2520320010102';

        query = session.createQuery("SELECT p from PurSuppWork p where p.suppSeq!=:suppSeq AND p.identNo LIKE :identNo ORDER BY p.suppName ");
        query.setString("suppSeq", suppSeq);
        query.setString("identNo", "%" + identNo + "%");
        List<PurSuppWork> pList = query.getResultList();
        return pList;
    }

}
