/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.PerOrganizationStructure;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class PerOrganizationStructureDAO<T> extends AbstractDao<T> {

    public List<PerOrganizationStructure> GetPerOrganizationStructureByEmpId(String employeeId) {
        Query query = session.createQuery("SELECT p from PerOrganizationStructure p where p.perEmploymentMaster.employeeId=:employeeId ");
        query.setString("employeeId", employeeId);
        List<PerOrganizationStructure> pList = query.getResultList();
        return pList;
    }

    public List<PerOrganizationStructure> GetPerOrganizationStructureByEmpNo(String employeeNo) {
        Query query = session.createQuery("SELECT p from PerOrganizationStructure p where p.perEmploymentMaster.employeeNo=:employeeNo ");
        query.setString("employeeNo", employeeNo);
        List<PerOrganizationStructure> pList = query.getResultList();
        return pList;
    }

}
