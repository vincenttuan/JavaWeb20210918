package websocket_client;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ClientEndpoint
public class HelloWSClient {
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("Client open");
	}
	
	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("Client message: " + message);
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println("Client close");
	}
	
}
