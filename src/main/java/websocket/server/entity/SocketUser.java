package websocket.server.entity;

import java.util.Objects;

import javax.websocket.Session;

public class SocketUser {
	private String name;
	private Session session;
	
	public SocketUser() {
		
	}
	
	public SocketUser(String name, Session session) {
		this.name = name;
		this.session = session;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, session);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SocketUser other = (SocketUser) obj;
		return Objects.equals(name, other.name) && Objects.equals(session, other.session);
	}
	
	
	
}
