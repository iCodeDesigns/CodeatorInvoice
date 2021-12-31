/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.VcleRecordMovement;
import com.codeator.www._1_2_DB_entities.VcleRecordMovementJoin;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mahmoud
 */
public class VcleRecordMovementDAO<T> extends AbstractDao<T> {

    public List<VcleRecordMovement> GetVcleRecordMovementCustomQuery(String HQL) {
        String H = "SELECT v from VcleRecordMovement v where " + HQL;
        //System.out.println(H);
        Query query = session.createQuery("SELECT v from VcleRecordMovement v WHERE " + HQL + " order by v.goingDate desc");
        List<VcleRecordMovement> vList = query.getResultList();
        return vList;
    }

    public List<VcleRecordMovement> GetAllVcleRecordMovement() {
        Query query = session.createQuery("SELECT v from VcleRecordMovement v order by v.goingDate desc ");
        List<VcleRecordMovement> vList = query.getResultList();
        return vList;
    }

    public List<VcleRecordMovement> GetAllVcleRecordMovementByGoingDate(String goingDate) {
        Query query = session.createQuery("SELECT v from VcleRecordMovement v where v.goingDate=to_date('" + goingDate + "','yyyy-MM-dd') order by v.goingDate desc ");
        List<VcleRecordMovement> vList = query.getResultList();
        return vList;
    }

    public List<VcleRecordMovement> GetVcleRecordMovementCarsInPeriod(Date FromDate, Date ToDate) {
        String FromDateStr = new DateOp().Date2String(FromDate, "dd-MMM-yyyy");
        String ToDateStr = new DateOp().Date2String(ToDate, "dd-MMM-yyyy");
        Query query = session.createQuery("SELECT v from VcleRecordMovement as v WHERE v.goingDate>='" + FromDateStr + "' AND v.goingDate<='" + ToDateStr + "' ");
        List<VcleRecordMovement> vList = query.getResultList();
        return vList;
    }

    public List<VcleRecordMovement> GetVcleRecordMovementDrvicersInPeriod(Date FromDate, Date ToDate) {
        String FromDateStr = new DateOp().Date2String(FromDate, "dd-MMM-yyyy");
        String ToDateStr = new DateOp().Date2String(ToDate, "dd-MMM-yyyy");
        Query query = session.createQuery("SELECT v from VcleRecordMovement as v WHERE v.goingDate>='" + FromDateStr + "' AND v.goingDate<='" + ToDateStr + "' ");
        List<VcleRecordMovement> vList = query.getResultList();
        return vList;
    }

    public List<VcleRecordMovement> GetVcleRecordMovementByGopingSp(String GopingSp) {
        Query query = session.createQuery("SELECT v from VcleRecordMovement v WHERE v.goingSp=" + GopingSp + " ");
        List<VcleRecordMovement> vList = query.getResultList();
        return vList;
    }

    public List<VcleRecordMovement> GetVcleRecordMovementStellOut() {
        Query query = session.createQuery("SELECT v from VcleRecordMovement v WHERE v.comingDate=null ");
        List<VcleRecordMovement> vList = query.getResultList();
        return vList;
    }

    public List<VcleRecordMovement> GetVcleRecordMovementStellOutByGoingSp(String GopingSp) {
        Query query = session.createQuery("SELECT v from VcleRecordMovement v WHERE v.goingSp=" + GopingSp + " and v.comingDate=null ");
        List<VcleRecordMovement> vList = query.getResultList();
        return vList;
    }

    public long GetMaxGoingSp() {
        Query query = session.createQuery("Select max(v.id.goingSp) from VcleRecordMovement v");
        long maxRequireSp = GetQueryNumber(query);
        return maxRequireSp;
    }

    public long GetLastVcleCountNumber(String BoardNumber) {
        Query query = session.createQuery("Select v.comingCountNumber from VcleRecordMovement v where v.id.goingSp=(Select max(z.id.goingSp) from VcleRecordMovement z where z.vcleVehicleMaster.boardNumber='" + BoardNumber + "') ");
        long maxRequireSp = GetQueryNumber(query);
        return maxRequireSp;
    }

    private long GetQueryNumber(Query query) {
        List<Long> list = query.getResultList();
        long number = 0;// no Employee saved in the system
        if (list.isEmpty()) {
            number = 0;
        } else {
            if (list.get(0) != null) {
                number = list.get(0);
            }
        }
        //System.out.println(number);
        return number;
    }

}
