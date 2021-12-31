/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._5_1_DashboardsModules;

import com.codeator.www._1_2_DB_entities.PerDeptOld;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequire;
import com.codeator.www._1_3_DB_daos.PerDeptOldDao;
import com.codeator.www._1_3_DB_daos.VcleVehicleRequireDao;
import com.codeator.www._5_0_DashboardsModulesBean.vcleRequestDashboardBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mahmoud
 */
public class vcleRequestDashboard {

    public List<vcleRequestDashboardBean> getDailyVcleRequestDashBoard() {
        List<vcleRequestDashboardBean> vList = new ArrayList<>();
        List<PerDeptOld> deptList = new PerDeptOldDao().GetAllDept();
        for (PerDeptOld p : deptList) {
            if(p.getDepName().equals("بدون")){
                continue;
            }               
            long ReqNum = new VcleVehicleRequireDao().GetVcleVehicleRequireCurrentDay("" + p.getId().getDepNoOld());
            if(ReqNum>0){
                vcleRequestDashboardBean vrdb = new vcleRequestDashboardBean(p.getDepName(), ReqNum);
                vList.add(vrdb);
            }
        }
        return vList;
    }
}
