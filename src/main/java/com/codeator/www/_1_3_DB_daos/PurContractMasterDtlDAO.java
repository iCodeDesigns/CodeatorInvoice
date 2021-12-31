/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.PurContractMasterDtl;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Moham
 */
public class PurContractMasterDtlDAO<T> extends AbstractDao<T> {

    /*public List<PurContractMasterDtl> GetAllContractService() {
        Query query = session.createQuery("SELECT p from PurContractServiceType p ORDER BY p.serviceName");
        List<PurContractMasterDtl> pList = query.getResultList();
        return pList;
    }*/
    public List<PurContractMasterDtl> GetContractsHaveThisDate(String date, String depNoOld, String sectionNoOld, String suppSeq, String titelSp) {
        Query query = session.createQuery("SELECT p from PurContractMasterDtl p where p.conFromDate<=to_date(:date1,'yyyy-MM-dd') and p.conToDate>=to_date(:date2,'yyyy-MM-dd') and  p.purContractMaster.purContractTitel.id.depNoOld=:depNoOld and p.purContractMaster.purContractTitel.id.sectionNoOld=:sectionNoOld and p.purContractMaster.purSuppWork.suppSeq=:suppSeq and p.purContractMaster.purContractTitel.id.titelSp=:titelSp ");
        query.setString("date1", date);
        query.setString("date2", date);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("suppSeq", suppSeq);
        query.setString("titelSp", titelSp);
        List<PurContractMasterDtl> pList = query.getResultList();
        return pList;
    }

    public List<PurContractMasterDtl> GetContractsDtl(String contractSp, String titelSp, String depNoOld, String sectionNoOld) {
        Query query = session.createQuery("SELECT p from PurContractMasterDtl p where p.id.contractSp=:contractSp and p.id.titelSp=:titelSp and p.id.depNoOld=:depNoOld and p.id.sectionNoOld=:sectionNoOld ORDER BY p.id.contractSeq");
        query.setString("contractSp", contractSp);
        query.setString("titelSp", titelSp);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        List<PurContractMasterDtl> pList = query.getResultList();
        return pList;
    }

    public int GetMaxInvoSp(String contractSp) {
        Query query = session.createQuery("Select nvl(max(v.id.contractSeq),0) from PurContractMasterDtl v where v.id.contractSp=:contractSp");
        query.setString("contractSp", contractSp);
        int maxRequireSp = GetQueryNumber(query);
        return maxRequireSp;
    }

    private int GetQueryNumber(Query query) {
        List<Integer> list = query.getResultList();
        int number = 1;// no Employee saved in the system
        if (list.get(0) != null) {
            number = list.get(0) + 1;
        }
        //System.out.println(number);
        return number;
    }
}
