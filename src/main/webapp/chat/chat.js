window.onload = function() {
	// DOM 元件
	var nickname = document.getElementById("nickname");
	var loginBtn = document.getElementById("loginBtn");
	var logoutBtn = document.getElementById("logoutBtn");
	var message = document.getElementById("message");
	var sendBtn = document.getElementById("sendBtn");
	var log = document.getElementById("log");
	var messages = document.getElementById("messages");
	
	var webSocket = null;
	var url = 'ws://' + window.location.hostname + ":" + window.location.port + '/JavaWeb20210918/chat/ws/server'
	
	loginBtn.addEventListener("click", function() {
		if(nickname.value == '') {
			log.innerHTML = '請輸入暱稱';
		} else {
			setWebSocket();
		}
	});
	
	sendBtn.addEventListener("click", function() {
		if(message.value == '') {
			log.innerHTML = '請輸入訊息';
		} else {
			var jsonObj = {
				nikename: nickname.value,
				data: message.value
			};
			webSocket.send(JSON.stringify(jsonObj));
		}
	});
	
	function setWebSocket() {
		
		webSocket = new WebSocket(url);
		
		webSocket.onopen = function() {
			loginBtn.disabled = true;
			logoutBtn.disabled = false;
			sendBtn.disabled = false;
			log.innerHTML = '登入成功';
		};
		
		webSocket.onmessage = function(e) {
			log.innerHTML = e.data;
		};
		
		webSocket.onclose = function() {
			loginBtn.disabled = false;
			logoutBtn.disabled = true;
			sendBtn.disabled = true;
			log.innerHTML = '登出成功';
		};
		
		webSocket.onerror = function(e) {
			loginBtn.disabled = false;
			logoutBtn.disabled = true;
			sendBtn.disabled = true;
			log.innerHTML = '連線失敗: ' + e.data;
		};
		
	}
	
}