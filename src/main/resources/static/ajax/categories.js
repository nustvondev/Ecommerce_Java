$(document).ready(()=>{
   loadCategory();

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
                alert("Category added successfully");
                $("#nameCategory").val('')// Reset form
                loadCategory();
            },
            error: () => {
                alert("Category added Failed");
            },
        });
    });

    //delete category
    $(document).on("click", ".delete-btn", function() {
        let categoryId = $(this).attr('data-id');
        $('#confirmModal').show();
        $('#confirmAction').click(function (){
            $.ajax({
                        url: "/apiCategories/deleteCategory/" + categoryId,
                        method: "GET",
                        success: function() {
                            loadCategory();
                            $('#confirmModal').hide();

                        },
                        error: function() {
                            alert("Failed to delete category");
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
            alert("Can't empty!!!");
        }else {
            if(nameUpdate){
                let updateNameCategory = {
                    name: nameUpdate
                }
                $('#confirmModal').show();
                $('#confirmAction').click(function (){
                        $.ajax({
                            url: "/apiCategories/updateCategory/" + categoryId,
                            method: "PUT",
                            contentType: "application/json",
                            data: JSON.stringify(updateNameCategory),
                            success: function(response) {
                                $("#nameCategory").val('')// Reset form
                                loadCategory();
                                $('#confirmModal').hide();
                            },
                            error: function() {
                                alert("Failed to update category");
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