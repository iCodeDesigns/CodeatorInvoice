package com.codeator.www._1_1_DB_mainDao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import org.hibernate.Session;

/**
 *
 * @author Mahmoud
 * @param <T>
 */
public abstract class AbstractDao<T> {

    //private Session session;
    /*public AbstractDao() {
               // Original Class . Static Methode     .
               // .............  .  that used to      .
               // .............  . only one object    .
               // .............  . that return Object .
               // .............  .  of original class .
               // .............  . (SessionProvider)  . it is the method inside (SessionProvider) object to get session with DB
        session = SessionProvider.getSessionProvider().getSession();
    }*/
    HibernateSessionCon con;
    public Session session;

    public AbstractDao() {
        con = new HibernateSessionCon();
        session = con.getSession();
    }

    public void insert(T s) {
        con.INSERT(s);
        //CommitTrans();
        //session.beginTransaction();
        //session.persist(s);
        //session.getTransaction().commit();
    }

    public void saveOrUpdate(T s) {
        con.SAVEorUPDATE(s);
        //CommitTrans();
        //session.beginTransaction();
        //session.persist(s);
        //session.getTransaction().commit();

    }

    public void save(T s) {
        con.SAVE(s);
        //CommitTrans();
        //session.beginTransaction();
        //session.persist(s);
        //session.getTransaction().commit();

    }

    public void update(T s) {
        con.UPDATE(s);
        //CommitTrans();
    }

    public void merge(T s) {
        con.MERGE(s);
        //CommitTrans();
    }

    public void delete(T s) {
        con.DELETE(s);
        //CommitTrans();
    }

    public T select(Class<T> T, Serializable id) {
        //Class<T> T = null;
        return con.getSession().load(T, id);
    }

}
