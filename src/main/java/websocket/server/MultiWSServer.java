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

@ServerEndpoint("/multi/ws/server")
public class MultiWSServer {
	
	private static CopyOnWriteArraySet<Session> sessions = new CopyOnWriteArraySet<Session>();
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("Client 要求建立連線 session is: " + session.getId());
		// 加入到 sessions 容器中
		sessions.add(session);
		// 回報給 client
		session.getAsyncRemote().sendText("Server 說: 建立成功, session id: " + session.getId());
	}
	
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		System.out.println("Client 傳送訊息: " + message);
		String data = "Server 說: %s 有 %d 個字 <span style='font-size: 9px;color: gray;'>(%s)</span>";
		data = String.format(data, message, message.length(), new Date());
		final String finalData = data;
		sessions.forEach(s -> {
				if(s.isOpen()) {
					s.getAsyncRemote().sendText(finalData);
				}
			}
		);
		
	}
	
	@OnClose
	public void onClose(Session session) {
		sessions.remove(session);
		System.out.println("Client 要求關閉連線: " + session.getId());
	}
	
}
