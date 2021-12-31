/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._0_0_App_tasks;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoTaxTokenServerStatus;
import com.codeator.www._1_3_DB_daos.InvoTaxTokenServerStatusDAO;
import com.taxdemo.www._5_0_0_SignWithSmartCard.signWithCsharp;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

/**
 *
 * @author Moham
 */
public class _0_0_0_Invoice_Tasks_3_ extends TimerTask {

    private boolean letsRun = true;

    @Override
    public void run() {
        if (letsRun) {
            letsRun = false;
            try {
                System.out.println(" ---------------------------------------------------------- ");
                System.out.println(" -------------------- Service Checker --------------------- ");
                System.out.println(" - Invoice_Tasks Service Checker : " + new Date());
                System.out.println(" - 1 - Port 5000     : ");
                check_port_5000();
                System.out.println(" - 2 - Porral Server : ");
                check_invoice_portal();
                System.out.println(" ---------------------------------------------------------- ");
            } catch (Exception e) {
                //e.printStackTrace();
            }
            letsRun = true;
        }
    }

    private void check_port_5000() throws IOException {
        new HibernateSessionCon().OpenCon();
        List<InvoTaxTokenServerStatus> pList = new InvoTaxTokenServerStatusDAO().getServerStatus();
        InvoTaxTokenServerStatus InvoTaxTokenServerStatus = null;
        String port_status = "0";
        String token_status = "0";
        try {
            Socket ServerSok = new Socket("127.0.0.1", 5000);
            ServerSok.close();
            port_status = "1";

            /**
             * check dongol
             */
            //sign With C#
            System.out.println("Server Port 5000 id Running :)");
            String signed_Document = new signWithCsharp().invokeCsharp(document_json_str_without_signature_element);

            if (signed_Document.equals("")) {
                System.out.println("Dongol Is Not Connected ...!");
                token_status = "0";
            } else {
                System.out.println("Dongol Is Connected :)");
                token_status = "1";
            }
        } catch (Exception e) {
            // port not Work
            System.out.println("Server Port 5000 Not Work ... !");
            port_status = "0";
        }

        if (pList.isEmpty()) {
            InvoTaxTokenServerStatus = new InvoTaxTokenServerStatus(Short.valueOf("1"), "1", token_status, port_status);
            new HibernateSessionCon().beginTrans();
            new InvoTaxTokenServerStatusDAO().insert(InvoTaxTokenServerStatus);
            new HibernateSessionCon().CommitTrans();
        } else {
            InvoTaxTokenServerStatus = pList.get(0);
            new HibernateSessionCon().beginTrans();
            InvoTaxTokenServerStatus.setSignAppStatus(port_status);
            InvoTaxTokenServerStatus.setTokenStatus(token_status);
            new InvoTaxTokenServerStatusDAO().update(InvoTaxTokenServerStatus);
            new HibernateSessionCon().CommitTrans();
        }
        new HibernateSessionCon().closeConn();

    }

    private void check_invoice_portal() throws MalformedURLException {
        new HibernateSessionCon().OpenCon();
        List<InvoTaxTokenServerStatus> pList = new InvoTaxTokenServerStatusDAO().getServerStatus();
        InvoTaxTokenServerStatus InvoTaxTokenServerStatus = null;
        String invoice_portal_status = "0";

        try {
            String UR = "";
            String sendType = "pre-production";
            if (sendType.equals("pre-production")) {
                UR = "https://id.preprod.eta.gov.eg/Account/Login";
            } else {
                UR = "https://id.eta.gov.eg/Account/Login";
            }
            URL url = new URL(UR);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();

            int responseCode = huc.getResponseCode();
            System.out.println(responseCode);
            if (responseCode == 200) {
                invoice_portal_status = "1";
            } else {
                System.out.println("Invoice Portal Server Not Work ... !");
                invoice_portal_status = "0";
            }

        } catch (Exception e) {
            // port not Work
            System.out.println("Invoice Portal Server Not Work ... !");
            invoice_portal_status = "0";
        }

        if (pList.isEmpty()) {
            InvoTaxTokenServerStatus = new InvoTaxTokenServerStatus(Short.valueOf("1"), invoice_portal_status, "1", "1");
            new HibernateSessionCon().beginTrans();
            new InvoTaxTokenServerStatusDAO().insert(InvoTaxTokenServerStatus);
            new HibernateSessionCon().CommitTrans();
        } else {
            InvoTaxTokenServerStatus = pList.get(0);
            new HibernateSessionCon().beginTrans();
            InvoTaxTokenServerStatus.setTaxStatus(invoice_portal_status);
            new InvoTaxTokenServerStatusDAO().update(InvoTaxTokenServerStatus);
            new HibernateSessionCon().CommitTrans();
        }
        new HibernateSessionCon().closeConn();
    }

    private String document_json_str_without_signature_element = "{\"issuer\":{\"address\":{\"branchID\":\"0\",\"country\":\"EG\",\"governate\":\"Cairo\",\"regionCity\":\"Cairo\",\"street\":\"Elgla\",\"buildingNumber\":\"Bldg. 3\",\"postalCode\":\"68030\",\"floor\":\"4\",\"room\":\"474\",\"landmark\":\"October Bridge\",\"additionalInformation\":\"Jornal Street\"},\"type\":\"B\",\"id\":\"100534287\",\"name\":\"Al-ahram | ????? ???????\"},\"receiver\":{\"address\":{\"country\":\"EG\",\"governate\":\"????????\",\"regionCity\":\"????????\",\"street\":\"???? ?????\",\"buildingNumber\":\"-\",\"postalCode\":\"-\",\"floor\":\"-\",\"room\":\"-\",\"landmark\":\"-\",\"additionalInformation\":\"-\"},\"type\":\"P\",\"id\":\"12345678911111\",\"name\":\"???? ???????\"},\"documentType\":\"I\",\"documentTypeVersion\":\"1.0\",\"dateTimeIssued\":\"2021-07-25T00:00:00Z\",\"taxpayerActivityCode\":\"1811\",\"internalID\":\"7/7500000/844953\",\"invoiceLines\":[{\"description\":\"??????? ???? ??????? - ?????\",\"itemType\":\"EGS\",\"itemCode\":\"EG-100534287-080021\",\"unitType\":\"EA\",\"quantity\":10.0,\"internalCode\":\"EG-100534287-080021\",\"unitValue\":{\"currencySold\":\"EGP\",\"amountEGP\":20.0,\"amountSold\":0.0,\"currencyExchangeRate\":0.0},\"salesTotal\":200.0,\"discount\":{\"rate\":0.0,\"amount\":0.0},\"netTotal\":200.0,\"valueDifference\":0.0,\"taxableItems\":[{\"taxType\":\"T1\",\"amount\":28.0,\"subType\":\"V009\",\"rate\":14.0}],\"totalTaxableFees\":0.0,\"itemsDiscount\":0.0,\"total\":228.0}],\"totalSalesAmount\":200.0,\"totalDiscountAmount\":0.0,\"netAmount\":200.0,\"taxTotals\":[{\"taxType\":\"T1\",\"amount\":28.0}],\"totalItemsDiscountAmount\":0.0,\"extraDiscountAmount\":28.0,\"totalAmount\":200.0}";

}
