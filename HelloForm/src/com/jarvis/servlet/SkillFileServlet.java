package com.jarvis.servlet;

import com.jarvis.dao.Skill;
import com.jarvis.dao.SkillDao;
import com.jarvis.dao.User;
import com.jarvis.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SkillFileServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method=req.getParameter("method");
        if(method.equals("add")){
            add(req,resp);
        }else if(method.equals("modify")){
            modify(req,resp);
        }else if(method.equals("delete")){
            delete(req,resp);
        }
    }

    protected void delete(HttpServletRequest req,HttpServletResponse resp) throws IOException{
        req.setCharacterEncoding("utf-8");
        SkillDao skillDao=new SkillDao();
        String userId=req.getParameter("userId");
        List<Skill> list=skillDao.getSkills(Integer.parseInt(userId));
        int index=Integer.parseInt(req.getParameter("index"));
        Skill skill=list.get(index);
        int status=skillDao.delete(skill.getSkillId());
        if(status==1){
            resp.sendRedirect(req.getContextPath()+"/management.jsp?userId="+userId);
        }else {
            resp.sendRedirect(req.getContextPath()+"/error.html");
        }
    }

    protected void modify(HttpServletRequest req,HttpServletResponse resp) throws IOException{
        req.setCharacterEncoding("utf-8");
        SkillDao skillDao=new SkillDao();
        String userId=req.getParameter("userId");
        List<Skill> list=skillDao.getSkills(Integer.parseInt(userId));
        int index=Integer.parseInt(req.getParameter("index"));
        Skill skill=list.get(index);
        String name=req.getParameter("skill-name");
        String points=req.getParameter("points");
        skill.setSkillName(name);
        skill.setSkillPoints(Integer.parseInt(points));
        int status=skillDao.update(skill);
        if(status==1){
            resp.sendRedirect(req.getContextPath()+"/management.jsp?userId="+userId);
        }else {
            resp.sendRedirect(req.getContextPath()+"/error.html");
        }
    }

    protected void add(HttpServletRequest req,HttpServletResponse resp)throws IOException{
        req.setCharacterEncoding("utf-8");
        SkillDao skillDao=new SkillDao(); User user=null;
        String userId=req.getParameter("userId");
        Skill skill=new Skill();
        skill.setUserId(Integer.parseInt(userId));
        skill.setSkillName(req.getParameter("skill-name"));
        skill.setSkillPoints(Integer.parseInt(req.getParameter("points")));
        int status=skillDao.save(skill);
        if(status==1){
            resp.sendRedirect(req.getContextPath()+"/management.jsp?userId="+userId);
        }else {
            resp.sendRedirect(req.getContextPath()+"/error.html");
        }
    }
}
