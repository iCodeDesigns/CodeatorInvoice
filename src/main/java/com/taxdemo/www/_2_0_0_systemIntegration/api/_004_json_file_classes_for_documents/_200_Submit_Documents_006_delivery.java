/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents;

import java.io.Serializable;

/**
 *
 * @author cdc
 */
public class _200_Submit_Documents_006_delivery implements Serializable {

    private String approach;
    private String packaging;
    private String dateValidity;
    private String exportPort;
    private String countryOfOrigin;
    private double grossWeight;
    private double netWeight;
    private String terms;

    public _200_Submit_Documents_006_delivery() {

    }

    public _200_Submit_Documents_006_delivery(_200_Submit_Documents_006_delivery Submit_Documents_006_delivery) {
        this(
                Submit_Documents_006_delivery.getApproach(),
                Submit_Documents_006_delivery.getPackaging(),
                Submit_Documents_006_delivery.getDateValidity(),
                Submit_Documents_006_delivery.getExportPort(),
                Submit_Documents_006_delivery.getCountryOfOrigin(),
                Submit_Documents_006_delivery.getGrossWeight(),
                Submit_Documents_006_delivery.getNetWeight(),
                Submit_Documents_006_delivery.getTerms()
        );
    }

    public _200_Submit_Documents_006_delivery(String approach, String packaging, String dateValidity, String exportPort, String countryOfOrigin, double grossWeight, double netWeight, String terms) {
        this.approach = approach;
        this.packaging = packaging;
        this.dateValidity = dateValidity;
        this.exportPort = exportPort;
        this.countryOfOrigin = countryOfOrigin;
        this.grossWeight = grossWeight;
        this.netWeight = netWeight;
        this.terms = terms;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getApproach() {
        return approach;
    }

    public void setApproach(String approach) {
        this.approach = approach;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public String getDateValidity() {
        return dateValidity;
    }

    public void setDateValidity(String dateValidity) {
        this.dateValidity = dateValidity;
    }

    public String getExportPort() {
        return exportPort;
    }

    public void setExportPort(String exportPort) {
        this.exportPort = exportPort;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(double netWeight) {
        this.netWeight = netWeight;
    }

}
