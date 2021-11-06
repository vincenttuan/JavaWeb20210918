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
				nickname: nickname.value,
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
			if(e.data == 'true') {
				var jsonObj = {
					nickname: nickname.value,
					data: '歡迎 ' + nickname.value + ' 的加入'
				};
				webSocket.send(JSON.stringify(jsonObj));
			} else {
				log.innerHTML = e.data;
				// json string 轉 json object
				var jsonObj = JSON.parse(e.data);
				
				var tbodyRef = document.getElementById('myTable').getElementsByTagName('tbody')[0];
				var newRow = tbodyRef.insertRow();
				var newCell = null;
				var newText = null;
				
				newCell = newRow.insertCell();
				newText = document.createTextNode(jsonObj.nickname);
				newCell.appendChild(newText);
				
				newCell = newRow.insertCell();
				newText = document.createTextNode(jsonObj.data);
				newCell.appendChild(newText);
				
				newCell = newRow.insertCell();
				// yyyy-MM-dd hh:mm:ss
				var date = new Date();
				const formatDate = (current_datetime)=>{
    					let formatted_date = current_datetime.getFullYear() + "-" + (current_datetime.getMonth() + 1) + "-" + current_datetime.getDate() + " " + current_datetime.getHours() + ":" + current_datetime.getMinutes() + ":" + current_datetime.getSeconds();
    					return formatted_date;
				}
				newText = document.createTextNode(formatDate(date));
				newCell.appendChild(newText);
				
			}
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