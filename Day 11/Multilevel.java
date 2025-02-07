class Order {
    int orderId;
    String orderDate;

    public Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public void getStatus() {
        System.out.println("Order is placed->" + orderDate + "--" + orderId);
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    public ShippedOrder(String trackingNumber, int orderId, String orderDate) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public void getStatus() {
        System.out.println("Order is shipped->" + trackingNumber + "--" + orderDate + "--" + orderId);
    }
}

class DeliveredOrders extends ShippedOrder {
    String deliveryDate;

    public DeliveredOrders(String deliveryDate, String trackingNumber, int orderId, String orderDate) {
        super(trackingNumber, orderId, orderDate);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public void getStatus() {
        System.out.println("Order is delivered->" + deliveryDate + trackingNumber + "--" + orderDate + "--" + orderId);
    }
}

class Multilevel {
    public static void main(String[] args) {
        Order order = new Order(1, "17Mar");
        ShippedOrder ship = new ShippedOrder("83", 2, "2Feb");
        DeliveredOrders deliver = new DeliveredOrders("4Feb", "84", 3, "1Feb");
        order.getStatus();
        ship.getStatus();
        deliver.getStatus();
    }
}
