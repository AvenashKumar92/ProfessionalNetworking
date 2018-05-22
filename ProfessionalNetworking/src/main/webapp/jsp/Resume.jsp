<%@ page import="com.example.util.Constants" %>
<%@ page import="com.example.model.User" %>
<%@ page import="com.example.model.JobExperience" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<title>Resume</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="../css/Resume.css" type="text/css" rel="stylesheet">
<script src="../js/jquery.min.js" type="text/javascript"></script>
<script src="../js/Resume.js" type="text/javascript"></script>
<body class="w3-light-blue">

<%
    User user = (User) request.getSession().getAttribute(Constants.USER_ATTRIBUTE);
    String location = user.getContact().getAddress().getCity() + ", " + user.getContact().getAddress().getState() + ", " + user.getContact().getAddress().getCountry();

    String fullName = user.getFirstName() + " " + user.getLastName();

    String profileImageName = user.getProfileImgName();
    if (profileImageName == null || profileImageName.equals(""))
        profileImageName = "DefaultImg.png";
    String profileImgPath = "../img/Resume/" + profileImageName;
%>

<!-- Page Container -->
<div class="w3-content w3-margin-top" style="max-width:1400px;">

    <!-- The Grid -->
    <div class="w3-row-padding">

        <!-- Left Column -->
        <div class="w3-third">

            <div class="w3-white w3-text-grey w3-card-4">
                <div class="w3-display-container">
                    <img id="profile-img" src="<%=profileImgPath%>" style="width:100%" alt="ProfileImage">
                    <div class="w3-display-bottomleft w3-container w3-text-black">
                        <h2><%=fullName%></h2>
                    </div>
                </div>
                <div class="w3-container">
                    <p><i class="fa fa-briefcase fa-fw w3-margin-right w3-large w3-text-teal"></i><%=user.getProfession()%></p>
                    <p><i class="fa fa-home fa-fw w3-margin-right w3-large w3-text-teal"></i><%=location%></p>
                    <p><i class="fa fa-envelope fa-fw w3-margin-right w3-large w3-text-teal"></i><%=user.getEmail()%>
                    </p>
                    <p><i class="fa fa-phone fa-fw w3-margin-right w3-large w3-text-teal"></i><%=user.getContact().getContactNo()%></p>
                    <p id="edit"><label><i
                            class="fa fa-edit fa-fw w3-margin-right w3-large w3-text-teal"></i>Edit</label></p>
                    <p id="publish"><label><i class="fa fa-check fa-fw w3-margin-right w3-large w3-text-teal"></i>Publish</label>
                    </p>
                    <hr>

                    <p class="w3-large"><b><i class="fa fa-asterisk fa-fw w3-margin-right w3-text-teal"></i>Skills</b>
                    </p>
                    <p>Adobe Photoshop</p>
                    <div class="w3-light-grey w3-round-xlarge w3-small">
                        <div class="w3-container w3-center w3-round-xlarge w3-teal" style="width:90%">90%</div>
                    </div>
                    <p>Photography</p>
                    <div class="w3-light-grey w3-round-xlarge w3-small">
                        <div class="w3-container w3-center w3-round-xlarge w3-teal" style="width:80%">
                            <div class="w3-center w3-text-white">80%</div>
                        </div>
                    </div>
                    <p>Illustrator</p>
                    <div class="w3-light-grey w3-round-xlarge w3-small">
                        <div class="w3-container w3-center w3-round-xlarge w3-teal" style="width:75%">75%</div>
                    </div>
                    <p>Media</p>
                    <div class="w3-light-grey w3-round-xlarge w3-small">
                        <div class="w3-container w3-center w3-round-xlarge w3-teal" style="width:50%">50%</div>
                    </div>
                    <br>

                    <p class="w3-large w3-text-theme"><b><i class="fa fa-globe fa-fw w3-margin-right w3-text-teal"></i>Languages</b>
                    </p>
                    <p>English</p>
                    <div class="w3-light-grey w3-round-xlarge">
                        <div class="w3-round-xlarge w3-teal" style="height:24px;width:100%"></div>
                    </div>
                    <p>Spanish</p>
                    <div class="w3-light-grey w3-round-xlarge">
                        <div class="w3-round-xlarge w3-teal" style="height:24px;width:55%"></div>
                    </div>
                    <p>German</p>
                    <div class="w3-light-grey w3-round-xlarge">
                        <div class="w3-round-xlarge w3-teal" style="height:24px;width:25%"></div>
                    </div>
                    <br>
                </div>
            </div>
            <br>

            <!-- End Left Column -->
        </div>

        <!-- Right Column -->
        <div class="w3-twothird">

            <div class="w3-container w3-card w3-white w3-margin-bottom">
                <h2 class="w3-text-grey w3-padding-16" id="editable-div-jobExperience">
                    <i class="fa fa-suitcase fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>Work Experience
                    <i id='edit-experience' class="fa fa-plus-circle fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>
                </h2>

                <div id="id01" class="modal">

                    <form class="modal-content animate" id="form-experience"
                          action="/UpdateExperience">
                        <div class="container">

                            <input type="email" name="email" value="<%=user.getEmail()%>" hidden>
                            <input type="password" name="password" value="<%=user.getPassword()%>" hidden>

                            <label for="employer"><b>Employer</b></label>
                            <input type="text" placeholder="Enter Employer" id="employer" name="employer" required>

                            <label for="from"><b>From </b></label>
                            <label for="current"><b>- Current</b></label>
                            <input id='curr-job' type="checkbox" name="current" required>
                            <input type="month" name="from" required>

                            <label class="hideable-check-job" for="to"><b>To</b></label>
                            <input class="hideable-check-job" type="month" name="to" required>

                            <label for="description"><b>Job Description</b></label>
                            <input type="text" placeholder="Job Description" name="description" required>

                            <button type="button" id="ok-experience" class="ok-btn">Ok</button>
                        </div>
                    </form>
                </div>

                <%
                    if(user!=null && user.getJobExperiences()!=null){
                        JobExperience[] jobExperienceList=user.getJobExperienceArray();

                        for(JobExperience job:jobExperienceList)
                        {
                            if(job.getTo().equals("current")){%>

                            <div class="w3-container">
                                <h5 class="w3-opacity"><b><%=job.getCompany().getName()%></b></h5>
                                <h6 class="w3-text-teal"><i class="fa fa-calendar fa-fw w3-margin-right"></i><%=job.getFrom()%> - <span
                                        class="w3-tag w3-teal w3-round">Current</span></h6>
                                <p></p>
                                <hr>
                            </div>

                            <%}
                            else{%>
                                <div class="w3-container">
                                    <h5 class="w3-opacity"><b><%=job.getCompany().getName()%></b></h5>
                                    <h6 class="w3-text-teal"><i class="fa fa-calendar fa-fw w3-margin-right"></i><%=job.getFrom()%> - <%=job.getTo()%>
                                    </h6>
                                    <p></p>
                                    <hr>
                                </div>
                            <%}
                        }
                        }
                %>
            </div>

            <div class="w3-container w3-card w3-white">
                <h2 class="w3-text-grey w3-padding-16" id="editable-div-education">
                    <i class="fa fa-certificate fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>Education
                    <i id='edit-education' class="fa fa-plus-circle fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>
                </h2>
                <div id="id02" class="modal">

                    <form class="modal-content animate" action="/action_page.php">
                        <div class="container">
                            <input type="email" name="email" value="<%=user.getEmail()%>" hidden>
                            <input type="password" name="password" value="<%=user.getPassword()%>" hidden>

                            <label for="school"><b>School Name</b></label>
                            <input type="text" placeholder="Enter School Name" name="school" required>

                            <label for="degree"><b>Degree</b></label>
                            <input type="text" placeholder="Degree" name="degree" required>

                            <label for="from"><b>From </b></label>
                            <label for="current"><b>- Current</b></label>
                            <input id='curr-edu' type="checkbox" name="current" required>
                            <input type="month" name="from" required>

                            <label class="hideable-check-edu" for="to"><b>To</b></label>
                            <input class="hideable-check-edu" type="month" name="to" required>


                            <button type="button" id="ok-education" class="ok-btn">Ok</button>
                        </div>
                    </form>
                </div>

                <div class="w3-container">
                    <h5 class="w3-opacity"><b>W3Schools.com</b></h5>
                    <h6 class="w3-text-teal"><i class="fa fa-calendar fa-fw w3-margin-right"></i>Forever</h6>
                    <p>Web Development! All I need to know in one place</p>
                    <hr>
                </div>
                <div class="w3-container">
                    <h5 class="w3-opacity"><b>London Business School</b></h5>
                    <h6 class="w3-text-teal"><i class="fa fa-calendar fa-fw w3-margin-right"></i>2013 - 2015</h6>
                    <p>Master Degree</p>
                    <hr>
                </div>
                <div class="w3-container">
                    <h5 class="w3-opacity"><b>School of Coding</b></h5>
                    <h6 class="w3-text-teal"><i class="fa fa-calendar fa-fw w3-margin-right"></i>2010 - 2013</h6>
                    <p>Bachelor Degree</p><br>
                </div>
            </div>

            <!-- End Right Column -->
        </div>

        <!-- End Grid -->
    </div>

    <!-- End Page Container -->
</div>

<!--footer class="w3-container w3-teal w3-center w3-margin-top">
<p>Find me on social media.</p>
<i class="fa fa-facebook-official w3-hover-opacity"></i>
<i class="fa fa-instagram w3-hover-opacity"></i>
<i class="fa fa-snapchat w3-hover-opacity"></i>
<i class="fa fa-pinterest-p w3-hover-opacity"></i>
<i class="fa fa-twitter w3-hover-opacity"></i>
<i class="fa fa-linkedin w3-hover-opacity"></i>
<p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
</footer-->

</body>
</html>
