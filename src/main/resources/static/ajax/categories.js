$(document).ready(()=>{
   loadCategory();
    toastr.options = {
        "closeButton": true,
        "debug": false,
        "positionClass": "toast-bottom-right",
        "onclick": null,
        "fadeIn": 300,
        "fadeOut": 1000,
        "timeOut": 5000,
        "extendedTimeOut": 1000
    }

    // add category
    $("#frmCategory").submit(function (event){
        event.preventDefault();
        var form = $(this);
        $.ajax({
            url: "/apiCategories/saveCategory",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                name: $("#nameCategory").val(),
            }),
            success: (response) => {
                toastr.success("Category added successfully");
                $("#nameCategory").val('')// Reset form
                loadCategory();
            },
            error: () => {
                toastr.error("Category added failed");
            },
        });
    });

    //delete category
    $(document).on("click", ".delete-btn", function() {
        let categoryId = $(this).attr('data-id');
        $('#confirmModal').show();
        $('#confirmAction').off().on("click",function (){
            $.ajax({
                        url: "/apiCategories/deleteCategory/" + categoryId,
                        method: "GET",
                        success: function(response) {
                            toastr.success(response,{
                                closeButton: true,
                                positionClass: "toast-bottom-right",
                            });
                            loadCategory();
                            $('#confirmModal').hide();

                        },
                        error: function(response) {
                            toastr.error(response,{
                                closeButton: true
                            });
                        }
                    });
        });
        cancelAction();
    });

    //update category
    $(document).on("click",".update-btn", function (){
        let categoryId = $(this).attr('data-id');
        let nameUpdate = $("#nameCategory").val();

        if(nameUpdate === ""){
            toastr.success("can't empty",{
                closeButton: true
            });
        }else {
            if(nameUpdate){
                let updateNameCategory = {
                    name: nameUpdate
                }
                $('#confirmModal').show();
                $('#confirmAction').off().on("click",function (){
                        $.ajax({
                            url: "/apiCategories/updateCategory/" + categoryId,
                            method: "PUT",
                            contentType: "application/json",
                            data: JSON.stringify(updateNameCategory),
                            success: function(response) {
                                $("#nameCategory").val('')// Reset form
                                toastr.success(response);
                                loadCategory();
                                $('#confirmModal').hide();
                            },
                            error: function(response) {
                                toastr.error(response);
                            }
                        });
                });
                cancelAction();
            }
        }

    });

    // reset form
    $(document).on("click","#reset",function () {
        $("#nameCategory").val('')// Reset form
    });

});

function loadCategory(){
    $.get("/apiCategories/ListCategory",(data)=>{
        $("#lst-category").empty();

        $.each(data, (index, category)=>{
            let categoryHtml = '<tr>' +
                '<td>' + category.id + '</td>' +
                '<td>' + category.name + '</td>' +
                '<td> <div class="button-group">' +
                '<button class="btn btn-warning delete-btn" data-id="' + category.id + '">Delete</button>' +
                '<button class="btn btn-primary update-btn" data-id="' + category.id + '">Update</button>' +
                '</div></td>' +
                '</tr>';
            $("#lst-category").append(categoryHtml);
        });
    });
}

function cancelAction(){
    $("#cancelAction").click(function () {
        $("#confirmModal").hide();
    });
}