/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.PurContractTitel;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Moham
 */
public class PurContractTitelDao<T> extends AbstractDao<T> {

    public Integer getMaxID(String sectionNoOld, String depNoOld) {
        Query query = session.createQuery("SELECT nvl(max(p.id.titelSp),0)+1 FROM PurContractTitel p where p.id.sectionNoOld=:sectionNoOld and p.id.depNoOld=:depNoOld "); //HQL
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("depNoOld", depNoOld);
        List<Integer> pList = query.getResultList();
        Integer number = 0;
        for (Integer num : pList) {
            number = num;
        }
        return number;
    }

    public List<PurContractTitel> getAllTitlesByDept(String sectionNoOld, String depNoOld) {
        Query query = session.createQuery("SELECT p FROM PurContractTitel p where p.id.sectionNoOld=:sectionNoOld and p.id.depNoOld=:depNoOld "); //HQL
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("depNoOld", depNoOld);
        List<PurContractTitel> pList = query.getResultList();
        return pList;
    }

    public List<PurContractTitel> getTitlesByDept(String titelSp, String sectionNoOld, String depNoOld) {
        Query query = session.createQuery("SELECT p FROM PurContractTitel p where p.id.titelSp=:titelSp and p.id.sectionNoOld=:sectionNoOld and p.id.depNoOld=:depNoOld  "); //HQL
        query.setString("titelSp", titelSp);
        query.setString("sectionNoOld", sectionNoOld);
        query.setString("depNoOld", depNoOld);
        List<PurContractTitel> pList = query.getResultList();
        return pList;
    }

}
