/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.VcleVehicleModel;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mohamed
 */
public class VcleVehicleModelDao<T> extends AbstractDao<T> {

    public List<VcleVehicleModel> GetAllVehiclesModels() {
        Query query = session.createQuery("SELECT v from VcleVehicleModel v order by v.vcleMarkType.markName");
        List<VcleVehicleModel> vList = query.getResultList();
        return vList;
    }
    
}
