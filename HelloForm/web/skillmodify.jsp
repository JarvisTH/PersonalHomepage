<%@ page import="java.util.List" %>
<%@ page import="com.jarvis.dao.*" %><%--
  Created by IntelliJ IDEA.
  User: Jarvis
  Date: 2018/12/16
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/addpro.css">
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="header">
        <div class="title">
            Jarvis's Blog
        </div>
    </div>
    <%
        SkillDao skillDao=new SkillDao();
        User user=null;
        String userId=request.getParameter("userId");
        List<Skill> list=skillDao.getSkills(Integer.parseInt(userId));
        int index=Integer.parseInt(request.getParameter("index"));
        Skill skill=list.get(index);
    %>
    <div class="content">
        <div class="sec">
            <form action="${pageContext.request.contextPath}/Servlet/SkillFileServlet?method=modify&index=<%=index%>&userId=<%=userId%>" method="post">
                <div class="input-line">
                    <label>Skill Name:</label>
                    <input type="text" class="input-field" name="skill-name" value="<%=skill.getSkillName()%>">
                </div>
                <div class="input-line">
                    <label >Points:</label>
                    <input type="text" class="input-field" name="points" value="<%=skill.getSkillPoints()%>">
                </div>
                <div class="input-line">
                    <input type="submit" value="Submit" class="btn" >
                </div>
            </form>
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
</body>
</html>