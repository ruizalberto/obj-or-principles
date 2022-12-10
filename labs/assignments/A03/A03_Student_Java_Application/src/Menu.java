//--------------------------------------------------
//	IMPORTS
//--------------------------------------------------

import java.util.ArrayList;

//--------------------------------------------------
//
//	CLASS Menu
//
//--------------------------------------------------
/**
 * This class models a Menu of the shop<br>.
 */
public abstract class Menu {

    //---------------------------------------
    //	Fields
    //---------------------------------------
    private ArrayList<Food> menu;

    //---------------------------------------
    //	Constructor
    //---------------------------------------
    /**
     * The constructor creates 1 instance (1 object) of the class Menu<br>
     */
    public Menu(){
        this.menu = new ArrayList<Food>();
    }

    //---------------------------------------
    //	GET METHODS
    //---------------------------------------    
    /** 
     * Given a concrete menu (this), the function returns its menu.<br>
     * @return The menu.
     */
    public final ArrayList<Food> getMenu() {
        return this.menu;
    }

    //---------------------------------------
    //	SET METHODS
    //---------------------------------------
    /** 
     * Given a concrete menu (this), the function updates its menu.<br>
     * @param menu
     */
    public void setMenu(ArrayList<Food> menu) {
        this.menu = menu;
    }

    //---------------------------------------
    //	EXTRA METHODS
    //---------------------------------------
    /** 
     * This method displays the menu.<br>
     */
    public abstract void displayMenu();
}
