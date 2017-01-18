package com.mycompany.mavenproject1;

import io.minutelab.mlab.PostGresLab;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
        
/**
 *
 * @author Your name
 */
public class Main {
    
    public static void main(String... param) throws SQLException,IOException,InterruptedException {
     //   Lab lab = new Lab(Main.class.getResource("/more"));
     //   lab.start();

        DB db = new DB();
        db.lab.start();
        Connection con = null;
            
        try {
            con = ((PostGresLab)db.lab).getConnection();
        } catch (PostGresLab.MLabException ex) {
           System.out.println("getConnection failed"+ ex.getMessage());
        }
    
        Statement st = con.createStatement();
       
       ResultSet rs = st.executeQuery("SELECT surname FROM people where firstname = 'mo'");
       rs.next();
       System.out.println("result: "+rs.getString("surname"));
      db.lab.close();

//        MlabRule lab = new MlabRule(Main.class.getResource("/more"));
    }
}