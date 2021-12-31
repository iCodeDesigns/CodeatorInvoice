/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents;

/**
 * كل ما يخص مصدر ال المستند
 *
 * @author cdc
 */
public class _200_Submit_Documents_002_issuer {

    private _200_Submit_Documents_004_address address;
    private String type; // B : Business , P : Person , F : Foreigner
    private String id;   // tax registration number : رقم التسجيل الضريبي
    private String name; // اسم الشركة المصدرة للفاتورة

    public _200_Submit_Documents_002_issuer() {

    }

    public _200_Submit_Documents_002_issuer(_200_Submit_Documents_002_issuer Submit_Documents_002_issuer) {
        this(
                Submit_Documents_002_issuer.getAddress(),
                Submit_Documents_002_issuer.getType(),
                Submit_Documents_002_issuer.getId(),
                Submit_Documents_002_issuer.getName()
        );
    }

    public _200_Submit_Documents_002_issuer(_200_Submit_Documents_004_address address, String type, String id, String name) {
        this.address = address;
        this.type = type;
        this.id = id;
        this.name = name;
    }

    public _200_Submit_Documents_004_address getAddress() {
        return address;
    }

    public void setAddress(_200_Submit_Documents_004_address address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
