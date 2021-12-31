/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.VcleEmployeeMaster;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mahmoud
 */
public class VcleEmployeeMasterDao<T> extends AbstractDao<T> {
    
     public List<VcleEmployeeMaster> GetEmployeesVehiclesOfCarAndBickes() {
        Query query = session.createQuery("SELECT v from VcleEmployeeMaster v WHERE v.vcleJobType='6' OR v.vcleJobType='7' ORDER BY v.empName");
        List<VcleEmployeeMaster> vList = query.getResultList();
        return vList;
    }
}
