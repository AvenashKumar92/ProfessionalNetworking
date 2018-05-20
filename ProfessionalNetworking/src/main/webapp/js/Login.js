/**
 * Created by Avenash_2 on 5/19/2018.
 */
$( function() {
    $("#btnLogin").click(validateUserInputs); // bound to submit button here
    $("#btnSignup").click(onClickSignUp)
} );


function validateUserInputs(event) {
    var email=$("#email").val();
    var password=$("#password").val();
}

function onClickSignUp(event) {
   /* $.ajax("http://localhost:8080/Registration", { "type": "GET" })
        .done(onSuccessReg)
        .fail(onFailureReg);*/

   /* var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "http://localhost:8080/Registration", false ); // false for synchronous request
    xmlHttp.send( null );
    return xmlHttp.responseText;*/
}

function onSuccessReg() {
    console.log("Professional-In: Successfully load 'registration' process")
}

function onFailureReg(xhr, status, exception) {
    console.log("Professional-In: Failed to load 'registration' process")
    console.log(xhr, status, exception);
}