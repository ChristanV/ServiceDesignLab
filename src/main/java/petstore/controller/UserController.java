package petstore.controller;

import java.util.List;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import petstore.model.User;
import petstore.services.UserService;

/**
 * Created by ChristanV on 2017/08/06.
 */
@Api(basePath = "/users", value = "users", description = "Operations with users", produces = "application/json")
@RestController
@RequestMapping("api/v1/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public List<User> list(){
        return userService.list();
    }

    @RequestMapping(method = RequestMethod.POST, value = "users")
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @RequestMapping(value = "users/{username}", method = RequestMethod.GET)
    public User find(@PathVariable String username){
        return userService.find(username);
    }
    @RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
    public User delete(@PathVariable String id){
        return userService.delete(id);
    }
    @RequestMapping(value = "users/{id}", method = RequestMethod.PUT)
    public User update(@RequestBody User user, @PathVariable String id){
        return userService.update(id, user);
    }

    @RequestMapping(value = "users/login/{id}/{username}/{password}", method = RequestMethod.PUT)
    public String login(@PathVariable String id,@PathVariable String username, @PathVariable String password){
        return userService.login(id, username, password);
    }

    @RequestMapping(value = "users/logout/{id}", method = RequestMethod.PUT)
    public String logout(@PathVariable String id){
        return userService.logout(id);
    }

}
