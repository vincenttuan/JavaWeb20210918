<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello WS Client</title>
<script>
window.onload = function() {
	var webSocket = null;
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

</body>
</html>