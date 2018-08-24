
function load(url) {
    $.ajax({
        type: "GET",
        data: { get_param: 'value' },
        dataType: 'json',
        url: 'http://localhost:8080/api/v1/vendors/1/interested',
        success: function (data) {

                console.log(data)
        },
        error: function () {
            console.log("error")
        }
    })
}


$(function(){
    setInterval(load, 5000);
});

M.AutoInit();

function answerCall(){
    console.log("call answered");
    document.getElementById('swippingView').className = 'hideScreen';
    var a = document.getElementById('phoneCallView');
    a.style.display = 'block';
    console.log(a);

}

function endCall() {
    document.getElementById('swippingView').className = 'showScreen';
    var a = document.getElementById('phoneCallView');
    a.style.display = 'none';

}

function endCallServiceProvider() {
    document.getElementById('swippingView').className = 'showScreen';
    var a = document.getElementById('phoneCallViewServiceProvider');
    a.style.display = 'none';

}

function onCloseCall(elem) {
    var a = document.getElementById('modal1');
}


function callClient() {

    document.getElementById('swippingView').className = 'hideScreen';
    var a = document.getElementById('phoneCallViewServiceProvider');
    a.style.display = 'block';
}


// USER ONCLICKS

function onDoBusinessButtonClick() {

    //ajax post to service customer

}
function onRejectServiceProviderClick() {
    console.log("fdfsdf");
    // fillUserViewData();
    //get with another serviceProvider
}
function onAnswerTheCallClick() {

}


// !USER ONCLICKS
function onCallCustomerClick() {

}


// SERVICE PROVIDER ONCLICK





//html templates
function fillUserViewData() {
    //name
    var serviceProvicerName = document.getElementById("name");
    serviceProvicerName.innerHTML = "";
    serviceProvicerName.innerHTML = "Sebastian Kauck"; //data from server here

    //description
    var aboutText = document.getElementById("aboutText");
    aboutText.innerHTML = "";
    aboutText.innerHTML = "I am an banking advisor specialized in financial trading areas with 17 years of experience. I always stars working right away,to provide the best customer experience"; //data from server here

    //description
    var scoreCount = document.getElementById("scoreCount");
    scoreCount.innerHTML = "";
    scoreCount.innerHTML = "(81)"; //data from server here

    $( "#stars" ).append( " <i class='star material-icons'>star</i>" );
    $( "#stars" ).append( " <i class='star material-icons'>star</i>" );
    $( "#stars" ).append( " <i class='star material-icons'>star</i>" );

    //swap photo
    var buisnessPhoto = document.getElementById("buisnessPhoto");
    buisnessPhoto.innerHTML = "";
    $( "#buisnessPhoto" ).append( "<img id='buisnessPhoto' class='responsive-img' src='images/Sebastian.jpeg' alt='Italian Trulli'>" );
    

}