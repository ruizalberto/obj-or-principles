import java.util.ArrayList;

public class Menu {
    // Fields
    private ArrayList<Food> menu;

    // Constructor
    public Menu(){
        this.menu = new ArrayList<Food>();
    }

    // GET Methods
    public ArrayList<Food> getMenu() {
        return this.menu;
    }

    // SET Methods
    public void setMenu(ArrayList<Food> menu) {
        this.menu = menu;
    }

    // EXTRA Methods
    public void displayMenu(){
        System.out.println();
        System.out.println(java.time.LocalDate.now().toString()+"'s Menu");
        int counter = 1;
        for(Food item: this.menu){
            System.out.println("--- "+counter+". "+item.getName()+" ---");
            System.out.print("Price: ");
            System.out.println(item.getPrice());
            System.out.println();
            counter++;
        }
    }
}
