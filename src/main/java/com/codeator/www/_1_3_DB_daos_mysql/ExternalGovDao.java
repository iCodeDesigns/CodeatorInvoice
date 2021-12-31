/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos_mysql;

import com.codeator.www._1_1_DB_mySqlMainDao.AbstractDao;
import static com.codeator.www._1_1_DB_mySqlMainDao.HibernateSessionConMySql.session;
import com.codeator.www._1_2_DB_entities_mysql.ExternalGov;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Mahmoud
 */
public class ExternalGovDao <T> extends AbstractDao<T> {

    public List<ExternalGov> GetAllExternalGov() {
        Query query = session.createQuery("SELECT d from ExternalGov d ");
        List<ExternalGov> dList = query.getResultList();
        return dList;
    }
    
    public List<ExternalGov> GetExternalGovById(String extenalGovId) {
        Query query = session.createQuery("SELECT d from ExternalGov d where d.extenalGovId='"+extenalGovId+"' ");
        List<ExternalGov> dList = query.getResultList();
        return dList;
    }
}
