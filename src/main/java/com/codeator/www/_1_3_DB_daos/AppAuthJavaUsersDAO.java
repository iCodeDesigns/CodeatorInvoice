/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.AppAuthJavaUsers;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Moham
 */
public class AppAuthJavaUsersDAO<T> extends AbstractDao<T> {

    public List<AppAuthJavaUsers> getAuthUser(String employeeId, String employeePassword) {
        Query query = session.createQuery("SELECT p FROM AppAuthJavaUsers p where p.employeeId=:employeeId and p.employeePassword=:employeePassword"); //HQL
        query.setString("employeeId", employeeId);
        query.setString("employeePassword", employeePassword);
        List<AppAuthJavaUsers> pList = query.getResultList();
        return pList;
    }

    public List<AppAuthJavaUsers> getEmployee(String employeeId) {
        Query query = session.createQuery("SELECT p FROM AppAuthJavaUsers p where p.employeeId=:employeeId"); //HQL
        query.setString("employeeId", employeeId);
        List<AppAuthJavaUsers> pList = query.getResultList();
        return pList;
    }
    
    public List<AppAuthJavaUsers> getEmployeeByUnit(String employeeId, String accUnitCode, String depNoOld, String sectionNoOld) {
        Query query = session.createQuery("SELECT p FROM AppAuthJavaUsers p where p.employeeId=:employeeId and p.invoAccUintDept.id.accUnitCode=:accUnitCode and p.invoAccUintDept.id.depNoOld=:depNoOld and p.invoAccUintDept.id.sectionNoOld=:sectionNoOld"); //HQL
        query.setString("employeeId", employeeId);
        query.setString("accUnitCode", accUnitCode);
        query.setString("depNoOld", depNoOld);
        query.setString("sectionNoOld", sectionNoOld);
        List<AppAuthJavaUsers> pList = query.getResultList();
        return pList;
    }
}
