
function load(url) {
    $.ajax({
        type: "GET",
        data: { get_param: 'value' },
        dataType: 'json',
        url: 'http://localhost:8080/api/v1/vendors/1',
        success: function (data) {
            console.log("working")
        },
        error: function () {
            console.log("error")
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

