<%@ page import="com.example.util.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link href="../css/Login.css" type="text/css" rel="stylesheet">
    <script src="../js/jquery.min.js" type="text/javascript"></script>
    <script src="../js/Login.js" type="text/javascript"></script>
</head>
<body>

<%
    // Create cookies for first and last names.
    Cookie[] cookies = request.getCookies();
    String email="";
    String password="";
    String remember="";
    for(Cookie cookie:cookies){
        if(cookie.getName().equalsIgnoreCase(Constants.COOKIE_EMAIL))
            email=cookie.getValue();
        else if(cookie.getName().equals(Constants.COOKIE_PASS))
            password=cookie.getValue();
        else if(cookie.getName().equalsIgnoreCase(Constants.COOKIE_REMEMBER))
            remember=cookie.getValue();
    }
%>

<form class="modal-content" action="/Login" method="post">
    <div class="imgcontainer">
        <img src="../img/Login/DefaultImg.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Enter Email" name="email" id="email" value="<%=email%>" required>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" id="password" value="<%=password%>" required>

        <button type="submit" id="btnLogin">Login</button>
        <button type="submit" id="btnSignup" formaction="/Registration" formnovalidate formmethod="get">Sign Up</button>
        <span id="error"><%=(request.getAttribute(Constants.AUTH_ERROR_ATTRIBUTE) == null) ? "" : request.getAttribute(Constants.AUTH_ERROR_ATTRIBUTE)%></span><br/>
        <label><input type="checkbox" name="remember" <%=remember%>> Remember me</label>
    </div>

</form>
</body>
</html>
