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
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterItem;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterStatus;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterStatusId;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterTax;
import com.codeator.www._1_2_DB_entities.InvoTaxTokenServerStatus;
import com.codeator.www._1_3_DB_daos.InvoDocumentStatusDAO;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterDao;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterStatusDAO;
import com.codeator.www._1_3_DB_daos.InvoTaxTokenServerStatusDAO;
import com.codeator.www._3_0_AjaxServlet._1_0_0_0_2_Electronic_Invoice_Query_00_changeInvoice_doc_status;
import com.taxdemo.www._0_1_0_api_tracks._001_connect_and_submit_document;
import com.taxdemo.www._0_1_0_api_tracks._003_connect_and_get_document;
import com.taxdemo.www._2_0_0_systemIntegration.api._001_submit_document._200_Submit_Documents;
import com.taxdemo.www._2_0_0_systemIntegration.api._002_received_json._101_Submit_Documents_JSON_100_;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_001_document;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_002_issuer;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_003_receiver;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_004_address;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_008_invoiceLine;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_009_unitValue;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_010_discount;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_012_taxableItem;
import com.taxdemo.www._2_0_0_systemIntegration.api._005_creation_of_document_json_Custom._201_Submit_Documents_003_json_generated_for_All_documents_custom;
import com.taxdemo.www._3_0_0_notificationCallbacks.api._002_received_json._301_Get_Document_JSON_000_;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

/**
 *
 * @author Moham
 */
public class _0_0_0_Invoice_Tasks_1_ extends TimerTask {

    public final String production = "production";//production // pre-production
    private String version = "1.0";//1.0 // 0.9

    private boolean letsRun = true;

    @Override
    public synchronized void run() {
        if (letsRun) {
            letsRun = false;
            new HibernateSessionCon().OpenCon();
            try {
                System.out.println(" ---------------------------------------------------------- ");
                System.out.println(" -------------------- Send To Portal ---------------------- ");

                List<InvoTaxTokenServerStatus> pList = new InvoTaxTokenServerStatusDAO().getServerStatus();

                int current_date = Integer.parseInt(new DateOp().getCustomSysDate("HH"));

                if (current_date <= 2 && current_date >= 0) {
                    System.out.println(current_date);
                    System.out.println(" -- Stop Send Time ");
                } else {
                    if (pList.isEmpty()) {
                        System.out.println(" - No Action Because 3 Service Not Active ");
                    } else {
                        InvoTaxTokenServerStatus InvoTaxTokenServerStatus = pList.get(0);
                        String TaxStatus = InvoTaxTokenServerStatus.getTaxStatus();
                        String SignAppStatus = InvoTaxTokenServerStatus.getSignAppStatus();
                        String TokenStatus = InvoTaxTokenServerStatus.getTokenStatus();
                        String documentTypeVersion = version;
                        if ((TaxStatus.equals("1") && SignAppStatus.equals("1") && TokenStatus.equals("1") && documentTypeVersion.equals("1.0"))
                                || (TaxStatus.equals("1") && documentTypeVersion.equals("0.9"))) {
                            List<String> documentStatus = new ArrayList<String>() {
                                {
                                    add("8");//جاري الإرسال 
                                }
                            };
                            List<InvoInvoiceMaster> iimList
                                    = new InvoInvoiceMasterDao().GetAllInvInvoiceMasterByDocumentStatus(documentStatus);
                            long size = iimList.size();
                            System.out.println(" Invoice_Tasks : " + new Date());
                            System.out.println(" Number Of Invoice : " + size);

                            for (InvoInvoiceMaster invoInvoiceMaster : iimList) {
                                sendToInvoicePortal(invoInvoiceMaster, documentTypeVersion);
                                Thread.sleep(5000);
                            }
                        }
                    }
                }

                System.out.println(" ---------------------------------------------------------- ");
            } catch (Exception e) {
                //e.printStackTrace();
            }
            //new HibernateSessionCon().clearConn();
            //new HibernateSessionCon().closeConn();
            letsRun = true;
        }
    }

    private synchronized void sendToInvoicePortal(InvoInvoiceMaster invoInvoiceMaster, String documentTypeVersion) {

        try {
            boolean old_invoice_T_F = new _1_0_0_0_2_Electronic_Invoice_Query_00_changeInvoice_doc_status().checkInvoiceOld(invoInvoiceMaster);

            if (!old_invoice_T_F) {
                throw new Exception("Old_Invoice");
            }
            // 3. Convert received JSON to Article
            _200_Submit_Documents_001_document document = new _200_Submit_Documents_001_document();
            /**
             * <<<<<<<<<<<------ Create Json Decoument
             */

            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 1. issuer data
             */
            // A. issuer address
            _200_Submit_Documents_004_address issuer_address = new _200_Submit_Documents_004_address(
                    "0", //branchID                
                    "EG", //country // دايما هتكون مصر
                    "القاهرة", //governate
                    "القاهرة", //regionCity
                    "شارع الجلاء", //street
                    "36", //buildingNumber
                    "-", //postalCode
                    "-", //floor
                    "-", //room
                    "كوبري أكتوبر", //landmark 
                    "شارع الصحافة");     //additionalInformation
            // B. issuer data
            _200_Submit_Documents_002_issuer issuer = new _200_Submit_Documents_002_issuer(
                    issuer_address, // address of issuer
                    "B", // type
                    "100534287", // id
                    "Al-ahram | مؤسسة الأهرام");
            // C. add issuer to document
            document.setIssuer(issuer);

            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 2. receiver data
             */
            // A. receiver address
            String CountrySynbol = (invoInvoiceMaster.getPerCountryCode() == null) ? ""
                    : invoInvoiceMaster.getPerCountryCode().getCountrySymbol();
            String buildingNumber = (invoInvoiceMaster.getBuildingNum() == null) ? "-" : invoInvoiceMaster.getBuildingNum();
            String governate = (invoInvoiceMaster.getPerGovernorateCode() == null)
                    ? "-" : invoInvoiceMaster.getPerGovernorateCode().getAGovName();
            String street = (invoInvoiceMaster.getAddress() == null) ? "-" : invoInvoiceMaster.getAddress();
            String regionCity = governate;//// لازم نجيب السيتي
            String receiver_dtl_address = (invoInvoiceMaster.getAddressBr() == null) ? "-" : invoInvoiceMaster.getAddressBr();
            _200_Submit_Documents_004_address receiver_address = new _200_Submit_Documents_004_address(
                    CountrySynbol, //country // دايما هتكون مصر
                    governate, //governate
                    regionCity, //regionCity
                    street, //street
                    buildingNumber, //buildingNumber
                    "-", //postalCode
                    "-", //floor
                    "-", //room
                    "-", //landmark 
                    receiver_dtl_address
            );     //additionalInformation

            // B. receiver data
            _200_Submit_Documents_003_receiver receiver = new _200_Submit_Documents_003_receiver(
                    receiver_address, // address of receiver
                    invoInvoiceMaster.getReceiverType(), // type
                    (invoInvoiceMaster.getSuppInfoId() == null) ? "" : invoInvoiceMaster.getSuppInfoId(), // id
                    (invoInvoiceMaster.getSuppName() == null) ? "" : invoInvoiceMaster.getSuppName() + ((invoInvoiceMaster.getSuppNameBr() == null) ? "" : " - " + invoInvoiceMaster.getSuppNameBr()));            // name
            // C. add receiver to document
            document.setReceiver(receiver);

            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 3. documentType I : invoice C : creditor D : depite
             */
            document.setDocumentType(invoInvoiceMaster.getDocumentType());

            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 4. documentTypeVersion // 0.9 : Disable signature validator , 1.0
             * : Enable signature validator
             */
            document.setDocumentTypeVersion(documentTypeVersion);

            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 5. dateTimeIssued
             */
            document.setDateTimeIssued(invoInvoiceMaster.getDateTimeIssued() + "T00:00:00Z");//"2021-06-04T15:15:00Z"
            System.out.println(" ---------------------- > " + document.getDateTimeIssued());
            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 6. taxpayerActivityCode
             */
            document.setTaxpayerActivityCode("1811");

            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 7. internalID
             */
            String internal_id = "" + invoInvoiceMaster.getInvoAccUintDept().getPerDeptOld().getId().getSectionNoOld() + "/" + invoInvoiceMaster.getInvoAccUintDept().getPerDeptOld().getId().getDepNoOld() + "/" + invoInvoiceMaster.getInternalId();
            document.setInternalID(internal_id);

            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 8. purchaseOrderReference
             */
            //document.setPurchaseOrderReference("P-233-A6375");
            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 9. purchaseOrderDescription
             */
            //document.setPurchaseOrderDescription("purchase Order description");
            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 10. salesOrderReference
             */
            //document.setSalesOrderReference("1231");
            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 11. salesOrderDescription
             */
            //document.setSalesOrderDescription("Sales Order description");
            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 12. proformaInvoiceNumber
             */
            //document.setProformaInvoiceNumber("SomeValue");
            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 13. payment
             */
            /*_200_Submit_Documents_005_payment payment = new _200_Submit_Documents_005_payment(
                "SomeValue", // bankName
                "SomeValue", // bankAddress
                "SomeValue", // bankAccountNo
                "", // bankAccountIBAN
                "", // swiftCode
                "SomeValue");// terms
        document.setPayment(payment);*/
            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 14. delivery
             */
            /*_200_Submit_Documents_006_delivery delivery = new _200_Submit_Documents_006_delivery(
                "SomeValue", // approach
                "SomeValue", // packaging
                "2020-09-28T09:30:10Z", // dateValidity
                "SomeValue", // exportPort
                "EG", // countryOfOrigin
                10.50, // grossWeight
                20.50, // netWeight
                "SomeValue");// terms
        document.setDelivery(delivery);*/
            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 15. invoiceLines -----------------------> can take many Lines or
             * Rows (LOOP)
             */
            List<_200_Submit_Documents_008_invoiceLine> invoiceLines = new ArrayList<>();

            for (InvoInvoiceMasterItem invoiceLine : invoInvoiceMaster.getInvoInvoiceMasterItems()) {
                // Line Num : 1 ------------------------------------------------------------->
                // A. unitValue

                _200_Submit_Documents_009_unitValue unitValue = new _200_Submit_Documents_009_unitValue(
                        invoiceLine.getAccCurrencyCode().getCurrencySymbol(), //currencySold
                        invoiceLine.getAmountEgp().doubleValue(),//amountEGP
                        invoiceLine.getAmountSold().doubleValue(),//amountSold
                        invoiceLine.getCurrencyExchangeRate().doubleValue());//currencyExchangeRate

                // B. discount
                double rate_discount = invoiceLine.getDiscountRate().doubleValue();//rate >> can set it to 0 in all cases
                double amount_discount = invoiceLine.getDiscountAmount().doubleValue();//amount >> can set the discount value without rate calculation
                _200_Submit_Documents_010_discount discount = new _200_Submit_Documents_010_discount(
                        rate_discount,//rate >> can set it to 0 in all cases
                        amount_discount);//amount >> can set the discount value without rate calculation        

                // C. salesTotal calculation
                double quantity = invoiceLine.getQuantity().doubleValue();
                double salesTotal = invoiceLine.getSalesTotal().doubleValue();

                // D. netTotal calculation
                double netTotal = invoiceLine.getNetTotal().doubleValue();

                // E. valueDifference
                double valueDifference = invoiceLine.getValueDifference().doubleValue();

                // F. taxableItems -----------------------> can take many type of taxes (LOOP)
                List<_200_Submit_Documents_012_taxableItem> taxableItems = new ArrayList<>();

                for (InvoInvoiceMasterTax taxableItem : invoiceLine.getInvoInvoiceMasterTaxes()) {
                    ///// I. Tax-1
                    double rate = taxableItem.getRate().doubleValue();
                    _200_Submit_Documents_012_taxableItem taxableItem_1 = new _200_Submit_Documents_012_taxableItem(
                            taxableItem.getInvoTaxTypeDtl().getId().getTaxType(),//taxType
                            roundForTwoDicimalPoints(taxableItem.getAmount().doubleValue()),//amount
                            taxableItem.getInvoTaxTypeDtl().getId().getTaxSubtype(),//subType
                            taxableItem.getRate().doubleValue());//rate
                    taxableItems.add(taxableItem_1);
                }

                // G. totalTaxableFees calculation3
                double totalTaxableFees = invoiceLine.getTotalTaxableFees().doubleValue();

                // H. itemsDiscount
                double itemsDiscount = invoiceLine.getItemsDiscount().doubleValue(); // قيمة توضع بعد حساب الضرايب ممكن نعمل خصم كمان فبنحط قيمة الخصم

                // I. total : حساب مجموع الصف الواحد
                double total = roundForTwoDicimalPoints(invoiceLine.getTotal().doubleValue());//2969.89; // Equation = (netTotal+(T1_amount+T2_amount+T3_amount)) - itemsDiscount;

                // J. One Invoice Line         
                _200_Submit_Documents_008_invoiceLine invoiceLine_1 = new _200_Submit_Documents_008_invoiceLine(
                        invoiceLine.getItemDescription(), //description
                        invoiceLine.getInvoItemCode().getCodeType(), //itemType
                        invoiceLine.getInvoItemCode().getItemCode(), //itemCode
                        invoiceLine.getInvoUnitType().getUnitType(), //unitType
                        quantity, //quantity
                        invoiceLine.getInvoItemCode().getInternalItemCode(), //internalCode
                        unitValue, //unitValue
                        salesTotal, //salesTotal
                        discount, //discount
                        netTotal, //netTotal
                        valueDifference, //valueDifference
                        taxableItems,//taxableItems
                        totalTaxableFees,//totalTaxableFees
                        itemsDiscount,//itemsDiscount
                        total);//total
                invoiceLine_1.setLineNumber(null);
                invoiceLines.add(invoiceLine_1);
                //-----------> end Line Num : 1  --------------------------------------
            }

            // add invoiceLines to the document
            document.setInvoiceLines(invoiceLines);

            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 16. totalSalesAmount
             */
            double totalSalesAmount = invoInvoiceMaster.getTotalSalesAmount().doubleValue();
            document.setTotalSalesAmount(totalSalesAmount);

            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 17. totalDiscountAmount
             */
            double totalDiscountAmount = invoInvoiceMaster.getTotalDiscountAmount().doubleValue();
            document.setTotalDiscountAmount(totalDiscountAmount);

            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 18. totalDiscountAmount
             */
            double netAmount = invoInvoiceMaster.getNetAmount().doubleValue();
            document.setNetAmount(netAmount);

            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 19. taxTotals
             */
            /*List<_200_Submit_Documents_014_taxTotal> taxTotals = invoice_calculation.calcTaxTotals(invoiceLines);
            document.setTaxTotals(taxTotals);*/
            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 20. totalItemsDiscountAmount (??)
             */
            double totalItemsDiscountAmount = invoInvoiceMaster.getTotalItemsDiscountAmount().doubleValue();
            document.setTotalItemsDiscountAmount(totalItemsDiscountAmount);

            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 21. totalItemsDiscountAmount
             */
            double extraDiscountAmount = invoInvoiceMaster.getExtraDiscountAmount().doubleValue();
            document.setExtraDiscountAmount(extraDiscountAmount);

            ///////////////////////////////////////////////////////////////////////////////////////
            /**
             * 22. totalAmount
             */
            //double total_of_all_line = roundForTwoDicimalPoints(invoice_calculation.getSumOfAll_Totals_InAllLines(invoiceLines));
            double totalAmount = roundForTwoDicimalPoints(invoInvoiceMaster.getTotalAmount().doubleValue());
            document.setTotalAmount(totalAmount);

            /**
             * <<<<<<<<<<<------ End Json Decoument
             */
            List<_200_Submit_Documents_001_document> doucuments = new ArrayList<>();
            doucuments.add(document);

            _201_Submit_Documents_003_json_generated_for_All_documents_custom Submit_Documents_create_json
                    = new _201_Submit_Documents_003_json_generated_for_All_documents_custom(documentTypeVersion, doucuments, false);

            Thread.sleep(5000);

            String json_str = Submit_Documents_create_json.getDocuments_json_str();
            System.out.println("-------------------------> JSON");
            System.out.println(json_str);
            //if(json_str.contains("")){
            String sendType = production;
            if (json_str.contains("No slots found") || json_str.contains("not detected")) {
                throw new Exception("No slots found");
            } else if (sendType.equals("postman")) {
                System.out.println(json_str);
            } else if (sendType.equals("pre-production") || sendType.equals("production")) {
                _200_Submit_Documents Submit_Documents = _001_connect_and_submit_document.submitDocument(json_str);
                /**
                 * <<<<<--------------- Sumbited Document Action to Our Database
                 */

                Thread.sleep(5000);
                if (Submit_Documents.getSubmit_Documents_JSON() == null) {
                    throw new Exception();
                }
                List<_101_Submit_Documents_JSON_100_> acceptedDocuments = Submit_Documents.getSubmit_Documents_JSON().getAcceptedDocuments();
                List<_101_Submit_Documents_JSON_100_> rejectedDocuments = Submit_Documents.getSubmit_Documents_JSON().getRejectedDocuments();
                if (!acceptedDocuments.isEmpty()) {

                    // Invoice SP
                    String InvoSp = "" + invoInvoiceMaster.getId().getInvoSp();
                    String SectionNoOld = "" + invoInvoiceMaster.getId().getSectionNoOld();
                    String DepNoOld = "" + invoInvoiceMaster.getId().getDepNoOld();
                    String AccUnitCode = "" + invoInvoiceMaster.getId().getAccUnitCode();
                    /**
                     * 1- get UUID
                     */
                    String uuid = acceptedDocuments.get(0).getUuid();

                    /**
                     * Save UUID First
                     */
                    new HibernateSessionCon().OpenCon();
                    new HibernateSessionCon().beginTrans();
                    InvoInvoiceMasterDao dao = new InvoInvoiceMasterDao();
                    List<InvoInvoiceMaster> existInvoiceList
                            = new InvoInvoiceMasterDao().GetInvoInvoiceMasterBySeq(InvoSp, DepNoOld, SectionNoOld, AccUnitCode);
                    //get document status
                    List<InvoDocumentStatus> invoDocumentStatusList = new InvoDocumentStatusDAO<>().GetInvoDocumentStatusByDocStatus("13");// Submited
                    if (invoDocumentStatusList.isEmpty()) {
                        throw new Exception();
                    }
                    InvoInvoiceMaster inv_master = existInvoiceList.get(0);

                    inv_master.setInvoDocumentStatus(invoDocumentStatusList.get(0));
                    inv_master.setUuid(uuid);
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

                    invoInvoiceMasterStatus.setRmrk("أرسلت بواسطة السيرفر");
                    invoInvoiceMasterStatus.setCurrDate(new DateOp().getSysDate());
                    /**
                     * add Data To Invoice Master Status
                     * <<---------------------------------------------------------------
                     * ADD To Table INVO_INVOICE_MASTER_STATUS
                     */

                    dao.update(inv_master);
                    dao.insert(invoInvoiceMasterStatus);
                    new HibernateSessionCon().CommitTrans();
                    /**
                     * 3- Finish Save UUID First
                     */

///
                    /**
                     * 2- get Document Status
                     */
                    _003_connect_and_get_document doc = new _003_connect_and_get_document();
                    //String json = recent_doc.getJson();
                    doc.getRecentDocuments(sendType, uuid);
                    Thread.sleep(5000);
                    _301_Get_Document_JSON_000_ Documents_JSON = doc.getGet_Recent_Documents_JSON();
                    String status = Documents_JSON.getStatus();
                    String DocStatus = "";
                    if (status.equals("Valid")) {
                        DocStatus = "9";
                    } else if (status.equals("Invalid")) {
                        DocStatus = "10";
                    } else if (status.equals("Cancelled")) {
                        DocStatus = "11";
                    } else if (status.equals("Rejected")) {
                        DocStatus = "12";
                    } else if (status.equals("Submitted")) {
                        DocStatus = "13";
                    } else if (status.equals("Cancellation Requested")) {
                        DocStatus = "14";
                    } else if (status.equals("Rejection Requested")) {
                        DocStatus = "15";
                    }

                    /**
                     * 3- set Update
                     */
                    new HibernateSessionCon().OpenCon();
                    new HibernateSessionCon().beginTrans();
                    existInvoiceList
                            = new InvoInvoiceMasterDao().GetInvoInvoiceMasterBySeq(InvoSp, DepNoOld, SectionNoOld, AccUnitCode);

                    if (existInvoiceList.isEmpty()) {
                        throw new Exception("notExistDocument");
                    }
                    //get document status
                    invoDocumentStatusList = new InvoDocumentStatusDAO<>().GetInvoDocumentStatusByDocStatus(DocStatus);// إعتماد
                    if (invoDocumentStatusList.isEmpty()) {
                        throw new Exception();
                    }

                    InvoInvoiceMaster inv_master1 = existInvoiceList.get(0);

                    inv_master1.setInvoDocumentStatus(invoDocumentStatusList.get(0));
                    inv_master1.setUuid(uuid);

                    // --------------------- Invoice Master Status ---------------------
                    // --------------------- Invoice Master Status ---------------------
                    // --------------------- Invoice Master Status ---------------------
                    // --------------------- Invoice Master Status ---------------------
                    logSeq = new InvoInvoiceMasterStatusDAO().GetMaxLogSeq(AccUnitCode, DepNoOld, SectionNoOld, InvoSp);
                    InvoInvoiceMasterStatusId id_MasterStatus1 = new InvoInvoiceMasterStatusId(Integer.parseInt(SectionNoOld), Long.parseLong(DepNoOld), Long.parseLong(InvoSp), AccUnitCode, logSeq);
                    InvoInvoiceMasterStatus invoInvoiceMasterStatus1 = new InvoInvoiceMasterStatus(id_MasterStatus1, inv_master1);
                    invoInvoiceMasterStatus1.setPerEmploymentMaster(null);
                    invoInvoiceMasterStatus1.setInvoDocumentStatus(invoDocumentStatusList.get(0));
                    invoInvoiceMasterStatus1.setCurrDateTime(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));
                    //ip -----------> user Ip
                    Client_IP = "0:0:0:0:0:0:0:1";// -- Client IP
                    invoInvoiceMasterStatus1.setDeskId(Client_IP);

                    invoInvoiceMasterStatus1.setRmrk("أرسلت بواسطة السيرفر");
                    invoInvoiceMasterStatus1.setCurrDate(new DateOp().getSysDate());
                    /**
                     * add Data To Invoice Master Status
                     * <<---------------------------------------------------------------
                     * ADD To Table INVO_INVOICE_MASTER_STATUS
                     */

                    dao.update(inv_master1);
                    dao.insert(invoInvoiceMasterStatus);
                    new HibernateSessionCon().CommitTrans();

                }
                /**
                 * <<<<<--------------- Sumbited Document Action to Our Database
                 */
                /*List<InvoTaxTokenServerStatus> pList = new InvoTaxTokenServerStatusDAO().getServerStatus();
                InvoTaxTokenServerStatus InvoTaxTokenServerStatus = null;
                if (pList.isEmpty()) {
                    InvoTaxTokenServerStatus = new InvoTaxTokenServerStatus(Short.valueOf("1"), "1", "1", "1");
                    new HibernateSessionCon().beginTrans();
                    new InvoTaxTokenServerStatusDAO().insert(InvoTaxTokenServerStatus);
                    new HibernateSessionCon().CommitTrans();
                } else {
                    InvoTaxTokenServerStatus = pList.get(0);
                    new HibernateSessionCon().beginTrans();
                    InvoTaxTokenServerStatus.setSignAppStatus("1");
                    InvoTaxTokenServerStatus.setTaxStatus("1");
                    InvoTaxTokenServerStatus.setTokenStatus("1");
                    new InvoTaxTokenServerStatusDAO().update(InvoTaxTokenServerStatus);
                    new HibernateSessionCon().CommitTrans();
                }*/
            } else {
                throw new Exception();
            }
            System.out.println("-------------------------> Finish ONE");

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
                /*new HibernateSessionCon().beginTrans();
                    InvoTaxTokenServerStatus.setTokenStatus("0");
                    new InvoTaxTokenServerStatusDAO().update(InvoTaxTokenServerStatus);
                    new HibernateSessionCon().CommitTrans();*/
            } else {
                message = "Error";
            }
            /*}*/

        }

    }

    /**
     * function used to round all numbers to two decimal numbers
     *
     * @param num
     * @return
     */
    private Double roundForTwoDicimalPoints(double num) {
        DecimalFormat df = new DecimalFormat("###################.#####");
        return Double.parseDouble(df.format(num));
    }

}
