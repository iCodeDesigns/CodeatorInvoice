/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.query.Query;

/**
 *
 * @author Mahmoud
 */
public class PerEmploymentMasterDao<T> extends AbstractDao<T> {

    public List<PerEmploymentMaster> GetAllEmpsCustomHQL(String HQL) {
        //SELECT distinct v.id.employeeId from VcleTrafficEmpPerm v
        Query query = session.createQuery("SELECT p from PerEmploymentMaster p " + HQL + " ");
        List<PerEmploymentMaster> vList = query.getResultList();
        return vList;
    }

    public List<PerEmploymentMaster> GetAllEmployees() {
        Query query = session.createQuery("SELECT p from PerEmploymentMaster p order by p.empAname ");
        List<PerEmploymentMaster> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMaster> GetAllEmployees2() {
        Query query = session.createQuery("SELECT p from PerEmploymentMaster p where p.employeeId Not In (SELECT c.employeeId from AppAuthJavaUsers c ) ");
        List<PerEmploymentMaster> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMaster> getPerEmploymentMasterByName(String empAname) {
        Query query = session.createQuery("SELECT p FROM PerEmploymentMaster p where p.empAname Like '" + empAname + "%' order by p.empAname"); //HQL
        List<PerEmploymentMaster> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMaster> getPerEmploymentMasterByNameAnddept(String empAname, String sectionNoOld, String depNoOld) {
        Query query = session.createQuery("SELECT p FROM PerEmploymentMaster p where p.empAname Like '" + empAname + "%' and p.perDeptOld.id.sectionNoOld=" + sectionNoOld + " and p.perDeptOld.id.depNoOld=" + depNoOld + " order by p.empAname"); //HQL
        List<PerEmploymentMaster> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMaster> getPerEmploymentMasterByNameAnddeptInJavaUsers(String empAname, String accUnitCode, String sectionNoOld, String depNoOld) {
        Query query = session.createQuery("SELECT p FROM PerEmploymentMaster p where p.perDeptOld.id.depNoOld=:depNoOld and  p.perDeptOld.id.sectionNoOld=:sectionNoOld and  p.empAname Like '" + empAname + "%' and p.employeeId IN (select v.employeeId from AppAuthJavaUsers v WHERE (v.invoAccUintDept.id.accUnitCode=null and v.invoAccUintDept.id.depNoOld=null and v.invoAccUintDept.id.sectionNoOld=null) OR (v.invoAccUintDept.id.accUnitCode=:accUnitCode and v.invoAccUintDept.id.depNoOld=:depNoOld and v.invoAccUintDept.id.sectionNoOld=:sectionNoOld) )"); //HQL
        query.setString("accUnitCode", accUnitCode);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("depNoOld", depNoOld);
        List<PerEmploymentMaster> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMaster> GetEmployeesByEmployee_ID(String employeeId) {
        Query query = session.createQuery("SELECT p from PerEmploymentMaster p WHERE p.employeeId='" + employeeId + "' ");
        List<PerEmploymentMaster> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMaster> GetEmployeesByEmployee_IDInJavaUsers(String employeeId, String accUnitCode, String depNoOld, String sectionNoOld) {
        Query query = session.createQuery("SELECT p from PerEmploymentMaster p WHERE p.perDeptOld.id.depNoOld=:depNoOld and  p.perDeptOld.id.sectionNoOld=:sectionNoOld and  p.employeeId IN (select v.employeeId from AppAuthJavaUsers v WHERE v.employeeId=:employeeId and ((v.invoAccUintDept.id.accUnitCode=null and v.invoAccUintDept.id.depNoOld=null and v.invoAccUintDept.id.sectionNoOld=null) OR (v.invoAccUintDept.id.accUnitCode=:accUnitCode and v.invoAccUintDept.id.depNoOld=:depNoOld and v.invoAccUintDept.id.sectionNoOld=:sectionNoOld) ))  ");
        query.setString("accUnitCode", accUnitCode);
        query.setString("employeeId", employeeId);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        List<PerEmploymentMaster> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMaster> GetEmployeesByEmployee_IDByDept(String accUnitCode, String employeeId, String depNoOld, String sectionNoOld) {
        Query query = session.createQuery("SELECT p from PerEmploymentMaster p WHERE p.perDeptOld.invoAccUintDepts.id.accUnitCode=:accUnitCode and p.perDeptOld.invoAccUintDepts.id.depNoOld=:depNoOld and p.perDeptOld.invoAccUintDepts.id.sectionNoOld=:sectionNoOld and p.employeeId=:employeeId ");
        query.setString("accUnitCode", accUnitCode);
        query.setString("employeeId", employeeId);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        List<PerEmploymentMaster> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMaster> GetEmployeesByEmployee_IDByDeptOnly(String employeeId, String depNoOld, String sectionNoOld) {
        Query query = session.createQuery("SELECT p from PerEmploymentMaster p WHERE p.perDeptOld.id.depNoOld=:depNoOld and p.perDeptOld.id.sectionNoOld=:sectionNoOld and p.employeeId=:employeeId ");
        query.setString("employeeId", employeeId);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        List<PerEmploymentMaster> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMaster> GetEmployeesByDept_ID(String sectionNoOld, String depNoOld) {
        Query query = session.createQuery("SELECT pp from PerEmploymentMaster pp WHERE pp.perDeptOld.id.depNoOld='" + depNoOld + "' and pp.perDeptOld.id.sectionNoOld='" + sectionNoOld + "' order by pp.empAname ");
        List<PerEmploymentMaster> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMaster> GetEmployeesByEmployee_ID_Birthdate(String employeeId, String birthDate) {

        Query query = session.createQuery("SELECT p from PerEmploymentMaster p WHERE p.employeeId='" + employeeId + "' and p.birthDate=to_date('" + birthDate + "','yyyy-MM-dd') ");
        List<PerEmploymentMaster> pList = query.getResultList();
        return pList;
    }

    public List<PerEmploymentMaster> GetEmployeesByEmployee_UserName_Password(String employeeId, String employeePassword) {

        Query query = session.createQuery("SELECT p from PerEmploymentMaster p WHERE p.appAuthJavaUsers.employeeId=:employeeId and p.appAuthJavaUsers.employeePassword=:employeePassword and p.appAuthJavaUsers.chkLock = '1'");
        query.setString("employeeId", employeeId);
        query.setString("employeePassword", employeePassword);
        List<PerEmploymentMaster> pList = query.getResultList();
        return pList;
    }
    
    public List<PerEmploymentMaster> GetEmployeesByEmployee_UserName(String employeeId) {

        Query query = session.createQuery("SELECT p from PerEmploymentMaster p WHERE p.appAuthJavaUsers.employeeId=:employeeId and p.appAuthJavaUsers.chkLock = '1'");
        query.setString("employeeId", employeeId);
        List<PerEmploymentMaster> pList = query.getResultList();
        return pList;
    }

    public long GetCountEmpInDept(String sectionNoOld, String depNoOld) {
        Query query = session.createQuery("Select count(*) from PerEmploymentMaster p where p.perDeptOld.id.depNoOld='" + depNoOld + "' and p.perDeptOld.id.sectionNoOld='" + sectionNoOld + "' ");
        long count = GetQueryNumber(query, 0);
        return count;
    }

    private long GetQueryNumber(Query query, long Default) {
        List<Long> list = query.getResultList();
        long number = Default;// no Employee saved in the system
        if (list.get(0) != null) {
            number = list.get(0);
        }
        //System.out.println(number);
        return number;
    }

    public List<PerEmploymentMaster> GetAllEmpsInVcleTrafficEmpPerm() {
        //SELECT distinct v.id.employeeId from VcleTrafficEmpPerm v
        Query query = session.createQuery("SELECT p from PerEmploymentMaster p where p.employeeId in (SELECT distinct v.id.employeeId from VcleTrafficEmpPerm v) order by p.empAname");
        List<PerEmploymentMaster> vList = query.getResultList();
        return vList;
    }

    public List<PerEmploymentMaster> GetEmployeesByEmployeeIDs(Set<Long> userIdList) {
        String HQL = "";
        long i = 0;
        System.out.println(" -------------------------->>> " + userIdList.size());
        for (Long userId : userIdList) {
            if (i == userIdList.size() - 1) {
                HQL += userId;
            } else {
                HQL += userId + ",";
            }
            i++;
        }
        Query query = session.createQuery("SELECT p from PerEmploymentMaster p where p.employeeId in (" + HQL + ") ");
        List<PerEmploymentMaster> vList = query.getResultList();
        return vList;
    }

}
