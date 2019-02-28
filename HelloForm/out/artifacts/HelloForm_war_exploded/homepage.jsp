<%@ page import="java.util.List" %>
<%@ page import="com.jarvis.dao.*" %><%--
  Created by IntelliJ IDEA.
  User: Jarvis
  Date: 2018/11/23
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width"/>
    <link rel="stylesheet" type="text/css" href="css/homepage.css"/>
    <title>Jarvis's WebSite</title>
</head>
<body>
<%
    User user=null;
    String userId=request.getParameter("userId");
    System.out.println(userId);
    UserDao userDao=new UserDao();
    List<User> listUSer=userDao.getUser();
    for(int i=0;i<listUSer.size();i++){
        if(listUSer.get(i).getId()==Integer.parseInt(userId)){
            user=listUSer.get(i);
        }
    }
%>
<div class="container">
    <a name="sec-1"></a>
    <div class="hea">
        <div class="manage">
            <a href="management.jsp?userId=<%=user.getId()%>" class="login-btn">Management</a>
        </div>
        <div class="front-ground">
            <div class="head-sculpture" id="head-sculpture">
                <a href="#"><img src="<%=user.getImage()%>" class="h-sculpture " alt="head sculpture"/></a>
            </div>
            <div class="info ">
                <h1>
                    <%=user.getName().toUpperCase()%>
                </h1>
                <p class="detail">Central South University</p>
                <p class="detail">School of Information Science and Engineering</p>
                <p class="detail">Computer Science and Technology</p>
            </div>
        </div>
        <div>
            <img src="img/wolf.jpg" alt="background image" />
        </div>
    </div>
    <nav class="nav-bar">
        <a href="#sec-1" class="first-a">About <%=user.getName()%></a>
        <a href="#sec-2">Skill</a>
        <a href="#sec-3">Language</a>
        <a href="#sec-4">Project Experience</a>
        <a href="#sec-5">Hobby</a>
    </nav>
    <%
        List<Skill> list=null;
        SkillDao skillDao=new SkillDao();
        list=skillDao.getSkills(user.getId());
    %>
    <div class="main">
        <a name="sec-2"></a>
        <div class="capability partition-margin">
            <div class="cap-content">
                <%for(int i=0;i<list.size()/2;i++){%>
                <div class="section">
                    <a href="#">
                        <%=list.get(i).getSkillName()%>:
                    </a>
                    <%for(int j=0;j<list.get(i).getSkillPoints();j++){%>
                        <span class="star-group"><img src="img/star.png" alt="star"/></span>
                   <%}%>
                </div>
                <%}%>
            </div>
            <div class="cap-img">
                <img src="img/mac.jpg" class="sec-margin" alt="mac image"/>
            </div>
        </div>
        <a name="sec-3"></a>
        <div class="capability partition-margin">
            <div class="cap-img"><img src="img/computer.jpg" class="sec-margin" alt="computer image"/></div>
            <div class="cap-content">
                <%for(int i=list.size()/2;i<list.size();i++){%>
                <div class="section">
                    <a href="#">
                        <%=list.get(i).getSkillName()%>:
                    </a>
                    <%for(int j=0;j<list.get(i).getSkillPoints();j++){%>
                    <span class="star-group"><img src="img/star.png" alt="star"/></span>
                    <%}%>
                </div>
                <%}%>
            </div>
        </div>
        <%
            List<Project> listPro=null;
            ProjectDao projectDao=new ProjectDao();
            listPro=projectDao.getProjects(user.getId());
        %>
        <a name="sec-4"></a>
        <div class="project partition-margin">
            <div class="pro-title">
                <h1>Project Experience</h1>
            </div>
            <div class="pro-text">
                <%for(int i=0;i<listPro.size();i++){%>
                    <div class="pro-left sec-pro">
                        <h2><%=listPro.get(i).getProName()%></h2>
                        <p>
                            <%=listPro.get(i).getExpDetail()%>
                        </p>
                    </div>
                <%}%>
            </div>
        </div>
        <a name="sec-5"></a>
        <div class=" partition-margin">
            <div class="hobby">
                <p><%=user.getHobbies()%></p>
            </div>
            <div>
                <img src="img/tree.jpg" alt="tree" />
            </div>
        </div>
    </div>
    <div class="footer">
        <address>
            <p>CSU</p>
            <p>Changsha City</p>
            <p>Hunan Province</p>
        </address>
        <%
            int count=Integer.parseInt(request.getParameter("HitCount"));
        %>
        点击量:<%=count%>
        <p>All rights reserved</p>
        <p>201810</p>
    </div>
</div>

<script src="js/head_sculpture.js"></script>
</body>
</html>