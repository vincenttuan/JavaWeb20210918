<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello WS Client 2</title>
<script>
window.onload = function() {
	var webSocket = null;
	
	// 當 sendBtn 按下(click)後所要做的事
	sendBtn.addEventListener("click", function(){
		sendMessage();
	})
	
	// 傳送資料
	function sendMessage() {
		// 獲取 DOM 元件
		var messageInput = document.getElementById("message");
		// 取得 message 資料
		var data = messageInput.value;
		console.log(data);
		// 傳送
		webSocket.send(data);
		
	}
	
	//設置WebSocket
	function setWebSocket() {
		var url = 'ws://localhost:8080/JavaWeb20210918/hello/ws/server'; 
		// 開始WebSocket連線
		webSocket = new WebSocket(url);
		// 以下開始偵測WebSocket的各種事件
		
		// onopen , 連線成功時觸發
		webSocket.onopen = function (event) {
			console.log('onopen: ' + event);
		};
		
		// onmessage , 接收到來自Server的訊息時觸發
		webSocket.onmessage = function (event) {
			console.log('onmessage: ' + event.data);
		};
		
		//onclose , 連線關閉時觸發
		webSocket.onclose = function (event) {
			console.log('onclose: ' + event.data);
		};
		
	}
	setWebSocket();
}
</script>
</head>
<body>
	
	<input type="text" id="message" name="message">
	<input type="button" value="Send" id="sendBtn" name="sendBtn">
	
</body>
</html>