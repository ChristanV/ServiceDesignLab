package petstore.model;

/**
 * Created by ChristanV on 2017/07/31.
 */
public class Order {
    private String orderId;
    private boolean orderActive;
    private String petId;

    public Order(String orderId, boolean orderActive, String petId) {
        this.orderId = orderId;
        this.orderActive = orderActive;
        this.petId = petId;
    }

    public Order(String petId) {
        this.orderActive = false;
        this.petId = petId;
    }

    public Order(){

    }

    public String getPetOrdered() {
        return petId;
    }

    public void setPetOrdered(String petOrdered) {
        this.petId = petOrdered;
    }

    public boolean isOrderActive() {
        return orderActive;
    }

    public void setOrderActive(boolean orderActive) {
        this.orderActive = orderActive;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
