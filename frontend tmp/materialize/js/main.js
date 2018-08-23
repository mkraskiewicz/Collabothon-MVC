<<<<<<< Updated upstream
=======
var firstName;
var lastName;
var vendor;
var counter = 1;
>>>>>>> Stashed changes

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

function answerCall(){
    console.log("call answered");
    document.getElementById('swippingView').className = 'hideScreen';
    var a = document.getElementById('phoneCallView');
    a.style.display = 'block';
    console.log(a);
    
}

function onCloseCall(elem){
    var a = document.getElementById('modal1');
  


}

