$(document).ready(function() {
    toastr.options = {
        "closeButton": true,
        "debug": false,
        "positionClass": "toast-bottom-right",
        "onclick": null,
        "fadeIn": 300,
        "fadeOut": 1000,
        "timeOut": 3000,
        "extendedTimeOut": 1000
    }
    loadCartItems();
    totalAmount();
    clearOneItem();
    clearAllItem();
    backHomePage();
});

function backHomePage() {
    $(".back").on("click",function () {
        const url = "/";
        window.location.href = url;
    });
}

function loadCartItems() {
    $.ajax({
        url: "/cart/view",
        type: "GET",
        success: function(data) {
            $("#cartItems").empty();

            $.each(data, function(index, cartItem) {
                var row = "<tr>" +
                    "<td>" + cartItem.productId + "</td>" +
                    "<td>" + cartItem.name + "</td>" +
                    '<td><img src="/images/'+ cartItem.image+'" style="width: 100px; height: 100px;"></td>'+
                    "<td>" + cartItem.quantity + "</td>" +
                    "<td>" + cartItem.price + "</td>" +
                    "<td>" + (cartItem.quantity * cartItem.price) + "</td>" +
                    '<td> <div class="button-group">' +
                    '<button class="btn btn-danger delete-btn" data-id="' + cartItem.productId + '">Delete</button>' +
                    '</div></td>' +
                    "</tr>";
                $("#cartItems").append(row);
            });
        },
        error: function(xhr, status, error) {
            console.log(error);
        }
    });
}

function totalAmount(){
    $(".totalAmount").empty();
    $.ajax({
        url: "/cart/totalAmount",
        method: "GET",
        success: function (data) {
            let totalAmount = data;
            $(".totalAmount").append("Total Amount : "+totalAmount);
        }
    });
}

function clearOneItem(){

    $(document).on("click",".delete-btn",function () {
        let productId = $(this).attr('data-id');
        $.ajax({
            url: "/cart/remove/" + productId,
            method: "POST",
            success: function (response) {
                loadCartItems();
                toastr.success(response);
                totalAmount()
            },
            error: function (response){
                toastr.error(response);
            }
        });
    })
}

function clearAllItem(){

    $(document).on("click",".clearAll",function () {
        $.ajax({
            url: "/cart/clearAll" ,
            method: "POST",
            success: function (response) {
                loadCartItems();
                toastr.success(response);
                totalAmount()
            },
            error: function (response){
                toastr.error(response);
            }
        });
    })
}







