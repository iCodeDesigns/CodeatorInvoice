/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.PerGovernorateCode;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Moham
 */
public class PerGovernorateCodeDAO<T> extends AbstractDao<T> {

    public List<PerGovernorateCode> GetPerGovernorateCodeByCountry(String countryCode) {
        Query query = session.createQuery("SELECT p from PerGovernorateCode p where p.id.countryCode=:countryCode");
        query.setString("countryCode", countryCode);
        List<PerGovernorateCode> pList = query.getResultList();
        return pList;
    }

    public List<PerGovernorateCode> GetPerGovernorateCodeByID(String countryCode, String govCode) {
        Query query = session.createQuery("SELECT p from PerGovernorateCode p where p.id.countryCode=:countryCode and p.id.govCode=:govCode");
        query.setString("countryCode", countryCode);
        query.setString("govCode", govCode);
        List<PerGovernorateCode> pList = query.getResultList();
        return pList;
    }
}
