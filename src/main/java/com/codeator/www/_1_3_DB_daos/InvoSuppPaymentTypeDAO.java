/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_3_DB_daos;

import com.codeator.www._1_1_DB_mainDao.AbstractDao;
//
import com.codeator.www._1_2_DB_entities.InvoSuppPaymentType;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Moham
 */
public class InvoSuppPaymentTypeDAO<T> extends AbstractDao<T> {

    public List<InvoSuppPaymentType> GetAllInvoSuppPaymentType() {
        Query query = session.createQuery("SELECT p from InvoSuppPaymentType p ORDER BY p.paymentType ");
        List<InvoSuppPaymentType> pList = query.getResultList();
        return pList;
    }

    public List<InvoSuppPaymentType> GetInvoSuppPaymentTypeById(String paymentType) {
        Query query = session.createQuery("SELECT p from InvoSuppPaymentType p where p.paymentType=:paymentType ORDER BY p.paymentType");
        query.setString("paymentType", paymentType);
        List<InvoSuppPaymentType> pList = query.getResultList();
        return pList;
    }

}
