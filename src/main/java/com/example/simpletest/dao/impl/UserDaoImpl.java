package com.example.simpletest.dao.impl;

import com.example.simpletest.dao.UserDao;
import com.example.simpletest.db.dbHelper;
import com.example.simpletest.model.User;
import jdk.nashorn.internal.runtime.ECMAException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends dbHelper implements UserDao {
    public List<User> getUserByUsername(String username) {
        List<User> list=new ArrayList<>();

        String sql = "SELECT * FROM USERS WHERE ACTIVE_STATUS = 1 ";
        if (username!=null && !username.trim().isEmpty()){
            sql+="AND LOWER(USERNAME) = LOWER(?) ";
        }
        try(Connection connection = dbHelper.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){

            if (username!=null && !username.trim().isEmpty()){
                ps.setString(1, username);
            }
            ResultSet rs = ps.executeQuery();
//            if(rs.next()){
//                list = new ArrayList<>();
//            }
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("ID"));
                user.setFirstName(rs.getString("FIRST_NAME"));
                user.setLastName(rs.getString("LAST_NAME"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PWD"));
                user.setDataDate(rs.getDate("DATA_DATE"));
                user.setActiveStatus(rs.getInt("ACTIVE_STATUS"));
                list.add(user);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public User getUserById(Integer id) {
        String sql = "SELECT * FROM USERS WHERE ID = ? AND ACTIVE_STATUS = ?";
        User user = null;
        try(Connection connection = dbHelper.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.setInt(2, 1);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user = new User();
                user.setId(id);
                user.setFirstName(rs.getString("FIRST_NAME"));
                user.setLastName(rs.getString("LAST_NAME"));
                user.setUsername(rs.getString("USERNAME"));
                user.setDataDate(rs.getDate("DATA_DATE"));
                user.setActiveStatus(1);
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        String sql = "INSERT INTO USERS(FIRST_NAME, LAST_NAME, USERNAME, PWD, DATA_DATE, ACTIVE_STATUS)" +
                " VALUES(?,?,?,?,?,?)";
        try(Connection connection = dbHelper.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setDate(5, new Date(new java.util.Date().getTime()));
            ps.setInt(6, 1);
            boolean success = ps.execute();
            System.out.println(success);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        String sql="UPDATE USERS SET FIRST_NAME=?,LAST_NAME=?,USERNAME=?,PWD=? WHERE ID=?";
        try(Connection connection=dbHelper.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ps.setString(1,user.getFirstName());
            ps.setString(2,user.getLastName());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setInt(5,user.getId());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(Integer id) {
        String sql= "DELETE FROM USERS WHERE ID=? AND ACTIVE_STATUS=1";
        try(Connection connection=dbHelper.getConnection();
        PreparedStatement ps=connection.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM USERS WHERE LOWER(USERNAME) = LOWER(?) AND PWD = ?";
        User user = null;
        try(Connection connection = dbHelper.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("ID"));
                user.setFirstName(rs.getString("FIRST_NAME"));
                user.setLastName(rs.getString("LAST_NAME"));
                user.setUsername(username);
                user.setPassword(password);
                user.setDataDate(rs.getDate("DATA_DATE"));
                user.setActiveStatus(rs.getInt("ACTIVE_STATUS"));
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return user;
    }

}
