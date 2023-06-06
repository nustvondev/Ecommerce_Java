$(document).ready(()=>{
   loadCategory();
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