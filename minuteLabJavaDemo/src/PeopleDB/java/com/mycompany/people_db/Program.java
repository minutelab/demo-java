package com.mycompany.people_db;

import io.minutelab.mlab.Lab;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by user on 30-Jan-17.
 */
public class Program {
    public static void main(String... param){
//        User dbHandler = new User();
//        dbHandler.createDataBase("/test.sql");
//        Connection con=null;
//
//        try {
//            dbHandler.dataBase.start();
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            con = dbHandler.getConnection();
//        } catch (InterruptedException | Lab.MLabException e) {
//            e.printStackTrace();
//        }
//
//        if(con==null){
//            System.out.println("+++++++++++connection failed to create");
//            return;
//        }
//        String[] cols = {"firstname","surname","age"};
//        String[] vals = {"yuval","klein","39"};
//        try {
//            dbHandler.insertData(con,"people",cols,vals);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//        ResultSet st=null;
//        String result;
//        try {
//            st = dbHandler.fetchData(con,"surname","people","firstname","=","yuval");
//            st.next();
//            result = st.getString("surname");
//        } catch (SQLException e) {
//            result = "error fetching data: " +e.getMessage();
//        }
//
//        System.out.println(result);
//        dbHandler.dataBase.close();
    }
}
