/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._002_received_json;

import java.util.List;

/**
 * this class is a mirror for api json received when try to submit document :
 *
 * - json file :
 *
 * {
 *
 * "submissionId" : "",
 *
 * "acceptedDocuments" :[ { "uuid":"", "longId":"", "internalId":"",
 * "hashKey":"" } ],
 *
 * "rejectedDocuments" : [ { "uuid":"", "longId":"", "internalId":"",
 * "hashKey":"" } ]
 *
 * }
 *
 * @author Mahmoud Ahmed
 */
public class _101_Submit_Documents_JSON_000_ {

    private String submissionId;
    private List<_101_Submit_Documents_JSON_100_> acceptedDocuments;
    private List<_101_Submit_Documents_JSON_100_> rejectedDocuments;

    public _101_Submit_Documents_JSON_000_() {

    }

    public _101_Submit_Documents_JSON_000_(String submissionId, List<_101_Submit_Documents_JSON_100_> acceptedDocuments, List<_101_Submit_Documents_JSON_100_> rejectedDocuments) {
        this.submissionId = submissionId;
        this.acceptedDocuments = acceptedDocuments;
        this.rejectedDocuments = rejectedDocuments;
    }

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    public List<_101_Submit_Documents_JSON_100_> getAcceptedDocuments() {
        return acceptedDocuments;
    }

    public void setAcceptedDocuments(List<_101_Submit_Documents_JSON_100_> acceptedDocuments) {
        this.acceptedDocuments = acceptedDocuments;
    }

    public List<_101_Submit_Documents_JSON_100_> getRejectedDocuments() {
        return rejectedDocuments;
    }

    public void setRejectedDocuments(List<_101_Submit_Documents_JSON_100_> rejectedDocuments) {
        this.rejectedDocuments = rejectedDocuments;
    }

}
