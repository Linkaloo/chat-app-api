// const stompClient = new StompJs.Client({
//     brokerURL: "ws://localhost:8080/chat-websocket",
// });
//
// stompClient.onConnect = (frame) => {
//     setConnected(true);
//     console.log("Connected: " + frame);
//     stompClient.subscribe("/topic/message", (message) => {
//         addMessage(JSON.parse(message.body));
//     });
// };
//
// stompClient.onWebSocketError = (error) => {
//     console.error("Error with websocket", error);
// }
//
// stompClient.onStompError = (frame) => {
//     console.error("Broker reported error: " + frame.headers["message"]);
//     console.error("Additional Details: " + frame.body);
// }
//
// const setConnected = (connected) => {
//     $("#connect").prop("disabled", connected);
//     $("#disconnect").prop("disabled", !connected);
//
//     if(connected) {
//         $("#responses").show();
//     }
//     else {
//         $("#responses").hide();
//     }
// }
//
// const connect = () => {
//     stompClient.activate();
// }
//
// const disconnect = () => {
//     stompClient.deactivate();
//     setConnected(false);
//     console.log("Disconnected")
// }
//
// const sendMessage = () => {
//     console.log("sending message");
//
//     stompClient.publish({
//         destination: "/app/message",
//         body: {name: "Josh", message: "Hello, im josh"}
//     });
// }
//
// const addMessage = (messageBody) =>  {
//     console.log("adding message")
//     console.log(messageBody);
//     const div = document.getElementById("response-body");
//     const context  = document.createTextNode(messageBody.content);
//     div.appendChild(context);
//     // $("#response-body")[0].appendChild(context);
//     // document.getElementById("response-body").appendChild(document.createTextNode("Message"));
// }
//
// $(function (){
//     $("#connect").click(() => connect());
//     $("#disconnect").click(() => disconnect());
//     $("#send").click(() => sendMessage());
// })