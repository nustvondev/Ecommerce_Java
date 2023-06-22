$(document).ready(()=>{
    toastr.options = {
        "closeButton": true,
        "debug": false,
        "positionClass": "toast-bottom-right",
        "onclick": null,
        "fadeIn": 300,
        "fadeOut": 1000,
        "timeOut": 10000,
        "extendedTimeOut": 1000
    }

    loadProduct();
    RedirectshowCart();
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


