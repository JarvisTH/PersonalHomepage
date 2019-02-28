package com.jarvis.servlet;

import com.jarvis.dao.Project;
import com.jarvis.dao.ProjectDao;
import com.jarvis.dao.User;
import com.jarvis.dao.UserDao;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProjectFileServlet  extends HttpServlet {
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

    protected void delete(HttpServletRequest req,HttpServletResponse resp)throws IOException{
        resp.setCharacterEncoding("utf-8");
        ProjectDao projectDao=new ProjectDao();
        int index=Integer.parseInt(req.getParameter("index"));
        int userId=Integer.parseInt(req.getParameter("userId"));
        Project project=projectDao.getProjects(userId).get(index);
        int status=projectDao.delete(project.getProId());
        if(status==1){
            resp.sendRedirect(req.getContextPath()+"/management.jsp?userId="+userId);
        }else {
            resp.sendRedirect(req.getContextPath()+"error.html");
        }
    }

    protected void modify(HttpServletRequest req,HttpServletResponse resp)throws IOException{
        resp.setCharacterEncoding("utf-8");
        ProjectDao projectDao=new ProjectDao();
        String userId=req.getParameter("userId");
        int index=Integer.parseInt(req.getParameter("index"));
        Project project=projectDao.getProjects(Integer.parseInt(userId)).get(index);
        project.setProName(req.getParameter("project-name"));
        project.setExpDetail(req.getParameter("exp-txt"));
        int flag=projectDao.update(project);
        if(flag==1){
            resp.sendRedirect(req.getContextPath()+"/management.jsp?userId="+userId);
        }else {
            resp.sendRedirect(req.getContextPath()+"/error.html");
        }
    }

    protected void add(HttpServletRequest req,HttpServletResponse resp)throws IOException{
        req.setCharacterEncoding("utf-8");
        ProjectDao projectDao=new ProjectDao();
        String userId=req.getParameter("userId");
        Project project=new Project();
        project.setProName(req.getParameter("project-name"));
        project.setExpDetail(req.getParameter("exp-txt"));
        project.setUserId(Integer.parseInt(userId));
        int status=projectDao.save(project);
        if(status==1){
            resp.sendRedirect(req.getContextPath()+"/management.jsp?userId="+userId);
        }else {
            resp.sendRedirect(req.getContextPath()+"error.html");
        }
    }
}
