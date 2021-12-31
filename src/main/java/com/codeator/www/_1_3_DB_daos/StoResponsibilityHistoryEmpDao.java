/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.StoResponsibilityHistoryEmp;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mahmoud
 */
public class StoResponsibilityHistoryEmpDao<T> extends AbstractDao<T> {
    public List<StoResponsibilityHistoryEmp> GetEmployeesResps(String employeeId) {
        Query query = session.createQuery("SELECT s from StoResponsibilityHistoryEmp s WHERE (s.recvType='1' OR s.recvType='2' OR s.recvType='3' OR s.recvType='7') and s.id.respType='1' and s.perEmploymentMaster.employeeId=" + employeeId + " ");
        List<StoResponsibilityHistoryEmp> vList = query.getResultList();
        return vList;
    }
    
    /*public List<StoResponsibilityHistoryEmp> GetEmployeesRespsByRespTypeActNot9(String cateCode) {
        Query query = session.createQuery("SELECT s from StoResponsibilityHistoryEmp s WHERE s.cateCode = "+cateCode+" and s.itemDigital is not null and s.qty > 0 and s.respTypeAct not in(9)  ");
        List<StoResponsibilityHistoryEmp> vList = query.getResultList();
        return vList;
    }*/
    
    public long GetCountEmployeesRespsByRespTypeActNot9(String HQL) {
        Query query = session.createQuery("SELECT count(*) from StoResponsibilityHistoryEmp s WHERE "+HQL+" and s.itemDigital is not null and s.qty > 0 and s.respTypeAct not in(9)  ");
        List<Long> pList = query.getResultList();
        return pList.get(0);
    }

}
