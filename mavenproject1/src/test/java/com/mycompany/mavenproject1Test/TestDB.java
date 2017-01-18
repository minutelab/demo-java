package com.mycompany.mavenproject1Test;

import com.mycompany.mavenproject1.DB;
import io.minutelab.mlab.PostGresLab;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import org.junit.Rule;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class TestDB {
    @Rule
    public DB db = new DB();
    @Rule
    public DB db2 = new DB();

    @Test
    public void testDB() throws Exception {
        Connection con = DriverManager.getConnection(((PostGresLab)db.lab).getDBURL(),"mlab","1234");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT VERSION()");

        if (rs.next()) {
            System.out.println("Database version: " + rs.getString(1));
        } else {
            fail("Could not find version");
        }
        rs = st.executeQuery("SELECT surname FROM people where firstname = 'bo'");
        if (!rs.next()) {
            fail("Could not find data in database");
        }
        assertEquals("Should get the right value",rs.getString("surname"),"shmo");
    }

    @Test
    public void testDBPgMlab() throws Exception {
        System.out.println("starting with testDBPgMlab");
        Connection con = ((PostGresLab)db2.lab).getConnection("mlab","1234");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT VERSION()");

        if (rs.next()) {
            System.out.println("Database version: " + rs.getString(1));
        } else {
            fail("Could not find version");
        }

        rs = st.executeQuery("SELECT surname FROM people where firstname = 'mo'");
        if (!rs.next()) {
            fail("Could not find data in database");
        }
        assertEquals("Should get the right value",rs.getString("surname"),"lam");
    }

    @Test
    public void testDBPgMlabDefaultUser() throws Exception {
        Connection con = ((PostGresLab)db2.lab).getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT VERSION()");

        if (rs.next()) {
            System.out.println("Database version: " + rs.getString(1));
        } else {
            fail("Could not find version");
        }

        rs = st.executeQuery("SELECT age FROM people where surname = 'Scott'");
        if (!rs.next()) {
            fail("Could not find data in database");
        }
        assertEquals("Should get the right value",rs.getInt("age"),65);
    }

}
