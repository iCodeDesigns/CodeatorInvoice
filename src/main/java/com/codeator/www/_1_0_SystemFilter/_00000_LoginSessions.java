/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_0_SystemFilter;

import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import java.util.Date;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Moham
 */
public class _00000_LoginSessions {

    private PerEmploymentMaster perUsers;
    private HttpSession session;
    private Date loginTime;
    private String host;
    private String ip;

    public PerEmploymentMaster getPerUsers() {
        return perUsers;
    }

    public void setPerUsers(PerEmploymentMaster perUsers) {
        this.perUsers = perUsers;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
