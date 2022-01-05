/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_0_SystemFilter;

import com.codeator.www._0_0_App_tasks._0_0_0_Invoice_Tasks_0_;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.hibernate.Hibernate;

/**
 * Web application lifecycle listener.
 *
 * @author Moham
 */
public class AppListener implements HttpSessionListener, HttpSessionAttributeListener, ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //while (true) {
        try {
            @SuppressWarnings("unused")
            org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
            java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.WARNING);
            java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.INFO);

            org.apache.log4j.Logger.getLogger("org.hibernate.SQL").setLevel(org.apache.log4j.Level.DEBUG);
            org.apache.log4j.Logger.getLogger("org.hibernate.type").setLevel(org.apache.log4j.Level.TRACE);
            org.apache.log4j.Logger.getLogger("org.hibernate.ast.AST").setLevel(org.apache.log4j.Level.INFO);
            org.apache.log4j.Logger.getLogger("org.hibernate.tool.hbm2ddl").setLevel(org.apache.log4j.Level.WARN);
            org.apache.log4j.Logger.getLogger("org.hibernate.hql").setLevel(org.apache.log4j.Level.DEBUG);
            org.apache.log4j.Logger.getLogger("org.hibernate.cache").setLevel(org.apache.log4j.Level.INFO);
            org.apache.log4j.Logger.getLogger("org.hibernate.jdbc").setLevel(org.apache.log4j.Level.DEBUG);
            

            _0_0_0_Invoice_Tasks_0_.runTask();
            //break;
        } catch (Exception e) {

        }
        //}
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //new HibernateSessionCon().closeConn();
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
