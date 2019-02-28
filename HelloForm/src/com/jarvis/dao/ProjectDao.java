package com.jarvis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProjectDao {
    private static String tbName="pro_exp";

    public  int save(Project pro){
        int status=0;
        try {
            String sql="insert into "+tbName+"(user_id,pro_name,exp_detail) values (?,?,?)";
            Connection con=new ConnectDB().getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,pro.getUserId());
            ps.setString(2,pro.getProName());
            ps.setString(3,pro.getExpDetail());
            status=ps.executeUpdate();
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public  int update(Project pro){
        int status=0;
        try {
            String sql="update "+tbName+" set pro_name=?,exp_detail=? where pro_id=?";
            Connection con=new ConnectDB().getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(3,pro.getUserId());
            ps.setString(1,pro.getProName());
            ps.setString(2,pro.getExpDetail());
            ps.setInt(3,pro.getProId());
            status=ps.executeUpdate();
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public  int delete(int proId){
        int status=0;
        try {
            String sql="delete from "+tbName+" where pro_id=?";
            Connection con=new ConnectDB().getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,proId);
            status=ps.executeUpdate();
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public  List<Project> getProjects(int userId){
        List<Project> list=new ArrayList<>();
        try {
            String sql="select * from "+tbName+" where user_id=?";
            Connection con=new ConnectDB().getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,userId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Project pro=new Project();
                pro.setProId(rs.getInt("pro_id"));
                pro.setUserId(userId);
                pro.setProName(rs.getString("pro_name"));
                pro.setExpDetail(rs.getString("exp_detail"));
                list.add(pro);
            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }

}
