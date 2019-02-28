<%--
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
    <div class="content">
        <div class="person-data">
            <form action="${pageContext.request.contextPath}/Servlet/UserFileServlet?method=upload" method="post" enctype="multipart/form-data">
                <div class="input-line">
                        <label>User Image:</label>
                        <span>Upload Image:</span>
                        <input type="file" name="image">
                        <input type="submit" value="Submit">
                </div>
            </form>
            <form action="${pageContext.request.contextPath}/Servlet/UserFileServlet?method=add" method="post">
                <div class="input-line">
                    <label>Name:</label>
                    <input type="text" class="input-field" name="name">
                </div>
                <div class="input-line">
                    <label>Password:</label>
                    <input type="password" class="input-field" name="password">
                </div>
                <div class="input-line">
                    <label>Sex:</label>
                    <input type="text" class="input-field"  name="sex">
                </div>
                <div class="input-line">
                    <label>E-mail:</label>
                    <input type="text" class="input-field"  name="email">
                </div>
                <div class="input-line">
                    <label>Phone:</label>
                    <input type="text" class="input-field" name="phone">
                </div>
                <div class="input-line">
                    <label>Birthday:</label>
                    <input type="text" class="input-field" name="birthday">
                </div>
                <div class="input-line">
                    <label>Hobbies:</label>
                    <textarea class="txt" name="hobby" id="s" cols="80" rows="5"></textarea>
                </div>
                <div class="input-line">
                    <label>Education Background:</label>
                    <textarea class="txt" name="edu" id="w" cols="80" rows="5"></textarea>
                </div>
                <div class="input-line">
                    <input type="submit" value="Subm it" class="btn" >
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
