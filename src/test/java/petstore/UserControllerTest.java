package petstore;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import petstore.controller.UserController;
import petstore.model.User;
import petstore.services.UserService;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

/**
 * Created by ChristanV on 2017/08/07.
 */
public class UserControllerTest {
    @InjectMocks
    private UserController uc;

    @Mock
    private UserService userService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_User_Find(){
        User u = uc.find("User1");
        assertEquals("User1", u.getUsername());
    }

    @Test
    public void test_User_Login(){
        String u = uc.login("1", "User1", "password1");
        assertEquals(true, uc.find("User1").isLoggedIn());
    }

    @Test
    public void test_User_Logout(){
        String u = uc.logout("1");
        assertEquals(false, uc.find("User1").isLoggedIn());
    }

}
