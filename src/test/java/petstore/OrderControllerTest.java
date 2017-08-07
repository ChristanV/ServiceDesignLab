package petstore;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import petstore.controller.OrderController;
import petstore.model.Order;
import petstore.model.Pet;
import petstore.services.PetStoreService;


import static org.junit.Assert.assertEquals;

/**
 * Created by ChristanV on 2017/08/07.
 */
public class OrderControllerTest {
    @InjectMocks
    private OrderController oc;

    @Mock
    private PetStoreService petStoreService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_Order_Place(){
        Order order = new Order("2");
        oc.placeOrder(order);

        Pet pet = petStoreService.findPet("2");

        assertEquals(true, pet.getPetStatus());
    }

    @Test
    public void test_Order_Cancel(){
        Order order = new Order("2");
        oc.placeOrder(order);
        oc.cancelOrder(order.getPetOrdered());

        Pet pet = petStoreService.findPet("2");

        assertEquals(false, pet.getPetStatus());
    }

}
