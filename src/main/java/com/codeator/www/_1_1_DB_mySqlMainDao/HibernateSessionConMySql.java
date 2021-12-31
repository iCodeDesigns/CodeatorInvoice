/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_1_DB_mySqlMainDao;

import java.io.Serializable;
import org.hibernate.Session;

/**
 * @author Mahmoud
 */
public class HibernateSessionConMySql {

    public static Session session = SessionProvider.getSessionProvider().getSession();

    /**
     * Start Transaction to DB
     */
    public static void MySQL_beginTrans() {
        session.beginTransaction();
    }

    /**
     * End Transaction to DB
     */
    public static void MySQL_CommitTrans() {
        session.getTransaction().commit();
    }

    /**
     * End Transaction to DB
     */
    public static void MySQL_RollBack() {
        session.getTransaction().rollback();
    }

    /**
     * Start Connection And END Session with DB
     */
    public static void MySQL_closeConn() {
        session.close();
    }

    /**
     * INSERT To DB
     *
     * @param T is General Object of Entities
     */
    public static void MySQL_INSERT(Object T) {
        session.persist(T);
    }
    
    /**
     * SAVE To DB
     *
     * @param T is General Object of Entities
     */
    public static void MySQL_SAVE(Object T) {
        session.save(T);
    }
    
    public static void MySQL_SAVEorUPDATE(Object T) {
        session.saveOrUpdate(T);
    }

    /**
     * UPDATE To DB
     *
     * @param T is General Object of Entities
     */
    public static void MySQL_UPDATE(Object T) {
        session.merge(T);
    }
    
    /**
     * MERGE To DB
     *
     * @param T is General Object of Entities
     */
    public static void MySQL_MERGE(Object T) {
        session.merge(T);
    }

    /**
     * DELETE From DB
     *
     * @param T is General Object of Entities
     */
    public static void MySQL_DELETE(Object T) {
        session.delete(T);
    }

    public static  <T> T MySQL_QUERY(Class<T> type, Serializable srlzbl) {
        return session.load(type, srlzbl);
    }
}
