package com.jarvis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static String tbName="user";

    public  int save(User user){
        int status=0;
        try{
            Connection connection=new ConnectDB().getConnection();
            String sql="insert into "+tbName+" (user_name,user_password,user_image,user_sex,user_birthday,user_phone,user_email,user_hobbies,user_edu_backgd) " +
                    "values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getImage());
            ps.setString(4,user.getSex());
            ps.setString(5,user.getBirthday());
            ps.setString(6,user.getPhone());
            ps.setString(7,user.getEmail());
            ps.setString(8,user.getHobbies());
            ps.setString(9,user.getEdu());
            status=ps.executeUpdate();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }


    public  int update(User user){
        int status=0;
        try {
            String sql="UPDATE "+tbName+" SET USER_NAME=?,USER_PASSWORD=?,USER_IMAGE=?,USER_SEX=?,USER_BIRTHDAY=?," +
                    "USER_PHONE=?,USER_EMAIL=?,USER_HOBBIES=?,USER_EDU_BACKGD=? WHERE USER_ID=?";
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getImage());
            ps.setString(4,user.getSex());
            ps.setString(5,user.getBirthday());
            ps.setString(6,user.getPhone());
            ps.setString(7,user.getEmail());
            ps.setString(8,user.getHobbies());
            ps.setString(9,user.getEdu());
            ps.setInt(10,user.getId());
            status=ps.executeUpdate();

            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public List<User> getUser(){
        List<User> list=new ArrayList<>();
        try {
            String sql="SELECT * FROM "+tbName;
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                User user=new User();
                user.setId(rs.getInt("user_id"));
                user.setName(rs.getString("user_name"));
                user.setPassword(rs.getString("user_password"));
                user.setImage(rs.getString("user_image"));
                user.setSex(rs.getString("user_sex"));
                user.setBirthday(rs.getString("user_birthday"));
                user.setPhone(rs.getString("user_phone"));
                user.setEmail(rs.getString("user_email"));
                user.setHobbies(rs.getString("user_hobbies"));
                user.setEdu(rs.getString("user_edu_backgd"));
                user.setCount(rs.getInt("count"));
                list.add(user);
            }
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public ResultSet login(String account ,String password){
        Connection con=new ConnectDB().getConnection();
        ResultSet rs=null;
        try{
            String sql="select * from user where user_name=? and user_password=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,account);
            ps.setString(2,password);
           rs=ps.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public  int updateCount(User user){
        int status=0;
        try {
            String sql="UPDATE "+tbName+" SET USER_NAME=?,USER_PASSWORD=?,USER_IMAGE=?,USER_SEX=?,USER_BIRTHDAY=?," +
                    "USER_PHONE=?,USER_EMAIL=?,USER_HOBBIES=?,USER_EDU_BACKGD=?,COUNT=? WHERE USER_ID=?";
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getImage());
            ps.setString(4,user.getSex());
            ps.setString(5,user.getBirthday());
            ps.setString(6,user.getPhone());
            ps.setString(7,user.getEmail());
            ps.setString(8,user.getHobbies());
            ps.setString(9,user.getEdu());
            ps.setInt(11,user.getId());
            System.out.println("DB:"+user.getCount());
            ps.setInt(10,user.getCount());
            status=ps.executeUpdate();

            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }
}
