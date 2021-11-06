window.onload = function() {
	var webSocket = null;
	var url = 'ws://' + window.location.hostname + ":" + window.location.port + '/JavaWeb20210918/chat/ws/server';

	function setWebSocket() {

		webSocket = new WebSocket(url);

		webSocket.onopen = function() {
			var jsonObj = {
				nickname: 'monitor',
				data: ''
			};
			webSocket.send(JSON.stringify(jsonObj));
		};

		webSocket.onmessage = function(e) {
			if(e.data == 'true') {
				console.log(e.data);
			} else {
				
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
		}

		webSocket.onclose = function() {

		};

		webSocket.onerror = function(e) {

		};
	};
	
	setWebSocket();
}