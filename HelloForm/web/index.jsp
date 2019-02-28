<%@ page import="com.jarvis.servlet.UserLoginServlet" %><%--
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
    <title>Login</title>
    <link rel="stylesheet" href="css/login.css" >
</head>
<body>
<div class="container">
    <div class="header">
        <div class="header-txt">
            Jarvis's Blog
        </div>
    </div>

    <div class="main">
        <div class="login-info">
            <h3 class="txt">Sign In Your Account</h3>
            <form action="${pageContext.request.contextPath}/Servlet/UserLoginServlet?method=login" method="post">
                <div class="input-line">
                    <label for="input-account" class="input-tip">Account:</label>
                    <input type="text" class="input-field" id="input-account" name="account">
                </div >
                <div class="input-line">
                    <label for="input-password" class="input-tip">Password:</label>
                    <input type="password"class="input-field" id="input-password" name="password">
                </div>
                <div class="input-line">
                    <input type="submit" value="Submit" class="submit" id="submit-button">
                </div>
            </form>
            <div class="input-line">
                <a href="register.jsp" class="submit">Register</a>
            </div>
            <div class="input-line">
                <a href="codeLogin.jsp" class="submit">验证码登录</a>
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
<script src="js/code.js"></script>
</body>
</html>
