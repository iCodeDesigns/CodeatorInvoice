package com.codeator.www._1_1_DB_mainDao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.codeator.www._0_0_CodeatorLib.dbInit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Mahmoud
 */
public class SessionProvider {

    //??????????????????????????????????????????????????????????????????????????
    private final boolean connectionType = false;//true = production // false = test
    SessionFactory factory;
    private static SessionProvider provider; // Objct of self class 

    ThreadLocal<Session> t1 = new ThreadLocal<>();

    // Static method to direct invoke it from other classes to block creating new object from it out side this class
    // why ? beacause class constructor is private
    // So Only way to create new object from it by writing the creation here in it self class
    public static synchronized SessionProvider getSessionProvider() {
        // to ensure that there is only one object created in all Application
        if (provider == null) {
            try {
                dbInit d = new dbInit();
                d.RunHibernate();
                provider = new SessionProvider();
            } catch (Exception e) {
                if (!e.getMessage().equals("x")) {
                    e.printStackTrace();
                }
            }
        }
        return provider;
    }

    // to Apply the Congiguration of Database exsist in "hibernate.cfg.xml" file
    private SessionProvider() {
        SetConnectionData();
        Configuration config = new Configuration().configure("oracle/hibernate.cfg.vehicle.xml");//hibernate.cfg.vehiclemysql.xml //hibernate.cfg.vehicle.xml
                /*.setProperty("hibernate.connection.url", this.url)
                .setProperty("hibernate.connection.username", this.username)
                .setProperty("hibernate.connection.password", this.password);*/
        factory = config.buildSessionFactory();
    }

    //open session from SessionProvider Object 
    public Session getSession() {
        //return factory.openSession();
        Session session = t1.get();
        if (session == null) {
            session = factory.openSession();
            t1.set(session);
        }
        return session;
    }

    private String url;
    private String username;
    private String password;

    private void SetConnectionData() {
        if (this.connectionType) {
            /*this.url = "jdbc:oracle:thin:@10.10.1.161:1521:ahram";
            this.username = "ahram";
            this.password = "ahram_28479";*/
            this.url = "jdbc:oracle:thin:@10.200.80.67:1521:ahram";
            this.username = "ahram";
            this.password = "ahram_28479";
        } else {
            /*this.url = "jdbc:oracle:thin:@10.2.210.236:1521:db12c";   ////Mohamed-pc@Ahram*/
            this.url = "jdbc:mysql://192.168.1.8:3306/codeator?autoReconnect=true&amp;useSSL=false";   ////Mohamed-pc@Home
            this.username = "root";
            this.password = "root";
        }
    }

    void close() {
        getSession().close();
        t1.set(null);
    }

    void clear() {
        getSession().clear();
    }

}
