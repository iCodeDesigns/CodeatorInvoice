/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterStatus;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Moham
 */
public class InvoInvoiceMasterStatusDAO<T> extends AbstractDao<T> {

    public List<InvoInvoiceMasterStatus> documentStatusLog(String accUnitCod, String depNoOld, String sectionNoOld, String invoSp) {//nvl(max(v.id.logSeq,0))
        Query query = session.createQuery("Select v from InvoInvoiceMasterStatus v where v.id.accUnitCode=:accUnitCod and v.id.depNoOld=:depNoOld and v.id.sectionNoOld=:sectionNoOld and v.id.invoSp=:invoSp ORDER BY v.id.logSeq DESC");
        query.setString("accUnitCod", accUnitCod);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("invoSp", invoSp);
        List<InvoInvoiceMasterStatus> pList = query.getResultList();
        return pList;
    }

    public short GetMaxLogSeq(String accUnitCod, String depNoOld, String sectionNoOld, String invoSp) {//nvl(max(v.id.logSeq,0))
        Query query = session.createQuery("Select nvl(max(v.id.logSeq),0)+1 from InvoInvoiceMasterStatus v where v.id.accUnitCode=:accUnitCod and v.id.depNoOld=:depNoOld and v.id.sectionNoOld=:sectionNoOld and v.id.invoSp=:invoSp");
        query.setString("accUnitCod", accUnitCod);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("invoSp", invoSp);
        short maxRequireSp = GetQueryNumber(query);
        return maxRequireSp;
    }

    public List<InvoInvoiceMasterStatus> documentsReviewed(String accUnitCod, String depNoOld, String sectionNoOld, String invoSp) {//nvl(max(v.id.logSeq,0))
        Query query = session.createQuery("Select v from InvoInvoiceMasterStatus v where v.id.accUnitCode=:accUnitCod and v.id.depNoOld=:depNoOld and v.id.sectionNoOld=:sectionNoOld and v.id.invoSp=:invoSp and v.invoDocumentStatus.docStatus=4");
        query.setString("accUnitCod", accUnitCod);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("invoSp", invoSp);
        List<InvoInvoiceMasterStatus> pList = query.getResultList();
        return pList;
    }

    public List<InvoInvoiceMasterStatus> documentsLastVerifyLog(String accUnitCod, String depNoOld, String sectionNoOld, String invoSp, String docStatus) {//nvl(max(v.id.logSeq,0))        
        Query query = session.createQuery("Select v from InvoInvoiceMasterStatus v where v.id.accUnitCode=:accUnitCod and v.id.depNoOld=:depNoOld and v.id.sectionNoOld=:sectionNoOld and v.id.invoSp=:invoSp and v.id.logSeq=(Select nvl(max(p.id.logSeq),0) from InvoInvoiceMasterStatus p where p.id.accUnitCode=:accUnitCod and p.id.depNoOld=:depNoOld and p.id.sectionNoOld=:sectionNoOld and p.id.invoSp=:invoSp and p.invoDocumentStatus.docStatus=:docStatus) and v.invoDocumentStatus.docStatus=:docStatus");
        query.setString("accUnitCod", accUnitCod);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("invoSp", invoSp);
        query.setString("docStatus", docStatus);
        List<InvoInvoiceMasterStatus> pList = query.getResultList();
        return pList;
    }
    
    public List<InvoInvoiceMasterStatus> documentsLastLog(String accUnitCod, String depNoOld, String sectionNoOld, String invoSp) {//nvl(max(v.id.logSeq,0))        
        Query query = session.createQuery("Select v from InvoInvoiceMasterStatus v where v.id.accUnitCode=:accUnitCod and v.id.depNoOld=:depNoOld and v.id.sectionNoOld=:sectionNoOld and v.id.invoSp=:invoSp and v.id.logSeq=(Select nvl(max(p.id.logSeq),0) from InvoInvoiceMasterStatus p where p.id.accUnitCode=:accUnitCod and p.id.depNoOld=:depNoOld and p.id.sectionNoOld=:sectionNoOld and p.id.invoSp=:invoSp)");
        query.setString("accUnitCod", accUnitCod);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("invoSp", invoSp);
        List<InvoInvoiceMasterStatus> pList = query.getResultList();
        return pList;
    }

    private short GetQueryNumber(Query query) {
        List<Short> list = query.getResultList();
        short number = Short.valueOf("" + list.get(0));
        //System.out.println(number);
        return number;
    }

}
