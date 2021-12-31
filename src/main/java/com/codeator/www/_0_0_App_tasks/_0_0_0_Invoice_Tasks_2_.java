/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._0_0_App_tasks;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoDocumentStatus;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMaster;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterStatus;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterStatusId;
import com.codeator.www._1_2_DB_entities.InvoTaxTokenServerStatus;
import com.codeator.www._1_3_DB_daos.InvoDocumentStatusDAO;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterDao;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterStatusDAO;
import com.codeator.www._1_3_DB_daos.InvoTaxTokenServerStatusDAO;
import com.taxdemo.www._0_1_0_api_tracks._003_connect_and_get_document;
import com.taxdemo.www._3_0_0_notificationCallbacks.api._002_received_json._301_Get_Document_JSON_000_;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

/**
 *
 * @author Moham
 */
public class _0_0_0_Invoice_Tasks_2_ extends TimerTask {

    private boolean letsRun = true;

    @Override
    public void run() {
        if (letsRun) {
            letsRun = false;
            try {
                new HibernateSessionCon().OpenCon();
                System.out.println(" ---------------------------------------------------------- ");
                System.out.println(" -------------- Portal Update Status Checker -------------- ");
                List<String> documentStatus = new ArrayList<String>() {
                    {
                        add("13");//Submitted
                        add("14");//Cancel Request
                        add("15");//Reject Request
                    }
                };
                List<InvoInvoiceMaster> iimList
                        = new InvoInvoiceMasterDao().GetAllInvInvoiceMasterByDocumentStatus(documentStatus);
                long size = iimList.size();
                System.out.println(" Invoice_Tasks Check : " + new Date());
                System.out.println(" Number Of Invoice Checked : " + size);

                for (InvoInvoiceMaster invoInvoiceMaster : iimList) {
                    CheckInvoicePortal(invoInvoiceMaster);
                    Thread.sleep(5000);
                }

                new HibernateSessionCon().closeConn();

                System.out.println(" ---------------------------------------------------------- ");

            } catch (Exception e) {
                //e.printStackTrace();
            }
            letsRun = true;
        }
    }

    private void CheckInvoicePortal(InvoInvoiceMaster invoInvoiceMaster) {
        while (true) {
            try {
                String sendType = new _0_0_0_Invoice_Tasks_1_().production;
                _003_connect_and_get_document doc = new _003_connect_and_get_document();
                //String json = recent_doc.getJson();
                doc.getRecentDocuments(sendType, invoInvoiceMaster.getUuid());
                Thread.sleep(5000);
                _301_Get_Document_JSON_000_ Documents_JSON = doc.getGet_Recent_Documents_JSON();
                String portal_status = Documents_JSON.getStatus();
                String DocStatus = "";
                switch (portal_status) {
                    case "Valid":
                        DocStatus = "9";
                        break;
                    case "Invalid":
                        DocStatus = "10";
                        break;
                    case "Cancelled":
                        DocStatus = "11";
                        break;
                    case "Rejected":
                        DocStatus = "12";
                        break;
                    case "Submitted":
                        DocStatus = "13";
                        break;
                    case "Cancellation Requested":
                        DocStatus = "14";
                        break;
                    case "Rejection Requested":
                        DocStatus = "15";
                        break;
                    default:
                        break;
                }

                // Invoice SP
                String InvoSp = "" + invoInvoiceMaster.getId().getInvoSp();
                String SectionNoOld = "" + invoInvoiceMaster.getId().getSectionNoOld();
                String DepNoOld = "" + invoInvoiceMaster.getId().getDepNoOld();
                String AccUnitCode = "" + invoInvoiceMaster.getId().getAccUnitCode();
                /**
                 * 3- set Update
                 */
                new HibernateSessionCon().OpenCon();
                InvoInvoiceMasterDao dao = new InvoInvoiceMasterDao();
                List<InvoInvoiceMaster> existInvoiceList
                        = new InvoInvoiceMasterDao().GetInvoInvoiceMasterBySeq(InvoSp, DepNoOld, SectionNoOld, AccUnitCode);

                if (existInvoiceList.isEmpty()) {
                    throw new Exception("notExistDocument");
                }
                //get document status
                List<InvoDocumentStatus> invoDocumentStatusList = new InvoDocumentStatusDAO<>().GetInvoDocumentStatusByDocStatus(DocStatus);// إعتماد
                if (invoDocumentStatusList.isEmpty()) {
                    throw new Exception();
                }

                InvoInvoiceMaster inv_master = existInvoiceList.get(0);

                String Database_status = inv_master.getInvoDocumentStatus().getDocStatusName();
                if (Database_status.equals(portal_status)
                        /*لو الحالة فالاهرام طلب الغاء او طلب رفض وفالضرايب فاليد برده مش هنغير الحالة عندنا*/
                        || ((Database_status.equals("Cancellation Requested") || Database_status.equals("Rejection Requested")) && portal_status.equals("Valid"))) {
                } else {
                    new HibernateSessionCon().beginTrans();

                    inv_master.setInvoDocumentStatus(invoDocumentStatusList.get(0));
                    dao.update(inv_master);

                    // --------------------- Invoice Master Status ---------------------
                    // --------------------- Invoice Master Status ---------------------
                    // --------------------- Invoice Master Status ---------------------
                    // --------------------- Invoice Master Status ---------------------
                    short logSeq = new InvoInvoiceMasterStatusDAO().GetMaxLogSeq(AccUnitCode, DepNoOld, SectionNoOld, InvoSp);
                    InvoInvoiceMasterStatusId id_MasterStatus = new InvoInvoiceMasterStatusId(Integer.parseInt(SectionNoOld), Long.parseLong(DepNoOld), Long.parseLong(InvoSp), AccUnitCode, logSeq);
                    InvoInvoiceMasterStatus invoInvoiceMasterStatus = new InvoInvoiceMasterStatus(id_MasterStatus, inv_master);
                    invoInvoiceMasterStatus.setPerEmploymentMaster(null);
                    invoInvoiceMasterStatus.setInvoDocumentStatus(invoDocumentStatusList.get(0));
                    invoInvoiceMasterStatus.setCurrDateTime(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));
                    //ip -----------> user Ip
                    String Client_IP = "0:0:0:0:0:0:0:1";// -- Client IP
                    invoInvoiceMasterStatus.setDeskId(Client_IP);

                    invoInvoiceMasterStatus.setRmrk("عدلت بواسطة السيرفر");
                    invoInvoiceMasterStatus.setCurrDate(new DateOp().getSysDate());
                    /**
                     * add Data To Invoice Master Status
                     * <<---------------------------------------------------------------
                     * ADD To Table INVO_INVOICE_MASTER_STATUS
                     */
                    dao.insert(invoInvoiceMasterStatus);
                    new HibernateSessionCon().CommitTrans();
                }
                break;
            } catch (Exception e) {
                e.printStackTrace();
                new HibernateSessionCon().RollBack();
                String message = e.getMessage();
                /*List<InvoTaxTokenServerStatus> pList = new InvoTaxTokenServerStatusDAO().getServerStatus();
            InvoTaxTokenServerStatus InvoTaxTokenServerStatus = null;
            if (pList.isEmpty()) {
                InvoTaxTokenServerStatus = new InvoTaxTokenServerStatus(Short.valueOf("1"), "0", "0", "0");
                new HibernateSessionCon().beginTrans();
                new InvoTaxTokenServerStatusDAO().insert(InvoTaxTokenServerStatus);
                new HibernateSessionCon().CommitTrans();
            } else {*/
                //InvoTaxTokenServerStatus = pList.get(0);
                if (message.equals("Token Server Not Running")) {
                    message = "برنامج التوقيع مغلق";
                    /*new HibernateSessionCon().beginTrans();
                    InvoTaxTokenServerStatus.setSignAppStatus("0");
                    new InvoTaxTokenServerStatusDAO().update(InvoTaxTokenServerStatus);
                    new HibernateSessionCon().CommitTrans();*/
                } else if (message.equals("Fire Wall Stands On Request Traffic")) {
                    message = "جدار الحماية يمنع اللإتصال";
                    /*new HibernateSessionCon().beginTrans();
                    InvoTaxTokenServerStatus.setTaxStatus("0");
                    new InvoTaxTokenServerStatusDAO().update(InvoTaxTokenServerStatus);
                    new HibernateSessionCon().CommitTrans();*/
                } else if (message.equals("No slots found")) {
                    message = "برجاء التأكد من توصيل فلاشة التوقيع الإلكتروني";
                    /* new HibernateSessionCon().beginTrans();
                    InvoTaxTokenServerStatus.setTokenStatus("0");
                    new InvoTaxTokenServerStatusDAO().update(InvoTaxTokenServerStatus);
                    new HibernateSessionCon().CommitTrans();*/
                } else {
                    message = "Error";
                }
                /* }*/
            }
        }
    }
}
