/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.PerSectionOld;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mahmoud
 */
public class PerSectionOldDao<T> extends AbstractDao<T> {

    public List<PerSectionOld> GetAllSections() {
        Query query = session.createQuery("SELECT p from PerSectionOld p ORDER BY p.sectionName");
        List<PerSectionOld> pList = query.getResultList();
        return pList;
    }

    public List<PerSectionOld> GetSectionsBySectionNoOld(String sectionNoOld) {
        Query query = session.createQuery("SELECT p from PerSectionOld as p WHERE p.sectionNoOld=" + sectionNoOld + "");
        List<PerSectionOld> pList = query.getResultList();
        return pList;
    }

}
