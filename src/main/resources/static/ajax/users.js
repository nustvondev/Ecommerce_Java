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

    $('.gender').change(function() {
        var selectedValue = $(this).val();
        console.log(selectedValue);
    });

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
                    '<button class="btn btn-warning delete-btn" data-toggle="modal" data-target="#confirmModal" data-id="' + user.id + '"><i class="fa fa-trash"></i></button>' +
                    '<button class="btn btn-primary update-btn"  data-id="' + user.id + '"><i class="fa fa-edit"></i></button>' +
                    "</td>" +
                    "</tr>";
                $("#lst-user").append(UserHTML);
            });
        },
        error: function (){
            alert("error");
        }
    });
}
function addUser() {
    $("#frmUser").submit(function (event) {
        event.preventDefault();
        let name =        $('#name').val();
        let username =    $('#username').val();
        let password =    $('#password').val();
        let phoneNumber = $('#phonenumber').val();
        let birthday =    $('#birthday').val();
        let gender =      $('#gender').val();
        let status =      $('#status').val();

        let userData = {
            name: name,
            username: username,
            password: password,
            phoneNumber: phoneNumber,
            birthday: birthday,
            gender: gender,
            status: status
        };
        $.ajax({
            url: "/apiUser/saveUser",
            method: "POST",
            data: userData,
            success: function (response){
                toastr.success(response);
                $('#name').val('');
                $('#username').val('');
                $('#password').val('');
                $('#phonenumber').val('');
                $('#birthday').val('');
                $('#gender').prop("selectedIndex",0);
                $('#status').prop("selectedIndex",0);
                loadUser();
            },
            error: function (response){
                toastr.error(response);
            }
        })
    })
}
function deleteUser() {

}
function updateUser() {

}