/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents;

import java.util.List;

/**
 *
 * @author cdc
 */
public class _200_Submit_Documents_011_taxableItems {

    private List<_200_Submit_Documents_012_taxableItem> taxableItem;

    public _200_Submit_Documents_011_taxableItems() {

    }

    public _200_Submit_Documents_011_taxableItems(List<_200_Submit_Documents_012_taxableItem> taxableItem) {
        this.taxableItem = taxableItem;
    }

    public List<_200_Submit_Documents_012_taxableItem> getTaxableItem() {
        return taxableItem;
    }

    public void setTaxableItem(List<_200_Submit_Documents_012_taxableItem> taxableItem) {
        this.taxableItem = taxableItem;
    }

}
