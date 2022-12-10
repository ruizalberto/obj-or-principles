//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//--------------------------------------------------
//
//	CLASS MyMain
//
//--------------------------------------------------
/**
 * This is the main class for the A03 Project of Alberto Ruiz,
 * representing the management of a grocery online shop<br>.
 */
public class MyMain {

	/**
	 * This function prints the menu by the screen to the user.<br>
	 * "This part of code is a result of consulting MyMain.java A03 Example Java Application".<br>
	 */
    public static void printMenu(){
        System.out.println();
		System.out.print("----------------\n");
		System.out.print("     MENU			  	  \n");
		System.out.print("----------------\n");
		System.out.print("0. Exit\n");
		System.out.print("1. Add Customer\n");
		System.out.print("2. Remove Customer\n");
		System.out.print("3. Display Customer Order History\n");
		System.out.print("4. Create New Order\n");
		System.out.print("5. Complete Order\n");
		System.out.print("6. Display Shop Menu\n");
		System.out.print("7. Add Food Item\n");
		System.out.print("8. Remove Food Item\n");
		System.out.print("9. Display All Customers List\n");
		System.out.print("10. Display All Customers Spending\n");
		System.out.println("");
	}

    
	/** 
	 * This function asks the user to enter a valid integer value (within a range) by keyboard.<br>
	 * "This part of code is a result of consulting MyMain.java A03 Example Java Application".<br>
	 * @param sc - The scanner getting input by keyboard.
	 * @param min - The lower bound value accepted.
	 * @param max - THe upper bound value accepted.
	 * @return The value entered by keyboard.
	 */
	public static int selectIntOption(Scanner sc, int min, int max){
		int res = -1;
		boolean validOption = false;
		while (!validOption) {
			System.out.print("Please enter an integer value within the range " + min + " and " + max + ": ");
			try {
				res = sc.nextInt();
				sc.nextLine();
				if ((res >= min) && (res <= max)){
                    validOption = true;
                } else {
					System.out.println("Sorry but the option must be within the range " + min + " and " + max);
                }
			} catch (Exception e) {
				System.out.println("Sorry you did not enter an integer and then press the return key");
				sc.next();
			}
		}
		return res;
	}

    
	/** 
	 * This function asks the user to enter a valid integer value by keyboard.<br>
	 * "This part of code is a result of consulting MyMain.java A03 Example Java Application".<br>
	 * @param sc - The scanner getting input by keyboard.
	 * @return The value entered by keyboard.
	 */
	public static int selectIntOption(Scanner sc){
		int res = -1;
		boolean validOption = false;
		while (!validOption) {
			try {
				res = sc.nextInt();
				sc.nextLine();
				validOption = true;
			} catch (Exception e) {
				System.out.println("Sorry you did not enter an integer and then press the return key");
				sc.next();
			}
		}
		return res;
	}

    
	/**
	 * This function asks the user to enter a valid String value by keyboard.<br>
	 * "This part of code is a result of consulting MyMain.java A03 Example Java Application".<br>
	 * @param sc - The scanner getting the input value by keyboard.
	 * @return - The value entered by keyboard.
	 */
	public static String selectStringOption(Scanner sc){
		String res = "";
		boolean validOption = false;
		while (!validOption) {
			try {
				res = sc.nextLine();
				if ((res.length() > 0)){
					validOption = true;
				} else {
					System.out.println("Sorry but the option must be a non-empty string");
				}
			} catch (Exception e) {
				System.out.println("Sorry you did not enter a String and then press the return key");
				sc.next();
			}
		}
		return res;
	}

	
	/** 
	 * This function attempts to find a customer in the shop.<br>
	 * @param buymie - The shop.
	 * @param myStr - The name of the customer to find.
	 * @return - The customer object if it is found; null if it is not.
	 */
	private static Customer findCustomer(ShopInt buymie, String myStr){
		for (Customer customers: buymie.getCustomerList()){
			if (customers.getName().equals(myStr)){
				System.out.println();
				System.out.println("Customer found!");
				return customers;
			}
		}
		return null;
	}

	
	/**
	 * This function asks the user to enter a name for the customer.<br> 
	 * @param sc - The scanner getting the input value by keyboard.
	 * @return The name of the customer.
	 */
	private static String enterName(Scanner sc){
		System.out.print("Please enter the name for the customer: ");
		return selectStringOption(sc);
	}

	
	/** 
	 * This function attempts to load the file with the food to the shop menu.<br>
	 * @param buymie - The shop.
	 */
	private static void writeFoodMenu(ShopInt buymie){
		String foodLocation = "./labs/assignments/A03/A03_Student_Java_Application/foodDatabase/menu.txt";
		String line = null;
		ArrayList<Food> menu = buymie.getMenu();
	
		try {
			FileReader fileReader = new FileReader(foodLocation);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
	
			while((line = bufferedReader.readLine()) != null) {
				String[] arrSplit = line.split(",");
				double price = Double.parseDouble(arrSplit[1]);
				Food addFood = new Food(arrSplit[0], price);
				menu.add(addFood);
			} 
	
			bufferedReader.close();         
		} catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '" + foodLocation + "'");                
		} catch(IOException ex) {
			System.out.println("Error reading file '" + foodLocation + "'");
		}

	}

	/**
	 * This function performs the interactive text-menu to the user.<br>
	 * "This part of code is a result of consulting MyMain.java A03 Example Java Application".<br>
	 */
    public static void interactiveMenu() {
        ShopInt buymie = new Shop();
		writeFoodMenu(buymie);

		boolean finish = false;
		int option;
		Scanner sc = new Scanner(System.in);

        String myStr, myStr2;
        int myInt, myInt2;

		while (!finish){
			printMenu();
            option = selectIntOption(sc, 0, 10);
            System.out.println();
			switch (option) {
				case 0 -> finish = true;

				case 1 -> {
					System.out.println("---------------\n1. Add Customer\n---------------");

					myStr = enterName(sc);
                    System.out.print("Please enter the address for the new customer: ");
					myStr2 = selectStringOption(sc);

                    Customer newCustomer = new Customer(myStr, myStr2);

					buymie.addCustomer(newCustomer);
				}

				case 2 -> {
					System.out.println("---------------\n2. Remove Customer\n---------------");

					myStr = enterName(sc);

					buymie.removeCustomer(myStr);
				}

				case 3 -> {
					System.out.println("---------------\n3. Display Customer Order History\n---------------");

					myStr = enterName(sc);

					Customer customerFound = findCustomer(buymie, myStr);
					if (customerFound != null){
						boolean existsPastOrders = false;
						for (Order pastOrders: customerFound.getPastOrders()){
							System.out.println();
							System.out.println("----"+myStr+"'s Order----");
							System.out.println("Order ID: "+pastOrders.getOrderID());
							int counter = 1;
							for (Food foodList: pastOrders.getBuyList()){
								System.out.print("Item "+counter+": ");
								System.out.println(foodList.getName());
								counter++;
							}
							System.out.println();
							System.out.println("Total Amount of the Order: "+pastOrders.getTotalPrice()+"€");
							existsPastOrders = true;
						}
						if (!existsPastOrders){
							System.out.println("There is no order history for this customer.");
						}
					} else {
						System.out.println("Sorry, no customer is registered with name = "+myStr);
					}
				}

				case 4 -> {
					System.out.println("---------------\n4. Create New Order\n---------------");

					myStr = enterName(sc);

					Order newOrder = null;
					Customer customerFound = findCustomer(buymie, myStr);
					boolean hasAddedFood = false;

					if (customerFound != null){
						if (customerFound.getCurrentOrder()==null){
							buymie.displayMenu();
							System.out.print("Select an item to be ordered (select 0 to finish): ");
							myInt = selectIntOption(sc);
							while (myInt!=0){
								hasAddedFood = true;
								newOrder = new Order(customerFound.getCustomerID(), new ArrayList<Food>());
								while (myInt-1 >= buymie.getMenu().size() || myInt<=0){
									System.out.println("Wrong value! Select a number between 1 and "+buymie.getMenu().size());
									System.out.print("Select an item to be ordered: ");
									myInt = selectIntOption(sc);
								}
								System.out.print("Select quantity for " + buymie.getMenu().get(myInt-1).getName()+ ": ");
								myInt2 = selectIntOption(sc);
								Food quantityNewFood = buymie.getMenu().get(myInt-1);
								quantityNewFood.setQuantity(myInt2);
								newOrder.addFood(quantityNewFood);

								buymie.displayMenu();
								System.out.print("Select an item to be ordered (select 0 to finish): ");
								myInt = selectIntOption(sc);
							}
							if (hasAddedFood){
								System.out.println();
								System.out.println("Total Amount of the Order: "+newOrder.getTotalPrice()+"€");
								buymie.addOrder(newOrder);
								customerFound.setCurrentOrder(newOrder);
							}
						} else {
							System.out.println("Sorry, you have an ongoing order.");
						}
					} else {
						System.out.println();
						System.out.println("Sorry, no customer is registered with name = "+myStr);
					}
				}

				case 5 -> {
					System.out.println("---------------\n5. Complete Order\n---------------");

					myStr = enterName(sc);
					Customer customerFound = findCustomer(buymie, myStr);
					if (customerFound != null){
						Order orderCompleted = customerFound.getCurrentOrder();
						if (orderCompleted != null){
							System.out.println(myStr+"'s Order Completed. Order ID: "+orderCompleted.getOrderID());
							customerFound.orderCompleted(orderCompleted);
							buymie.orderCompleted(orderCompleted);
						} else {
							System.out.println("This customer doesn't have a current order.");
						}
					} else {
						System.out.println();
						System.out.println("Sorry, no customer is registered with name = "+myStr);
					}
				}

				case 6 -> {
					System.out.println("---------------\n6. Display Shop Menu\n---------------");
					buymie.displayMenu();
				}

				case 7 -> {
					System.out.println("---------------\n7. Add Food Item\n---------------");
					System.out.print("Please enter the name for the new food item: ");
					myStr = selectStringOption(sc);
					System.out.print("Please select the price for the new food item: ");
					Double price = sc.nextDouble();

					Food addFood = new Food(myStr, price);
					buymie.getMenu().add(addFood);
				}

				case 8 -> {
					System.out.println("---------------\n8. Remove Food Item\n---------------");
					buymie.displayMenu();
					System.out.print("Please enter the integer for the food item to be removed: ");
					myInt = selectIntOption(sc);
					while (myInt>buymie.getMenu().size() || myInt<=0){
						System.out.println("Wrong number!");
						System.out.print("Please enter the integer for the food item to be removed: ");
						myInt = selectIntOption(sc);
					}
					buymie.getMenu().remove(myInt-1);
				}

				case 9 -> {
					System.out.println("---------------\n9. Display All Customers List\n---------------");
					for (Customer customers: buymie.getCustomerList()){
						System.out.println(customers.toString());
						System.out.println();
					}
				}

				case 10 -> {
					System.out.println("---------------\n10. Display All Customers Spending\n---------------");
					for (Customer customers: buymie.getCustomerList()){
						System.out.println(customers.toString());
						int totalAmount = 0;
						for (Order orders: customers.getPastOrders()){
							totalAmount += orders.getTotalPrice();
						}
						System.out.println("Total Spent: "+totalAmount+"€");
						System.out.println();
					}
				}
            }
        }
    }

    
	/**
	 * This is the main entry point for the Java application.<br>
	 * @param args - Any argument passed when calling to the Java application.
	 */
	public static void main(String[] args) {
        // test the functionality of the project
        interactiveMenu();
    }
}
