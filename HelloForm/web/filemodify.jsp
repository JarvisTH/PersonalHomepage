<%@ page import="com.jarvis.dao.UserDao" %>
<%@ page import="com.jarvis.dao.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Jarvis
  Date: 2018/12/15
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/filemodify.css">
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="header">
        <div class="title">
            Personal File
        </div>
    </div>
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
    <div class="content">
        <div class="person-data">
            <form action="${pageContext.request.contextPath}/Servlet/UserFileServlet?method=modify&userId=<%=userId%>" method="post">
                <div class="input-line">
                    <label>User Image:</label>
                    <img src="<%=user.getImage()%>" alt="touxiang" class="head-sculpture">
                    <span>Upload Another Image:</span>
                    <input type="file">
                </div>
                <div class="input-line">
                    <label>Name:</label>
                    <input type="text" class="input-field" value="<%=user.getName()%>" name="user-name">
                </div>
                <div class="input-line">
                    <label>Sex:</label>
                    <input type="text" class="input-field" value="<%=user.getSex()%>" name="user-sex">
                </div>
                <div class="input-line">
                    <label>E-mail:</label>
                    <input type="text" class="input-field" value="<%=user.getEmail()%>" name="user-email">
                </div>
                <div class="input-line">
                    <label>Phone:</label>
                    <input type="text" class="input-field" value="<%=user.getPhone()%>" name="user-phone">
                </div>
                <div class="input-line">
                    <label>Birthday:</label>
                    <input type="text" class="input-field" value="<%=user.getBirthday()%>" name="user-birthday">
                </div>
                <div class="input-line">
                    <label>Hobbies:</label>
                    <textarea class="txt" name="hobby-txt" id="s" cols="80" rows="5"><%=user.getHobbies()%></textarea>
                </div>
                <div class="input-line">
                    <label>Education Background:</label>
                    <textarea class="txt" name="edu-txt" id="w" cols="80" rows="5"><%=user.getEdu()%></textarea>
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
