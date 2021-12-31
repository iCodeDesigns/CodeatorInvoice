/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.VcleVehicleRequireStatusDt;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Support
 */
public class VcleVehicleRequireStatusDtDao<T> extends AbstractDao<T> {

    public byte GetMaxStatusSeq(String requireSp) {
        Query query = session.createQuery("Select max(v.id.statusSeq) from VcleVehicleRequireStatusDt v where v.id.requireSp='" + requireSp + "' ");
        byte maxRequireSp = GetQueryNumber(query);
        return maxRequireSp;
    }

    private byte GetQueryNumber(Query query) {
        List<Byte> list = query.getResultList();
        byte number = 1;// no Employee saved in the system
        if (list.get(0) != null) {
            number = (byte) (list.get(0) + 1);
        }
        //System.out.println(number);
        return number;
    }

    public List<VcleVehicleRequireStatusDt> GetVcleVehicleRequireStatusDt(String requireSp, String requireStatus) {
        Query query = session.createQuery("SELECT v from VcleVehicleRequireStatusDt v WHERE v.vcleVehicleRequireStatus.requireStatus='" + requireStatus + "' and v.id.requireSp=" + requireSp + " ");
        List<VcleVehicleRequireStatusDt> vList = query.getResultList();
        return vList;
    }
}
