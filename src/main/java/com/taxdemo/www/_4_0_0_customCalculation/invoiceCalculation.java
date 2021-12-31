/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._4_0_0_customCalculation;

import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_008_invoiceLine;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_012_taxableItem;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_014_taxTotal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cdc
 */
public class invoiceCalculation {

    /**
     * totalTaxableFees
     */
    List<String> totalTaxableFees_calculatedOnTaxType = new ArrayList<String>() {
        {
            add("T5");
            add("T6");
            add("T7");
            add("T8");
            add("T9");
            add("T10");
            add("T11");
            add("T12");
        }
    };

    public double calcTotalTaxableFees(List<_200_Submit_Documents_012_taxableItem> taxableItems) {
        double totalTaxableFees = 0.0;
        for (_200_Submit_Documents_012_taxableItem taxableItem : taxableItems) {
            if (totalTaxableFees_calculatedOnTaxType.contains(taxableItem.getTaxType())) {
                totalTaxableFees += taxableItem.getAmount();
            }
        }
        return totalTaxableFees;
    }
    
    /**
     * total 
     */
    List<String> totalTaxableFees_calculatedOnTaxType_for_total = new ArrayList<String>() {
        {
            add("T1");
            add("T2");
            add("T3");
            add("T4");
            add("T5");
            add("T6");
            add("T7");
            add("T8");
            add("T9");
            add("T10");
            add("T11");
            add("T12");
            
            
            //add("T20");// تم وضغها عشان المنطق بيقول كده لكن فيديو الشرح مقالش كده
            
        }
    };
    public double calcTotalTaxableFees_for_total(List<_200_Submit_Documents_012_taxableItem> taxableItems) {
        double totalTaxableFees = 0.0;
        for (_200_Submit_Documents_012_taxableItem taxableItem : taxableItems) {
            if (totalTaxableFees_calculatedOnTaxType_for_total.contains(taxableItem.getTaxType())) {
                totalTaxableFees += taxableItem.getAmount();
            }
        }
        return totalTaxableFees;
    }

    /**
     * سيتم تجميع كل ال SalesTotal المتواجد بكل الصفوف
     *
     * @param invoiceLines : كل الصفوف بالفاتورة
     * @return
     */
    public double calcTotalSalesAmount(List<_200_Submit_Documents_008_invoiceLine> invoiceLines) {
        double totalSalesAmount = 0.0;
        for (_200_Submit_Documents_008_invoiceLine invoiceLine : invoiceLines) {
            totalSalesAmount += invoiceLine.getSalesTotal();
        }
        return totalSalesAmount;
    }

    /**
     * سيتم تجميع مل ال DiscountAmount الموجودة في ستراكشر الديسكاونت على مستوى
     * كل صف
     *
     * @param invoiceLines : كل الصفوف بالفاتورة
     * @return
     */
    public double calcTotalDiscountAmount(List<_200_Submit_Documents_008_invoiceLine> invoiceLines) {
        double totalDiscountAmount = 0.0;
        for (_200_Submit_Documents_008_invoiceLine invoiceLine : invoiceLines) {
            totalDiscountAmount += invoiceLine.getDiscount().getAmount();
        }
        return totalDiscountAmount;
    }

    /**
     * كل نوع ضريبة سيتم تجميع كل فئاتها من الفاتورا مع بعض مثال : على مستوى كل
     * الصفوف T1 = 200 T2 = 400 وهكذا
     *
     * @param invoiceLines :كل الصفوف بالفاتورة
     * @return
     */
    public List<_200_Submit_Documents_014_taxTotal> calcTaxTotals(List<_200_Submit_Documents_008_invoiceLine> invoiceLines) {
        List<_200_Submit_Documents_014_taxTotal> taxTotals = new ArrayList<>();

        for (_200_Submit_Documents_008_invoiceLine invoiceLine : invoiceLines) {

            for (_200_Submit_Documents_012_taxableItem taxableItem : invoiceLine.getTaxableItems()) { // الضريبة الواقعه على الصف الواحد
                String taxType = taxableItem.getTaxType();
                double amount = taxableItem.getAmount();
                int founded_at_index = taxType_in_taxTotals_at_index(taxType, taxTotals);
                if (founded_at_index > -1) { // if founded get its amount and add the new value
                    double old_amount = taxTotals.get(founded_at_index).getAmount();
                    taxTotals.get(founded_at_index).setAmount(amount + old_amount);
                } else {
                    _200_Submit_Documents_014_taxTotal taxTotal = new _200_Submit_Documents_014_taxTotal(taxType, amount);
                    taxTotals.add(taxTotal);
                }
            }

        }
        return taxTotals;
    }

    private int taxType_in_taxTotals_at_index(String taxType, List<_200_Submit_Documents_014_taxTotal> taxTotals) {
        int founded_at_index = -1;
        for (int i = 0; i < taxTotals.size(); i++) {
            _200_Submit_Documents_014_taxTotal taxTotal = taxTotals.get(i);

            if (taxTotal.getTaxType().equals(taxType)) {
                founded_at_index = i;
                break;
            }
        }
        return founded_at_index;
    }

    /**
     * سيتم تجميع كل ال totals لكل الصفوف
     *
     * @param invoiceLines :كل الصفوف بالفاتورة
     * @return
     */
    public double getSumOfAll_Totals_InAllLines(List<_200_Submit_Documents_008_invoiceLine> invoiceLines) {
        double sum_od_totals_in_oneDocument = 0.0;
        for (_200_Submit_Documents_008_invoiceLine invoiceLine : invoiceLines) {
            sum_od_totals_in_oneDocument += invoiceLine.getTotal();
        }
        return sum_od_totals_in_oneDocument;
    }
    
    public double calcTotalItemDiscount(List<_200_Submit_Documents_008_invoiceLine> invoiceLines){
        double totalItemDiscount = 0.0;
        for (_200_Submit_Documents_008_invoiceLine invoiceLine : invoiceLines) {
            totalItemDiscount += invoiceLine.getItemsDiscount();
        }
        return totalItemDiscount;
    }
}
