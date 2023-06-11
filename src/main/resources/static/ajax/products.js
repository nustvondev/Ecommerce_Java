$(document).ready(() =>{
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
    loadCategories();
    loadProducts();
    addProduct();
    deleteProduct();
    updateProduct();
});

function loadCategories () {
    $.get("/apiCategories/ListCategory",(data)=>{
        $(".lst-categories").empty();
        $.each(data, (index, category)=>{
            let categoryOption = '<option value="' + category.id + '">' + category.name + '</option>';
            $(".lst-categories").append(categoryOption);
        });
    });
}

function loadProducts(){
    $.get("/apiProduct/ListProduct",(data)=>{
        $("#lst-product").empty();
        $.each(data, (index, products)=>{
            let productHtml = '<tr>' +
                '<td>' + products.id + '</td>' +
                '<td>' + products.name + '</td>' +
                '<td>' + products.price + '</td>' +
                '<td>' + products.brand + '</td>' +
                '<td><img src="/images/' + products.image + '" style="width: 100px; height: 100px;"></td>'+
                '<td>' + products.createdDate + '</td>' +
                '<td>' + products.updatedDate + '</td>' +
                '<td>' + products.category.name + '</td>' +
                '<td> <div class="button-group">' +
                '<button class="btn btn-warning delete-btn" data-toggle="modal" data-target="#confirmModal" data-id="' + products.id + '">Delete</button>' +
                '<button class="btn btn-primary update-btn" data-toggle="modal" data-target="#productModal" data-id="' + products.id + '">Update</button>' +
                '</div></td>' +
                '</tr>';
            $("#lst-product").append(productHtml);
        });
    });
};

function addProduct() {
// add
    $("#frmProduct").submit(function (event) {
        const now = new Date();
        const currentDate = now.getFullYear() + "-"
            + (now.getMonth()+1).toString().padStart(2, '0')
            + "-" + now.getDate().toString().padStart(2, '0');
        event.preventDefault();
        const formData = new FormData();
        formData.append("name", $("#nameProduct").val());
        formData.append("brand", $("#Brand").val());
        formData.append("price", $("#Price").val());
        formData.append("imageProduct", $("#imageProduct")[0].files[0]);
        formData.append("createdDate", currentDate);
        formData.append("updatedDate", currentDate);
        formData.append("category", $(".lst-categories").val());
        $.ajax({
            url: "/apiProduct/saveProduct",
            method: "POST",
            data: formData,
            processData: false,
            contentType: false,
            success: function (response) {
                toastr.success(response);
                $("#nameProduct").val('');
                $("#Brand").val('');
                $("#Price").val('');
                $(".lst-categories").prop("selectedIndex", 0);
                $("#imageProduct").val(null);
                loadProducts();
            },
            error: function (response) {
                toastr.error(response);
            }
        });
    });
}

function cancelAction(){
    $("#cancelAction").click(function () {
        $("#confirmModal").hide();
    });
}

function deleteProduct() {
    $(document).on("click",".delete-btn",function () {
        let productId = $(this).attr('data-id');
        $("#confirmModal").show();
        $("#confirmAction").off().on("click",function () {
            $.ajax({
                url: "/apiProduct/deleteProduct/" + productId,
                method: "GET",
                success: function (response) {
                    toastr.success(response);
                    loadProducts();
                    $("#confirmModal").hide();
                    $('.modal-backdrop').remove();
                },
                error: function (response) {
                    toastr.error(response);
                }
            });

        });
        cancelAction();
    });
}

function updateProduct() {
    $(document).on("click",".update-btn",function () {
        let productId = $(this).attr('data-id');

        $("#productModal").show();
        $("#update").on("click",function () {
            const formData = new FormData();
            formData.append("name", $("#nameProduct1").val());
            formData.append("brand", $("#Brand1").val());
            formData.append("price", $("#Price1").val());
            formData.append("imageProduct", $("#imageProduct1")[0].files[0]);
            formData.append("category", $(".lst-categories").val());
            $.ajax({
                url: "/apiProduct/updateProduct/" + productId,
                method: "PUT",
                data: formData,
                processData: false,
                contentType: false,
                success: function (response) {
                    toastr.success(response);
                    loadProducts();
                    $("#productModal").hide();
                    $('.modal-backdrop').remove();
                    },
                error: function (response) {
                    toastr.error(response);
                }
            });
        })
    })
}