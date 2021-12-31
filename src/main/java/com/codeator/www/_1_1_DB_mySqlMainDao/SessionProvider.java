/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_1_DB_mySqlMainDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Mahmoud
 */
public class SessionProvider {
    //??????????????????????????????????????????????????????????????????????????
    
    SessionFactory factory; 
    private static SessionProvider provider ; // Objct of self class 
    
    // Static method to direct invoke it from other classes to block creating new object from it out side this class
    // why ? beacause class constructor is private
    // So Only way to create new object from it by writing the creation here in it self class
    public static synchronized SessionProvider getSessionProvider()
    {
        // to ensure that there is only one object created in all Application
        if(provider == null)
            provider = new SessionProvider();
        return provider;
    }

    // to Apply the Congiguration of Database exsist in "hibernate.cfg.xml" file
    private SessionProvider()
    {
        Configuration config = new Configuration().configure("mysql/hibernate.cfg.mysql.xml");//hibernate.cfg.vehiclemysql.xml //hibernate.cfg.vehicle.xml
        factory = config.buildSessionFactory(); 
    }
    
    //open session from SessionProvider Object 
    public Session getSession()
    {
        return factory.openSession();
    }
    
}
