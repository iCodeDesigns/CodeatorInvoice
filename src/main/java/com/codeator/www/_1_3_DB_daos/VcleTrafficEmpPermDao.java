/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.VcleTrafficEmpPerm;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class VcleTrafficEmpPermDao<T> extends AbstractDao<T> {

    public List<VcleTrafficEmpPerm> GetVcleTrafficEmpPermByMonthAndVal(String Month,String val) {
        Query query = session.createQuery("SELECT v from VcleTrafficEmpPerm v where v.id.execMm=to_date( :Month , 'MM-yyyy') and v.val=:val order by v.employeeNo ");
        query.setString("Month", Month);
        query.setString("val", val);
        List<VcleTrafficEmpPerm> vList = query.getResultList();
        return vList;
    } 
    
    public List<VcleTrafficEmpPerm> GetVcleTrafficEmpPermCustomQuery(String HQL) {
        Query query = session.createQuery("SELECT v from VcleTrafficEmpPerm v " + HQL + " order by v.id.execMm desc ");
        List<VcleTrafficEmpPerm> vList = query.getResultList();
        return vList;
    }

    public List<VcleTrafficEmpPerm> GetAllVcleTrafficEmpPerm() {
        Query query = session.createQuery("SELECT v from VcleTrafficEmpPerm v order by v.id.execMm desc, v.val asc ");
        List<VcleTrafficEmpPerm> vList = query.getResultList();
        return vList;
    }

    public List<VcleTrafficEmpPerm> GetAllVcleTrafficEmpPermByDate(String HQL) {
        Query query = session.createQuery("SELECT v from VcleTrafficEmpPerm v " + HQL + " order by v.id.execMm desc, v.val asc ");
        List<VcleTrafficEmpPerm> vList = query.getResultList();
        return vList;
    }

    public List<VcleTrafficEmpPerm> GetAllVcleTrafficEmpPermByEmployeeId(String employeeId, String HQL) {
        Query query = session.createQuery("SELECT v from VcleTrafficEmpPerm v " + HQL + " v.id.employeeId=" + employeeId + " order by v.id.execMm desc, v.val asc ");
        List<VcleTrafficEmpPerm> vList = query.getResultList();
        return vList;
    }

    public List<VcleTrafficEmpPerm> GetAllVcleTrafficEmpPermByVal(String val, String HQL) {
        Query query = session.createQuery("SELECT v from VcleTrafficEmpPerm v " + HQL + " v.val=" + val + " order by v.id.execMm desc ");
        List<VcleTrafficEmpPerm> vList = query.getResultList();
        return vList;
    }

    public List<VcleTrafficEmpPerm> GetAllVcleTrafficEmpPermByDate2(String HQL) {
        Query query = session.createQuery("SELECT v from VcleTrafficEmpPerm v " + HQL + " order by v.val desc ");
        List<VcleTrafficEmpPerm> vList = query.getResultList();
        return vList;
    }

    public List<VcleTrafficEmpPerm> GetAllVcleTrafficEmpPermByEmployeeId2(String employeeId, String HQL) {
        Query query = session.createQuery("SELECT v from VcleTrafficEmpPerm v " + HQL + " v.id.employeeId=" + employeeId + " order by v.val desc ");
        List<VcleTrafficEmpPerm> vList = query.getResultList();
        return vList;
    }

    public List<VcleTrafficEmpPerm> GetAllVcleTrafficEmpPermByVal2(String val, String HQL) {
        Query query = session.createQuery("SELECT v from VcleTrafficEmpPerm v " + HQL + " v.val=" + val + " order by v.val desc ");
        List<VcleTrafficEmpPerm> vList = query.getResultList();
        return vList;
    }

    public List<BigDecimal> GetValValusFromVcleTrafficEmpPerm(String HQL) {
        Query query = session.createQuery("SELECT distinct v.val from VcleTrafficEmpPerm v " + HQL + " order by v.val desc");
        List<BigDecimal> vList = query.getResultList();
        return vList;
    }

    public List<Date> GetExecMmFromVcleTrafficEmpPerm() {
        Query query = session.createQuery("SELECT distinct v.id.execMm from VcleTrafficEmpPerm v order by v.id.execMm desc");
        List<Date> vList = query.getResultList();
        return vList;
    }

    public List<Date> GetExecYearFromVcleTrafficEmpPerm() {
        Query query = session.createQuery("SELECT distinct to_date(v.id.execMm,'yyyy') from VcleTrafficEmpPerm v order by v.id.execMm desc");
        List<Date> vList = query.getResultList();
        return vList;
    }

    public Map<String, BigDecimal> GetCountVcleTrafficEmpPermByYearMainMonthEmpID(Date date) {

        Map<String, BigDecimal> dictionary = new HashMap<String, BigDecimal>();

        String date1 = new DateOp().Date2String(date, "MM-yyyy");
        Query query = session.createQuery("SELECT count(*) from VcleTrafficEmpPerm v where v.id.execMm = to_date( :date1 , 'MM-yyyy') order by v.id.execMm desc");
        query.setString("date1", date1);
        long countEmployeeIdInMonth = GetQueryNumberInt(query);

        query = session.createQuery("SELECT SUM(v.val) from VcleTrafficEmpPerm v where v.id.execMm = to_date( :date1 , 'MM-yyyy') order by v.id.execMm desc ");
        query.setString("date1", date1);
        BigDecimal countValInMonth = GetQueryNumberDouble(query);

        dictionary.put("countEmployeeIdInMonth", BigDecimal.valueOf(countEmployeeIdInMonth));
        dictionary.put("countValInMonth", countValInMonth);
        return dictionary;
    }

    private long GetQueryNumberInt(Query query) {
        List<Long> list = query.getResultList();
        long number = 0;// no Employee saved in the system
        if (list.get(0) != null) {
            number = list.get(0);
        }
        //System.out.println(number);
        return number;
    }

    private BigDecimal GetQueryNumberDouble(Query query) {
        List<BigDecimal> list = query.getResultList();
        BigDecimal number = BigDecimal.valueOf(0.0);// no Employee saved in the system
        if (list.get(0) != null) {
            number = list.get(0);
        }
        //System.out.println(number);
        return number;
    }

    public List<Date> GetVcleTrafficEmpPermByYearMain(String year) {
        Query query = session.createQuery("SELECT distinct v.id.execMm from VcleTrafficEmpPerm v where extract(YEAR from v.id.execMm)=:year  order by v.id.execMm desc");
        query.setString("year", year);
        List<Date> vList = query.getResultList();
        return vList;
    }

    public List<BigDecimal> GetVcleTrafficEmpPermByMonthFeat(String Month) {
        Query query = session.createQuery("SELECT distinct v.val from VcleTrafficEmpPerm v where v.id.execMm=to_date( :Month , 'MM-yyyy') order by v.val desc ");
        query.setString("Month", Month);
        List<BigDecimal> vList = query.getResultList();
        return vList;
    }

    public long GetCountEmployeeByMonthAndVal(String month, String val) {

        Map<String, BigDecimal> dictionary = new HashMap<String, BigDecimal>();
        Query query = session.createQuery("SELECT count(*) from VcleTrafficEmpPerm v where v.id.execMm = to_date( :month , 'MM-yyyy') and v.val=:val ");
        query.setString("month", month);
        query.setString("val", val);
        long countEmployeeIdInMonth = GetQueryNumberInt(query);
        return countEmployeeIdInMonth;
    }

}
