/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoAccUintDept;
import com.codeator.www._1_2_DB_entities.InvoAdvCollectorCode;
import com.codeator.www._1_2_DB_entities.InvoAdvProducerCode;
import com.codeator.www._1_2_DB_entities.MainframeSuppMobawaba;
import com.codeator.www._1_2_DB_entities.MainframeSuppTogarya;
import com.codeator.www._1_2_DB_entities.PerCountryCode;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_2_DB_entities.PerGovernorateCode;
import com.codeator.www._1_2_DB_entities.PurContractServiceType;
import com.codeator.www._1_2_DB_entities.PurSuppWork;
import com.codeator.www._1_2_DB_entities.PurSuppWorkDtl;
import com.codeator.www._1_3_DB_daos.InvoAccUintDeptDao;
import com.codeator.www._1_3_DB_daos.InvoAdvCollectorCode_DAO;
import com.codeator.www._1_3_DB_daos.InvoAdvProducerCode_DAO;
import com.codeator.www._1_3_DB_daos.MainframeSuppMobawaba_DAO;
import com.codeator.www._1_3_DB_daos.MainframeSuppTogarya_DAO;
import com.codeator.www._1_3_DB_daos.PerCountryCodeDAO;
import com.codeator.www._1_3_DB_daos.PerGovernorateCodeDAO;
import com.codeator.www._1_3_DB_daos.PurContractServiceTypeDao;
import com.codeator.www._1_3_DB_daos.PurSuppWorkDao;
import com.codeator.www._1_3_DB_daos.PurSuppWorkDtlDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
public class _1_0_0_1_7_Mainframe_Supp_Mobawaba_Togarya_Query_Ajax_03_move_supp_mainFrame_AjaxServlet extends HttpServlet {

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
            MainframeSuppMobawaba MainframeSuppMobawaba_JasonFile = mapper.readValue(json, MainframeSuppMobawaba.class);
            MainframeSuppTogarya MainframeSuppTogarya_JasonFile = mapper.readValue(json, MainframeSuppTogarya.class);
            String accUnitId = request.getParameter("accUnitId");
            String deptId = request.getParameter("deptId");
            String sectionId = request.getParameter("sectionId");

            String mainFrameCode = "";
            String prodCode = "";
            String receiverCode = "";
            String suppName = "";
            String adress = "";
            String taxCardNo = "";
            String chkMoved = "1";
            String countryCode = "";
            String govCode = "";
            String serviceSeq = "";

            if (accUnitId.equals("20") || accUnitId.equals("80")) {
                mainFrameCode = MainframeSuppMobawaba_JasonFile.getMainFrameCode();
                prodCode = MainframeSuppMobawaba_JasonFile.getProdCode();
                receiverCode = MainframeSuppMobawaba_JasonFile.getReceiverCode();
                suppName = MainframeSuppMobawaba_JasonFile.getSuppName();
                adress = MainframeSuppMobawaba_JasonFile.getAdress();
                taxCardNo = MainframeSuppMobawaba_JasonFile.getTaxCardNo();
                countryCode = MainframeSuppMobawaba_JasonFile.getCountryCode().split("-")[0];
                govCode = MainframeSuppMobawaba_JasonFile.getGovCode().split("-")[0];

                serviceSeq = MainframeSuppMobawaba_JasonFile.getServiceSeq().split("-")[0];

            } else if (accUnitId.equals("02") || accUnitId.equals("81")) {
                mainFrameCode = MainframeSuppTogarya_JasonFile.getMainFrameCode();
                prodCode = MainframeSuppTogarya_JasonFile.getProdCode();
                receiverCode = MainframeSuppTogarya_JasonFile.getReceiverCode();
                suppName = MainframeSuppTogarya_JasonFile.getSuppName();
                adress = MainframeSuppTogarya_JasonFile.getAdress();
                taxCardNo = MainframeSuppTogarya_JasonFile.getTaxCardNo();
                countryCode = MainframeSuppTogarya_JasonFile.getCountryCode().split("-")[0];
                govCode = MainframeSuppTogarya_JasonFile.getGovCode().split("-")[0];

                serviceSeq = MainframeSuppTogarya_JasonFile.getServiceSeq().split("-")[0];

            }

            new HibernateSessionCon().beginTrans();
            if (accUnitId.equals("20") || accUnitId.equals("80")) {
                MainframeSuppMobawaba_JasonFile.setChkMoved(chkMoved);
                MainframeSuppMobawaba_JasonFile.setGovCode(govCode);
                MainframeSuppMobawaba_JasonFile.setCountryCode(countryCode);
                MainframeSuppMobawaba_JasonFile.setServiceSeq(serviceSeq);
                new MainframeSuppMobawaba_DAO().update(MainframeSuppMobawaba_JasonFile);
            } else if (accUnitId.equals("02") || accUnitId.equals("81")) {
                MainframeSuppTogarya_JasonFile.setChkMoved(chkMoved);
                MainframeSuppTogarya_JasonFile.setGovCode(govCode);
                MainframeSuppTogarya_JasonFile.setCountryCode(countryCode);
                MainframeSuppTogarya_JasonFile.setServiceSeq(serviceSeq);
                new MainframeSuppTogarya_DAO().update(MainframeSuppTogarya_JasonFile);
            }

            govCode = (govCode.equals("*") ? "" : govCode);

            List<InvoAccUintDept> InvoAccUintDeptList = new InvoAccUintDeptDao().GetInvoAccUintInDeptAndUnit(accUnitId, sectionId, deptId);

            List<InvoAdvCollectorCode> InvoAdvCollectorCodeList = new InvoAdvCollectorCode_DAO().GetInvoAdvCollectorCode(receiverCode);
            if (InvoAdvCollectorCodeList.isEmpty()) {
                InvoAdvCollectorCode InvoAdvCollectorCode = new InvoAdvCollectorCode();
                int advCollectorSeq = new InvoAdvCollectorCode_DAO().GetMaxSp();
                InvoAdvCollectorCode.setPerEmploymentMaster(employee_session);
                InvoAdvCollectorCode.setAdvCollectorCode(Short.valueOf(receiverCode));
                InvoAdvCollectorCode.setAdvCollectorName("");
                InvoAdvCollectorCode.setAdvCollectorSeq(advCollectorSeq);
                InvoAdvCollectorCode.setInvoAccUintDept(InvoAccUintDeptList.get(0));

                new InvoAdvCollectorCode_DAO().save(InvoAdvCollectorCode);
            }

            List<InvoAdvProducerCode> InvoAdvProducerCodeList = new InvoAdvProducerCode_DAO().GetInvoAdvProducerCode(prodCode);
            if (InvoAdvProducerCodeList.isEmpty()) {
                InvoAdvProducerCode InvoAdvProducerCode = new InvoAdvProducerCode();
                int advProducerSeq = new InvoAdvProducerCode_DAO().GetMaxSp();
                InvoAdvProducerCode.setPerEmploymentMaster(employee_session);
                InvoAdvProducerCode.setAdvProducerCode(Short.valueOf(prodCode));
                InvoAdvProducerCode.setAdvProducerName("");
                InvoAdvProducerCode.setAdvProducerSeq(advProducerSeq);
                InvoAdvProducerCode.setInvoAccUintDept(InvoAccUintDeptList.get(0));

                new InvoAdvProducerCode_DAO().save(InvoAdvProducerCode);

            }

            long suppSeq = addSupplier(suppName, countryCode, govCode, adress, "-", taxCardNo, "", "", employee_session);

            addSupplierDtl("" + suppSeq, suppName, adress, mainFrameCode, receiverCode, prodCode, serviceSeq, deptId, sectionId, accUnitId, employee_session);

            new HibernateSessionCon().CommitTrans();
            //System.out.println(pList.size());
            // success
            response.getWriter().write("Success");
        } catch (Exception e) {
            new HibernateSessionCon().RollBack();
            e.printStackTrace();
            String message = e.getMessage();
            switch (message) {
                default:
                    message = "حدث خطأ أثناء تنفيذ العملية";
                    break;
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

    private long addSupplier(String supplierName, String countryCode, String govCode, String street, String buildingNumber, String taxCardNo, String identNo, String passport, PerEmploymentMaster employee_session) {
        long suppSeq = 0;
        try {

            suppSeq = new PurSuppWorkDao<>().GetMaxInvoSp();
            PurSuppWork purSuppWork = new PurSuppWork(suppSeq);
            purSuppWork.setChkUpd("J");
            purSuppWork.setSuppName(supplierName);

            if (taxCardNo == null) {
            } else {
                if (countryCode.equals("1")) {

                    if (!(taxCardNo == null || taxCardNo.equals(""))) {
                        List<PurSuppWork> PurSuppWorkList1 = new PurSuppWorkDao().GetPurSupplierWorkByTaxCardNo(taxCardNo);
                        if (!PurSuppWorkList1.isEmpty()) {
                            suppSeq = PurSuppWorkList1.get(0).getSuppSeq();
                            throw new Exception("taxCardNoExist");
                        }
                    }

                    if (!(identNo == null || identNo.equals(""))) {
                        List<PurSuppWork> PurSuppWorkList2 = new PurSuppWorkDao().GetPurSupplierWorkByIdentNo(identNo);
                        if (!PurSuppWorkList2.isEmpty()) {
                            throw new Exception("identNoExist");
                        }
                    }

                    purSuppWork.setTaxCardNo(taxCardNo);
                    purSuppWork.setIdentNo(identNo);
                } else if (!countryCode.equals("1")) {
                    purSuppWork.setPassportNum(passport);
                }
            }

            System.out.println("------------)))))))))) " + countryCode);
            List<PerCountryCode> PerCountryCodeList = new PerCountryCodeDAO().GetCountriesByCountryCode(countryCode);
            if (PerCountryCodeList.isEmpty()) {
                throw new Exception();
            }

            purSuppWork.setPerCountryCode(PerCountryCodeList.get(0));

            if (govCode == null || govCode.equals("")) {

            } else {
                List<PerGovernorateCode> PerGovernorateCodeList = new PerGovernorateCodeDAO().GetPerGovernorateCodeByID(countryCode, govCode);
                if (PerGovernorateCodeList.isEmpty()) {
                    throw new Exception();
                }
                purSuppWork.setPerGovernorateCode(PerGovernorateCodeList.get(0));
            }

            purSuppWork.setAddress(street);
            purSuppWork.setBuildingNum(buildingNumber);
            purSuppWork.setPerEmploymentMasterByInsertEmpId(employee_session);
            purSuppWork.setInsertDate(new DateOp().getSysDate());
            purSuppWork.setInsertDateTime(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));
            new PerGovernorateCodeDAO().insert(purSuppWork);
            return suppSeq;
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
            if (message.equals("identNoExist")) {
                //message = "الرقم القومي مسجل لعميل من قبل";
            } else if (message.equals("taxCardNoExist")) {
                //message = "السجل الضريبي مسجل لعميل من قبل";
            } else {
                //message = "حدث خطأ";
            }
            return suppSeq;
        }
    }

    private void addSupplierDtl(String SuppSeq, String suppNameBr, String AddressBr, String suppMainFrameCode, String AdvCollectorCode, String AdvProducerCode, String serviceSeq, String deptId, String sectionId, String accUnitId, PerEmploymentMaster employee_session) {
        try {

            if (employee_session == null) {
                throw new Exception();
            }

            System.out.println("(((((((())))))))))))))))))000000151500000 || " + SuppSeq);
            List<PurSuppWork> PurSuppWorkList = new PurSuppWorkDao().GetPurSupplierById(SuppSeq);
            if (PurSuppWorkList.isEmpty()) {
                throw new Exception();
            }

            List<InvoAccUintDept> InvoAccUintDeptDaoList = new InvoAccUintDeptDao().GetInvoAccUintInDeptAndUnit(accUnitId, sectionId, deptId);
            if (PurSuppWorkList.isEmpty()) {
                throw new Exception();
            }

            long suppSeqBr = new PurSuppWorkDtlDao<>().GetMaxsuppSeqBr();
            PurSuppWorkDtl purSuppWorkDtl = new PurSuppWorkDtl(suppSeqBr, PurSuppWorkList.get(0));

            if (suppNameBr == null || suppNameBr == "") {
                purSuppWorkDtl.setSuppNameBr(PurSuppWorkList.get(0).getSuppName());
            } else {
                purSuppWorkDtl.setSuppNameBr(suppNameBr);
            }

            if (AddressBr == null || AddressBr == "") {
                purSuppWorkDtl.setAddressBr(PurSuppWorkList.get(0).getAddress());
            } else {
                purSuppWorkDtl.setAddressBr(AddressBr);
            }
            purSuppWorkDtl.setSuppMainFrameCode(suppMainFrameCode);
            purSuppWorkDtl.setPurSuppWork(PurSuppWorkList.get(0));
            purSuppWorkDtl.setPerEmploymentMaster(employee_session);
            purSuppWorkDtl.setInsertDate(new Date());
            purSuppWorkDtl.setInsertDateTime(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));
            purSuppWorkDtl.setInvoAccUintDept(InvoAccUintDeptDaoList.get(0));
            purSuppWorkDtl.setPerEmploymentMaster(employee_session);

            List<InvoAdvCollectorCode> invoAdvCollectorCodeList = new InvoAdvCollectorCode_DAO().GetInvoAdvCollectorCode(AdvCollectorCode);
            if (!invoAdvCollectorCodeList.isEmpty()) {
                purSuppWorkDtl.setInvoAdvCollectorCode(invoAdvCollectorCodeList.get(0));
            }

            List<InvoAdvProducerCode> invoAdvProducerCodeList = new InvoAdvProducerCode_DAO().GetInvoAdvProducerCode(AdvProducerCode);
            if (!invoAdvProducerCodeList.isEmpty()) {
                purSuppWorkDtl.setInvoAdvProducerCode(invoAdvProducerCodeList.get(0));
            }

            System.out.println("(((((((())))))))))))))))))000000000000 || " + serviceSeq);
            List<PurContractServiceType> PurContractServiceTypeList = new PurContractServiceTypeDao().GetContractService(serviceSeq);
            if (!PurContractServiceTypeList.isEmpty()) {
                purSuppWorkDtl.setPurContractServiceType(PurContractServiceTypeList.get(0));
            }
            new PurSuppWorkDtlDao().insert(purSuppWorkDtl);

        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
        }
    }

}
