package websocket.server;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.github.javafaker.Faker;

import websocket.server.entity.SocketUser;

@ServerEndpoint("/multi/ws/server")
public class MultiWSServer {
	
	private static CopyOnWriteArraySet<SocketUser> socketUsers = new CopyOnWriteArraySet<>();
	private Faker faker = new Faker();
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("Client 要求建立連線 session is: " + session.getId());
		// 加入到 sessions 容器中
		SocketUser socketUser = new SocketUser(faker.name().lastName(), session);
		socketUsers.add(socketUser);
		// 回報給 client
		session.getAsyncRemote().sendText("Server 說: 建立成功, session id: " + session.getId());
	}
	
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		System.out.println("Client 傳送訊息: " + message);
		SocketUser socketUser = socketUsers.stream().filter(su -> su.getSession().equals(session)).findFirst().get();
		String data = "%s 說: %s 有 %d 個字 <span style='font-size: 9px;color: gray;'>(%s)</span>";
		data = String.format(data, socketUser.getName(), message, message.length(), new Date());
		final String finalData = data;
		socketUsers.forEach(su -> {
				if(su.getSession().isOpen()) {
					su.getSession().getAsyncRemote().sendText(finalData);
				}
			}
		);
		
	}
	
	@OnClose
	public void onClose(Session session) {
		SocketUser socketUser = socketUsers.stream().filter(su -> su.getSession().equals(session)).findFirst().get();
		socketUsers.remove(socketUser);
		System.out.println("Client 要求關閉連線: " + session.getId());
	}
	
}
