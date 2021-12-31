/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoDocumentStatus;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMaster;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterStatus;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterStatusId;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_3_DB_daos.InvoDocumentStatusDAO;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterDao;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterStatusDAO;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Mohamed
 */
public class _1_0_0_0_2_Electronic_Invoice_Query_00_changeInvoice_doc_status {

    public _1_0_0_0_2_Electronic_Invoice_Query_00_changeInvoice_doc_status() {

    }

    public boolean updateStatus(InvoInvoiceMaster inv_master, InvoDocumentStatus invoDocumentStatus, PerEmploymentMaster employee_session, HttpServletRequest request, String rmrk) {
        try {
            new HibernateSessionCon().OpenCon();
            new HibernateSessionCon().beginTrans();
            InvoInvoiceMasterDao dao = new InvoInvoiceMasterDao();

            inv_master.setInvoDocumentStatus(invoDocumentStatus);
            dao.update(inv_master);

            // --------------------- Invoice Master Status ---------------------
            // --------------------- Invoice Master Status ---------------------
            // --------------------- Invoice Master Status ---------------------
            // --------------------- Invoice Master Status ---------------------
            short logSeq = new InvoInvoiceMasterStatusDAO().GetMaxLogSeq(
                    "" + inv_master.getId().getAccUnitCode(),
                    "" + inv_master.getId().getDepNoOld(),
                    "" + inv_master.getId().getSectionNoOld(),
                    "" + inv_master.getId().getInvoSp());
            InvoInvoiceMasterStatusId id_MasterStatus = new InvoInvoiceMasterStatusId(
                    inv_master.getId().getSectionNoOld(),
                    inv_master.getId().getDepNoOld(),
                    inv_master.getId().getInvoSp(),
                    inv_master.getId().getAccUnitCode(),
                    logSeq);
            InvoInvoiceMasterStatus invoInvoiceMasterStatus = new InvoInvoiceMasterStatus(id_MasterStatus, inv_master);
            invoInvoiceMasterStatus.setPerEmploymentMaster(employee_session);
            invoInvoiceMasterStatus.setInvoDocumentStatus(invoDocumentStatus);
            invoInvoiceMasterStatus.setCurrDateTime(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));
            //ip -----------> user Ip
            if (request != null) {
                String host = request.getHeader("host"); // -- Server Host IP and PORT
                String Client_IP = request.getRemoteAddr();// -- Client IP
                invoInvoiceMasterStatus.setDeskId(Client_IP);
            } else {
                String Client_IP = "0:0:0:0:0:0:0:1";
                invoInvoiceMasterStatus.setDeskId(Client_IP);
            }

            invoInvoiceMasterStatus.setRmrk(rmrk);
            invoInvoiceMasterStatus.setCurrDate(new DateOp().getSysDate());
            /**
             * add Data To Invoice Master Status
             * <<---------------------------------------------------------------
             * ADD To Table INVO_INVOICE_MASTER_STATUS
             */
            dao.insert(invoInvoiceMasterStatus);

            if (!inv_master.getInvoInvoiceMastersForInvoimsInvoimsSplitFk().isEmpty()) {
                //فواتير عادي وليست مقسمة
                for (InvoInvoiceMaster invoInvoiceMaster : inv_master.getInvoInvoiceMastersForInvoimsInvoimsSplitFk()) {
                    invoInvoiceMaster.setInvoDocumentStatus(invoDocumentStatus);
                    dao.update(invoInvoiceMaster);
                }
            }
            new HibernateSessionCon().CommitTrans();
            new HibernateSessionCon().closeConn();
            return true;
        } catch (Exception e) {
            new HibernateSessionCon().RollBack();
            new HibernateSessionCon().closeConn();
            e.printStackTrace();
            return false;
        }

    }

    public boolean checkInvoiceOld(InvoInvoiceMaster invoInvoiceMaster) {

        Date document_issue_date = invoInvoiceMaster.getIssueDate();
        Date CurrentDate = new Date();
        long diff_days = new DateOp().differentsBetweenTwoDates(CurrentDate, document_issue_date);
        if (diff_days > 6) {
            //get document status
            List<InvoDocumentStatus> invoDocumentStatusList = new InvoDocumentStatusDAO<>().GetInvoDocumentStatusByDocStatus("16");// قدبمة
            if (invoDocumentStatusList.isEmpty()) {
                return false;
            }

            InvoDocumentStatus invoDocumentStatus = invoDocumentStatusList.get(0);
            boolean updateStatus
                    = updateStatus(
                            invoInvoiceMaster,
                            invoDocumentStatus,
                            null,
                            null,
                            "");

            return false;
        } else {
            return true;
        }
    }

}
