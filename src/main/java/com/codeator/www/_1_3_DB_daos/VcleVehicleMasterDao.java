/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.VcleVehicleMaster;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mahmoud
 */
public class VcleVehicleMasterDao<T> extends AbstractDao<T> {

    public List<VcleVehicleMaster> GetAllVehiclesCars() {
        Query query = session.createQuery("SELECT v from VcleVehicleMaster v WHERE v.vcleVehicleType.vcleType=2 order by v.boardDigital ");
        List<VcleVehicleMaster> vList = query.getResultList();
        return vList;
    }
    
    public List<VcleVehicleMaster> GetAllVehiclesCarsHaveGuestNumber() {
        Query query = session.createQuery("SELECT v from VcleVehicleMaster v WHERE v.vcleVehicleType.vcleType=2 AND v.vcleVehicleType.guestNo>=0 order by v.boardDigital ");
        List<VcleVehicleMaster> vList = query.getResultList();
        return vList;
    }

    public List<VcleVehicleMaster> GetAllVehiclesCarsByBoardDigital(String BoardDigital) {
        Query query = session.createQuery("SELECT v from VcleVehicleMaster v WHERE v.boardDigital='" + BoardDigital + "' and v.vcleVehicleType.guestNo>=0 order by v.vcleVehicleType.guestNo ");
        List<VcleVehicleMaster> vList = query.getResultList();
        return vList;
    }
    
    public List<VcleVehicleMaster> GetAllVehiclesCarsByBoardDigitalAccordingToGuestNo(String BoardDigital,String guestNo) {
        Query query = session.createQuery("SELECT v from VcleVehicleMaster v WHERE v.boardDigital='" + BoardDigital + "' and v.vcleVehicleType.guestNo>='"+guestNo+"' order by v.vcleVehicleType.guestNo ");
        List<VcleVehicleMaster> vList = query.getResultList();
        return vList;
    }
    
    public List<VcleVehicleMaster> GetVehiclesCarsByBoardDigital(String boardNumber) {
        Query query = session.createQuery("SELECT v from VcleVehicleMaster v WHERE v.boardNumber='" + boardNumber + "' ");
        List<VcleVehicleMaster> vList = query.getResultList();
        return vList;
    }
}
