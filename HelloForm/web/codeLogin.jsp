<%@ page import="com.jarvis.servlet.UserLoginServlet" %><%--
  Created by IntelliJ IDEA.
  User: Jarvis
  Date: 2018/12/14
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
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
    <%
        String phone= request.getParameter("phone");
    %>
    <div class="main">
        <div class="login-info">
            <h3 class="txt">Sign In Your Account</h3>
            <form action="${pageContext.request.contextPath}/Servlet/UserCodeLogin?method=code" method="post">
                <div class="input-line">
                    <label for="input-phone" class="input-tip">Phone:</label>
                    <%
                        if(phone==null){
                    %>
                        <input type="text" class="input-field" id="input-phone" name="phone" >
                    <%}else{%>
                        <input type="text" class="input-field" id="input-phone" name="phone" value="<%=phone%>">
                    <%}%>
                </div>
                <div class="input-line">
                    <input type="submit" class="submit" id="codeBtn"  value="Get Code">
                </div>
            </form>
            <form action="${pageContext.request.contextPath}/Servlet/UserCodeLogin?method=codeLogin" method="post">
                <div class="input-line">
                    <label for="input-code" class="code-tip">Code:</label>
                    <input type="text" class="code-field" id="input-code"  name="code">
                    <input type="text" class="input-field phone" id="phone" name="phone-txt">
                </div>
                <div class="input-line">
                    <input type="submit" value="Submit" class="submit" id="submit-button">
                </div>
            </form>
            <div class="input-line">
                <a href="register.jsp" class="submit">Register</a>
            </div>
            <div class="input-line">
                <a href="index.jsp" class="submit">Password Login</a>
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
