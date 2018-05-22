const MONTHNAMES = ["January", "February", "March", "April", "May", "June",
  "July", "August", "September", "October", "November", "December"
];

$(function(){
    $("#edit").click(onEdit);
    $("#curr-job").change(onCurrJob);
    $("#curr-edu").change(onCurrSchool);
    $("#ok-experience").click(onClickBtnOkExperience);
    $("#ok-education").click(onClickBtnOkEducation);
    $('#edit-experience').click(onEditExperience);
    $('#edit-education').click(onEditEducation);
    $('#logout').click(onLogout);

    hideAllEditBtn();

    $('#publish').click(onPublish);
    $('#publish').hide();

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = onWindowClick;
}) 

function updateExperienceAPI(){
    submitForm($('#form-experience'))
}

function updateEducationAPI(){
    submitForm($('#form-education'))
}

function onLogout(event) {
   /* $.get('/Logout').done(function (data) {
        console.log('Application logout successfully');
    }).fail(function (xhr, status, exception) {
        console.log(xhr, status, exception);
    });*/
    window.location.replace("/Logout");
}

function submitForm(form){
    let url = form.attr("action");
    let formData = $(form).serializeArray();
    $.post(url, formData).done(function (data) {
        console.log('Data sended to server successfully');
    }).fail(function (xhr, status, exception) {
        console.log(xhr, status, exception);
    });
}

function createInfoDiv(isCurrent, name, to, from, extraInfo){
    let outerDiv=$('<div>');
    $(outerDiv).attr('class', 'w3-container');

    let h5=$('<h5>');
    $(h5).attr('class', 'w3-opacity');

    let b=$('<b>');
    $(b).html(name);

    $(h5).append($(b));
    $(outerDiv).append($(h5));

    let h6=$('<h6>');
    $(h6).addClass('w3-text-teal');

    let i=$('<i>');
    $(i).addClass('fa fa-calendar fa-fw w3-margin-right');
    

    $(h6).append($(i));

    
    if(isCurrent){
        let span0=$('<span>');
        $(span0).html(from+ ' - ');
        $(h6).append($(span0));

        let span1=$('<span>');
        $(span1).addClass("w3-tag w3-teal w3-round");
        $(span1).html('Current');
        $(h6).append($(span1));
    }
    else{
        let span0=$('<span>');
        $(span0).html(from+ ' - ' + to);
        $(h6).append($(span0));
    }
    $(outerDiv).append($(h6));

    let para=$('<p>');
    $(para).html(extraInfo);

    $(outerDiv).append($(para));
    $(outerDiv).append($('<hr>'));

    return $(outerDiv);
}

function getFormatedDateText(inputDate) {
    let date = new Date(inputDate)
    return MONTHNAMES[(date.getMonth()+1)%12] + ' '+ date.getFullYear();
}

function onClickBtnOkExperience(event){
    //Close the dialog
    $("#id01").css("display", 'none');

    //Update experience on server side
    updateExperienceAPI();

    //Update experience on client side
    let formData=$('#form-experience').serialize();

    //Extract form data
    let employerName=document.forms['form-experience'].elements['employer'].value;
    let from=getFormatedDateText(document.forms['form-experience'].elements['from'].value);
    let to=getFormatedDateText(document.forms['form-experience'].elements['to'].value);
    let description=document.forms['form-experience'].elements['description'].value;

    let current=$('#curr-job').is(':checked') ;

    //Create container for the purpose of data display
    let infoDiv=createInfoDiv(current, employerName, to, from, description);

    //Add container in html
    $('#id01').after($(infoDiv));

    //Clear all form fields
    $('#form-experience').trigger("reset");

    //to=MONTHNAMES[(to.getMonth()+1)%12] + ' ' + to.getFullYear();
}

function onClickBtnOkEducation(event){
    //Close the dialog
    $("#id02").css("display", 'none');

    //Update education on server side
    updateEducationAPI();

    //Update education on client side
    let formData=$('#form-education').serialize();

    //Extract form data
    let schoolName=document.forms['form-education'].elements['school'].value;
    let from=getFormatedDateText(document.forms['form-education'].elements['from'].value);
    let to=getFormatedDateText(document.forms['form-education'].elements['to'].value);
    let degree=document.forms['form-education'].elements['degree'].value;
    let current=$('#curr-edu').is(':checked') ;

    //Create container for the purpose of data display
    let infoDiv=createInfoDiv(current, schoolName, to, from, degree);

    //Add container in html
    $('#id02').after($(infoDiv));

    //Clear all form fields
    $('#form-education').trigger("reset");
}


function onWindowClick(event){

    var modal1 = document.getElementById('id01');
    var modal2 = document.getElementById('id02');
    if(event.target == modal1 || event.target==modal2){
        $("#id01").css("display", 'none');
        $("#id02").css("display", 'none');

        //Clear all form fields
        $('#form-experience').trigger("reset");
        $('#form-education').trigger("reset");
    }
}

function onCurrSchool(event){
    if( $(this).is(':checked') ){
        $(".hideable-check-edu").hide();
    }
    else{
        $(".hideable-check-edu").show();
    }
}
function onCurrJob(event){
    if( $(this).is(':checked') ){
        $(".hideable-check-job").hide();
    }
    else{
        $(".hideable-check-job").show();
    }
}

function showAllEditBtn () {
    $('#edit-experience').show();
    $('#edit-education').show();
}
function hideAllEditBtn () {
    $('#edit-experience').hide();
    $('#edit-education').hide();
}

function onEdit(event){
    showAllEditBtn();
    $('#edit').hide();
    $('#publish').show();
}

function onPublish(event){
    hideAllEditBtn();
    $('#edit').show();
    $('#publish').hide();
}

function onEditExperience(event){
    $("#id01").css("display", 'block');
    event.stopPropagation();
}

function onEditEducation(event){
    $("#id02").css("display", 'block');
    event.stopPropagation();
}