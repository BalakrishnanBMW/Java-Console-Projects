package user;

import java.util.*;

public class Session {
	
	private HashMap<String, String> session;

	public Session() {
		this.session = new HashMap<String, String>();
	}

	public void setSession(String key, String value) {
		this.session.put(key,value);
	}

	public boolean isSessionSet() {
		return this.session != null;
	}

	public void unSetSession() {
		session.clear();
	}

}