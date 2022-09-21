package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("E-mail: ");
        String email = sc.next();
        System.out.print("Data de nascimento: ");
        LocalDate birthday = LocalDate.parse(sc.next(), dateFormat);

        Client client = new Client(name, email, birthday);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String status = sc.next().toUpperCase();

        Order order = new Order(Instant.now(), OrderStatus.valueOf(status), client);

        System.out.print("How many items to this order? ");
        int quantity = sc.nextInt();

        for (int i = 0; i < quantity; i++ ) {
            System.out.println("Enter #" + (i + 1) + " item data: ");
            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();

            Product product = new Product(productName, productPrice);

            System.out.print("Quantity: ");
            int productQuantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(productQuantity, product.getPrice(), product);

            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println("Order Summary: ");
        System.out.println(order);

        sc.close();
    }
}
