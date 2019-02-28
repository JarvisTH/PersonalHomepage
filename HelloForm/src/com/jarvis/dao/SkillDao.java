package com.jarvis.dao;

import java.lang.ref.PhantomReference;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class SkillDao {
    private static String tbName="skill";

    public  int save(Skill skill){
        int status=0;
        try{
            Connection con=new ConnectDB().getConnection();
           String sql="insert into "+tbName+"(user_id,skill_name,skill_points) values (?,?,?)";
           PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,skill.getUserId());
            ps.setString(2,skill.getSkillName());
            ps.setInt(3,skill.getSkillPoints());

            status=ps.executeUpdate();

            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public  int update(Skill skill){
        int status=0;
        try {
            String sql="update "+tbName+ " set skill_name=?,skill_points=? where order_id=?";
            Connection con=new ConnectDB().getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,skill.getSkillName());
            ps.setInt(2,skill.getSkillPoints());
            ps.setInt(3,skill.getSkillId());
            System.out.println(ps);
            status=ps.executeUpdate();

            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }


    public  int delete(int skillId){
        int status=0;
        try {
            String sql="delete from "+tbName+" where order_id=?";
            Connection con=new ConnectDB().getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,skillId);
            status=ps.executeUpdate();
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public  List<Skill> getSkills(int userId){
        List<Skill> list=new ArrayList<>();
        try {
            String sql="select * from "+tbName+ " where user_id=?";
            Connection con=new ConnectDB().getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,userId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Skill skill=new Skill();
                skill.setSkillId(rs.getInt("order_id"));
                skill.setSkillName(rs.getString("skill_name"));
                skill.setSkillPoints(rs.getInt("skill_points"));
                skill.setUserId(rs.getInt("user_id"));
                list.add(skill);
            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
