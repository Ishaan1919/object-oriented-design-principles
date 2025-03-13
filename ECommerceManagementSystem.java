import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private int orderId;
    private List<Product> products;

    public Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayOrder() {
        System.out.println("\nOrder ID: " + orderId);
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
    }
}

class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void displayOrders() {
        System.out.println("\nCustomer: " + name + " - Orders:");
        for (Order order : orders) {
            order.displayOrder();
        }
    }
}

public class ECommerceManagementSystem {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Ross");
        Customer customer2 = new Customer("Chandler");

        Product product1 = new Product("Laptop", 1200.00);
        Product product2 = new Product("Phone", 800.00);
        Product product3 = new Product("Football", 150.00);

        Order order1 = new Order(101);
        order1.addProduct(product1);
        order1.addProduct(product2);

        Order order2 = new Order(102);
        order2.addProduct(product3);

        customer1.placeOrder(order1);
        customer2.placeOrder(order2);

        customer1.displayOrders();
        customer2.displayOrders();

//        Customer: Ross - Orders:
//
//        Order ID: 101
//        Products:
//        Laptop - 1200.0
//        Phone - 800.0
//
//        Customer: Chandler - Orders:
//
//        Order ID: 102
//        Products:
//        Football - 150.0
    }
}
