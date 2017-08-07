package petstore.controller;

import java.util.List;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import petstore.model.Order;
import petstore.services.OrderService;

/**
 * Created by ChristanV on 2017/08/07.
 */
@Api(basePath = "/orders", value = "orders", description = "Operations with orders", produces = "application/json")
@RestController
@RequestMapping("api/v1/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("orders")
    public List<Order> getOrders() {
        return orderService.list();
    }

    @RequestMapping(value = "orders", method = RequestMethod.POST)
    public String placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

    @RequestMapping(value = "orders/{id}", method = RequestMethod.PUT)
    public String cancelOrder(@PathVariable String  id) {
        return orderService.cancelOrder(id);
    }
}
