/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.VcleVehicleRequire;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mahmoud
 */
public class VcleVehicleRequireDao<T> extends AbstractDao<T> {

    public long GetMaxRequireSp() {
        Query query = session.createQuery("Select max(v.requireSp) from VcleVehicleRequire v ");
        long maxRequireSp = GetQueryNumber(query);
        return maxRequireSp;
    }

    private long GetQueryNumber(Query query) {
        List<Long> list = query.getResultList();
        long number = 1;// no Employee saved in the system
        if (list.get(0) != null) {
            number = list.get(0) + 1;
        }
        //System.out.println(number);
        return number;
    }

    public List<VcleVehicleRequire> GetVcleVehicleRequireByDepNoOld(String depNoOld) {
        Query query = session.createQuery("SELECT v from VcleVehicleRequire v WHERE  v.perDeptOld.id.depNoOld='" + depNoOld + "' order by v.requireSp ");
        List<VcleVehicleRequire> vList = query.getResultList();
        return vList;
    }

    public List<Date> GetRequireDateDistnictYear() {
        Query query = session.createQuery("SELECT DISTINCT v.requireDate from VcleVehicleRequire v order by v.requireDate ");
        List<Date> vList = query.getResultList();
        return vList;
    }

    public List<VcleVehicleRequire> GetVcleVehicleRequireByDepNoOld(String depNoOld, String requireStatus) {
        Query query = session.createQuery("SELECT v from VcleVehicleRequire v WHERE v.vcleVehicleRequireStatus.requireStatus='" + requireStatus + "' and v.perDeptOld.id.depNoOld='" + depNoOld + "' ");
        List<VcleVehicleRequire> vList = query.getResultList();
        return vList;
    }

    public List<VcleVehicleRequire> GetVcleVehicleRequireByDepNoOldAndAprovalNull(String depNoOld) {
        Query query = session.createQuery("SELECT v from VcleVehicleRequire v WHERE v.vcleVehicleRequireStatus.requireStatus='1' and v.employeeNoApproval=null and v.perDeptOld.id.depNoOld='" + depNoOld + "' ");
        List<VcleVehicleRequire> vList = query.getResultList();
        return vList;
    }

    public List<VcleVehicleRequire> GetVcleVehicleRequireByDepNoOldAndAprovalNotNull(String depNoOld) {
        Query query = session.createQuery("SELECT v from VcleVehicleRequire v WHERE  v.perDeptOld.id.depNoOld='" + depNoOld + "' and v.employeeNoApproval!=null order by v.requireSp ");
        List<VcleVehicleRequire> vList = query.getResultList();
        return vList;
    }

    public List<VcleVehicleRequire> GetVcleVehicleRequireByRequireSp(String RequireSp) {
        Query query = session.createQuery("SELECT v from VcleVehicleRequire v WHERE v.requireSp='" + RequireSp + "' ");
        List<VcleVehicleRequire> vList = query.getResultList();
        return vList;
    }

    public List<VcleVehicleRequire> GetVcleVehicleRequireByDeptIdWithRequireStatusIs4(String DeptId, String SectionId) {
        Query query = session.createQuery("SELECT v from VcleVehicleRequire v WHERE v.vcleVehicleRequireStatus.requireStatus='2' and v.perDeptOld.id.sectionNoOld='" + SectionId + "' and v.perDeptOld.id.depNoOld='" + DeptId + "' ");
        List<VcleVehicleRequire> vList = query.getResultList();
        return vList;
    }

    public List<VcleVehicleRequire> GetVcleVehicleRequireByRequireStatus1OfCurrentDay(String requireDate) {
        Query query = session.createQuery("SELECT v from VcleVehicleRequire v WHERE v.vcleVehicleRequireStatus.requireStatus IN ('11','12') and v.requireDate = to_date('" + requireDate + "','yyyy-MM-dd') order by v.perDeptOld.id.depNoOld  ");
        List<VcleVehicleRequire> vList = query.getResultList();
        return vList;
    }

    public long getReuiredTripsCount(String SectionId, String yearMonthFrom, String yearMonthTo, String HQL) {
        Query query = session.createQuery("SELECT count(*) FROM VcleVehicleRequire p where p.vcleVehicleRequireStatus.requireStatus=25 and p.perDeptOld.id.sectionNoOld=" + SectionId + " and p.vcleRecordMovementJoin.vcleRecordMovement.goingDate>=to_date('" + yearMonthFrom + "','yyyy-MM-dd') and p.vcleRecordMovementJoin.vcleRecordMovement.goingDate<to_date('" + yearMonthTo + "','yyyy-MM-dd') " + HQL + " "); //HQL
        List<Long> pList = query.getResultList();
        return pList.get(0);
    }

    public long getReuiredTripsCountForDept(String SectionId,String DeptId ,String yearMonthFrom,String yearMonthTo, String HQL) {
        Query query = session.createQuery("SELECT count(*) FROM VcleVehicleRequire p where p.vcleVehicleRequireStatus.requireStatus=25 and  p.perDeptOld.id.sectionNoOld="+SectionId+" and p.perDeptOld.id.depNoOld="+DeptId+" and p.vcleRecordMovementJoin.vcleRecordMovement.goingDate>=to_date('"+yearMonthFrom+"','yyyy-MM-dd') and p.vcleRecordMovementJoin.vcleRecordMovement.goingDate<to_date('"+yearMonthTo+"','yyyy-MM-dd') "+HQL+" "); //HQL
        List<Long> pList = query.getResultList();
        return pList.get(0);
    }
    public long GetVcleVehicleRequireCurrentDay(String DeptId) {
        Query query = session.createQuery("SELECT COUNT(v.id.requireSp) from VcleVehicleRequire v WHERE v.perDeptOld.id.depNoOld='" + DeptId + "' and v.requireDate = to_date('" + new DateOp().getCustomSysDate("dd-MM-yyyy") + "','dd-MM-yyyy') ");
        long ReqNumbers = GetNumberOfRequestesGeneral(query);
        return ReqNumbers;
    }

    private long GetNumberOfRequestesGeneral(Query query) {
        List<Long> ReqNumbersList = query.getResultList();
        long ReqNumbers = 0;// no Employee saved in the system
        if (ReqNumbersList.size() > 0) {
            ReqNumbers = ReqNumbersList.get(0);
        }
        return ReqNumbers;
    }

}
