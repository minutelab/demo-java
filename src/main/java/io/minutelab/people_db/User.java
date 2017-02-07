package io.minutelab.people_db;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Your name
 */
public class User {
    String firstName;
    String surName;
    int age;
    int id;

    private static Connection connection;
    final private static String SELECT_USERS_BY_FIRSTNAME = "SELECT * FROM users WHERE firstname=?";
    final private static String ADD_RECORD = "INSERT INTO users (firstname, surname, age) VALUES (?, ?, ?)";
    final private static String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id=?";

    public User(String firstName, String surName, int age) {
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
    }

    public User(int id, String firstName, String surName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
    }

    @Override
    public String toString(){
        return this.firstName + " " + this.surName + ", " + this.age;
    }

    static void setDBConnection(Connection con){
        User.connection = con;
    }

    static ArrayList<User> fetchUsersByFirstName(String firstName) throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        PreparedStatement ps = User.connection.prepareStatement(User.SELECT_USERS_BY_FIRSTNAME);
        ps.setString(1, firstName);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
            users.add(new User(rs.getInt("id"), rs.getString("firstname"),rs.getString("surname"),rs.getInt("age")));

        return users;
    }

    static User fetchUserByID(int id) throws SQLException {
        PreparedStatement ps = User.connection.prepareStatement(User.SELECT_USER_BY_ID);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return new User(rs.getInt("id"),rs.getString("firstname"),rs.getString("surname"),rs.getInt("age"));
    }

    void storeUser() throws SQLException {
        PreparedStatement ps = User.connection.prepareStatement(this.ADD_RECORD);
        ps.setString(1, this.firstName);
        ps.setString(2, this.surName);
        ps.setInt(3, this.age);
        ps.executeUpdate();
    }
}