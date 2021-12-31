
import com.codeator.www._0_1_CodeatorLib.Hashing.hashing_algorithm_class;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.AppAuthJavaUsers;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_3_DB_daos.AppAuthJavaUsersDAO;
import com.codeator.www._1_3_DB_daos.PerEmploymentMasterDao;
import java.nio.charset.StandardCharsets;
import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mahmoud
 */
public class mainTestClass {

    public static void main(String[] args) {

        hashing_algorithm_class h = new hashing_algorithm_class("SHA-256");
        String password = h.getHash("19723".getBytes(StandardCharsets.UTF_8));
        System.out.println(password);
    }
}
