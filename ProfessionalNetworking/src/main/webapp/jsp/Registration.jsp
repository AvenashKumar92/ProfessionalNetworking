<%@ page import="com.example.util.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<title>Registration</title>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="../js/jquery.min.js" type="text/javascript"></script>
<script src="../js/Registration.js" type="text/javascript"></script>
<link href="../css/Registration.css" type="text/css" rel="stylesheet">

<body>


<!-- Content -->
<div class="w3-content" style="max-width:1100px;margin-top:10px;margin-bottom:10px">

    <div class="w3-panel">
        <h1><b>Professional-In</b></h1>
    </div>

    <!-- Slideshow -->
    <form action="/Registration" method="POST" enctype="multipart/form-data" >
        <div class="w3-container">


            <div class="w3-display-container mySlides">
                <div class="w3-section">
                    <label>First Name</label>
                    <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="firstName"
                           required>
                </div>
                <div class="w3-section">
                    <label>Last Name</label>
                    <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="lastName"
                           required>
                </div>
                <div class="w3-section">
                    <label>Email</label>
                    <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="email"
                           required>
                </div>
                <div class="w3-section">
                    <label>New Password</label>
                    <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="password"
                           name="password" required>
                </div>
                <div class="w3-section">
                    <label>Confirm Password</label>
                    <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="password"
                           name="ConfirmPassword" required>
                </div>

            </div>


            <div class="w3-display-container mySlides">
                <div class="w3-section">
                    <label>Profession</label>
                    <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="profession"
                           required>
                </div>
                <div class="w3-section">
                    <label>Contact#</label>
                    <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="number"
                           name="contactNo" required>
                </div>
                <div class="w3-section">
                    <label>City</label>
                    <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="city"
                           required>
                </div>
                <div class="w3-section">
                    <label>State</label>
                    <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="state"
                           required>
                </div>
                <div class="w3-section">
                    <label>Country</label>
                    <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text"
                           name="country" required>
                </div>
            </div>

            <div class="w3-display-container mySlides">
                <div class="w3-section" id="img-div">
                    <img id="avatar" class="w3-circle" src="../img/Registration/DefaultImg.png"  alt="Avatar">
                </div>

                <div class="w3-section">
                    <label>Profile Image</label>
                    <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="file"
                           name="imgURL" onchange="readURL(this);" required>
                </div>
            </div>



            <!-- Slideshow next/previous buttons -->
            <div class="w3-container w3-dark-grey w3-padding w3-xlarge">
                <div class="w3-left" onclick="plusDivs(-1)"><i class="fa fa-arrow-circle-left w3-hover-text-teal"></i>
                </div>
                <div class="w3-right" onclick="plusDivs(1)"><i class="fa fa-arrow-circle-right w3-hover-text-teal"></i>
                </div>

                <div class="w3-center">
                    <span class="w3-tag demodots w3-border w3-transparent w3-hover-white"
                          onclick="currentDiv(1)"></span>
                    <span class="w3-tag demodots w3-border w3-transparent w3-hover-white"
                          onclick="currentDiv(2)"></span>
                    <span class="w3-tag demodots w3-border w3-transparent w3-hover-white"
                          onclick="currentDiv(3)"></span>
                </div>
            </div>
        </div>
        <span class="error"><%=(request.getAttribute(Constants.USER_ALREADYEXIST_ATTRIBUTE) == null) ? "" : request.getAttribute(Constants.USER_ALREADYEXIST_ATTRIBUTE)%></span><br/>
        <button type="submit" class="w3-button w3-block w3-black">Send</button>
    </form>
</div>
</body>
</html>
