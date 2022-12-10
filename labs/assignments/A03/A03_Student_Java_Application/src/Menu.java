import java.util.ArrayList;

public abstract class Menu {
    // Fields
    private ArrayList<Food> menu;

    /**
     * The constructor creates 1 instance (1 object) of the class Menu<br>
     */
    public Menu(){
        this.menu = new ArrayList<Food>();
    }

    
    /** 
     * @return ArrayList<Food>
     */
    // GET Methods
    public final ArrayList<Food> getMenu() {
        return this.menu;
    }

    
    /** 
     * @param menu
     */
    // SET Methods
    public void setMenu(ArrayList<Food> menu) {
        this.menu = menu;
    }

    // EXTRA Methods
    public abstract void displayMenu();
}
