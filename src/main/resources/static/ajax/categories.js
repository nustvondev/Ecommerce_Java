$(document).ready(()=>{
   loadCategory();

   $("#frmCategory").submit((event)=>{
       event.preventDefault();
       let form = $(this);
       $.ajax({
          url: "/api/saveCategory",
           method:"POST",
          contentType: "application/json",
           data: JSON.stringify({
                name : $("#nameCategory").val(),
           }),
           success: (response) =>{
               alert("Category added successfully");
               form.trigger("reset");
               loadCategory();
           },
           error:()=>{
               alert("Category added Failed");
           },

       });
   });
});

function loadCategory(){
    $.get("/api/ListCategory",(data)=>{
        $("#lst-category").empty();

        $.each(data, (index, category)=>{
            let categoryHtml = '<tr>' +
                '<td>' + category.id + '</td>' +
                '<td>' + category.name+ '</td>' +
                '</tr>';
            $("#lst-category").append(categoryHtml);
        });
    });
}