/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents;

/**
 *
 * @author cdc
 */
public class _200_Submit_Documents_004_address {

    private String branchID;
    private String country;
    private String governate;
    private String regionCity;
    private String street;
    private String buildingNumber;
    private String postalCode;
    private String floor;
    private String room;
    private String landmark;
    private String additionalInformation;

    private String countryCode;//مش للضرايب
    private String governateCode;//مش للضرايب

    public _200_Submit_Documents_004_address() {

    }

    public _200_Submit_Documents_004_address(String country, String governate, String regionCity, String street, String buildingNumber, String postalCode, String floor, String room, String landmark, String additionalInformation) {
        this.country = country;
        this.governate = governate;
        this.regionCity = regionCity;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.postalCode = postalCode;
        this.floor = floor;
        this.room = room;
        this.landmark = landmark;
        this.additionalInformation = additionalInformation;
    }

    public _200_Submit_Documents_004_address(String branchID, String country, String governate, String regionCity, String street, String buildingNumber, String postalCode, String floor, String room, String landmark, String additionalInformation) {
        this.branchID = branchID;
        this.country = country;
        this.governate = governate;
        this.regionCity = regionCity;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.postalCode = postalCode;
        this.floor = floor;
        this.room = room;
        this.landmark = landmark;
        this.additionalInformation = additionalInformation;
    }

    public String getBranchID() {
        return branchID;
    }

    public void setBranchID(String branchID) {
        this.branchID = branchID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGovernate() {
        return governate;
    }

    public void setGovernate(String governate) {
        this.governate = governate;
    }

    public String getRegionCity() {
        return regionCity;
    }

    public void setRegionCity(String regionCity) {
        this.regionCity = regionCity;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getGovernateCode() {
        return governateCode;
    }

    public void setGovernateCode(String governateCode) {
        this.governateCode = governateCode;
    }
}
