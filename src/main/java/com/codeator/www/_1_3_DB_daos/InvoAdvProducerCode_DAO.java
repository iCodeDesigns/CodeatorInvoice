/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
import com.codeator.www._1_2_DB_entities.InvoAdvCollectorCode;
import com.codeator.www._1_2_DB_entities.InvoAdvProducerCode;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Mohamed
 */
public class InvoAdvProducerCode_DAO<T> extends AbstractDao<T> {

    public List<InvoAdvProducerCode> GetInvoAdvProducerCode(String advProducerCode) {
        Query query = session.createQuery("SELECT p from InvoAdvProducerCode p WHERE p.advProducerCode=:advProducerCode ");
        query.setString("advProducerCode", advProducerCode);
        List<InvoAdvProducerCode> pList = query.getResultList();
        return pList;
    }

    public int GetMaxSp() {
        Query query = session.createQuery("Select nvl(max(v.advProducerSeq),0) from InvoAdvProducerCode v");
        int maxRequireSp = GetQueryNumber(query);
        return maxRequireSp;
    }

    private int GetQueryNumber(Query query) {
        List<Integer> list = query.getResultList();
        int number = 1;// no Employee saved in the system
        if (list.get(0) != null) {
            number = list.get(0) + 1;
        }
        //System.out.println(number);
        return number;
    }

}
