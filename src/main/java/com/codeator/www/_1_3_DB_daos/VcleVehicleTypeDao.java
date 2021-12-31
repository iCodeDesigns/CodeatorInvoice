/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.VcleVehicleType;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mahmoud
 */
public class VcleVehicleTypeDao<T> extends AbstractDao<T> {

    public List<VcleVehicleType> GetAllVehicles() {
        Query query = session.createQuery("SELECT v from VcleVehicleType v order by v.vcleTypeName");
        List<VcleVehicleType> vList = query.getResultList();
        return vList;
    }
    
    public List<VcleVehicleType> GetVehiclesByGuestNo(String guestNo) {
        Query query = session.createQuery("SELECT v from VcleVehicleType v where v.guestNo>="+guestNo+" order by v.guestNo");
        List<VcleVehicleType> vList = query.getResultList();
        return vList;
    }

    public List<VcleVehicleType> GetVehicleByVehicleType(String VehicleType) {
        Query query = session.createQuery("SELECT v from VcleVehicleType v WHERE v.vcleType='" + VehicleType + "' ");
        List<VcleVehicleType> vList = query.getResultList();
        return vList;
    }
}
