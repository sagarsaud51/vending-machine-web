var stompClient = null;

function setConnected(connected) {
    console.log('connected is  ' + connected);
}

function connect() {
    var socket = new SockJS('/websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/public', function (message) {
            let response = JSON.parse(message.body);
            if (response.balance != 0) {
                $('#balance').text('Balance :' + response.balance);
            }else{
                $('#balance').text('');
            }
            showMessage(response)
            // toastr.info(response.message);
            console.log(JSON.parse(message.body));
            // showGreeting(JSON.parse(greeting.body).content);
        });
    });
}

showMessage = (data) => {
    if (data.success) {
        toastr.success(data.message);
    } else {
        toastr.error(data.message);
    }
}

connect();