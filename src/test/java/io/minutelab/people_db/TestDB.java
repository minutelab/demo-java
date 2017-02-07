package  io.minutelab.people_db;;

import io.minutelab.mlab.MlabRule;
import io.minutelab.mlab.PostGresLab;
import io.minutelab.mlab.ResourcePrepare;
import org.junit.Rule;
import org.junit.Test;

import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

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
    public MlabRule test = new MlabRule(new PostGresLab(ResourcePrepare.filename(User.class,"/users.sql")));


    @Test
    public void testFetchUsers()throws Exception{
       URL x = User.class.getResource("/users.sql");
        Connection con = ((PostGresLab)test.lab).getConnection();
        User.setDBConnection(con);
        ArrayList<User> bobs = User.fetchUsersByFirstName("Bob");
        assertEquals("Should get the right value",bobs.size(),3);
    }

    @Test
    public void testGetById() throws Exception{
        Connection con = ((PostGresLab)test.lab).getConnection();
        User.setDBConnection(con);
        new User("Nisim","Garame",61).storeUser();
        int id = User.fetchUsersByFirstName("Nisim").get(0).id;
        User nisimGarame = User.fetchUserByID(id);
        assertEquals("Should get the right value",nisimGarame.surName,"Garame");
    }

    @Test
    public void testStoreAndFetchBack() throws Exception{
        Connection con =((PostGresLab)test.lab).getConnection();
        User.setDBConnection(con);
        User user = new User("Boaz","Sharabi",1000000);
        user.storeUser();
        User sameUser = User.fetchUsersByFirstName("Boaz").get(0);

        assertEquals("Should get the right value",user.surName,sameUser.surName);
    }

}
