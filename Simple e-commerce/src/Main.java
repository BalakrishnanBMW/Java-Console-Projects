import order.Order;
import payment.Payment;
import user.*;
import inventory.*;
import java.util.*;

public class Main {

	public static void main(String [] args) {
		System.out.println();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		int choice_lr = 0;
		do {
			System.out.print("1. Buyer  2. Seller  3.Exit\nWho are you? : ");
			choice = sc.nextInt();
			sc.nextLine();
			System.out.println();

			switch(choice) {
				case 1 -> {
					System.out.println("Time to Purchase");
					System.out.println("1.Buyer Login  2.Buyer Register  3.Exit");
					System.out.print("Already User(1) or New User(2) : ");
					choice_lr = sc.nextInt();
					sc.nextLine();
					System.out.println();
					switch(choice_lr) {
						case 1 -> {
							System.out.println("Buyer Login");
							System.out.print("\tMail : ");
							String mail = sc.nextLine();
							System.out.print("\tPassword : ");
							String password = sc.nextLine();
							System.out.println();
							User u = User.checkUserForLogin(mail, password, Buyer.getBuyersList());
							if(u != null) {
								System.out.println("Logged in successful");
								System.out.println();
                                buyerMenu((Buyer)u);
							} else {
								System.out.println("Incorrect Mail or Password. Try Again or Register");
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
							if(!User.checkUserMailAlreadyExists(mail, Buyer.getBuyersList())) {
								Buyer buyer = new Buyer(name, mail, address, password);
								System.out.println("Succesfully Registered");
								System.out.println();
								buyerMenu(buyer);
							} else {
								System.out.println("Mail already registered Try Different mail or Login");
								System.out.println();
							}
						}
					}
				}
				case 2 -> {
					System.out.println("Time to Sell");
					System.out.println("1.Seller Login  2.Seller Register  3.Exit");
					System.out.print("Already User(1) or New User(2) : ");
					choice_lr = sc.nextInt();
					sc.nextLine();
					System.out.println();
					switch(choice_lr) {
						case 1 -> {
							System.out.println("Seller Login");
							System.out.print("\tMail : ");
							String mail = sc.nextLine();
							System.out.print("\tPassword : ");
							String password = sc.nextLine();
							System.out.println();
							User u = User.checkUserForLogin(mail, password, Seller.getSellersList());
							if(u != null) {
								System.out.println("Logged in successful");
								System.out.println();
								sellerMenu((Seller)u);
							} else {
								System.out.println("Incorrect Mail or Password. Try Again or Register");
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
							if(!User.checkUserMailAlreadyExists(mail, Seller.getSellersList())) {
								Seller seller = new Seller(name, mail, address, password);
								System.out.println("Succesfully Registered");
								System.out.println();
								sellerMenu(seller);
							} else {
								System.out.println("Mail already registered Try Different mail or Login");
								System.out.println();
							}
						}
					}
				}
			}
		} while(choice>0 && choice<3);
		System.out.println();
	}


	public static void buyerMenu(Buyer buyer) {
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		Inventory inv = new Inventory();
		do {
			System.out.println("\n\n\tMenu");
			System.out.print("1.Profile  2.List Inventory  3.View Cart  4.Order History  5.Log out\nEnter Option> ");
			choice = sc.nextInt();
			sc.nextLine();
			System.out.println();

			switch(choice) {

				case 1 -> {
					System.out.println("User Profile");
					System.out.println(buyer);
					System.out.println();
				}
				case 2 -> {
					System.out.println("Inventories");
					List<Product> l = inv.getInventoryList();
					for(Product p : l) {
						System.out.println(p);
					}
					System.out.print("\n\t Sub Menu \n1.Add to cart 2.Place Order 3.Back to Menu\nEnter option> ");
					int ch = sc.nextInt();
					sc.nextLine();
					System.out.println();
					switch(ch) {
						case 1 -> {
							System.out.print("Enter the product id which you want to add to cart : ");
							int pid = sc.nextInt();
							sc.nextLine();
							Product p = inv.getProductById(pid);
							buyer.addToCart(p);
							System.out.println();
						}
						case 2 -> {
							System.out.print("Enter the product id which you want to place order : ");
							int pid = sc.nextInt();
							sc.nextLine();

							Product p = inv.getProductById(pid);
							System.out.println("Product : "+p.getProductName()+"\nProduct Price:"+p.getPricePerUnit());
							System.out.print("Enter How many item do you want to order : ");
							int count = sc.nextInt();
							sc.nextLine();

							if(inv.validateProduct(pid, count)) {
								p.setCount(p.getCount() - count);
								Seller s = Seller.getSellerById(p.getSellerId());
								System.out.println(p.getProductName() + "\nNos = " + count + "\nprice = "+ count*p.getPricePerUnit());
								Order soldProd = new Order(p.getProductName(), count, p.getPricePerUnit(), buyer, s);
								System.out.print("Enter the Payment mode : (1.credit card, 2.UPI, 3.POD) : ");
								String paymentMethod = new String();
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
								}
								Payment payment = new Payment(soldProd, paymentMethod);
								System.out.println("You sucessfully ordered the product");
                                s.putSoldHistory(soldProd);
								buyer.putOrderHistory(soldProd);
								buyer.putPayments(payment);
								s.recievedPayments(payment);
								System.out.println(payment);
							} else  {
								System.out.println("Product is less in count");
							}
							System.out.println();

						}
					}
				}
				case 3 -> {
					System.out.println("Your Cart");
					List<Product> cart = buyer.getCart();
					for(Product p : cart) {
						System.out.println(p);
					}
					System.out.print("\n\t Sub Menu \n1.Remove from cart 2.Place Order 3.Back to Menu\nEnter option> ");
					int ch = sc.nextInt();
					sc.nextLine();
					switch(ch) {
						case 1 -> {
							System.out.print("Enter the product id which you want to remove from cart : ");
							int pid = sc.nextInt();
							sc.nextLine();
							Product p = inv.getProductById(pid);
							buyer.removeFromCart(p);
							System.out.println();
						}
						case 2 -> {
							System.out.println("Enter the product id which you want to place order : ");
							int pid = sc.nextInt();
							sc.nextLine();

							Product p = inv.getProductById(pid);
							System.out.println("Product : "+p.getProductName()+"\nProduct Price:"+p.getPricePerUnit());
							System.out.print("Enter How many item do you want to order : ");
							int count = sc.nextInt();
							sc.nextLine();

							if(inv.validateProduct(pid, count)) {
								p.setCount(p.getCount() - count);
								Seller s = Seller.getSellerById(p.getSellerId());
								System.out.println(p.getProductName() + "\nNos = " + count + "\nprice = "+ count*p.getPricePerUnit());
								Order soldProd = new Order(p.getProductName(), count, p.getPricePerUnit(), buyer, s);
								System.out.print("Enter the Payment mode : (1.credit card, 2.UPI, 3.POD) : ");
								String paymentMethod = new String();
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
								}
								Payment payment = new Payment(soldProd, paymentMethod);
								System.out.println("You sucessfully ordered the product");
								s.putSoldHistory(soldProd);
								buyer.putOrderHistory(soldProd);
								buyer.putPayments(payment);
								s.recievedPayments(payment);
								System.out.println(payment);
							} else  {
								System.out.println("Product is less in count");
							}
							System.out.println();
						}
					}
				}

				case 4 -> {
					System.out.println("Order History");
					List<Order> orderHist = buyer.getOrderHistory();
					System.out.println("Product | Nos | Price ");
					for(Order o : orderHist) {
						System.out.println(o.getProductName() + " | " + o.getCount() + " | " + o.getPricePerCount() * o.getCount());
					}
					System.out.println();
					System.out.print("Enter 1 to payment details or 2 to exit : ");
					int temp = sc.nextInt();
					if(temp == 1) {
						System.out.print("Enter Order id to view :  ");
						int oid = sc.nextInt();
						Payment p = buyer.getPaymentById(oid);
						System.out.println(p);
					}
					System.out.println();

				}


			}

		} while(choice>0 && choice <5);
		System.out.println();
	}


	public static void sellerMenu(Seller seller) {
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n\n\tMenu");
			System.out.print("1.Profile  2.My Inventory  3.Add new inventory\n4.Sold history 5.Logout\n\nEnter Option> ");
			choice = sc.nextInt();
			sc.nextLine();
			System.out.println();

			switch(choice) {

				case 1 -> {
					System.out.println("User Profile");
					System.out.println(seller);
					System.out.println();
				}
				case 2 -> {
					System.out.println("Your Inventories");
					List<Product> myInv = seller.getMyInventories();
					for(Product p : myInv) {
						System.out.println(p);
					}
					System.out.print("\n\t Sub Menu \n1.Update 2.Delete 3.Back to Menu\nEnter option> ");
					int ch = sc.nextInt();
					sc.nextLine();
					switch(ch) {
						case 1 -> {
							System.out.println("Update Product");
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
							if(seller.updateProduct(pid,productName,count,pricePerUnit)) {
								System.out.println("Update success");
							} else {
								System.out.println("Something went wrong");
							}
							System.out.println();
						}
						case 2 -> {
							System.out.println("Delete Product");
							System.out.print("Enter the product id which you want to delete : ");
							int pid = sc.nextInt();
							sc.nextLine();
							seller.deleteProduct(pid);
							System.out.println("Product deleted");
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
					System.out.println();
				}
				case 4 -> {
					System.out.println("Your sold products details");
					List<Order> soldProd  = seller.getSoldItems();
					System.out.println("Product | units | Amount Paid");
					for(int i=soldProd.size()-1; i>=0; i--) {
						System.out.println(soldProd.get(i).getProductName()+" | " +soldProd.get(i).getCount() +" | "+(soldProd.get(i).getCount()*soldProd.get(i).getPricePerCount()));
					}
					System.out.println();
				}
			}
			
		} while (choice>0 && choice<5);
		System.out.println();
	}


}