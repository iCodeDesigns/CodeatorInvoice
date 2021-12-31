/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author cdc
 */
public class _200_Submit_Documents_008_invoiceLine implements Serializable {

    private String index = null;// مش للضرايب
    private String lineNumber = null;// مش للضرايب
    private String itemSeq = null;// مش للضرايب

    private double calcUnit;// مش للضرايب
    private double priceBeforeCalcUnit;// مش للضرايب
    private double minimumLimit;// مش للضرايب

    private String description; // اسم المنتج أو وصفه
    private String itemType; // GS1 Coding System : 13 digit number in itemCode , EGS Coding System : EG-taxRegisterationNumber-InternalCode in itemCode
    private String itemCode; // 13 digit number if (GS1) , EG-taxRegisterationNumber-InternalCode if (EGS)
    private String unitType;// (M) : Meter , (EA) : unmeasureble unit >> وحدة , these Codes Come From the SDK portal
    private double quantity;// الكمية المباعة
    private String internalCode;// optional field : internal code of the item

    private _200_Submit_Documents_009_unitValue unitValue;

    private double salesTotal;

    private _200_Submit_Documents_010_discount discount;

    private double netTotal;
    private double valueDifference;

    private List<_200_Submit_Documents_012_taxableItem> taxableItems;

    private double totalTaxableFees;
    private double itemsDiscount;
    private double total;

    private List<_201_itemDescDetails> itemDescDetails;

    public _200_Submit_Documents_008_invoiceLine() {

    }

    // مش محتاجاه  الضرايب
    public _200_Submit_Documents_008_invoiceLine(String lineNumber, String description, String itemType, String itemCode, String unitType, double quantity, String internalCode, _200_Submit_Documents_009_unitValue unitValue, double salesTotal, _200_Submit_Documents_010_discount discount, double netTotal, double valueDifference, List<_200_Submit_Documents_012_taxableItem> taxableItems, double totalTaxableFees, double itemsDiscount, double total, String itemSeq) {
        this.lineNumber = lineNumber;////////////<-----------
        this.description = description;
        this.itemType = itemType;
        this.itemCode = itemCode;
        this.unitType = unitType;
        this.quantity = quantity;
        this.internalCode = internalCode;
        this.unitValue = unitValue;
        this.salesTotal = salesTotal;
        this.discount = discount;
        this.netTotal = netTotal;
        this.valueDifference = valueDifference;
        this.taxableItems = taxableItems;
        this.totalTaxableFees = totalTaxableFees;
        this.itemsDiscount = itemsDiscount;
        this.total = total;
        this.itemSeq = itemSeq;
    }

    public _200_Submit_Documents_008_invoiceLine(_200_Submit_Documents_008_invoiceLine Submit_Documents_008_invoiceLine) {
        this(
                Submit_Documents_008_invoiceLine.getDescription(),
                Submit_Documents_008_invoiceLine.getItemType(),
                Submit_Documents_008_invoiceLine.getItemCode(),
                Submit_Documents_008_invoiceLine.getUnitType(),
                Submit_Documents_008_invoiceLine.getQuantity(),
                Submit_Documents_008_invoiceLine.getInternalCode(),
                Submit_Documents_008_invoiceLine.getUnitValue(),
                Submit_Documents_008_invoiceLine.getSalesTotal(),
                Submit_Documents_008_invoiceLine.getDiscount(),
                Submit_Documents_008_invoiceLine.getNetTotal(),
                Submit_Documents_008_invoiceLine.getValueDifference(),
                Submit_Documents_008_invoiceLine.getTaxableItems(),
                Submit_Documents_008_invoiceLine.getTotalTaxableFees(),
                Submit_Documents_008_invoiceLine.getItemsDiscount(),
                Submit_Documents_008_invoiceLine.getTotal()
        );
    }

    //محتاجاه الضرايب
    public _200_Submit_Documents_008_invoiceLine(String description, String itemType, String itemCode, String unitType, double quantity, String internalCode, _200_Submit_Documents_009_unitValue unitValue, double salesTotal, _200_Submit_Documents_010_discount discount, double netTotal, double valueDifference, List<_200_Submit_Documents_012_taxableItem> taxableItems, double totalTaxableFees, double itemsDiscount, double total) {
        this.description = description;
        this.itemType = itemType;
        this.itemCode = itemCode;
        this.unitType = unitType;
        this.quantity = quantity;
        this.internalCode = internalCode;
        this.unitValue = unitValue;
        this.salesTotal = salesTotal;
        this.discount = discount;
        this.netTotal = netTotal;
        this.valueDifference = valueDifference;
        this.taxableItems = taxableItems;
        this.totalTaxableFees = totalTaxableFees;
        this.itemsDiscount = itemsDiscount;
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalTaxableFees() {
        return totalTaxableFees;
    }

    public void setTotalTaxableFees(double totalTaxableFees) {
        this.totalTaxableFees = totalTaxableFees;
    }

    public double getItemsDiscount() {
        return itemsDiscount;
    }

    public void setItemsDiscount(double itemsDiscount) {
        this.itemsDiscount = itemsDiscount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public _200_Submit_Documents_009_unitValue getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(_200_Submit_Documents_009_unitValue unitValue) {
        this.unitValue = unitValue;
    }

    public double getSalesTotal() {
        return salesTotal;
    }

    public void setSalesTotal(double salesTotal) {
        this.salesTotal = salesTotal;
    }

    public _200_Submit_Documents_010_discount getDiscount() {
        return discount;
    }

    public void setDiscount(_200_Submit_Documents_010_discount discount) {
        this.discount = discount;
    }

    public double getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(double netTotal) {
        this.netTotal = netTotal;
    }

    public double getValueDifference() {
        return valueDifference;
    }

    public void setValueDifference(double valueDifference) {
        this.valueDifference = valueDifference;
    }

    public List<_200_Submit_Documents_012_taxableItem> getTaxableItems() {
        return taxableItems;
    }

    public void setTaxableItems(List<_200_Submit_Documents_012_taxableItem> taxableItems) {
        this.taxableItems = taxableItems;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getItemSeq() {
        return itemSeq;
    }

    public void setItemSeq(String itemSeq) {
        this.itemSeq = itemSeq;
    }

    public List<_201_itemDescDetails> getItemDescDetails() {
        return itemDescDetails;
    }

    public void setItemDescDetails(List<_201_itemDescDetails> itemDescDetails) {
        this.itemDescDetails = itemDescDetails;
    }

    public double getCalcUnit() {
        return calcUnit;
    }

    public void setCalcUnit(double calcUnit) {
        this.calcUnit = calcUnit;
    }

    public double getPriceBeforeCalcUnit() {
        return priceBeforeCalcUnit;
    }

    public void setPriceBeforeCalcUnit(double priceBeforeCalcUnit) {
        this.priceBeforeCalcUnit = priceBeforeCalcUnit;
    }

    public double getMinimumLimit() {
        return minimumLimit;
    }

    public void setMinimumLimit(double minimumLimit) {
        this.minimumLimit = minimumLimit;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

}
