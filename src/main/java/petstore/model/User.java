package petstore.model;

/**
 * Created by ChristanV on 2017/07/31.
 */
public class User {
    private String userId;
    private String username;
    private String password;
    private boolean loggedInStatus;

    public User(){

    }
    public User(String id , String username, String password){
        this.userId = id;
        this.username = username;
        this.password = password;
        this.loggedInStatus = false;
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.loggedInStatus = false;
    }

    public String getUserid() {
        return userId;
    }

    public void setUserid(String userid) {
        this.userId = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedInStatus;
    }

    public void setLoggedInStatus(boolean loggedin) {
        this.loggedInStatus = loggedin;
    }
}
