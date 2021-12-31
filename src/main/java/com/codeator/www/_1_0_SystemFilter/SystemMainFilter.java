/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_0_SystemFilter;

import com.codeator.www._0_0_CodeatorLib.Encryption;
import com.codeator.www._0_0_CodeatorLib.FileOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.AppSubTab;
import com.codeator.www._1_2_DB_entities.AppSubTabSpecAuth;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_3_DB_daos.AppSubTabSpecAuth_DAO;
import com.codeator.www._1_3_DB_daos.AppSubTab_DAO;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
public class SystemMainFilter implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public SystemMainFilter() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("SystemMainFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("SystemMainFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        new HibernateSessionCon().OpenCon();
        try {
            PerEmploymentMaster employee_session = (PerEmploymentMaster) req.getSession().getAttribute("employee_session");

            String AccessServlet = req.getServletPath();
            AccessServlet = AccessServlet.substring(1);
            /**
             * Licenes
             */
            FilterFunction(AccessServlet, employee_session);

            chain.doFilter(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("_0_0_0_0_LoginAccesServlet");
        }
        new HibernateSessionCon().clearConn();
        new HibernateSessionCon().closeConn();
    }

    public void FilterFunction(String AccessServlet, PerEmploymentMaster employee_session) throws Exception {
        List<AppSubTab> pList = new AppSubTab_DAO().getApplicationSubTabByAccessServlet(AccessServlet);
        if (pList.isEmpty()) {
            throw new Exception();
        }
        AppSubTab applicationSubTab = pList.get(0);
        String AvailableToUserControl = applicationSubTab.getAvailableToUserControl();
        String App = "" + applicationSubTab.getId().getApplicationId();
        String Tab = "" + applicationSubTab.getId().getTabId();
        String SubTab = "" + applicationSubTab.getId().getSubTabId();
        String status = checkScreen(AvailableToUserControl, App, Tab, SubTab, "" + employee_session.getEmployeeId());

        if (!status.equals("1")) {

            throw new Exception();
        }

    }

    public String checkScreen(String AvailableToUserControl, String App, String Tab, String SubTab, String employeeId) {

        List<Character> chars = new Encryption().decrypt_AvailableToUserControl(AvailableToUserControl);

        boolean General = false;
        boolean LIC_File_Exist = false;
        boolean DB_Manipulation = false;
        boolean User_Access = false;
        boolean Screen_Active = false;
        // 0 = Demo | 1 = can use | 2 = DB Manipulation | 3 = No Access
        String Status = "0";
        String AppCode = "" + chars.get(0);
        String TabCode = "" + chars.get(1);
        String SubTabCode = "" + chars.get(2);
        String statusCode = "" + chars.get(3);
        if (App.equals(AppCode) && Tab.equals(TabCode) && SubTab.equals(SubTabCode) && "1".equals(statusCode)) {
            Screen_Active = true;
        } else {
            Screen_Active = false;
        }
        String FileName = "S_" + App + Tab + SubTab;
        try {
            FileOp file = new FileOp("C:\\LIC\\b532t91\\" + FileName + ".txt");
            String line = file.ReadFileInWebApp();//2021-01-01
            //System.out.println(" -------------- Status 2 = " + AvailableToUserControl + " || " + line.split("\r\n")[0]);
            if (!AvailableToUserControl.equals(line.split("\r\n")[0])) {
                DB_Manipulation = true;
            } else {
                List<AppSubTab> ApplicationSubTabList = new AppSubTab_DAO().get_ApplicationSubTabsByApplicationIdWithAuthType1(App, Tab, SubTab);
                List<AppSubTabSpecAuth> screenAuthList = new AppSubTabSpecAuth_DAO().getEmpSubTabSpecAuth(employeeId, App, Tab, SubTab);
                //System.out.println(" -------------- Status 1 = " + ApplicationSubTabList.isEmpty());
                //System.out.println(" -------------- Status 3 = " + screenAuthList.isEmpty());
                if (!ApplicationSubTabList.isEmpty()) {
                    General = true;
                }
                if (!screenAuthList.isEmpty()) {
                    User_Access = true;
                }

            }
            LIC_File_Exist = true;
        } catch (Exception e) {
            LIC_File_Exist = false;
        }
        // 0 = Demo | 1 = can use | 2 = DB Manipulation | 3 = No Access
        //System.out.println(" -------------- LIC_File_Exist    = " + LIC_File_Exist);
        //System.out.println(" -------------- DB_Manipulation   = " + DB_Manipulation);
        //System.out.println(" --------------     General       = " + General);
        //System.out.println(" --------------   User_Access     = " + User_Access);
        if (!LIC_File_Exist || !Screen_Active) {
            Status = "0";
        } else if (DB_Manipulation) {
            Status = "2";
        } else if (General || User_Access) {
            Status = "1";
        } else {
            Status = "3";
        }
        //System.out.println(" -------------- Status   = " + Status);
        return Status;
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("SystemMainFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("SystemMainFilter()");
        }
        StringBuffer sb = new StringBuffer("SystemMainFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
