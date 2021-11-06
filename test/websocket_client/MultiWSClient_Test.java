package websocket_client;

import java.net.URI;
import java.util.Scanner;

import javax.websocket.ContainerProvider;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;


public class MultiWSClient_Test {
	public static void main(String[] args) throws Exception {
		String path = "ws://localhost:8080/JavaWeb20210918/multi/ws/server";
		URI uri = new URI(path);
		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		Session session = container.connectToServer(new HelloWSClient(), uri);
		
		RemoteEndpoint.Async remote = session.getAsyncRemote();
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("請輸入訊息(輸入 q 可以離開): ");
			String message = scanner.next();
			if(message.equals("q")) {
				break;
			}
			remote.sendText(message);
			Thread.sleep(1000);
		}
		
		session.close();
		
	}
}
