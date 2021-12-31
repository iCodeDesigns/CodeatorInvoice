/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos_mysql;

import com.codeator.www._1_1_DB_mySqlMainDao.AbstractDao;
import static com.codeator.www._1_1_DB_mySqlMainDao.HibernateSessionConMySql.session;
import com.codeator.www._1_2_DB_entities_mysql.Employees;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mahmoud
 */
public class EmployeesDao <T> extends AbstractDao<T> {

    public List<Employees> GetEmployeesByEmployee_Password(String employeePassword) {
        Query query = session.createQuery("SELECT e from Employees e WHERE e.empPassword='"+employeePassword+"' ");
        List<Employees> pList = query.getResultList();
        return pList;
    }
    
     public List<Employees> GetEmployeesByDeptId(String DeptId) {
        Query query = session.createQuery("SELECT e from Employees e WHERE e.departmens.deptId='"+DeptId+"' ");
        List<Employees> pList = query.getResultList();
        return pList;
    }
     public List<Employees> GetEmployeesByEmpId(String EmpId) {
        Query query = session.createQuery("SELECT e from Employees e WHERE e.empId='"+EmpId +"' ");
        List<Employees> pList = query.getResultList();
        return pList;
    }
}
