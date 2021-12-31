/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
//import com.codeator.www._1_2_DB_entities.InvAccDeptEmpJoin;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class InvAccDeptEmpJoinDAO <T> extends AbstractDao<T> {

   /* public List<InvAccDeptEmpJoin> GetAccDeptEmpByEmbId(String employeeId) {
        Query query = session.createQuery("SELECT p from InvAccDeptEmpJoin p where p.id.employeeId=:employeeId");
        query.setString("employeeId", employeeId);
        List<InvAccDeptEmpJoin> pList = query.getResultList();
        return pList;
    }*/
    
}
