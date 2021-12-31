/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.InvoDocumentStatus;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Moham
 */
public class InvoDocumentStatusDAO<T> extends AbstractDao<T> {

    public List<InvoDocumentStatus> GetInvoDocumentStatus() {
        Query query = session.createQuery("SELECT i from InvoDocumentStatus i Where i.docStatus BETWEEN 7 and 12 ORDER BY i.docStatus ");
        List<InvoDocumentStatus> pList = query.getResultList();
        return pList;
    }

    public List<InvoDocumentStatus> GetInvoDocumentStatusByDocStatus(String docStatus) {
        Query query = session.createQuery("SELECT i from InvoDocumentStatus i where i.docStatus=:docStatus ");
        query.setString("docStatus", docStatus);
        List<InvoDocumentStatus> pList = query.getResultList();
        return pList;
    }

}
