$(document).ready( ()=>{
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

    loadUser();
    addUser();
    deleteUser();
    updateUser();
});

function loadUser() {
    $.ajax({
        url: "/apiUser/ListUser",
        method: "GET",
        success: function (users){
            $("#lst-product tbody").empty();
            users.forEach(function(user) {
                var activeStatus = user.active ? "Activated" : "Not Activated";
                var genderStatus = user.gender ? "Male" : "Female"
                let UserHTML = "<tr>" +
                    "<td>" + user.id + "</td>" +
                    "<td>" + user.name + "</td>" +
                    "<td>" + user.username + "</td>" +
                    "<td>" + user.password + "</td>" +
                    "<td>" + user.phoneNumber + "</td>" +
                    "<td>" + user.address + "</td>" +
                    "<td>" + genderStatus + "</td>" +
                    "<td>" + user.birthday + "</td>" +
                    "<td>" + activeStatus + "</td>" +
                    "<td>" +
                    '<button class="btn btn-warning delete-btn" data-toggle="modal" data-target="#confirmModal" data-id="' + user.id + '">Delete</button>' +
                    '<button class="btn btn-primary update-btn"  data-id="' + user.id + '">Update</button>' +
                    "</td>" +
                    "</tr>";
                $("#lst-product tbody").append(UserHTML);
            });
        },
        error: function (){
            alert("error");
        }
    });
}
function addUser() {

}
function deleteUser() {

}
function updateUser() {

}