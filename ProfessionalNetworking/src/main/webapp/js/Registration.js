// Slideshow

var slideIndex = 1;


$(function init(){
    var btnLeft=$("#w3-left")[0];
    $(btnLeft).click(plusDivs(-1));

    var btnRight=$("#w3-right")[0];
    $(btnRight).click(plusDivs(1));

    $("#submit").click(onSubmit);

    $("#error-validation-confirmPass").hide();

    showDivs(slideIndex);
})

function onSubmit(event) {
    let pass=$( "input[name='password']" ).val();
    let cpass=$( "input[name='ConfirmPassword']" ).val();

    if(pass!==cpass) {
        //Update view
        showDivs(slideIndex = 1);

        //Display error
        $("#error-validation-confirmPass").show();

        //No need to submit request
        return false;
    }
}



function plusDivs(n) {
  showDivs(slideIndex += n);
}

function currentDiv(n) {
  showDivs(slideIndex = n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("demodots");
  if (n > x.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = x.length} ;
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
     dots[i].className = dots[i].className.replace(" w3-white", "");
  }
  x[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " w3-white";
}

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#avatar')
                .attr('src', e.target.result);
        };

        reader.readAsDataURL(input.files[0]);
    }
}