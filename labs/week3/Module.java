
public class Module {

    //---------------------------------------
    //	Fields
    //---------------------------------------

    String title;
    int CRN;
    boolean isCA;

    //---------------------------------------
    //	Constructor
    //---------------------------------------

    public Module(String s, int i, boolean b){
        this.title = s;
        this.CRN = i;
        this.isCA = b;
    }

    //---------------------------------------
    //	Get Methods
    //---------------------------------------

    public int getCRN() {
        return this.CRN;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean getIsCA() {
        return this.isCA;
    }

    //---------------------------------------
    //	Set Methods
    //---------------------------------------



    //---------------------------------------
    //	Extra Functionality
    //---------------------------------------

    
}
