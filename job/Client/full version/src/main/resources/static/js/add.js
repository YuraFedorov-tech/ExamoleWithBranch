$(function ($) {
    $('#btnAdd').click(function (e) {
        alert('add');
        e.preventDefault();
        var result = $('#dataAdd').serializeArray();
          $.ajax({
            url: "/admin/add",
            type: 'POST',
            data: result,
            context: document.getElementById('#ajax'),
            success: function (data) {
                succsess(data);
                alert('succsess');
            }

        });
        $('#someTabs a[href="#mainTab"]').tab('show');
    });
});


function succsess(data) {
    $('.table.table-striped tr:last').after(insidUser(data));
    $('.js-tableUsers tr:last').css({border: '1px solid green'});
    $('.js-tableUsers tr:last').addClass("js-usesrsFromMainTable");
}


function insidUser(data) {
    var ans =
        '<tr>' +
        '<td><span>' + data.id + '</span></td> ' +
        '<td><span>' + data.firstName + '</span></td> ' +
        '<td><span>' + data.lastName + '</span></td> ' +
        '<td><span>' + data.age + '</span></td> ' +
        '<td><span>' + data.email + '</span></td> ' +
        '<td><span>' + data.password + '</span></td> ' +
        '<td><span>' + findOneRoleByIdes(data.roles) + '</span></td> ' +
        '<td>' + findBtnEdit(data) + '</td> ' +
        '<td><span>' + findBtnDelete(data) + '</span></td> ' +
        '</tr>';
    return ans;
};

function findBtnDelete(data) {
    ans = '                                        <div class="form-row text-center">\n' +
        '                                            <div class="col-12">\n' +
        '                                                <button class="btn btn-danger " ' +
        'data-id="'+data.id    +'"'+
        'data-firstname="'+data.firstName    +'"'+
        'data-lastname="'+data.lastName    +'"'+
        'data-age="'+data.age    +'"'+
        'data-email="'+data.email    +'"'+
        'data-password="'+data.password    +'"'+
        'data-roles="'+data.roles    +'"'+
        '                                                        data-target="#myModalDelete" data-toggle="modal"' +
        '                                                        type="button">Delete' +
        '                                                </button>' +
        '                                            </div>' +
        '                                        </div>';
    return ans;
};


function findBtnEdit(data) {
    ans = '         <div class="form-row text-center">\n' +
        '                                            <div class="col-12">\n' +
        '                                                <button class="btn btn-primary " ' +
        'data-id="'+data.id    +'"'+
        'data-firstname="'+data.firstName    +'"'+
        'data-lastname="'+data.lastName    +'"'+
        'data-age="'+data.age    +'"'+
        'data-email="'+data.email    +'"'+
        'data-password="'+data.password    +'"'+
        'data-roles="'+data.roles    +'"'+

        '                                                        data-target="#myModal" data-toggle="modal"\n' +
        '                                                        type="button">Edit\n' +
        '                                                </button>\n' +
        '                                            </div>\n' +
        '                                        </div>';

    return ans;
};


function findOneRoleByIdes(roles) {
    var ans = "";
    $.each(roles, function (index, role) {
        ans = ans + findOneRoleById(role.id)+ " ";
    });
    return ans;
};

function findOneRoleById(id) {
    if (id == 463) {
        return 'SUPERADMIN';
    }
    if (id == 459) {
        return 'USER';
    }
    if (id == 458) {
        return 'ADMIN';
    }
    return 'GUEST';
};
