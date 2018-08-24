var firstName;
var lastName;
var vendor;
var counter = 1;

function load(url) {
    $.ajax({
        type: "GET",
        data: {get_param: 'value'},
        dataType: 'json',
        url: url + counter,
        success: function (data) {
            firstName = data.firstName;
            lastName = data.lastName;
            vendor = data.vendor;
            counter++;
        }
    })
}



M.AutoInit();

function answerCall() {
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

    //get with another serviceProvider
}
function onAnswerTheCallClick() {

}


// !USER ONCLICKS
function onCallCustomerClick() {

}


// SERVICE PROVIDER ONCLICK