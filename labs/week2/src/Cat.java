
public class Cat {

    //---------------------------------------
    //	Fields
    //---------------------------------------

    String name;
    int playfulLevel;

    //---------------------------------------
    //	Constructor
    //---------------------------------------

    public Cat(String myName, int myPlayfulLevel){
        this.name = myName;
        this.playfulLevel = myPlayfulLevel;
    }

    //---------------------------------------
    //	Get Methods
    //---------------------------------------

    public String getName() {
        return name;
    }

    public int getPlayfulLevel() {
        return playfulLevel;
    }

    //---------------------------------------
    //	Set Method
    //---------------------------------------

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayfulLevel(int playfulLevel) {
        this.playfulLevel = playfulLevel;
    }

    //---------------------------------------
    //	Extra Functionality
    //---------------------------------------

    public boolean isPayingAttention(){
        int M = 1;
        int N = 3;
        int valorEntero = (int) Math.floor(Math.random()*(N-M+1)+M);

        if (valorEntero==3){
            return true;
        }
        return false;
    }

    

}
