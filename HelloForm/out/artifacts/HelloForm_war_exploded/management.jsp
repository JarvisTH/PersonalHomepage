<%@ page import="java.util.List" %>
<%@ page import="com.jarvis.dao.*" %><%--
  Created by IntelliJ IDEA.
  User: Jarvis
  Date: 2018/12/14
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/manage.css">
    <title>Jarvis's Blog</title>
</head>
<body>
<%
    User user=null;
    String userId=request.getParameter("userId");
    UserDao userDao=new UserDao();
    List<User> listUSer=userDao.getUser();
    for(int i=0;i<listUSer.size();i++){
        if(listUSer.get(i).getId()==Integer.parseInt(userId)){
            user=listUSer.get(i);
        }
    }
%>
<div class="container">
    <div class="header">
        <div class="title">
            <%=user.getName().toUpperCase()%>
                's Blog</a>
        </div>
        <%--<div class="logout">--%>
            <%--<a href="" class="btn">Logout</a>--%>
        <%--</div>--%>
    </div>
    <div class="main">
        <div class="sidebar">
            <a href="#" class="sidebar-button" id="person-btn">Personal Profile</a>
            <a href="#" class="sidebar-button" id="project-btn">Project Experience</a>
            <a href="#" class="sidebar-button" id="skill-btn">Skill Points</a>
        </div>
        <div class="content">
            <div class="detail page-person" id="page-person">
                <div class="info-part">
                    User Image：
                    <img src="<%=user.getImage()%>" alt="User Image" class="user-image">
                </div>
                <div class="info-part">
                    User Name：
                    <span><%=user.getName()%></span>
                </div>
                <div class="info-part">
                    Sex：
                    <span><%=user.getSex()%></span>
                </div>
                <div class="info-part">
                    E-mail：
                    <span><%=user.getEmail()%></span>
                </div>
                <div class="info-part">
                    Phone Number：
                    <span><%=user.getPhone()%></span>
                </div>
                <div class="info-part">
                    Birthday：
                    <span><%=user.getBirthday()%></span>
                </div>
                <div class="info-part">
                    Hobbies：
                    <span><%=user.getHobbies()%></span>
                </div>
                <div class="info-part">
                    Education Background：
                    <span><%=user.getEdu()%></span>
                </div>
                <div class="modify-part">
                    <a href="filemodify.jsp?userId=<%=user.getId()%>" class="btn">
                        Modify
                    </a>
                </div>
            </div>
            <%
                ProjectDao projectDao=new ProjectDao();
                List<Project> list=projectDao.getProjects(user.getId());
            %>
            <div class="detail page-project" id="page-project">
                <table border="1" cellspacing="10">
                    <tr>
                        <th>Number</th>
                        <th>Name</th>
                        <th>Modify</th>
                        <th>Delete</th>
                    </tr>
                    <%for(int i=0;i<list.size();i++){%>
                        <tr>
                            <td><%=i+1%></td>
                            <td><%=list.get(i).getProName()%></td>
                            <td><a href="projectmodify.jsp?index=<%=i%>&userId=<%=user.getId()%>" >Modify</a></td>
                            <td><a href="deletePro.jsp?index=<%=i%>&userId=<%=user.getId()%>" >Delete</a></td>
                        </tr>
                    <%}%>
                </table>
                <div class="space">
                    <a href="addpro.jsp?userId=<%=user.getId()%>" class="btn">Add</a>
                </div>
            </div>
            <%
                SkillDao skillDao=new SkillDao();
                List<Skill> skillList=skillDao.getSkills(user.getId());
            %>
            <div class="detail page-skill" id="page-skill">
                <table border="1" cellspacing="10">
                    <tr>
                        <th>Number</th>
                        <th>Name</th>
                        <th>Points</th>
                        <th>Modify</th>
                        <th>Delete</th>
                    </tr>
                    <%for(int i=0;i<skillList.size();i++){%>
                        <tr>
                            <td><%=i+1%></td>
                            <td><%=skillList.get(i).getSkillName()%></td>
                            <td><%=skillList.get(i).getSkillPoints()%></td>
                            <td><a href="skillmodify.jsp?index=<%=i%>&userId=<%=user.getId()%>"  >Modify</a></td>
                            <td><a href=" deleteSkill.jsp?index=<%=i%>&userId=<%=user.getId()%>">Delete</a></td>
                        </tr>
                    <%}%>
                </table>
                <div class="space">
                    <a href="addskill.jsp?userId=<%=user.getId()%>" class="btn">Add</a>
                </div>
            </div>
        </div>
    </div>
    <div class="footer">
        <address>
            <p>CSU</p>
            <p>Changsha City</p>
            <p>Hunan Province</p>
        </address>
        <p>All rights reserved</p>
        <p>201810</p>
    </div>
</div>
<script src="js/sidebar.js"></script>
</body>
</html>
