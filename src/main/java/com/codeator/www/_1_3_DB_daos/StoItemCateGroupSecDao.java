/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.StoItemCateGroupSec;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class StoItemCateGroupSecDao<T> extends AbstractDao<T> {

    public List<StoItemCateGroupSec> GetAllStoItemCateGroupSec(String cateCode, String groupCode) {
        Query query = session.createQuery("SELECT p from StoItemCateGroupSec p where p.id.groupCode=:groupCode and p.id.cateCode=:cateCode ORDER BY p.id.sectionCode ");
        query.setString("cateCode", cateCode);
        query.setString("groupCode", groupCode);
        List<StoItemCateGroupSec> pList = query.getResultList();
        return pList;
    }
    
}
