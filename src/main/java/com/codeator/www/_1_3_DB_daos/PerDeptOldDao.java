/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.InvoAccUintDept;
import com.codeator.www._1_2_DB_entities.InvoAccUnitsCode;
import com.codeator.www._1_2_DB_entities.PerDeptOld;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mahmoud
 */
public class PerDeptOldDao<T> extends AbstractDao<T> {

    public List<PerDeptOld> GetDeptByDept_ID(String SectionId, String depNoOld) {
        Query query = session.createQuery("SELECT p from PerDeptOld p WHERE p.id.sectionNoOld='" + SectionId + "' and p.id.depNoOld='" + depNoOld + "' ");
        List<PerDeptOld> pList = query.getResultList();
        return pList;
    }

    public List<PerDeptOld> GetDeptBySectionNoOld(String SectionNoOld) {
        Query query = session.createQuery("SELECT p from PerDeptOld p WHERE p.id.sectionNoOld='" + SectionNoOld + "' order by p.depName");
        List<PerDeptOld> pList = query.getResultList();
        return pList;
    }

    /*public List<PerDeptOld> GetDeptBySectionNoOldThatHaveEmp(String SectionNoOld) {
        //Query query1 = session.createQuery("SELECT count(*) from PerEmploymentMaster m WHERE m.perDeptOld.id.depNoOld in (select d.id.depNoOld from PerDeptOld d where d.id.sectionNoOld ='"+SectionNoOld+"' )");
        String extraHQL = "SELECT count(*) from PerEmploymentMaster m WHERE m.perDeptOld.id.depNoOld in (select d.id.depNoOld from PerDeptOld d where d.id.sectionNoOld ='"+SectionNoOld+"' )";
        Query query = session.createQuery("SELECT p from PerDeptOld p WHERE p.id.sectionNoOld='" + SectionNoOld + "' AND ("+extraHQL+")>0 ");
        List<PerDeptOld> pList = query.getResultList();
        return pList;
    }*/
    public List<PerDeptOld> GetAllDeptWigNewRequireStatus() {
        Query query = session.createQuery("SELECT p from PerDeptOld as p inner join p.vcleVehicleRequires as v where v.requireStatus=4");
        List<PerDeptOld> pList = query.getResultList();
        return pList;
    }

    public List<PerDeptOld> GetAllDept() {
        Query query = session.createQuery("SELECT p from PerDeptOld p");
        List<PerDeptOld> pList = query.getResultList();
        return pList;
    }

    public List<PerDeptOld> GetAllDeptInInvoice() {
        Query query = session.createQuery("SELECT p from PerDeptOld p where (p.id.depNoOld,p.id.sectionNoOld) in (Select c.id.depNoOld,c.id.sectionNoOld From InvoInvoiceMaster c ) ");
        List<PerDeptOld> pList = query.getResultList();
        return pList;
    }

    public List<InvoAccUintDept> GetAllAccDeptInInvoice() {
        Query query = session.createQuery("SELECT p from InvoAccUintDept p where (p.id.depNoOld,p.id.sectionNoOld,p.id.accUnitCode) in (Select c.id.depNoOld,c.id.sectionNoOld,c.id.accUnitCode From InvoInvoiceMaster c where c.id.accUnitCode!='80') ");
        List<InvoAccUintDept> pList = query.getResultList();
        return pList;
    }

    public List<InvoAccUintDept> GetAllAccDeptInInvoiceInDepts(List<String> dept) {
        String deptsAcc = "";
        int i = 0;
        for (String s : dept) {
            if (i == dept.size() - 1) {
                deptsAcc += "(" + s + ")";
            } else {
                deptsAcc += "(" + s + "),";
            }
            i++;
        }
        System.out.println(" ----- " + deptsAcc);
        Query query = session.createQuery("SELECT p from InvoAccUintDept p where (p.id.accUnitCode,p.id.sectionNoOld,p.id.depNoOld) in (" + deptsAcc + ") ");
        List<InvoAccUintDept> pList = query.getResultList();
        return pList;
    }

    public List<PerDeptOld> GetAllDeptExceptDeptsWithoutEmp() {
        Query query = session.createQuery("SELECT p from PerDeptOld p where p.id.depNoOld in (select DISTINCT pp.perDeptOld.id.depNoOld from PerEmploymentMaster pp) order by p.depName");
        List<PerDeptOld> pList = query.getResultList();
        return pList;
    }

    public List<PerDeptOld> GetimportantDept() {
        Query query = session.createQuery("SELECT p from PerDeptOld p where p.id.depNoOld=1200006");
        List<PerDeptOld> pList = query.getResultList();
        return pList;
    }

    public List<PerDeptOld> GetDeptByDeptId(String depNoOld) {
        Query query = session.createQuery("SELECT p from PerDeptOld p where p.id.depNoOld=" + depNoOld + "");
        List<PerDeptOld> pList = query.getResultList();
        return pList;
    }

    public List<PerDeptOld> GetDeptByemployeeId(String employeeId) {
        Query query = session.createQuery("SELECT p from PerDeptOld p WHERE p.perEmploymentMaster.employeeId=:employeeId ");
        query.setString("employeeId", employeeId);
        List<PerDeptOld> pList = query.getResultList();
        return pList;
    }

    public List<InvoAccUintDept> GetPerDeptOldDistinctFromInvoiceMaster(String[] accUnitCode_arr) {
        String accUnitCode = "";
        int i = 0;
        for (String acc : accUnitCode_arr) {
            if (i == accUnitCode_arr.length - 1) {
                accUnitCode += "'" + acc + "'";
            } else {
                accUnitCode += "'" + acc + "',";
            }
            i++;
        }
        Query query = session.createQuery("SELECT p from InvoAccUintDept p WHERE (p.id.depNoOld,p.id.sectionNoOld,p.id.accUnitCode) IN (Select c.id.depNoOld,c.id.sectionNoOld,c.id.accUnitCode From InvoInvoiceMaster c where c.id.accUnitCode IN (" + accUnitCode + ") ) ");
        List<InvoAccUintDept> pList = query.getResultList();
        return pList;
    }
}
