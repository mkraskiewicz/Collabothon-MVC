
function load(url) {
    $.ajax({
        type: "GET",
        data: { get_param: 'value' },
        dataType: 'json',
        url: 'http://localhost:8080/api/v1/vendors/1',
        success: function (data) {
            if(data.vendorInterested){
                console.log("Vendor " + data.vendor.id + " wants to deal with me!")
            }else
            console.log("No one is going to make a deal with me.")
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

    //get with another serviceProvider
}
function onAnswerTheCallClick() {

}


// !USER ONCLICKS
function onCallCustomerClick() {

}


// SERVICE PROVIDER ONCLICK