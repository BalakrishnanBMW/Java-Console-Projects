package user;

import java.util.HashMap;
import java.util.List;

public class User {

    private static int id = 1;
    private int userId;
    private String name;
    private String mail;
    private String address;
    private String userType;
    private String password;


    /**
     * User class takes information (such as name, mail, address, userType, password)
     * while creating User object. <br/>
     * <b>User is the {@code parent class} of {@code Seller} and {@code Buyer} class.</b>
     * @param name Name of the user.
     * @param mail Unique mail of the user.
     * @param address Address of the user.
     * @param userType Usertype : whether Buyer or Seller.
     * @param password Password of the user.
     *
     */
    public User(String name, String mail, String address, String userType, String password) {
        this.setName(name);
        this.setMail(mail);
        this.setAddress(address);
        this.setUserType(userType);
        this.setPassword(password);
        this.setUserId(this.incId());
    }

    /**
     * The method {@code incId()} gives the unique id to each user
     * @return id
     */
    private int incId() {
        return id++;
    }

    /**
     * Getter for userId
     * @return userId
     */
    public int getUserId() {
        return this.userId;
    }

    /**
     * Setter for userId
     * @param userId
     */
    private void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Getter for user name
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for user name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for user mail
     * @return mail
     */
    public String getMail() {
        return this.mail;
    }

    /**
     * Setter for user mail
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Getter for address
     * @return address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Setter for address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter for UserTpe - Whether Buyer or Seller
     * @return userType
     */
    public String getUserType() {
        return this.userType;
    }

    /**
     * Setter for UserType - Whether Buyer or Seller
     * @param userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * The method {@code getPassword()} returns the user password.<br/> can access within the class only.
     * @return password
     */
    private String getPassword() {
        return this.password;
    }

    /**
     * The method {@code setPassword()} sets the password of the user. <br/>
     * Can access within the class only.
     * @param password
     */
    private void setPassword(String password) {
        this.password = password;
    }

    /**
     * Check whether the user is already registered.
     * @param mail
     * @param password
     * @param userList
     * @return User or null
     */
    public static User checkUserForLogin(String mail, String password, HashMap<String, ? extends User> userList) {
        if(userList.containsKey(mail)){
            User user = userList.get(mail);
            if(user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Ensure that the mail is not registered.
     * @param mail
     * @param userList
     * @return boolean
     */
    public static boolean checkUserMailAlreadyExists(String mail, HashMap<String, ? extends User> userList) {
        if(userList.containsKey(mail)) {
            return true;
        }
        return false;
    }

}
