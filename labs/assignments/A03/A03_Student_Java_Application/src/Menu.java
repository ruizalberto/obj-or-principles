import java.util.ArrayList;

public abstract class Menu {
    // Fields
    private ArrayList<Food> menu;

    /**
     * 
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
