<%--
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
    <div class="content">
        <div class="sec">
            <form action="${pageContext.request.contextPath}/Servlet/ProjectFileServlet?method=add&userId=<%=request.getParameter("userId")%>" method="post">
                <div class="input-line">
                    <label>Project Name:</label>
                    <input type="text" class="input-field" name="project-name">
                </div>
                <div class="input-line">
                    <label >Experience:</label>
                    <textarea name="exp-txt" id="" class="txt" cols="80" rows="5"></textarea>
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