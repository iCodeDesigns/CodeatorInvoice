/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.InvoTaxTokenServerStatus;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Moham
 */
public class InvoTaxTokenServerStatusDAO<T> extends AbstractDao<T> {

    public List<InvoTaxTokenServerStatus> getServerStatus() {
        Query query = session.createQuery("SELECT p from InvoTaxTokenServerStatus p where p.serverSeq=:serverSeq ");
        query.setString("serverSeq", "1");
        List<InvoTaxTokenServerStatus> pList = query.getResultList();
        return pList;
    }

}
