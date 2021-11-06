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
import com.google.gson.Gson;

import websocket.server.entity.ChatUser;
import websocket.server.entity.SocketUser;

@ServerEndpoint("/chat/ws/server")
public class ChatWSServer {
	
	private static CopyOnWriteArraySet<ChatUser> chatUsers = new CopyOnWriteArraySet<>();
	private Gson gson = new Gson();
	
	@OnOpen
	public void onOpen(Session session) {
		// 回報給 client
		session.getAsyncRemote().sendText(session.getId());
	}
	
	@OnMessage
	public void onMessage(String jsonstring, Session session) throws IOException {
		final ChatUser chatUser = gson.fromJson(jsonstring, ChatUser.class);
		// 判斷是否是第一次聯入
		//if(!chatUsers.stream().filter(cu -> cu.getNikename().equals(chatUser.getNikename())).findAny().isPresent()) {
			chatUser.setSession(session);
			chatUsers.add(chatUser); // 因為是 Set, 所以相同的元素不會加入
		//}
		System.out.println(chatUsers);
		// 判斷是否有傳送data資料
		if(chatUser.getData().length() > 0) {
			chatUsers.forEach(cu -> {
				if(cu.getSession().isOpen()) {
					synchronized(cu) {
						cu.getSession().getAsyncRemote().sendText(jsonstring);
					}
				}
			});
		}
	}
	
	@OnClose
	public void onClose(Session session) {
		ChatUser chatUser = chatUsers.stream().filter(su -> su.getSession().equals(session)).findFirst().get();
		chatUsers.remove(chatUser);
	}
	
}
