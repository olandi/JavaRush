$(document).ready(function () {

    $('#saveContact').submit(function (e) {

        $.post('/user/save', $(this).serialize(), function (user) {
            $('#contactTableResponse').last().append(
                '<tr>' +
                '<td>' + user.id + '</td>' +
                '<td>' + user.name + '</td>' +
                '<td>' + user.age + '</td>' +
                '<td>' + user.admin + '</td>' +
                '<td>' + Date.now() + '</td>' +
                '<td>' + '<input type="button" value="Delete" onclick="deleteRow(this)"/>' + '</td>' +
                '</tr>'
            );
        });

        clearInputs();

        e.preventDefault();
    });

});

function deleteRow(btn) {
    var row = btn.parentNode.parentNode;
    $.ajax({
        type: 'GET',
        url: '/user/delete/' + row.cells[0].innerHTML,
        dataType: 'json',
        async: true
    });
    row.parentNode.removeChild(row);
}

function updateRow(btn) {
    var row = btn.parentNode.parentNode;
    var id = row.cells[0].innerHTML;
    var name = $(btn).closest("tr.users").find("input[name='name']").val();
    var age = $(btn).closest("tr.users").find("input[name='age']").val();
    var user = {
        'id': id,
        'name': name,
        'date': Date.now(),
       'age': age
    };
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: '/user/update',
        cache: false,
        processData: false,
        data: JSON.stringify(user)
    });
}

function clearInputs() {
    $('input[id*="Input"]').each(function () {
        $(this).val('');
    });
}

$(document).ready(function () {
    $('#button').click(function () {

        var first = $('#nameInput').val();

        $.ajax({
            type: 'GET',
            url: "/user/getJSON/" + first,
            dataType: 'json',
            success: function (result) {

                var user =
                    "id : " + result.id +
                    " | name : " + result.name + " " +
                    " | age : " + result.age;

                $("#theJson").html(user);

                clearInputs();

            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("User " + textStatus + " " + errorThrown + " !");
            }

        });
    });
});

$(document).ready(function () {
    $('#search').keyup(function (e) {
        var filter = $('#search').val();
        if (filter.length > 0) {
            loadTable(filter);
        } else {
            $('tr[id*="tr_"]').remove();
        }
    });
});

function loadTable(filter) {
    var url = "/user/load/" + filter;

    $('#tbody').load(url, function (response, status, xhr) {
        if (status == "error") {
            var msg = "Sorry but there was an error: ";
            $("#info").html(msg + xhr.status + " " + xhr.statusText);
        }
    });

    return false;
}

(function(document) {
    'use strict';

    var LightTableFilter = (function(Arr) {

        var _input;

        function _onInputEvent(e) {
            _input = e.target;
            var tables = document.getElementsByClassName(_input.getAttribute('data-table'));
            Arr.forEach.call(tables, function(table) {
                Arr.forEach.call(table.tBodies, function(tbody) {
                    Arr.forEach.call(tbody.rows, _filter);
                });
            });
        }

        function _filter(row) {
            var text = row.textContent.toLowerCase(), val = _input.value.toLowerCase();
            row.style.display = text.indexOf(val) === -1 ? 'none' : 'table-row';
        }

        return {
            init: function() {
                var inputs = document.getElementsByClassName('light-table-filter');
                Arr.forEach.call(inputs, function(input) {
                    input.oninput = _onInputEvent;
                });
            }
        };
    })(Array.prototype);

    document.addEventListener('readystatechange', function() {
        if (document.readyState === 'complete') {
            LightTableFilter.init();
        }
    });

})(document);
