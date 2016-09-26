function get(){
    $.ajax({
        type: "GET",
        url: "api/context/get",
        success: function(data){
            console.info(data.name)
        }
    });
}