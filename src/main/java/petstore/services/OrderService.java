package petstore.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petstore.model.Order;
import petstore.model.Pet;

/**
 * Created by ChristanV on 2017/08/07.
 */

@Service
public class OrderService {
    private static Map<String, Order> orders = new HashMap<String, Order>();
    private static int orderIndex = 1;

    //populate orders
    static {
        Order a = new Order("1", false, "1");
        orders.put("1", a);
    }

    @Autowired
    private static PetStoreService petStoreService;

    public static List<Order> list(){
        return new ArrayList<Order>(orders.values());
    }

    public static String placeOrder(Order order) {
        orderIndex += 1;
        List<Pet> pets = petStoreService.getPets();
        Pet pet = pets.stream().filter(p -> p.getPetId().equals(order.getPetOrdered())).findFirst().get();
        if (pet != null && !pet.getPetStatus()){
            order.setOrderId(String.valueOf(orderIndex));
            order.setOrderActive(true);
            pet.setPetStatus(true);
            petStoreService.updatePets(pet, order.getPetOrdered());
            order.setOrderId(String.valueOf(orderIndex));
            orders.put(String.valueOf(orderIndex), order);
            return "Ordered";
        }
        return "Pet already ordered";
    }

    public static String cancelOrder(String id) {
        List<Pet> pets = petStoreService.getPets();
        Order order = find(id);
        if (order.isOrderActive()) {
            Pet pet = pets.stream().filter(p -> p.getPetId().equals(order.getPetOrdered())).findFirst().get();
            if (pet != null && pet.getPetStatus()) {
                pet.setPetStatus(false);
                order.setOrderActive(false);
                petStoreService.updatePets(pet, order.getPetOrdered());
                orders.put(id, order);
                return "Cancelled";
            }
        }
        return "not cancelled";
    }

    public static Order find(String id){
        List<Order> orderList = list();
        return orderList.stream().filter(p -> p.getOrderId().equals(id)).findFirst().get();
    }


}
