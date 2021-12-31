/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._003_creation_of_document_json;

import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_004_address;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_009_unitValue;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_014_taxTotal;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_010_discount;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_016_signature;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_008_invoiceLine;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_001_document;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_012_taxableItem;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_002_issuer;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_003_receiver;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.taxdemo.www._4_0_0_customCalculation.invoiceCalculation;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * This Class used to get the document data from data base and set it the target
 * class
 *
 * @author Mahmoud Ahmed
 */
public class _201_Submit_Documents_001_create_json_from_database {

    private final String documentTypeVersion; // 0.9 : Disable signature validator , 1.0 : Enable signature validator

    /**
     *
     * @param documentTypeVersion :
     *
     * 0.9 : Disable signature validator ,
     *
     * 1.0 : Enable signature validator
     */
    public _201_Submit_Documents_001_create_json_from_database(String documentTypeVersion) {
        this.documentTypeVersion = documentTypeVersion;
    }

    /**
     * create object of all document data received from the database
     *
     * @return @throws JsonProcessingException
     */
    public _201_Submit_Documents_002_json_generated_for_one_document createJsonOfOneDocument(String documentId) {

        invoiceCalculation invoice_calculation = new invoiceCalculation();

        //List<_200_Submit_Documents_001_document> documents = new ArrayList<>();
        /**
         * First Document
         */
        _200_Submit_Documents_001_document document_json_object_without_signature_element;
        _200_Submit_Documents_001_document document_json_object_with_signature_element;

        _200_Submit_Documents_001_document document = new _200_Submit_Documents_001_document();

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 1. issuer data
         */
        // A. issuer address
        _200_Submit_Documents_004_address issuer_address = new _200_Submit_Documents_004_address(
                "0", //branchID                
                "EG", //country // دايما هتكون مصر
                "Cairo", //governate
                "Cairo", //regionCity
                "Elgla", //street
                "Bldg. 3", //buildingNumber
                "68030", //postalCode
                "4", //floor
                "474", //room
                "October Bridge", //landmark 
                "Jornal Street");     //additionalInformation
        // B. issuer data
        _200_Submit_Documents_002_issuer issuer = new _200_Submit_Documents_002_issuer(
                issuer_address, // address of issuer
                "B", // type
                "100534287", // id
                "Amac - Ahram - مؤسسة الأهرام");
        // C. add issuer to document
        document.setIssuer(issuer);

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 2. receiver data
         */
        // A. receiver address
        _200_Submit_Documents_004_address receiver_address = new _200_Submit_Documents_004_address(
                "EG", //country // دايما هتكون مصر
                "Cairo", //governate
                "Cairo", //regionCity
                "14 شارع فريد سميكة النزهة - مصر الجديدة", //street
                "14", //buildingNumber
                "68030", //postalCode
                "", //floor
                "", //room
                "", //landmark 
                "");     //additionalInformation
        // B. receiver data
        _200_Submit_Documents_003_receiver receiver = new _200_Submit_Documents_003_receiver(
                receiver_address, // address of receiver
                "B", // type
                "463728602", // id
                "جريدة بلدنا اليوم");            // name
        // C. add receiver to document
        document.setReceiver(receiver);

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 3. documentType I : invoice C : creditor D : depite
         */
        document.setDocumentType("I");

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 4. documentTypeVersion // 0.9 : Disable signature validator , 1.0 :
         * Enable signature validator
         */
        document.setDocumentTypeVersion(this.documentTypeVersion);

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 5. dateTimeIssued
         */
        document.setDateTimeIssued("2021-06-04T15:15:00Z");

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 6. taxpayerActivityCode
         */
        document.setTaxpayerActivityCode("1811");

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 7. internalID
         */
        document.setInternalID("29778");

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
         * 15. invoiceLines -----------------------> can take many Lines or Rows
         * (LOOP)
         */
        List<_200_Submit_Documents_008_invoiceLine> invoiceLines = new ArrayList<>();

        // Line Num : 1 ------------------------------------------------------------->
        // A. unitValue
        String currencySold = "EGP";
        double amountEGP;
        double amountSold;
        double currencyExchangeRate;
        if (currencySold.equals("EGP")) {
            amountSold = roundForTwoDicimalPoints(0.00);
            currencyExchangeRate = roundForTwoDicimalPoints(0.00);
            amountEGP = roundForTwoDicimalPoints(3.125); // هنا يوضع سعر الوحدة بالمصري
        } else {
            amountSold = roundForTwoDicimalPoints(5.00);
            currencyExchangeRate = roundForTwoDicimalPoints(16.00);
            amountEGP = roundForTwoDicimalPoints(amountSold * currencyExchangeRate);
        }
        _200_Submit_Documents_009_unitValue unitValue = new _200_Submit_Documents_009_unitValue(
                currencySold, //currencySold
                amountEGP,//amountEGP
                amountSold,//amountSold
                currencyExchangeRate);//currencyExchangeRate

        // B. discount
        double rate_discount = roundForTwoDicimalPoints(0.00);//rate >> can set it to 0 in all cases
        double amount_discount = roundForTwoDicimalPoints(0.00);//amount >> can set the discount value without rate calculation
        _200_Submit_Documents_010_discount discount = new _200_Submit_Documents_010_discount(
                rate_discount,//rate >> can set it to 0 in all cases
                amount_discount);//amount >> can set the discount value without rate calculation        

        // C. salesTotal calculation
        int quantity = 2000;
        double salesTotal = roundForTwoDicimalPoints(quantity * amountEGP);

        // D. netTotal calculation
        double netTotal = roundForTwoDicimalPoints(salesTotal - amount_discount);

        // E. valueDifference
        double valueDifference = roundForTwoDicimalPoints(0.00);

        // F. taxableItems -----------------------> can take many type of taxes (LOOP)
        List<_200_Submit_Documents_012_taxableItem> taxableItems = new ArrayList<>();

        ///// I. Tax-1
        double rate = roundForTwoDicimalPoints(0.1);
        /*_200_Submit_Documents_012_taxableItem taxableItem_1 = new _200_Submit_Documents_012_taxableItem(
                "T20",//taxType
                roundForTwoDicimalPoints(netTotal * (rate / 100.00)),//amount
                "OF03",//subType
                rate);//rate
        taxableItems.add(taxableItem_1);*/

        // G. totalTaxableFees calculation3
        double totalTaxableFees = roundForTwoDicimalPoints(invoice_calculation.calcTotalTaxableFees(taxableItems));

        // H. itemsDiscount
        double itemsDiscount = roundForTwoDicimalPoints(0.00); // قيمة توضع بعد حساب الضرايب ممكن نعمل خصم كمان فبنحط قيمة الخصم

        // I. total : حساب مجموع الصف الواحد
        double all_line_taxableItem = roundForTwoDicimalPoints(invoice_calculation.calcTotalTaxableFees_for_total(taxableItems));
        double total = roundForTwoDicimalPoints((netTotal + all_line_taxableItem) - itemsDiscount);//2969.89; // Equation = (netTotal+(T1_amount+T2_amount+T3_amount)) - itemsDiscount;

        // J. One Invoice Line         
        _200_Submit_Documents_008_invoiceLine invoiceLine_1 = new _200_Submit_Documents_008_invoiceLine(
                "طبع وتوريد جورنال بلدنا اليوم مقاس 38x56 سم مطبوع 1 ملزمة 4 لون والباقي لون واحد على ورق جورنال 45 جم الجورنال 16 صفحة - إصدار 24/05/2021م", //description
                "GS1", //itemType
                "10002103", //itemCode
                "EA", //unitType
                quantity, //quantity
                "10002103", //internalCode
                unitValue, //unitValue
                salesTotal, //salesTotal
                discount, //discount
                netTotal, //netTotal
                valueDifference, //valueDifference
                taxableItems,//taxableItems
                totalTaxableFees,//totalTaxableFees
                itemsDiscount,//itemsDiscount
                total);//total
        invoiceLines.add(invoiceLine_1);
        //-----------> end Line Num : 1  --------------------------------------

        // add invoiceLines to the document
        document.setInvoiceLines(invoiceLines);

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 16. totalSalesAmount
         */
        double totalSalesAmount = roundForTwoDicimalPoints(invoice_calculation.calcTotalSalesAmount(invoiceLines));
        document.setTotalSalesAmount(totalSalesAmount);

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 17. totalDiscountAmount
         */
        double totalDiscountAmount = roundForTwoDicimalPoints(invoice_calculation.calcTotalDiscountAmount(invoiceLines));
        document.setTotalDiscountAmount(totalDiscountAmount);

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 18. totalDiscountAmount
         */
        double netAmount = roundForTwoDicimalPoints(totalSalesAmount - totalDiscountAmount);
        document.setNetAmount(netAmount);

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 19. taxTotals
         */
        List<_200_Submit_Documents_014_taxTotal> taxTotals = invoice_calculation.calcTaxTotals(invoiceLines);
        document.setTaxTotals(taxTotals);

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 20. totalItemsDiscountAmount (??)
         */
        double totalItemsDiscountAmount = invoice_calculation.calcTotalItemDiscount(invoiceLines);
        document.setTotalItemsDiscountAmount(totalItemsDiscountAmount);

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 21. totalItemsDiscountAmount
         */
        double extraDiscountAmount = roundForTwoDicimalPoints(0.00);
        document.setExtraDiscountAmount(extraDiscountAmount);

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 22. totalAmount
         */
        double total_of_all_line = roundForTwoDicimalPoints(invoice_calculation.getSumOfAll_Totals_InAllLines(invoiceLines));
        double totalAmount = roundForTwoDicimalPoints(total_of_all_line - extraDiscountAmount);
        document.setTotalAmount(totalAmount);

        /**
         * VERY IMPORTANT PART Adding document to
         * <<<<<<<<<<<<<<----------------------------------------------------------------------
         * document_json_object_without_signature_element
         */
        document_json_object_without_signature_element = new _200_Submit_Documents_001_document(document);
        ///////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 23. signatures
         */
        List<_200_Submit_Documents_016_signature> signatures = new ArrayList<_200_Submit_Documents_016_signature>();
        // ------------> (LOOP)

        // A. signature 1:
        _200_Submit_Documents_016_signature signature_1 = new _200_Submit_Documents_016_signature(
                "I",
                "Encoded Base-64 calculated on the document's data & Physical Drive");
        signatures.add(signature_1);

        // B. signature 2:
        /*_200_Submit_Documents_016_signature signature_2 = new _200_Submit_Documents_016_signature(
                "I",
                "Encoded Base-64 calculated on the document's data & Physical Drive");
        signatures.add(signature_2);*/
        document.setSignatures(signatures);

        /**
         * VERY IMPORTANT PART Adding document to
         * <<<<<<<<<<<<<<----------------------------------------------------------------------
         * document_json_object_without_signature_element
         */
        document_json_object_with_signature_element = new _200_Submit_Documents_001_document(document);
        ///////////////////////////////////////////////////////////////////////////////////////

        // ---------------------> End Of First Document <---------------------
        //documents.add(document);
        ////////////////////////////////////////////////////////////////////////
        _201_Submit_Documents_002_json_generated_for_one_document json_generated = new _201_Submit_Documents_002_json_generated_for_one_document(
                document_json_object_without_signature_element,
                document_json_object_with_signature_element);

        return json_generated;
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

    /*public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("###.##");
        Double x = Double.parseDouble(df.format(10000005.25));
        Double y = Double.parseDouble(df.format(10000000.25));
        System.out.println(x.intValue());
        System.out.println((int) ((x-x.intValue())*100));
    }*/
}
