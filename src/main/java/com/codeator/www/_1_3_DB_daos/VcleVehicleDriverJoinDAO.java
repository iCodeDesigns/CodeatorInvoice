/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.VcleVehicleDriverJoin;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mohamed
 */
public class VcleVehicleDriverJoinDAO<T> extends AbstractDao<T> {

    public List<VcleVehicleDriverJoin> GetAllVcleVehicleDriverJoin() {
        Query query = session.createQuery("SELECT v from VcleVehicleDriverJoin v order by v.perEmploymentMaster.empAname");
        List<VcleVehicleDriverJoin> vList = query.getResultList();
        return vList;
    }

    public List<VcleVehicleDriverJoin> GetAllVcleVehicleDriverJoinOrderByVcleNumber() {
        Query query = session.createQuery("SELECT v from VcleVehicleDriverJoin v order by v.boardDigital");
        List<VcleVehicleDriverJoin> vList = query.getResultList();
        return vList;
    }

    public List<VcleVehicleDriverJoin> GetVcleVehicleDriverJoinByemployeeId(String employeeId) {
        Query query = session.createQuery("SELECT v from VcleVehicleDriverJoin v where v.id.employeeId=" + employeeId + "");
        List<VcleVehicleDriverJoin> vList = query.getResultList();
        return vList;
    }

    public List<VcleVehicleDriverJoin> GetVcleVehicleDriverJoinByboardNumber(String boardNumber) {
        Query query = session.createQuery("SELECT v from VcleVehicleDriverJoin v where v.boardNumber like '" + boardNumber + "'");
        List<VcleVehicleDriverJoin> vList = query.getResultList();
        return vList;
    }
    
    public List<VcleVehicleDriverJoin> GetVcleVehicleDriverJoinByDriver(String emp_id) {
        Query query = session.createQuery("SELECT v from VcleVehicleDriverJoin v where v.id.employeeId='" + emp_id + "'");
        List<VcleVehicleDriverJoin> vList = query.getResultList();
        return vList;
    }

    public List<VcleVehicleDriverJoin> GetVcleVehicleDriverJoinByModelCode(String ModelCode, String MarkType, String VcleType) {
        Query query = session.createQuery("SELECT v from VcleVehicleDriverJoin v where v.vcleVehicleMaster.vcleVehicleModel.id.modelCode=" + ModelCode + " and v.vcleVehicleMaster.vcleVehicleModel.id.markType=" + MarkType + " and v.vcleVehicleMaster.vcleVehicleModel.id.vcleType=" + VcleType + " ");
        List<VcleVehicleDriverJoin> vList = query.getResultList();
        return vList;
    }

    public List<VcleVehicleDriverJoin> GetVcleVehicleDriverJoinByVcleType(String VcleType) {
        Query query = session.createQuery("SELECT v from VcleVehicleDriverJoin v where v.vcleVehicleMaster.vcleVehicleType.vcleType=" + VcleType + "");
        List<VcleVehicleDriverJoin> vList = query.getResultList();
        return vList;
    }

}
