/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
//import com.codeator.www._1_2_DB_entities.InvUnitType;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class InvUnitTypeDAO<T> extends AbstractDao<T> {

    /*public List<InvUnitType> GetInvUnitType() {
        Query query = session.createQuery("SELECT i from InvUnitType i");
        List<InvUnitType> pList = query.getResultList();
        return pList;
    }

    public List<InvUnitType> GetInvUnitTypeByUnitTypeCode(String unitTypeCode) {
        Query query = session.createQuery("SELECT i from InvUnitType i where i.unitTypeCode=:unitTypeCode ");
        query.setString("unitTypeCode", unitTypeCode);
        List<InvUnitType> pList = query.getResultList();
        return pList;
    }*/

}
