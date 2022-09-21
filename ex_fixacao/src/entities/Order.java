package entities;

import enums.OrderStatus;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private Instant moment;
    private OrderStatus status;

    Client client;
    private List<OrderItem> orderItemsList = new ArrayList<OrderItem>();

    public Order(){
    }

    public Order(Instant moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Instant getMoment(DateTimeFormatter instantFormatter) {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrderItemsList() {
        return orderItemsList;
    }

    public void addItem(OrderItem item) {
        orderItemsList.add(item);
    }

    public void removeItem(OrderItem item) {
        orderItemsList.remove(item);
    }

    public double total(){
        double sum = 0;
        for(OrderItem item : orderItemsList) {
            sum += item.subTotal();
        }
        return sum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(moment.atZone(ZoneId.systemDefault()) + "\n");
        sb.append("Order Status: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append(client + "\n");
        sb.append("Ordem items: ");

        for (OrderItem item : orderItemsList) {
            sb.append(item + "\n");
        }

        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
}
