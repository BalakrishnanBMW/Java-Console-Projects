package user;

import java.util.*;

public class User {

	static int autoInc = 1;
	private int userId;
	private String name;
	private String mail;
	private String address;
	private String userType;
	private String password;

	
	public User(String name, String mail, String address, String userType, String password) {
		this.setUserId(autoInc++);
		this.setName(name);
		this.setMail(mail);
		this.setAddress(address);
		this.setUserType(userType);
		this.password = password;
	}




	public String toString() {
		return ("User Id : " + this.getUserId() +
			"\nName : " + this.getName() + " (" + this.getUserType() + ")" +
			"\nMail : " + this.getMail() + "\nAddress : " + this.getAddress());
	}

	public static User checkUserForLogin(String mail, String password, List<? extends User> userList) {
		for(User user : userList) {
			if(mail.equals(user.getMail()) && password.equals(user.password)) {
				return user;
			}
		}
		return null;
	}

	public static boolean checkUserMailAlreadyExists(String mail, List<? extends User> userList) {
		for(User u : userList) {
			if(mail.equals(u.getMail())) {
				return true;
			}
		}
		return false;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
}