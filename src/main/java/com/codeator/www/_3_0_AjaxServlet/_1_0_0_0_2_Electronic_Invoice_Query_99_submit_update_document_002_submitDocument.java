/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.AccCurrencyCode;
import com.codeator.www._1_2_DB_entities.InvoItemCode;
import com.codeator.www._1_2_DB_entities.InvoDeptItemJoinDescDtl;
import com.codeator.www._1_2_DB_entities.InvoDocumentStatus;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMaster;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterId;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterItem;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterItemId;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterStatus;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterStatusId;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterTax;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterTaxId;
import com.codeator.www._1_2_DB_entities.InvoTaxTypeDtl;
import com.codeator.www._1_2_DB_entities.InvoUnitType;
import com.codeator.www._1_2_DB_entities.PerCountryCode;
import com.codeator.www._1_2_DB_entities.PerDeptOld;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_2_DB_entities.PurContractServiceType;
import com.codeator.www._1_2_DB_entities.PurSuppWork;
import com.codeator.www._1_3_DB_daos.AccCurrencyCodeDAO;
import com.codeator.www._1_3_DB_daos.InvoItemCodeDAO;
import com.codeator.www._1_3_DB_daos.InvoDeptItemJoinDescDtlDAO;
import com.codeator.www._1_3_DB_daos.InvoDocumentStatusDAO;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterDao;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterItemDAO;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterStatusDAO;
import com.codeator.www._1_3_DB_daos.InvoTaxTypeDtlDAO;
import com.codeator.www._1_3_DB_daos.InvoUnitTypeDAO;
import com.codeator.www._1_3_DB_daos.PerCountryCodeDAO;
import com.codeator.www._1_3_DB_daos.PerDeptOldDao;
import com.codeator.www._1_3_DB_daos.PurContractServiceTypeDao;
import com.codeator.www._1_3_DB_daos.PurSuppWorkDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_001_document;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_008_invoiceLine;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_012_taxableItem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
public class _1_0_0_0_2_Electronic_Invoice_Query_99_submit_update_document_002_submitDocument extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected synchronized void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        new HibernateSessionCon().OpenCon();
        try {
            PerEmploymentMaster employee_session = (PerEmploymentMaster) request.getSession().getAttribute("employee_session");
            if (employee_session == null) {
                throw new Exception();
            }
            //String locationCode = "0";
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            String json = "";
            if (br != null) {
                json = br.readLine();
                //System.out.println(json);
            }
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();

            // 3. Convert received JSON to Article
            _200_Submit_Documents_001_document document = mapper.readValue(json, _200_Submit_Documents_001_document.class);

            String invSp = request.getParameter("invSp");
            String sectionId = request.getParameter("sectionId");
            String deptId = request.getParameter("deptId");
            String accUnitId = request.getParameter("accUnitId");
            String chkInvoInternalIdSeq = request.getParameter("chkInvoInternalIdSeq");
            //System.out.println("________________________________________>>>>>");
            //System.out.println("---> " + invSp);
            //System.out.println("---> " + sectionId);
            //System.out.println("---> " + deptId);

            List<InvoInvoiceMaster> existInvoiceList
                    = new InvoInvoiceMasterDao().GetInvoInvoiceMasterBySeq(invSp, deptId, sectionId, accUnitId);

            if (existInvoiceList.isEmpty()) {
                throw new Exception("notExistDocument");
            }

            //get document status
            List<InvoDocumentStatus> invoDocumentStatusList = new InvoDocumentStatusDAO<>().GetInvoDocumentStatusByDocStatus("2");// تعديل
            if (invoDocumentStatusList.isEmpty()) {
                throw new Exception();
            }

            InvoInvoiceMaster inv_master = existInvoiceList.get(0);
            inv_master.setInvoDocumentStatus(invoDocumentStatusList.get(0));

            if (chkInvoInternalIdSeq.equals("false")) {
                inv_master.setInternalId(document.getInternalID()); //InternalID
            }

            inv_master.setPerEmploymentMasterByEmployeeId(employee_session);

            inv_master.setTotalAmount(BigDecimal.valueOf(document.getTotalAmount()));
            inv_master.setTotalDiscountAmount(BigDecimal.valueOf(document.getTotalDiscountAmount()));
            inv_master.setNetAmount(BigDecimal.valueOf(document.getNetAmount()));
            inv_master.setExtraDiscountAmount(BigDecimal.valueOf(document.getExtraDiscountAmount()));

            inv_master.setTotalItemsDiscountAmount(BigDecimal.valueOf(document.getTotalItemsDiscountAmount()));
            inv_master.setTotalSalesAmount(BigDecimal.valueOf(document.getTotalSalesAmount()));

            List<PurContractServiceType> purContractServiceTypeList = new PurContractServiceTypeDao<>().GetContractService(document.getServiceSeq());
            if (purContractServiceTypeList.isEmpty()) {
                inv_master.setPurContractServiceType(null);
            } else {
                inv_master.setPurContractServiceType(purContractServiceTypeList.get(0));
                inv_master.setServiceCode(purContractServiceTypeList.get(0).getServiceCode());
            }

            inv_master.setIssueDate(new DateOp().String2Date(document.getDateTimeIssued(), "yyyy-MM-dd"));
            inv_master.setDateTimeIssued(document.getDateTimeIssued());
            inv_master.setInvoRealDate(new DateOp().String2Date(document.getInvoRealDate(), "yyyy-MM-dd"));
            inv_master.setNotes(document.getNotes());
            new HibernateSessionCon().beginTrans();
            InvoInvoiceMasterDao dao = new InvoInvoiceMasterDao();
            // ------------------------ Invoice Master -------------------------
            // ------------------------ Invoice Master -------------------------
            // ------------------------ Invoice Master -------------------------
            // ------------------------ Invoice Master -------------------------  

            /**
             * add Data To Invoice Master
             * <<---------------------------------------------------------------
             * ADD To Table INVO_INVOICE_MASTER
             */
            dao.update(inv_master);

            // ------------------------ Invoice Master -------------------------
            // ------------------------ Invoice Master -------------------------
            // ------------------------ Invoice Master -------------------------
            // ------------------------ Invoice Master -------------------------            
            /**
             * add Data To Invoice Master
             * <<---------------------------------------------------------------
             * Delete Item And Tax Details
             */
            for (InvoInvoiceMasterItem invoInvoiceMasterItem : inv_master.getInvoInvoiceMasterItems()) {
                for (InvoInvoiceMasterTax invoInvoiceMasterTaxe : invoInvoiceMasterItem.getInvoInvoiceMasterTaxes()) {
                    dao.delete(invoInvoiceMasterTaxe);
                }
                dao.delete(invoInvoiceMasterItem);
            }

            // --------------------- Invoice Master Status ---------------------
            // --------------------- Invoice Master Status ---------------------
            // --------------------- Invoice Master Status ---------------------
            // --------------------- Invoice Master Status ---------------------
            short logSeq = new InvoInvoiceMasterStatusDAO().GetMaxLogSeq(accUnitId, deptId, sectionId, invSp);
            InvoInvoiceMasterStatusId id_MasterStatus = new InvoInvoiceMasterStatusId(Integer.parseInt(sectionId), Long.parseLong(deptId), Long.parseLong(invSp), accUnitId, logSeq);
            InvoInvoiceMasterStatus invoInvoiceMasterStatus = new InvoInvoiceMasterStatus(id_MasterStatus, inv_master);
            invoInvoiceMasterStatus.setPerEmploymentMaster(employee_session);
            invoInvoiceMasterStatus.setInvoDocumentStatus(invoDocumentStatusList.get(0));
            invoInvoiceMasterStatus.setCurrDateTime(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));
            //ip -----------> user Ip
            String host = request.getHeader("host"); // -- Server Host IP and PORT
            String Client_IP = request.getRemoteAddr();// -- Client IP
            invoInvoiceMasterStatus.setDeskId(Client_IP);

            invoInvoiceMasterStatus.setRmrk("");
            invoInvoiceMasterStatus.setCurrDate(new DateOp().getSysDate());
            /**
             * add Data To Invoice Master Status
             * <<---------------------------------------------------------------
             * ADD To Table INVO_INVOICE_MASTER_STATUS
             */
            dao.insert(invoInvoiceMasterStatus);

            // ---------------------- Invoice Master Items ---------------------
            // ---------------------- Invoice Master Items ---------------------
            // ---------------------- Invoice Master Items ---------------------
            // ---------------------- Invoice Master Items ---------------------
            for (_200_Submit_Documents_008_invoiceLine invoiceLine : document.getInvoiceLines()) {
                int invoSpItem = new InvoInvoiceMasterItemDAO().GetMaxInvoSpItem(accUnitId, deptId, sectionId, invSp);
                InvoInvoiceMasterItemId id_ = new InvoInvoiceMasterItemId(accUnitId, Long.parseLong(invSp), Integer.parseInt(sectionId), Long.parseLong(deptId), invoSpItem);
                String currencyCode = invoiceLine.getUnitValue().getCurrencySold();//"" + new InvoiceDocumentConstants().currency.get(invoiceLine.getUnitValue().getCurrencySold());

                List<AccCurrencyCode> AccCurrencyCodeList = new AccCurrencyCodeDAO().GetAccCurrencyCodeByCode(currencyCode);
                if (AccCurrencyCodeList.isEmpty()) {
                    throw new Exception();
                }

                List<InvoItemCode> InvItemCodeList = new InvoItemCodeDAO().GetInvItemCodeByItemCode(invoiceLine.getItemCode());
                if (InvItemCodeList.isEmpty()) {
                    throw new Exception();
                }

                System.out.println(" ------> unitType : " + invoiceLine.getUnitType());
                List<InvoUnitType> InvUnitTypeList = new InvoUnitTypeDAO().GetInvoUnitTypeByUnitTypeCode(invoiceLine.getUnitType());
                if (InvUnitTypeList.isEmpty()) {
                    throw new Exception();
                }

                List<InvoDeptItemJoinDescDtl> invoItemCodeDescList = new InvoDeptItemJoinDescDtlDAO().GetInvoItemCodeDescByItemSeqAndItemCode(invoiceLine.getItemSeq(), invoiceLine.getItemCode());

                //System.out.println(" >>>>>>>>>>>>>>>>>>>> ||||||||||| ?>>>>> " + invoiceLine.getUnitValue().getCurrencySold());
                List<AccCurrencyCode> accCurrencyCodeList = new AccCurrencyCodeDAO().GetAccCurrencyCodeByCode(invoiceLine.getUnitValue().getCurrencySold());
                if (accCurrencyCodeList.isEmpty()) {
                    throw new Exception();
                }

                InvoInvoiceMasterItem invMasterItems
                        = new InvoInvoiceMasterItem();
                invMasterItems.setId(id_);
                invMasterItems.setInvoItemCode(InvItemCodeList.get(0));
                invMasterItems.setInvoUnitType(InvUnitTypeList.get(0));
                invMasterItems.setInvoInvoiceMaster(inv_master);
                invMasterItems.setItemDescription(invoiceLine.getDescription());
                invMasterItems.setQuantity(BigDecimal.valueOf(invoiceLine.getQuantity()));
                invMasterItems.setCurrencyExchangeRate(BigDecimal.valueOf(invoiceLine.getUnitValue().getCurrencyExchangeRate()));
                invMasterItems.setAmountSold(BigDecimal.valueOf(invoiceLine.getUnitValue().getAmountSold()));
                invMasterItems.setSalesTotal(BigDecimal.valueOf(invoiceLine.getSalesTotal()));
                invMasterItems.setDiscountAmount(BigDecimal.valueOf(invoiceLine.getDiscount().getAmount()));
                invMasterItems.setNetTotal(BigDecimal.valueOf(invoiceLine.getNetTotal()));
                invMasterItems.setTotal(BigDecimal.valueOf(invoiceLine.getTotal()));

                if (!invoItemCodeDescList.isEmpty()) {
                    invMasterItems.setInvoDeptItemJoinDescDtl(invoItemCodeDescList.get(0));
                }

                invMasterItems.setAccCurrencyCode(accCurrencyCodeList.get(0));
                invMasterItems.setItemsDiscount(BigDecimal.valueOf(invoiceLine.getItemsDiscount()));
                invMasterItems.setTotalTaxableFees(BigDecimal.valueOf(invoiceLine.getTotalTaxableFees()));
                invMasterItems.setAmountEgp(BigDecimal.valueOf(invoiceLine.getUnitValue().getAmountEGP()));
                invMasterItems.setDiscountRate(BigDecimal.valueOf(invoiceLine.getDiscount().getRate()));
                invMasterItems.setValueDifference(BigDecimal.valueOf(invoiceLine.getValueDifference()));

                if (invoiceLine.getCalcUnit() == 0) {
                    invMasterItems.setCalcUnit(null);
                    invMasterItems.setPriceBeforeCalcUnit(null);
                    invMasterItems.setMinimumLimit(null);
                } else {
                    invMasterItems.setCalcUnit(BigDecimal.valueOf(invoiceLine.getCalcUnit()));
                    invMasterItems.setPriceBeforeCalcUnit(BigDecimal.valueOf(invoiceLine.getPriceBeforeCalcUnit()));
                    invMasterItems.setMinimumLimit(BigDecimal.valueOf(0));
                }

                /**
                 * add Data To Invoice Master Items
                 * <<-----------------------------------------------------------
                 * ADD To Table INVO_INVOICE_MASTER_ITEM
                 */
                dao.insert(invMasterItems);
                // ------------------ Invoice Master Items Tax -----------------
                // ------------------ Invoice Master Items Tax -----------------
                // ------------------ Invoice Master Items Tax -----------------
                // ------------------ Invoice Master Items Tax -----------------
                for (_200_Submit_Documents_012_taxableItem taxableItem : invoiceLine.getTaxableItems()) {

                    InvoInvoiceMasterTaxId _id_ = new InvoInvoiceMasterTaxId(accUnitId, Integer.parseInt(sectionId), Long.parseLong(deptId), invoSpItem, Long.parseLong(invSp), taxableItem.getSubType(), taxableItem.getTaxType());
                    List<InvoTaxTypeDtl> InvoTaxTypeDtlList = new InvoTaxTypeDtlDAO().GetInvTaxSubtypeById(taxableItem.getTaxType(), taxableItem.getSubType());
                    if (InvoTaxTypeDtlList.isEmpty()) {
                        throw new Exception();
                    }

                    InvoInvoiceMasterTax tax
                            = new InvoInvoiceMasterTax(
                                    _id_,//InvoInvoiceMasterTaxId                                    
                                    InvoTaxTypeDtlList.get(0),//InvoTaxTypeDtl
                                    invMasterItems,//InvoInvoiceMasterItem
                                    BigDecimal.valueOf(taxableItem.getAmount())//amount
                            );
                    tax.setRate(BigDecimal.valueOf(taxableItem.getRate()));
                    /**
                     * add Data To Invoice Master Items Tax
                     * <<-----------------------------------------------------------
                     * ADD To Table INVO_INVOICE_MASTER_TAX
                     */
                    dao.insert(tax);
                }
            }
            new HibernateSessionCon().CommitTrans();
            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
            new HibernateSessionCon().RollBack();
            String message = e.getMessage();
            if (message.equals("notExistDocument")) {
                message = "الفاتورة غير موجودة لتعديلها";
            } else {
                message = "Error";
            }
            response.getWriter().write(message);
        }

        new HibernateSessionCon().closeConn();
        //new HibernateSessionCon().clearConn();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
