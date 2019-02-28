package com.jarvis.servlet;

import com.jarvis.dao.User;
import com.jarvis.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;


public class UserLoginServlet extends HttpServlet {
    private int num=0;
    private int count;

    @Override
    public void init() throws ServletException {
        super.init();
        count=0;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        String method=req.getParameter("method");
        if(method.equals("login")){
            login(req,resp);
        }
    }

    protected void login(HttpServletRequest req,HttpServletResponse resp)throws IOException{
        req.setCharacterEncoding("utf-8");
        String username=req.getParameter("account");
        String password=req.getParameter("password");
        if(username==null || password==null ){
            try {
                resp.sendRedirect(req.getContextPath()+"/error.html");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            UserDao userDao=new UserDao();
            ResultSet rs=userDao.login(username,password);
            try{
                if(rs.next()){
                    int count=rs.getInt("count");
                    int userId=rs.getInt("user_id");
                    List<User> list=userDao.getUser();
                    User user=null;
                    for(int i=0;i<list.size();i++){
                        if(list.get(i).getId()==userId){
                            user=list.get(i);
                        }
                    }
                    //if(user!=null){
                        count=user.getCount();
                        count++;
                        user.setCount(count);
                        userDao.updateCount(user);
                        System.out.println("kkk"+count);
                        resp.sendRedirect(req.getContextPath()+"/homepage.jsp?userId="+rs.getInt("user_id")+"&HitCount="+count);
//                    }else {
//                        resp.sendRedirect(req.getContextPath()+"/error.html");
//                    }
                }else {
                    resp.sendRedirect(req.getContextPath()+"/error.html");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
