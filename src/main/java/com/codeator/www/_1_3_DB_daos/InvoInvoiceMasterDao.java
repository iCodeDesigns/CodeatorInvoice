/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.InvoInvoiceMaster;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.persistence.Parameter;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class InvoInvoiceMasterDao<T> extends AbstractDao<T> {

    public List<InvoInvoiceMaster> GetAllInvoInvoiceMaster() {
        Query query = session.createQuery("SELECT p from InvoInvoiceMaster p ORDER BY p.createdDate");
        List<InvoInvoiceMaster> pList = query.getResultList();
        return pList;
    }

    public List<InvoInvoiceMaster> GetInvoInvoiceMasterByInternalIdInDeptAndSection(String internalId, String depNoOld, String sectionNoOld, String accUnitCode) {
        Query query = session.createQuery("SELECT p from InvoInvoiceMaster p where p.internalId=:internalId and p.id.depNoOld=:depNoOld and p.id.sectionNoOld=:sectionNoOld and p.id.accUnitCode=:accUnitCode and p.invoDocumentStatus.docStatus!=0");
        query.setString("internalId", internalId);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("accUnitCode", accUnitCode);
        List<InvoInvoiceMaster> pList = query.getResultList();
        return pList;
    }

    public List<InvoInvoiceMaster> GetInvoInvoiceMasterBySeq(String invoSp, String depNoOld, String sectionNoOld, String accUnitCode) {
        Query query = session.createQuery("SELECT p from InvoInvoiceMaster p where p.id.invoSp=:invoSp and p.id.depNoOld=:depNoOld and p.id.sectionNoOld=:sectionNoOld and p.id.accUnitCode=:accUnitCode ");
        query.setString("invoSp", invoSp);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("accUnitCode", accUnitCode);
        List<InvoInvoiceMaster> pList = query.getResultList();
        return pList;
    }

    public List<InvoInvoiceMaster> GetInvoInvoiceMasterDtlFromMain(String invoSp, String depNoOld, String sectionNoOld, String accUnitCode) {
        Query query = session.createQuery("SELECT p from InvoInvoiceMaster p where p.invoInvoiceMasterByInvoimsInvoimsFk.id.invoSp=:invoSp and p.invoInvoiceMasterByInvoimsInvoimsFk.id.depNoOld=:depNoOld and p.invoInvoiceMasterByInvoimsInvoimsFk.id.sectionNoOld=:sectionNoOld and p.invoInvoiceMasterByInvoimsInvoimsFk.id.accUnitCode=:accUnitCode ");
        query.setString("invoSp", invoSp);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("accUnitCode", accUnitCode);
        List<InvoInvoiceMaster> pList = query.getResultList();
        return pList;
    }

    public long GetMaxInvoSp(String accUnitCode, String sectionNoOld, String depNoOld) {
        Query query = session.createQuery("Select nvl(max(v.id.invoSp),0) from InvoInvoiceMaster v where v.id.accUnitCode=:accUnitCode and v.id.sectionNoOld=:sectionNoOld and v.id.depNoOld=:depNoOld");
        query.setString("accUnitCode", accUnitCode);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("depNoOld", depNoOld);
        long maxRequireSp = GetQueryNumber(query);
        return maxRequireSp;
    }

    public long GetMaxInternalID(String accUnitCode, String sectionNoOld, String depNoOld) {
        Query query = session.createQuery("Select nvl(max(to_number(regexp_substr(v.internalId , '[^-]+',1,1))),0)+1 from InvoInvoiceMaster v where v.id.accUnitCode=:accUnitCode and v.id.sectionNoOld=:sectionNoOld and v.id.depNoOld=:depNoOld and v.invoDocumentStatus.docStatus!=0 ");
        query.setString("accUnitCode", accUnitCode);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("depNoOld", depNoOld);
        long maxRequireSp = GetQueryNumberAsInt(query);
        return maxRequireSp;
    }

    /*public long GetCountInvoSp(String sectionNoOld, String depNoOld, String accUnitCode, String docStatus, String fromDate, String toDate, String createdDate_OR_issueDate) {
        System.out.println("-->> sectionNoOld : " + sectionNoOld);
        System.out.println("-->> depNoOld : " + depNoOld);
        System.out.println("-->> accUnitCode : " + accUnitCode);
        System.out.println("-->> docStatus : " + docStatus);
        System.out.println("-->> fromDate : " + fromDate);
        System.out.println("-->> toDate : " + toDate);

        Query query = session.createQuery("Select nvl(count(v.id.invoSp),0) from InvoInvoiceMaster v where v.invoDocumentStatus.docStatus=:docStatus and v.id.depNoOld=:depNoOld and v.id.sectionNoOld=:sectionNoOld and v.id.accUnitCode=:accUnitCode and v." + createdDate_OR_issueDate + " BETWEEN to_date(:fromDate,'yyyy-MM-dd') and to_date(:toDate,'yyyy-MM-dd') ");
        query.setString("docStatus", docStatus);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("accUnitCode", accUnitCode);
        query.setString("fromDate", fromDate);
        query.setString("toDate", toDate);
        long maxRequireSp = GetQueryNumber(query) - 1;
        return maxRequireSp;
    }*/
    public long GetCountInvoSp(String sectionNoOld, String depNoOld, String accUnitCode, String docStatus, String fromDate, String toDate, String createdDate_OR_issueDate) {
        System.out.println("-->> sectionNoOld : " + sectionNoOld);
        System.out.println("-->> depNoOld : " + depNoOld);
        System.out.println("-->> accUnitCode : " + accUnitCode);
        System.out.println("-->> docStatus : " + docStatus);
        System.out.println("-->> fromDate : " + fromDate);
        System.out.println("-->> toDate : " + toDate);

        Query query = session.createQuery("Select nvl(count(v.id.invoSp),0) from InvoInvoiceMaster v where (v.id.depNoOld=:depNoOld and v.id.sectionNoOld=:sectionNoOld and v.id.accUnitCode=:accUnitCode and v.invoInvoiceMasterByInvoimsInvoimsSplitFk=null and v.invoDocumentStatus.docStatus=:docStatus and v." + createdDate_OR_issueDate + " BETWEEN to_date(:fromDate,'yyyy-MM-dd') and to_date(:toDate,'yyyy-MM-dd')) ");
        query.setString("docStatus", docStatus);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("accUnitCode", accUnitCode);
        query.setString("fromDate", fromDate);
        query.setString("toDate", toDate);
        long maxRequireSp = GetQueryNumber(query) - 1;
        return maxRequireSp;
    }

    public BigDecimal GetSumInvoSp(String sectionNoOld, String depNoOld, String accUnitCode, String docStatus, String fromDate, String toDate, String createdDate_OR_issueDate) {

        Query query = session.createQuery("Select nvl(sum(v.totalAmount),0) from InvoInvoiceMaster v where v.documentType!='D' v.invoDocumentStatus.docStatus=:docStatus and v.id.depNoOld=:depNoOld and v.id.sectionNoOld=:sectionNoOld and v.id.accUnitCode=:accUnitCode and v." + createdDate_OR_issueDate + " BETWEEN to_date(:fromDate,'yyyy-MM-dd') and to_date(:toDate,'yyyy-MM-dd') ");
        query.setString("docStatus", docStatus);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("accUnitCode", accUnitCode);
        query.setString("fromDate", fromDate);
        query.setString("toDate", toDate);
        Query query2 = session.createQuery("Select nvl(sum(v.totalAmount),0) from InvoInvoiceMaster v where v.documentType='D' v.invoDocumentStatus.docStatus=:docStatus and v.id.depNoOld=:depNoOld and v.id.sectionNoOld=:sectionNoOld and v.id.accUnitCode=:accUnitCode and v." + createdDate_OR_issueDate + " BETWEEN to_date(:fromDate,'yyyy-MM-dd') and to_date(:toDate,'yyyy-MM-dd') ");
        query2.setString("docStatus", docStatus);
        query2.setString("depNoOld", depNoOld);
        query2.setString("sectionNoOld", sectionNoOld);
        query2.setString("accUnitCode", accUnitCode);
        query2.setString("fromDate", fromDate);
        query2.setString("toDate", toDate);
        List<BigDecimal> list_I_C = query.getResultList();
        List<BigDecimal> list_D = query2.getResultList();
        BigDecimal Total_I_C = (BigDecimal) list_I_C.get(0);
        BigDecimal Total_D = (BigDecimal) list_D.get(0);
        BigDecimal maxRequireSp = BigDecimal.valueOf(Total_I_C.doubleValue() - Total_D.doubleValue());
        return maxRequireSp;
    }

    public BigDecimal GetSumTaxInvoSp(String sectionNoOld, String depNoOld, String accUnitCode, String tax, String fromDate, String toDate, String createdDate_OR_issueDate) {

        Query query = session.createQuery("Select nvl(sum(v.amount),0) from InvoInvoiceMasterTax as v INNER JOIN v.invoInvoiceMasterItem as i INNER JOIN i.invoInvoiceMaster as o where v.invoTaxTypeDtl.id.taxType=:taxType and v.invoTaxTypeDtl.id.taxSubtype=:taxSubtype and o.documentType!='D' and o.invoDocumentStatus.docStatus IN (9 , 17) and v.id.depNoOld=:depNoOld and v.id.sectionNoOld=:sectionNoOld and v.id.accUnitCode=:accUnitCode and o." + createdDate_OR_issueDate + " BETWEEN to_date(:fromDate,'yyyy-MM-dd') and to_date(:toDate,'yyyy-MM-dd') ");
        //query.setString("docStatus", "9");
        //query.setString("docStatus1", "17");
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("accUnitCode", accUnitCode);
        query.setString("fromDate", fromDate);
        query.setString("toDate", toDate);
        query.setString("taxType", tax.split(",")[0]);
        query.setString("taxSubtype", tax.split(",")[1]);

        Query query2 = session.createQuery("Select nvl(sum(v.amount),0) from InvoInvoiceMasterTax as v INNER JOIN v.invoInvoiceMasterItem as i INNER JOIN i.invoInvoiceMaster as o where v.invoTaxTypeDtl.id.taxType=:taxType and v.invoTaxTypeDtl.id.taxSubtype=:taxSubtype and o.documentType='D' and o.invoDocumentStatus.docStatus IN (9 , 17) and v.id.depNoOld=:depNoOld and v.id.sectionNoOld=:sectionNoOld and v.id.accUnitCode=:accUnitCode and o." + createdDate_OR_issueDate + " BETWEEN to_date(:fromDate,'yyyy-MM-dd') and to_date(:toDate,'yyyy-MM-dd') ");
        //query2.setString("docStatus", "9");
        //query2.setString("docStatus1", "17");
        query2.setString("depNoOld", depNoOld);
        query2.setString("sectionNoOld", sectionNoOld);
        query2.setString("accUnitCode", accUnitCode);
        query2.setString("fromDate", fromDate);
        query2.setString("toDate", toDate);
        query2.setString("taxType", tax.split(",")[0]);
        query2.setString("taxSubtype", tax.split(",")[1]);

        List<BigDecimal> list_I_C = query.getResultList();
        List<BigDecimal> list_D = query2.getResultList();
        BigDecimal Total_I_C = (BigDecimal) list_I_C.get(0);
        BigDecimal Total_D = (BigDecimal) list_D.get(0);
        BigDecimal maxRequireSp = BigDecimal.valueOf(Total_I_C.doubleValue() - Total_D.doubleValue());
        return maxRequireSp;
    }

    /*public BigDecimal GetSumInvoSp(String sectionNoOld, String depNoOld, String accUnitCode, String docStatus, String fromDate, String toDate, String createdDate_OR_issueDate) {

        Query query = session.createQuery("Select nvl(sum(v.totalAmount),0) from InvoInvoiceMaster v where (v.id.depNoOld=:depNoOld and v.id.sectionNoOld=:sectionNoOld and v.id.accUnitCode=:accUnitCode and v.invoInvoiceMasterByInvoimsInvoimsSplitFk=null and v.invoDocumentStatus.docStatus=:docStatus and v." + createdDate_OR_issueDate + " BETWEEN to_date(:fromDate,'yyyy-MM-dd') and to_date(:toDate,'yyyy-MM-dd')) OR (v.id.depNoOld=:depNoOld and v.id.sectionNoOld=:sectionNoOld and v.id.accUnitCode=:accUnitCode and v.uuid!=null and v.invoDocumentStatus.docStatus=:docStatus and v." + createdDate_OR_issueDate + " BETWEEN to_date(:fromDate,'yyyy-MM-dd') and to_date(:toDate,'yyyy-MM-dd')) ");
        query.setString("docStatus", docStatus);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("accUnitCode", accUnitCode);
        query.setString("fromDate", fromDate);
        query.setString("toDate", toDate);
        List<BigDecimal> list = query.getResultList();
        BigDecimal maxRequireSp = (BigDecimal) list.get(0);
        return maxRequireSp;
    }*/
    private long GetQueryNumber(Query query) {
        List<Long> list = query.getResultList();
        long number = 1;// no Employee saved in the system
        if (list.get(0) != null) {
            number = list.get(0) + 1;
        }
        //System.out.println(number);
        return number;
    }

    private int GetQueryNumberAsInt(Query query) {
        List<Integer> list = query.getResultList();
        int number = 1;// no Employee saved in the system
        if (list.get(0) != null) {
            number = list.get(0);
        }
        //System.out.println(number);
        return number;
    }

    public List<InvoInvoiceMaster> GetAllInvInvoiceMasterByDeptAndSectionAndDocumentStatusWithoutSperatedDoc(String depNoOld, String sectionNoOld, String accUnitCode, List<String> documentStatus) {
        String status = "";
        for (int i = 0; i < documentStatus.size(); i++) {
            if (i == documentStatus.size() - 1) {
                status += documentStatus.get(i);
            } else {
                status += documentStatus.get(i) + ",";
            }
        }

        Query query = session.createQuery("SELECT p from InvoInvoiceMaster p where (p.id.depNoOld=:depNoOld and p.id.sectionNoOld=:sectionNoOld and p.id.accUnitCode=:accUnitCode and p.invoInvoiceMasterByInvoimsInvoimsSplitFk=null and p.invoDocumentStatus.docStatus IN (" + status + ")) OR (p.id.depNoOld=:depNoOld and p.id.sectionNoOld=:sectionNoOld and p.id.accUnitCode=:accUnitCode and p.uuid!=null and p.invoDocumentStatus.docStatus IN (" + status + ") )    ORDER BY p.id.invoSp DESC");
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("accUnitCode", accUnitCode);

        List<InvoInvoiceMaster> pList = query.getResultList();
        return pList;
    }

    public List<InvoInvoiceMaster> GetAllInvInvoiceMasterByDeptAndSectionAndDocumentStatusWithoutSperatedDoc(String depNoOld, String sectionNoOld, String accUnitCode, List<String> documentStatus, String toDate, String fromDate, String createdDate_OR_issueDate) {
        String status = "";
        for (int i = 0; i < documentStatus.size(); i++) {
            if (i == documentStatus.size() - 1) {
                status += documentStatus.get(i);
            } else {
                status += documentStatus.get(i) + ",";
            }
        }

        System.out.println("--------------->>>>>>_)()_))()__");
        //"SELECT p from InvoInvoiceMaster p where (p.id.depNoOld=:depNoOld and p.id.sectionNoOld=:sectionNoOld and p.id.accUnitCode=:accUnitCode and p.invoInvoiceMasterByInvoimsInvoimsSplitFk=null and p.invoInvoiceMasterByInvoimsInvoimsFk=null and p.invoDocumentStatus.docStatus IN (" + status + ") and p." + createdDate_OR_issueDate + " BETWEEN to_date(:fromDate,'yyyy-MM-dd') and to_date(:toDate,'yyyy-MM-dd')) ORDER BY p.internalId ,p.id.invoSp ASC"
        Query query = session.createQuery("SELECT p from InvoInvoiceMaster p where (p.id.depNoOld=:depNoOld and p.id.sectionNoOld=:sectionNoOld and p.id.accUnitCode=:accUnitCode and p.invoInvoiceMasterByInvoimsInvoimsSplitFk=null and p.invoDocumentStatus.docStatus IN (" + status + ") and p." + createdDate_OR_issueDate + " BETWEEN to_date(:fromDate,'yyyy-MM-dd') and to_date(:toDate,'yyyy-MM-dd')) ORDER BY p.internalId ,p.id.invoSp ASC");
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("accUnitCode", accUnitCode);
        query.setString("toDate", toDate);
        query.setString("fromDate", fromDate);

        List<InvoInvoiceMaster> pList = query.getResultList();
        return pList;
    }

    public List<InvoInvoiceMaster> GetAllInvInvoiceMasterByDeptAndSectionAndDocumentStatusWithSperatedDoc(String depNoOld, String sectionNoOld, String accUnitCode, List<String> documentStatus) {
        String status = "";
        for (int i = 0; i < documentStatus.size(); i++) {
            if (i == documentStatus.size() - 1) {
                status += documentStatus.get(i);
            } else {
                status += documentStatus.get(i) + ",";
            }
        }

        //SELECT p from InvoInvoiceMaster p where  p.id.depNoOld=:depNoOld and p.id.sectionNoOld=:sectionNoOld and p.id.accUnitCode=:accUnitCode and p.invoDocumentStatus.docStatus IN (" + status + ") ORDER BY p.id.invoSp DESC
        Query query = session.createQuery("SELECT p from InvoInvoiceMaster p where  p.id.depNoOld=:depNoOld and p.id.sectionNoOld=:sectionNoOld and p.id.accUnitCode=:accUnitCode and (p.uuid!=null AND p.invoDocumentStatus.docStatus IN (" + status + ") ) ORDER BY p.id.invoSp DESC");
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("accUnitCode", accUnitCode);

        List<InvoInvoiceMaster> pList = query.getResultList();
        return pList;
    }

    public List<InvoInvoiceMaster> GetAllInvInvoiceMasterByDeptAndSectionAndDocumentStatusByInternalId(String depNoOld, String sectionNoOld, String accUnitCode, List<String> documentStatus, String internalId, boolean useLike) {
        String status = "";
        for (int i = 0; i < documentStatus.size(); i++) {
            if (i == documentStatus.size() - 1) {
                status += documentStatus.get(i);
            } else {
                status += documentStatus.get(i) + ",";
            }
        }

        //System.out.println("SELECT p from InvoInvoiceMaster p where p.id.depNoOld='" + depNoOld + "' and p.id.sectionNoOld='" + sectionNoOld + "' and p.invoDocumentStatus.docStatus IN (" + status + ")");
        Query query = session.createQuery("SELECT p from InvoInvoiceMaster p where  p.id.depNoOld=:depNoOld and p.id.sectionNoOld=:sectionNoOld and p.id.accUnitCode=:accUnitCode and p.invoInvoiceMasterByInvoimsInvoimsFk=null and p.internalId LIKE :internalId and p.invoDocumentStatus.docStatus IN (" + status + ") ORDER BY p.id.invoSp DESC");
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("accUnitCode", accUnitCode);
        if (useLike) {
            query.setString("internalId", "%" + internalId + "%");
        } else {
            query.setString("internalId", internalId);
        }

        List<InvoInvoiceMaster> pList = query.getResultList();
        return pList;
    }

    public List<InvoInvoiceMaster> GetAllInvInvoiceMasterByDeptAndSectionAndDocumentStatusByInternalIdLastOne(String depNoOld, String sectionNoOld, String accUnitCode, List<String> documentStatus, String internalId, boolean useLike) {
        String status = "";
        for (int i = 0; i < documentStatus.size(); i++) {
            if (i == documentStatus.size() - 1) {
                status += documentStatus.get(i);
            } else {
                status += documentStatus.get(i) + ",";
            }
        }

//        System.out.println("SELECT p from InvoInvoiceMaster p where p.id.invoSp=(Select nvl(max(i.id.invoSp),0) from InvoInvoiceMaster i where i.id.depNoOld='" + depNoOld + "' and i.id.sectionNoOld='" + sectionNoOld + "' and i.internalId LIKE '" + internalId + "') and p.id.depNoOld='" + depNoOld + "' and p.id.sectionNoOld='" + sectionNoOld + "' and p.internalId LIKE '" + internalId + "' and p.invoDocumentStatus.docStatus IN (" + status + ")");
        Query query = session.createQuery("SELECT p from InvoInvoiceMaster p where p.id.invoSp=(Select nvl(max(i.id.invoSp),0) from InvoInvoiceMaster i where i.id.depNoOld=:depNoOld0 and i.id.sectionNoOld=:sectionNoOld0 and i.id.accUnitCode=:accUnitCode0 and i.invoInvoiceMasterByInvoimsInvoimsSplitFk=null and i.internalId LIKE :internalId0) and p.id.depNoOld=:depNoOld1 and p.id.sectionNoOld=:sectionNoOld1 and p.id.accUnitCode=:accUnitCode1 and p.invoInvoiceMasterByInvoimsInvoimsSplitFk=null and p.internalId LIKE :internalId1 and p.invoDocumentStatus.docStatus IN (" + status + ") ORDER BY p.id.invoSp DESC");

        query.setString("depNoOld0", depNoOld);
        query.setString("sectionNoOld0", sectionNoOld);
        query.setString("accUnitCode0", accUnitCode);
        if (useLike) {
            query.setString("internalId0", "%" + internalId + "%");
        } else {
            query.setString("internalId0", internalId);
        }

        query.setString("depNoOld1", depNoOld);
        query.setString("sectionNoOld1", sectionNoOld);
        query.setString("accUnitCode1", accUnitCode);
        if (useLike) {
            query.setString("internalId1", "%" + internalId + "%");
        } else {
            query.setString("internalId1", internalId);
        }

        List<InvoInvoiceMaster> pList = query.getResultList();
        System.out.println(pList.size());
        return pList;
    }

    public List<InvoInvoiceMaster> GetAllInvInvoiceMasterByDeptAndSectionAndDocumentStatusByInternalIdLastOne1(String depNoOld, String sectionNoOld, String accUnitCode, List<String> documentStatus, String internalId, boolean useLike, String searchType) {
        String status = "";
        for (int i = 0; i < documentStatus.size(); i++) {
            if (i == documentStatus.size() - 1) {
                status += documentStatus.get(i);
            } else {
                status += documentStatus.get(i) + ",";
            }
        }

//        System.out.println("SELECT p from InvoInvoiceMaster p where p.id.invoSp=(Select nvl(max(i.id.invoSp),0) from InvoInvoiceMaster i where i.id.depNoOld='" + depNoOld + "' and i.id.sectionNoOld='" + sectionNoOld + "' and i.internalId LIKE '" + internalId + "') and p.id.depNoOld='" + depNoOld + "' and p.id.sectionNoOld='" + sectionNoOld + "' and p.internalId LIKE '" + internalId + "' and p.invoDocumentStatus.docStatus IN (" + status + ")");
        Query query;//= session.createQuery("SELECT p from InvoInvoiceMaster p where p.id.invoSp IN (Select i.id.invoSp from InvoInvoiceMaster i where i.id.depNoOld=:depNoOld0 and i.id.sectionNoOld=:sectionNoOld0 and i.id.accUnitCode=:accUnitCode0 and i.invoInvoiceMasterByInvoimsInvoimsSplitFk=null and i.internalId LIKE :internalId) and p.id.depNoOld=:depNoOld1 and p.id.sectionNoOld=:sectionNoOld1 and p.id.accUnitCode=:accUnitCode1 and p.invoInvoiceMasterByInvoimsInvoimsSplitFk=null and p.internalId LIKE :internalId and p.invoDocumentStatus.docStatus IN (" + status + ") ORDER BY p.id.invoSp DESC");

        String column_DB;
        switch (searchType) {
            case "paidFormCode":
                query = session.createQuery("SELECT p from InvoInvoiceMaster p where p.id.invoSp IN (Select i.id.invoSp from InvoInvoiceMaster i where i.id.depNoOld=:depNoOld and i.id.sectionNoOld=:sectionNoOld and i.id.accUnitCode=:accUnitCode and i.invoInvoiceMasterByInvoimsInvoimsSplitFk=null and i.paidFormCode LIKE :paidFormCode) and p.id.depNoOld=:depNoOld and p.id.sectionNoOld=:sectionNoOld and p.id.accUnitCode=:accUnitCode and p.invoInvoiceMasterByInvoimsInvoimsSplitFk=null and p.paidFormCode LIKE :paidFormCode and p.invoDocumentStatus.docStatus IN (" + status + ") ORDER BY p.id.invoSp DESC");
                column_DB = "paidFormCode";
                break;
            case "permToReceiveCode":
                query = session.createQuery("SELECT p from InvoInvoiceMaster p where p.id.invoSp IN (Select i.id.invoSp from InvoInvoiceMaster i where i.id.depNoOld=:depNoOld and i.id.sectionNoOld=:sectionNoOld and i.id.accUnitCode=:accUnitCode and i.invoInvoiceMasterByInvoimsInvoimsSplitFk=null and i.permToReceiveCode LIKE :permToReceiveCode) and p.id.depNoOld=:depNoOld and p.id.sectionNoOld=:sectionNoOld and p.id.accUnitCode=:accUnitCode and p.invoInvoiceMasterByInvoimsInvoimsSplitFk=null and p.permToReceiveCode LIKE :permToReceiveCode and p.invoDocumentStatus.docStatus IN (" + status + ") ORDER BY p.id.invoSp DESC");
                column_DB = "permToReceiveCode";
                break;
            case "permToDeliverCode":
                query = session.createQuery("SELECT p from InvoInvoiceMaster p where p.id.invoSp IN (Select i.id.invoSp from InvoInvoiceMaster i where i.id.depNoOld=:depNoOld and i.id.sectionNoOld=:sectionNoOld and i.id.accUnitCode=:accUnitCode and i.invoInvoiceMasterByInvoimsInvoimsSplitFk=null and i.permToDeliverCode LIKE :permToDeliverCode) and p.id.depNoOld=:depNoOld and p.id.sectionNoOld=:sectionNoOld and p.id.accUnitCode=:accUnitCode and p.invoInvoiceMasterByInvoimsInvoimsSplitFk=null and p.permToDeliverCode LIKE :permToDeliverCode and p.invoDocumentStatus.docStatus IN (" + status + ") ORDER BY p.id.invoSp DESC");
                column_DB = "permToDeliverCode";
                break;
            default:
                query = session.createQuery("SELECT p from InvoInvoiceMaster p where p.id.invoSp IN (Select i.id.invoSp from InvoInvoiceMaster i where i.id.depNoOld=:depNoOld and i.id.sectionNoOld=:sectionNoOld and i.id.accUnitCode=:accUnitCode and i.invoInvoiceMasterByInvoimsInvoimsSplitFk=null and i.internalId LIKE :internalId) and p.id.depNoOld=:depNoOld and p.id.sectionNoOld=:sectionNoOld and p.id.accUnitCode=:accUnitCode and p.invoInvoiceMasterByInvoimsInvoimsSplitFk=null and p.internalId LIKE :internalId and p.invoDocumentStatus.docStatus IN (" + status + ") ORDER BY p.id.invoSp DESC");
                column_DB = "internalId";
        }

        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("accUnitCode", accUnitCode);

        if (useLike) {
            query.setString(column_DB, "%" + internalId + "%");
        } else {
            System.out.println("))))))))))))))))))))))))))))))))) -- " + internalId);
            query.setString(column_DB, internalId);
        }

        List<InvoInvoiceMaster> pList = query.getResultList();
        System.out.println(pList.size());
        return pList;
    }

    public List<InvoInvoiceMaster> GetAllInvInvoiceMasterByDeptAndSectionAndDocumentStatusInPeriod(String depNoOld, String sectionNoOld, String accUnitCode, String docStatus, String From, String To, boolean isTo_InInterval) {

        String comparison_To = "";
        if (isTo_InInterval) {
            comparison_To = "<=";
        } else {
            comparison_To = "<";
        }

        Query query = session.createQuery("SELECT p from InvoInvoiceMaster p where  p.id.depNoOld=:depNoOld and p.id.sectionNoOld=:sectionNoOld and p.id.accUnitCode=:accUnitCode and p.invoDocumentStatus.docStatus=:docStatus and p.issueDate>=to_date('" + From + "','yyyy-MM-dd') and p.issueDate" + comparison_To + "to_date('" + To + "','yyyy-MM-dd') ORDER BY p.id.invoSp DESC");
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("accUnitCode", accUnitCode);
        query.setString("docStatus", docStatus);

        List<InvoInvoiceMaster> pList = query.getResultList();
        return pList;
    }

    public List<InvoInvoiceMaster> GetAllInvInvoiceMasterByDocumentStatus(List<String> documentStatus) {
        String status = "";
        for (int i = 0; i < documentStatus.size(); i++) {
            if (i == documentStatus.size() - 1) {
                status += documentStatus.get(i);
            } else {
                status += documentStatus.get(i) + ",";
            }
        }

        Query query = session.createQuery("SELECT p from InvoInvoiceMaster p where p.invoDocumentStatus.docStatus IN (" + status + ")");

        List<InvoInvoiceMaster> pList = query.getResultList();
        return pList;
    }

}
