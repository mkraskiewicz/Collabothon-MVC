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