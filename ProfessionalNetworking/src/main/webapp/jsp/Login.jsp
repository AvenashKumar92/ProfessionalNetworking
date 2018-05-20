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


<!--button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</button-->

<!--div id="id01" class="modal"-->
  
  <form class="modal-content" action="http://localhost:8080/Login" method="post">
    <div class="imgcontainer">
      <img src="../img/Login/Login.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
      <label for="email"><b>Email</b></label>
      <input type="text" placeholder="Enter Email" name="email" id="email" required>

      <label for="password"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" id="password" required>
        
        <button type="submit" id="btnLogin">Login</button>
        <button type="submit" id="btnSignup" formaction="http://localhost:8080/Registration" formnovalidate>Sign Up</button>
        <span id="error"><%=(request.getAttribute("errMessage") == null) ? "": request.getAttribute("errMessage")%></span><br/>
        <input type="checkbox" checked="checked" name="remember"> Remember me
    </div>

  </form>

<!--form class="modal-content" action="http://localhost:8080/Registration">
    <div class="container">
        <button type="submit" id="btnSignup" formaction="http://localhost:8080/Registration">Sign Up</button>
    </div>
</form>

<label>
    <input type="checkbox" checked="checked" name="remember"> Remember me
</label-->
<!--/div-->

</body>
</html>
