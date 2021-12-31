/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import java.util.List;
import javax.persistence.Query;

import com.codeator.www._1_2_DB_entities.VcleRecordMovementJoin;

/**
 *
 * @author Mahmoud
 */
public class VcleRecordMovementJoinDao <T> extends AbstractDao<T> {
    public List<VcleRecordMovementJoin> GetVcleRecordMovementJoinByRequireSp(String requireSp) {
        Query query = session.createQuery("SELECT v from VcleRecordMovementJoin v WHERE v.requireSp="+requireSp+" ");
        List<VcleRecordMovementJoin> vList = query.getResultList();
        return vList;
    }
    public List<VcleRecordMovementJoin> GetVcleRecordMovementJoinByPeriodAndDept(String HQLDate,String depNoOld) {
        Query query = session.createQuery("SELECT v from VcleRecordMovementJoin v WHERE v.vcleRecordMovement.comingDate!=null AND v.vcleVehicleRequire.perDeptOld.id.depNoOld="+depNoOld+" AND "+HQLDate+" ");
        List<VcleRecordMovementJoin> vList = query.getResultList();
        return vList;
    }
}
