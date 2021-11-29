//on init fetch the data from the server
// const baseUrl = "http://localhost:8080/";
var baseUrl;
$(document).ready(function () {
    baseUrl = window.location.origin + '/';
    console.log(baseUrl);
    getInfo();
    fetchAllItems();
});

function getInfo() {
    $.ajax({
        url: baseUrl + 'api/v1/cool/info',
        type: 'GET',
        success: function (data) {
            console.log(data);
            $('#vending-name').text(data.object);
            $.each(data, function (index, value) {
                // $('#products').append('<tr><td>' + value.id + '</td><td>' + value.name + '</td><td>' + value.price + '</td><td>' + value.quantity + '</td></tr>');
            });
        }
    });
}


function placeOrder(data) {
    console.log(data);
    console.log(data.length);
    if (data.length !== 0) {
        $.ajax({
            url: baseUrl + 'api/v1/cool/order',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify({orderId: data}),
            success: function (data) {
                console.log(data);
                fetchAllItems();
            }, error: function (data) {
                isError = true;
                console.log(data);
            }
        });
    }

    document.getElementById('code').value = '';

}


function addCash(data) {
    $.ajax({
        url: baseUrl + 'api/v1/cool/load-cash',
        type: 'POST',
        contentType: "application/json",
        data: JSON.stringify({amount: data}),
        success: function (data) {
            console.log(data);
        }
    });
}

function addCoins(data) {
    $.ajax({
        url: baseUrl + 'api/v1/cool/load-cash',
        type: 'POST',
        contentType: "application/json",
        data: JSON.stringify({amount: data}),
        success: function (data) {
            console.log(data);
        }
    });
}

function cancel() {
    $.ajax({
        url: baseUrl + 'api/v1/cool/cancel',
        type: 'GET',
        success: function (data) {
            console.log(data);
        }
    });
}

function fetchAllItems() {
    $('#item-body').empty();
    $.ajax({
        url: baseUrl + 'api/v1/cool/all-items',
        type: 'GET',
        success: function (data) {
            console.log(data);
            $.each(data, function (index, value) {
                $('#item-body').append(
                    `
                         <div class="card card-custom mx-2 mb-3">
                            <img src="https://via.placeholder.com/150" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <p class="card-text">Name: ${value.name}(${value.stock})<br>Code: ${value.code} <br> price: ${value.amount}</p>
                                </div>
                         </div>
                        `
                );
                // $('#name'+index).append( value.name);
                // $('#price'+index).append( value.amount);
                // $('#stock'+index).append( value.stock);
            });
        }
    });
}

// var stomp