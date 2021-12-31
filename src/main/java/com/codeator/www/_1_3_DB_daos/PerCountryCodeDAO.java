/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.PerCountryCode;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class PerCountryCodeDAO<T> extends AbstractDao<T> {

    public List<PerCountryCode> GetAllCountries() {
        Query query = session.createQuery("SELECT p from PerCountryCode p where p.countrySymbol!='EG' AND p.countrySymbol!=null ORDER BY p.ACountryName ");
        List<PerCountryCode> pList = query.getResultList();
        return pList;
    }

    public List<PerCountryCode> GetAllCountriesIncludeEG() {
        Query query = session.createQuery("SELECT p from PerCountryCode p where p.countrySymbol!=null ORDER BY p.ACountryName");
        List<PerCountryCode> pList = query.getResultList();
        return pList;
    }

    public List<PerCountryCode> GetCountriesBySymbol(String countrySymbol) {
        Query query = session.createQuery("SELECT p from PerCountryCode p where p.countrySymbol=:countrySymbol");
        query.setString("countrySymbol", countrySymbol);
        List<PerCountryCode> pList = query.getResultList();
        return pList;
    }

    public List<PerCountryCode> GetCountriesByCountryCode(String countryCode) {
        Query query = session.createQuery("SELECT p from PerCountryCode p where p.countryCode=:countryCode");
        query.setString("countryCode", countryCode);
        List<PerCountryCode> pList = query.getResultList();
        return pList;
    }
}
