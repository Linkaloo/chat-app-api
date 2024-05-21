const stompClient = new StompJs.Client({
    brokerURL: "ws://localhost:8080/chat-websocket",
});

stompClient.onConnect = (frame) => {
    setConnected(true);
    console.log("Connected: " + frame);
    stompClient.subscribe("/topic/message", (message) => {
        addMessage(JSON.parse(message.body).content);
    });
};

stompClient.onWebSocketError = (error) => {
    console.error("Error with websocket", error);
}

stompClient.onStompError = (frame) => {
    console.error("Broker reported error: " + frame.headers["message"]);
    console.error("Additional Details: " + frame.body);
}

const setConnected = (connected) => {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);

    if(connected) {
        $("#responses").show();
    }
    else {
        $("#responses").hide();
    }
}

const connect = () => {
    stompClient.activate();
}

const disconnect = () => {
    stompClient.deactivate();
    setConnected(false);
    console.log("Disconnected")
}

const sendMessage = () => {
    console.log("sending message");

    stompClient.publish({
        destination: "/app/message",
        body: JSON.stringify({name: "Josh"})
    });
}

const addMessage = (message) =>  {
    console.log("adding message")
    console.log(message);
    const div = document.getElementById("response-body");
    console.log(div);
    const context  = document.createTextNode(message.toString());
    console.log(context);
    div.appendChild(context);
    // $("#response-body")[0].appendChild(context);
    // document.getElementById("response-body").appendChild(document.createTextNode("Message"));
}

$(function (){
    $("#connect").click(() => connect());
    $("#disconnect").click(() => disconnect());
    $("#send").click(() => sendMessage());
})