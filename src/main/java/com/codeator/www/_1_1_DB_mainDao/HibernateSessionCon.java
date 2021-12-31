package com.codeator.www._1_1_DB_mainDao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import org.hibernate.Session;

/**
 * @author Mahmoud
 */
public final class HibernateSessionCon {

    public SessionProvider provider;

    private Session session;

    public HibernateSessionCon() {
        this.provider = SessionProvider.getSessionProvider();
        this.OpenCon();
    }
    
    

    public void OpenCon() {
        session = provider.getSession();
    }

    /**
     * Start Transaction to DB
     */
    public void beginTrans() {
        session.beginTransaction();
    }

    /**
     * End Transaction to DB
     */
    public void CommitTrans() {
        session.getTransaction().commit();
    }

    /**
     * End Transaction to DB
     */
    public void RollBack() {
        session.getTransaction().rollback();
    }

    /**
     * Start Connection And END Session with DB
     */
    public void closeConn() {
        //session.close();
        provider.close();
    }

    public void clearConn() {
        //session.close();
        provider.clear();
    }

    /**
     * INSERT To DB
     *
     * @param T is General Object of Entities
     */
    public void INSERT(Object T) {
        session.persist(T);
    }

    /**
     * SAVE To DB
     *
     * @param T is General Object of Entities
     */
    public void SAVE(Object T) {
        session.save(T);
    }

    public void SAVEorUPDATE(Object T) {
        session.saveOrUpdate(T);
    }

    /**
     * UPDATE To DB
     *
     * @param T is General Object of Entities
     */
    public void UPDATE(Object T) {
        session.merge(T);
    }

    /**
     * MERGE To DB
     *
     * @param T is General Object of Entities
     */
    public void MERGE(Object T) {
        session.merge(T);
    }

    /**
     * DELETE From DB
     *
     * @param T is General Object of Entities
     */
    public void DELETE(Object T) {
        session.delete(T);
    }

    public <T> T QUERY(Class<T> type, Serializable srlzbl) {
        return session.load(type, srlzbl);
    }

    public Session getSession() {
        return session;
    }
}
