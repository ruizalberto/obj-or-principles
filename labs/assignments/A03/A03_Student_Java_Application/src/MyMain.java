import java.util.ArrayList;
import java.util.Scanner;

public class MyMain {
    public static void printMenu(){
		System.out.print("------------------------------------\n");
		System.out.print("			    MENU			  	  \n");
		System.out.print("------------------------------------\n");
		System.out.print("0. Exit\n");
		System.out.print("1. Add Customer\n");
		System.out.print("2. Remove Customer\n");
		System.out.print("3. Display User Order History\n");
		System.out.print("4. Add Food Item\n");
		System.out.print("5. Remove Food Item\n");
		System.out.print("6. Display Food Item Info\n");
		System.out.print("7. Display Shop Food Menu\n");
		System.out.print("8. Create New Order\n");
		System.out.println("\n\n");
	}

    public static int selectOption(Scanner sc, int min, int max){

		int res = -1;
		boolean validOption = false;
		while (!validOption) {
			System.out.println("Please enter an integer value within the range " + min + " and " + max );
			try {
				res = sc.nextInt();
				sc.nextLine();
				if ((res >= min) && (res <= max)){
                    validOption = true;
                } else {
					System.out.println("Sorry but the option must be within the range " + min + " and " + max);
                }
			}
			catch (Exception e) {
				System.out.println("Sorry you did not enter an integer and then press the return key");
				sc.next();
			}
		}
		return res;
	}

    public static int selectIntOption(Scanner sc){
		int res = -1;
		boolean validOption = false;
		while (!validOption) {
			System.out.println("Please enter an integer value");
			try {
				res = sc.nextInt();
				sc.nextLine();
				validOption = true;
			}
			catch (Exception e) {
				System.out.println("Sorry you did not enter an integer and then press the return key");
				sc.next();
			}
		}
		return res;
	}

    public static void interactiveMenu() {
        Shop buymie = new Shop();

		// 2. We create some auxiliary variables
		boolean finish = false;
		int option;
		Scanner sc = new Scanner(System.in);

        String myStr;

		while (!finish){
			printMenu();
            option = selectOption(sc, 0, 15);
			switch (option) {
				case 0 -> finish = true;

				case 1 -> {
					// I. We print the message
					System.out.println("---------------\n1. Add User\n---------------");

					// II. We ask for the user input to define the user
					System.out.print("Please enter the name for the new user: ");
					myStr = selectStringOption(sc);

					// III. We attempt to add the user
					myInt = l.addUser(myStr);

					// IV. We inform of the success of the operation
					System.out.println("New user with id " + myInt + " successfully created");
				}

				case 2 -> {
					// I. We print the message
					System.out.println("---------------\n2. Remove User\n---------------");

					// II. We ask for the user input to identify the user to be removed
					System.out.println("Please enter the id for the user to be removed");
					myInt = selectIntOption(sc);

					// III. We attempt to remove the user
					myInt = l.removeUser(myInt);

					// IV. We inform of the success of the operation
					if (myInt == -1)
						System.out.println("Sorry, no user is registered with id = " + myInt + " so the remove operation cannot proceed.");
					else
						if (myInt == -2)
							System.out.println("Sorry, the user with id = " + myInt + " has pending borrows, so the remove operation cannot proceed.");
						else
							System.out.println("User with id = " + myInt + " successfully removed");
				}

				case 3 -> {
					// I. We print the message
					System.out.println("---------------\n3. Display User Info\n---------------");

					// II. We ask for the user input to identify the user to be removed
					System.out.println("Please enter the id for the user to be displayed");
					myInt = selectIntOption(sc);

					// III. We attempt to display the user info
					l.displayUserInfo(myInt);
				}

				case 4 -> {
					// I. We print the message
					System.out.println("---------------\n3. Display All User IDs\n---------------");

					// II. We perform the action
					l.displayAllUserIDs();
				}

				case 5 -> {
					// I. We print the message
					System.out.println("---------------\n5. Add Book Item\n---------------");

					// II. We ask for the user input to define the item
					System.out.println("Please enter the title for the new book");
					myStr = selectStringOption(sc);
					System.out.println("Please enter the author for the new book");
					myStr2 = selectStringOption(sc);
					System.out.println("Please enter the release year for the new book");
					myInt = selectIntOption(sc);
					System.out.println("Please enter the genre for the new book");
					myStr3 = selectStringOption(sc);
					System.out.println("Please enter the number of pages for the new book");
					myInt2 = selectIntOption(sc);

					// III. We attempt to add the book
					myInt = l.addBook(myStr,
							myStr2,
							myInt,
							myStr3,
							myInt2
					);

					// IV. We inform of the success of the operation
					System.out.println("New book with id " + myInt + " successfully created");
				}

				case 6 -> {
					// I. We print the message
					System.out.println("---------------\n6. Add Music Album Item\n---------------");

					// II. We ask for the user input to define the item
					System.out.println("Please enter the title for the new music album");
					myStr = selectStringOption(sc);
					System.out.println("Please enter the author for the new music album");
					myStr2 = selectStringOption(sc);
					System.out.println("Please enter the release year for the new music album");
					myInt = selectIntOption(sc);
					System.out.println("Please enter the genre for the new music album");
					myStr3 = selectStringOption(sc);
					System.out.println("Please enter if the new music album was album of the year");
					myBool = selectBooleanOption(sc);

					// III. We attempt to add the book
					myInt = l.addMusicAlbum(myStr,
							myStr2,
							myInt,
							myStr3,
							myBool
					);

					// IV. We inform of the success of the operation
					System.out.println("New music album with id " + myInt + " successfully created");
				}

				case 7 -> {
					// I. We print the message
					System.out.println("---------------\n7. Remove Item\n---------------");

					// II. We ask for the user input to identify the item to be removed
					System.out.println("Please enter the id for the item to be removed");
					myInt = selectIntOption(sc);

					// III. We attempt to remove the user
					myBool = l.removeItem(myInt);

					// IV. We inform of the success of the operation
					if (!myBool) {
						System.out.println("Sorry, no item is registered with id = " + myInt + " so the remove operation can not proceed.");
					} else
						System.out.println("Item with id = " + myInt + " successfully removed");
				}

				case 8 -> {
					// I. We print the message
					System.out.println("---------------\n8. Display Item Info\n---------------");

					// II. We ask for the user input to identify the item to be displayed
					System.out.println("Please enter the id for the item to be displayed");
					myInt = selectIntOption(sc);

					// III. We attempt to display the user info
					l.displayItemInfo(myInt);
				}
            }
        }
    }

    public static void main(String[] args) {
        // test the functionality of the project
        Shop buymie = new Shop();
        Menu menu = new Menu();
        Food meat = new Food("Sirloin Steak", 5);
        Food fish = new Food("Hake Fillets", 5);
        menu.addFood(meat);
        menu.addFood(fish);
        Customer alberto = new Customer("Alberto Ruiz", "St Patrick's Street, 9");
        buymie.addCustomer(alberto);
        ArrayList<Food> listaCompra = new ArrayList<>();
        listaCompra.add(meat);
        meat.setQuantity(4);
        listaCompra.add(fish);
        fish.setQuantity(4);
        Order albertoOrder = new Order(alberto.getCustomerID(), listaCompra);
        buymie.addOrder(albertoOrder);
        int total = buymie.getCurrentOrders().get(0).getTotalPrice();
        System.out.println(total);
    }
}
