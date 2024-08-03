import inventory.Inventory;
import inventory.Product;
import order.Order;
import payment.Payment;
import user.Buyer;
import user.Seller;
import user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.print("1. Buyer  2. Seller  3.Exit\n\tWho are you? : ");
            choice = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (choice) {
                case 1 -> {
                    System.out.println("Hello Buyer. It's purchase time.");
                    System.out.println("1.Login | 2.Register | 3.Exit");
                    System.out.print("\tEnter option> ");
                    int ch = sc.nextInt();
                    sc.nextLine();
                    System.out.println();
                    switch (ch) {
                        case 1 -> {
                            System.out.println("Buyer Login");

                            System.out.print("\tMail : ");
                            String mail = sc.nextLine();
                            System.out.print("\tPassword : ");
                            String password = sc.nextLine();

                            System.out.println();

                            User u = User.checkUserForLogin(mail, password, Buyer.getBuyers());
                            if (u != null) {
                                System.out.println("\nLogged in successful");
                                System.out.println();
                                buyerMenu((Buyer) u);
                            } else {
                                System.out.println("\nIncorrect Mail or Password. Try Again or Register");
                                System.out.println();
                            }
                        }
                        case 2 -> {
                            System.out.println("Buyer Register");

                            System.out.print("\tName : ");
                            String name = sc.nextLine();
                            System.out.print("\tMail : ");
                            String mail = sc.nextLine();
                            System.out.print("\tAddress : ");
                            String address = sc.nextLine();
                            System.out.print("\tPassword : ");
                            String password = sc.nextLine();

                            System.out.println();

                            if (!User.checkUserMailAlreadyExists(mail, Buyer.getBuyers())) {
                                Buyer buyer = new Buyer(name, mail, address, password);
                                System.out.println("\nSuccessfully Registered");
                                System.out.println();
                                buyerMenu(buyer);
                            } else {
                                System.out.println("\nMail already registered Try Different mail or Login");
                                System.out.println();
                            }
                        }
                    }

                }
                case 2 -> {
                    System.out.println("Hello Seller. It's Selling time.");
                    System.out.println("1.Login | 2.Register | 3.Exit");
                    System.out.print("\tEnter option> ");
                    int ch = sc.nextInt();
                    sc.nextLine();
                    System.out.println();
                    switch (ch) {
                        case 1 -> {
                            System.out.println("Seller Login");

                            System.out.print("\tMail : ");
                            String mail = sc.nextLine();
                            System.out.print("\tPassword : ");
                            String password = sc.nextLine();

                            System.out.println();

                            User u = User.checkUserForLogin(mail, password, Seller.getSellers());
                            if (u != null) {
                                System.out.println("\nLogged in successful");
                                System.out.println();
                                sellerMenu((Seller) u);
                            } else {
                                System.out.println("\nIncorrect Mail or Password. Try Again or Register");
                                System.out.println();
                            }
                        }
                        case 2 -> {
                            System.out.println("Seller Register");

                            System.out.print("\tName : ");
                            String name = sc.nextLine();
                            System.out.print("\tMail : ");
                            String mail = sc.nextLine();
                            System.out.print("\tAddress : ");
                            String address = sc.nextLine();
                            System.out.print("\tPassword : ");
                            String password = sc.nextLine();

                            System.out.println();

                            if (!User.checkUserMailAlreadyExists(mail, Seller.getSellers())) {
                                Seller seller = new Seller(name, mail, address, password);
                                System.out.println("\nSuccessfully Registered");
                                System.out.println();
                                sellerMenu(seller);
                            } else {
                                System.out.println("\nMail already registered Try Different mail or Login");
                                System.out.println();
                            }
                        }
                    }
                }
            }
        } while (choice > 0 && choice < 3);
    }

    private static void buyerMenu(Buyer buyer) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();

        do {
            System.out.println("\n\n\tMenu");
            System.out.print("1.Profile | 2.List Inventory | 3.View Cart \n4.Order History | 5.Log out\n\tEnter Option> ");
            choice = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch(choice) {
                case 1 -> {
                    userProfile(buyer);
                }
                case 2 -> {
                    System.out.println("Inventory List");
                    if(displayInventoryList(inventory.getInventoryList())) break;

                    System.out.print("\t Sub Menu \n1.Add to cart 2.Place Order 3.Back to Menu\n\tEnter option> ");
                    int ch = sc.nextInt();
                    sc.nextLine();
                    System.out.println();

                    switch(ch){
                        case 1 -> {
                            System.out.print("\tEnter product id  which you want to add to cart : ");
                            int pid = sc.nextInt();
                            sc.nextLine();

                            buyer.addToMyCart(pid);
                            System.out.println("\nProduct added to cart Successfully.\n");
                        }
                        case 2 -> {
                            placeOrder(buyer);
                        }
                    }

                }
                case 3 -> {
                    System.out.println("Your Cart");
                    if(displayInventoryList(buyer.getMyCart())) break;

                    System.out.print("\tSub Menu \n1.remove from cart 2.Place Order 3.Back to Menu\n\tEnter option> ");
                    int ch = sc.nextInt();
                    sc.nextLine();
                    System.out.println();

                    switch(ch){
                        case 1 -> {
                            System.out.print("Enter product id  which you want to remove from cart : ");
                            int pid = sc.nextInt();
                            sc.nextLine();
                            Product product = inventory.getInventoryList().get(pid);
                            buyer.removeFromMyCart(product);
                            System.out.println();
                            System.out.println("\nProduct removed from cart Successfully.\n");
                        }
                        case 2 -> {
                            placeOrder(buyer);
                        }
                    }

                }
                case 4 -> {
                    System.out.println("Your orders");
                    displayMyOrders(buyer.getMyOrders());
                }
                case 5 -> {
                    System.out.println("Logged out successfully");
                    System.out.println();
                }
            }

        }while(choice>0 && choice<5);

    }

    private static void sellerMenu(Seller seller) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n\tMenu");
            System.out.print("1.Profile | 2.My Inventory | 3.Add new inventory\n4.Sold history | 5.Logout\n\n\tEnter Option> ");
            choice = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (choice) {

                case 1 -> {
                    userProfile(seller);
                }
                case 2 -> {
                    System.out.println("Your Inventories");
                    if(displayInventoryList(seller.getMyProducts())) break;

                    System.out.print("\t Sub Menu \n1.Update 2.Delete 3.Back to Menu\n\tEnter option> ");
                    int ch = sc.nextInt();
                    sc.nextLine();
                    switch(ch) {
                        case 1 -> {
                            System.out.println("\nUpdate Product");

                            System.out.print("Enter the product id which you want to update : ");
                            int pid = sc.nextInt();
                            sc.nextLine();
                            System.out.print("\tEnter Product name : ");
                            String productName = sc.nextLine();
                            System.out.print("\tEnter stock count : ");
                            int count = sc.nextInt();
                            sc.nextLine();
                            System.out.print("\tEnter Price per unit : ");
                            double pricePerUnit = sc.nextDouble();
                            sc.nextLine();

                            if(seller.updateProduct(pid,productName,count,pricePerUnit))
                                System.out.println("Product Updated successfully");
                            else
                                System.out.println("Hmm, something went wrong.");

                            System.out.println();
                        }
                        case 2 -> {
                            System.out.println("Delete Product");
                            System.out.print("Enter the product id which you want to delete : ");
                            int pid = sc.nextInt();
                            sc.nextLine();

                            if(seller.deleteProduct(pid))
                                System.out.println("Product Deleted successfully");
                            else
                                System.out.println("Hmm, something went wrong.");

                            System.out.println();
                        }
                    }

                }
                case 3 -> {
                    System.out.println("Add new Product");
                    System.out.print("\tEnter Product name : ");
                    String productName = sc.nextLine();
                    System.out.print("\tEnter stock count : ");
                    int count = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\tEnter Price per unit : ");
                    double pricePerUnit = sc.nextDouble();
                    sc.nextLine();
                    seller.addProduct(productName, count, pricePerUnit);
                    System.out.println("\nYour Product is added to inventory Successfully");
                }
                case 4 -> {
                    System.out.println("Sold Products");
                    displayMyOrders(seller.getMySoldProducts());
                }
                case 5 -> {
                    System.out.println("Logged out successfully");
                    System.out.println();
                }
            }
        }while(choice>0 && choice<5);
    }

    private static void userProfile(User user) {
        System.out.println("Welcome " + user.getName());
        System.out.println("============================");
        System.out.println("User Id : " + user.getUserId());
        System.out.println("Name : " + user.getName() + " (" + user.getUserType() + ")");
        System.out.println("Mail : " + user.getMail());
        System.out.println("Address : " + user.getAddress());
        System.out.println("============================");
        System.out.println();
    }

    private static boolean displayInventoryList(HashMap<Integer, Product> inventoryList) {
        if(inventoryList.isEmpty()){
            System.out.println("List is Empty");
            return true;
        }
        System.out.println("Product Id | Name | price | stock count");
        System.out.println("=========================================");
        for(Map.Entry<Integer, Product> entry : inventoryList.entrySet()) {
            Product product = entry.getValue();
            System.out.println(product.getProductId() + " | " + product.getProductName() + " | " + product.getPricePerUnit()  + " | " + product.getCount());
        }
        System.out.println("=========================================");
        System.out.println();
        return false;
    }

    private static boolean displayInventoryList(List<Integer> inventoryList) {
        if(inventoryList.isEmpty()){
            System.out.println("List is Empty");
            return true;
        }
        Inventory inventory = new Inventory();
        System.out.println("Product Id | Name | price | stock count");
        System.out.println("=========================================");
        for(int i : inventoryList) {
            Product product = inventory.getInventoryList().get(i);
            if(product != null)
                System.out.println(product.getProductId() + " | " + product.getProductName() + " | " + product.getPricePerUnit() + " | " + product.getCount());
        }
        System.out.println("=========================================");
        System.out.println();
        return false;
    }

    private static boolean displayMyOrders(HashMap<Integer, Order> orders) {
        if(orders.isEmpty()) {
            System.out.println("List is Empty");
            return true;
        }
        System.out.println("Order Id | Product Name | Nos | Amount Paid");
        System.out.println("=========================================");
        for(Map.Entry<Integer, Order> entry : orders.entrySet()) {
            Order order = entry.getValue();
            System.out.println(order.getOrderId() + " | " + order.getProductName() + " | " + order.getCount() + " | " + order.getPricePerUnit()*order.getCount());
        }
        System.out.println("=========================================");
        System.out.println();
        return false;
    }

    private static void placeOrder(Buyer buyer) {
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);

        System.out.print("\tEnter product id which you want to place order : ");
        int pid = sc.nextInt();
        sc.nextLine();

        Product product = inventory.getInventoryList().get(pid);
        System.out.println("\nProduct : "+product.getProductName()+"\nProduct Price:"+product.getPricePerUnit());

        System.out.print("\n\tEnter How many item do you want to order : ");
        int count = sc.nextInt();
        sc.nextLine();

        if(inventory.validateProduct(product, count)) {
            product.setCount(product.getCount() - count);
            Seller seller = product.getSeller();
            System.out.println(product.getProductName() + "\nNos = " + count + "\nprice = "+ count*product.getPricePerUnit());
            Order soldProd = new Order(product.getProductName(), count, product.getPricePerUnit(), buyer, seller);
            System.out.print("\n\tEnter the Payment mode : (1.credit card, 2.UPI, 3.POD) : ");
            String paymentMethod = "";
            int paymentOption = sc.nextInt();
            sc.nextLine();
            switch (paymentOption) {
                case 1 -> {
                    paymentMethod = "Credit Card";
                }
                case 2 -> {
                    paymentMethod = "UPI";
                }
                case 3 -> {
                    paymentMethod = "Pay On Delivery";
                }
                default -> {
                    break;
                }
            }
            Payment payment = new Payment(soldProd, paymentMethod);
            System.out.println("You successfully ordered the product");

            seller.addToMySoldProducts(soldProd);
            buyer.addToMyOrders(soldProd);
            buyer.addToMadePayments(payment);
            seller.addToRecievedPayments(payment);
            System.out.println(payment);
        } else  {
            System.out.println("Product is less in count");
        }
        System.out.println();
    }
}
