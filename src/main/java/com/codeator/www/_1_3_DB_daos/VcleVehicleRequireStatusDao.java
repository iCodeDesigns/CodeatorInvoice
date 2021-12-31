/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.VcleVehicleRequireStatus;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Support
 */
public class VcleVehicleRequireStatusDao<T> extends AbstractDao<T> {

    public List<VcleVehicleRequireStatus> GetVcleVehicleRequireByRequireStatus(String requireStatus) {
        Query query = session.createQuery("SELECT v from VcleVehicleRequireStatus v WHERE v.requireStatus = '" + requireStatus + "' ");
        List<VcleVehicleRequireStatus> vList = query.getResultList();
        return vList;
    }

}
