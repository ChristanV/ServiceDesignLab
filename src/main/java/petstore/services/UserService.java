package petstore.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import petstore.model.User;

/**
 * Created by ChristanV on 2017/08/06.
 */
@Service
public class UserService {
    private static Map<String, User> users = new HashMap<String, User>();
    private static int userIndex = 3;

    //populate users
    static {
        User a = new User("1", "User1","password1");
        users.put("1",a);
        User b = new User("2", "User2","password2");
        users.put("2",b);
        User c = new User("3", "User3","password3");
        users.put("3",c);
    }

    public static List<User> list(){
        return new ArrayList<User>(users.values());
    }

    public static User create(User user) {
        userIndex += 1;
        user.setUserid(String.valueOf(userIndex));
        users.put(String.valueOf(userIndex), user);
        return user;
    }

    public static User get(String id) {
        return users.get(id);
    }

    public static User find(String username){
        List<User> usersList = list();
        return usersList.stream().filter(p -> p.getUsername().equals(username)).findFirst().get();
    }

    public static User delete(String id) {
        return users.remove(id);
    }

    public static User update(String id, User user) {
        User updatedUser = users.get(id);
        if (updatedUser != null) {
            user.setUserid(updatedUser.getUserid());
            users.put(id, user);
        }
        return users.get(id);
    }
    
    public static String login(String id, String username, String password) {
        User user = users.get(id);
        if (!user.isLoggedIn() && user.getUsername().equals(username) && user.getPassword().equals(password)){
            user.setLoggedInStatus(true);
            users.put(id, user);
            return  "Logged in";
        }
        return  "Already logged in";
    }

    public static String logout(String id) {
        User user = users.get(id);
        if (user.isLoggedIn()) {
            user.setLoggedInStatus(false);
            users.put(id, user);
            return "Logged out";
        }
        return "Logout failed";
    }
}
