$(function ($) {
    $('#btnEdit').click(function (e) {
        e.preventDefault();
        alert('edite');
        var result = $('.js-dataEdit').serializeArray();
        $.ajax({
            url: "/admin/update",
            type: 'POST',
            data: result,
            context: document.getElementById('#ajax'),
            success: function (data) {
                succsess3(data);
                alert('succsess');
            }
        });

        $('#myModal').modal('hide');
    });
});

function succsess3(result) {
    $('.js-usesrsFromMainTable  span').each(function () {
        if ($(this).text() == result.id) {
            changeData(result );
        }
    });
}

function changeData(result) {
    succsess2(result);
    succsess(result);
}

function fun  (data) {
    if(data.firstName=="11111111111111111"){
        if(data.email!=="111111111111111111"){
            var t=4/0;
        };
    };
}