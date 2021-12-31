/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.PurContractMaster;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Moham
 */
public class PurContractMasterDAO<T> extends AbstractDao<T> {

    public List<PurContractMaster> GetContractById(String contractSp, String titelSp, String sectionNoOld, String depNoOld) {
        Query query = session.createQuery("SELECT p from PurContractMaster p where p.id.contractSp=:contractSp and p.id.titelSp=:titelSp and p.id.sectionNoOld=:sectionNoOld and p.id.depNoOld=:depNoOld ");
        query.setString("contractSp", contractSp);
        query.setString("titelSp", titelSp);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("depNoOld", depNoOld);
        List<PurContractMaster> pList = query.getResultList();
        return pList;
    }

    public List<PurContractMaster> GetAllContractInDeptBySupplier(String depNoOld, String sectionNoOld, String suppSeq) {
        Query query = session.createQuery("SELECT p from PurContractMaster p where  p.perDeptOld.id.depNoOld=:depNoOld and p.perDeptOld.id.sectionNoOld=:sectionNoOld and p.purSuppWork.suppSeq=:suppSeq ORDER BY p.contractDate");
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("suppSeq", suppSeq);
        List<PurContractMaster> pList = query.getResultList();
        return pList;
    }

    public List<PurContractMaster> GetAllContractInDeptBySupplier(String depNoOld, String sectionNoOld, String suppSeq, String titelSp) {
        Query query = session.createQuery("SELECT p from PurContractMaster p where  p.id.depNoOld=:depNoOld and p.id.sectionNoOld=:sectionNoOld and p.purSuppWork.suppSeq=:suppSeq and p.id.titelSp=:titelSp and p.contractToDate>=to_date(:date,'yyyy-MM-dd') ORDER BY p.contractDate");
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("suppSeq", suppSeq);
        query.setString("titelSp", titelSp);
        query.setString("date", new DateOp().getCustomSysDate("yyyy-MM-dd"));
        List<PurContractMaster> pList = query.getResultList();
        return pList;
    }

    public long GetMaxInvoSp(String depNoOld, String sectionNoOld, String titelSp) {
        Query query = session.createQuery("Select nvl(max(v.id.contractSp),0) from PurContractMaster v where v.id.depNoOld=:depNoOld and v.id.sectionNoOld=:sectionNoOld and v.id.titelSp=:titelSp");
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("titelSp", titelSp);
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

}
