$(document).ready(()=>{
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

    loadProduct();
    RedirectshowCart();
    RedirectLogin();
    addToCart();
    totalQuantity();
    inforUserLogin();
    Userlogout();
});

function loadProduct(){
    $.ajax({
        url: "/apiProduct/GetProductByCategory/Fashion",
        type: "GET",
        success: function(data) {
          $("#product-list-fashion").empty();

            for (var i = 0; i < data.length; i++) {
                var product = data[i];
                var productHtml =
                    '<div class="col-lg-4 col-sm-4 technology">' +
                    '<div class="box_main">' +
                    '<h4 class="shirt_text">' + product.name + '</h4>' +
                    '<p class="price_text">Price <span style="color: #262626;">$ ' + product.price + '</span></p>' +
                    '<div class="tshirt_img"><img src="/images/'+ product.image+'" style="max-width: 100%; height: auto;"></div>' +
                    '<div class="btn_main">' +
                    '<button class="btn btn-warning cart-btn" data-id="' + product.id + '">Add To Cart</button>' +
                    '<button class="btn btn-primary details-btn" data-id="' + product.id + '">Details</button>' +
                    '</div>' +
                    '</div>' +
                    '</div>';
                $("#product-list-fashion").append(productHtml);
            }
        },
        error: function(xhr, status, error) {
            console.log("Error: " + error);
        }
    });

    $.ajax({
        url: "/apiProduct/GetProductByCategory/Technology",
        type: "GET",
        success: function(data) {
            $("#product-list-technology").empty();

            for (var i = 0; i < data.length; i++) {
                var product = data[i];
                var productHtml =
                    '<div class="col-lg-4 col-sm-4 technology">' +
                    '<div class="box_main">' +
                    '<h4 class="shirt_text">' + product.name + '</h4>' +
                    '<p class="price_text">Price <span style="color: #262626;">$ ' + product.price + '</span></p>' +
                    '<div class="tshirt_img"><img src="/images/'+ product.image+'" style="max-width: 100%; height: auto;"></div>' +
                    '<div class="btn_main">' +
                    '<button class="btn btn-warning cart-btn" data-id="' + product.id + '">Add To Cart</button>' +
                    '<button class="btn btn-primary details-btn" data-id="' + product.id + '">Details</button>' +
                    '</div>' +
                    '</div>' +
                    '</div>';
                $("#product-list-technology").append(productHtml);
            }
        },
        error: function(xhr, status, error) {
            console.log("Error: " + error);
        }
    });
}

function RedirectshowCart(){
    $("#shoppingCart").on("click",function (){
        const url = "/showCart";
        window.location.href = url;
    });
}

function RedirectLogin(){
    $("#loginPage").on("click",function (){
        const url = "/login";
        window.location.href = url;
    });
}

function addToCart() {
    $(document).off().on("click",".cart-btn", function () {
        var productId = $(this).attr('data-id');

        $.ajax({
            url: "/cart/add/" + productId,
            method: "POST",
            success: function(response) {
                totalQuantity();
                toastr.success(response);
            },
            error: function(xhr, status, error) {
                toastr.error(xhr.responseText);
            }
        });
    })
}

function totalQuantity(){
    $("#quantity").empty();
    $.ajax({
        url: "/cart/totalQuantity",
        method: "GET",
        success: function (data) {
            let totalQuantity = data;
            $("#quantity").append(" ( "+totalQuantity +" )");
        }
    });
}

function inforUserLogin(){
    $("#NameUser").empty();
    $.ajax({
        url: "/apiUser/GetSessionUser",
        method: "GET",
        success: function (data) {
            let name = data.name
            if(name){
                $("#NameUser").append(name);
                $("#loginPage").hide();
                $("#logoutPage").show();
            } else{
                $("#NameUser").append("");
                $("#loginPage").show();
                $("#logoutPage").hide();
            }

        },
        error: function () {
            alert("error");
        }
    });
}

function Userlogout() {
    $(document).on("click","#logoutPage",function () {
        $.ajax({
            url: "/apiUser/UserLogout",
            method: "POST",
            success: function (response) {
                const url = "/";
                window.location.href = url;
                toastr.success(response);
            },
            error: function () {
                alert("Can't Logout");
            }
        })
    })
}





