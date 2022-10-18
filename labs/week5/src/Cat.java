import java.util.Random;

/**
 * Our second child class for the inheritance lab<br>.
 */

public class Cat extends Animal {

    //---------------------------------------
    //	Fields
    //---------------------------------------

    protected int attentionLevel;


    //---------------------------------------
    //	Constructor
    //---------------------------------------

    public Cat(String _name, int _age, int _attentionLevel){
        super(_name, _age);
        this.attentionLevel = _attentionLevel;
    }


    //---------------------------------------
    //	Get Methods
    //---------------------------------------

    public int getAttentionLevel() {
        return attentionLevel;
    }


    //---------------------------------------
    //	Set Method
    //---------------------------------------

    public void setAttentionLevel(int attentionLevel) {
        this.attentionLevel = attentionLevel;
    }


    //---------------------------------------
    //	Extra Functionality
    //---------------------------------------

    public boolean isPayingAttention(){
        Random ran = new Random();
        int coin = ran.nextInt(9)+1;
        if (coin <= getAttentionLevel()){
            return true;
        }
        return false;
    }

}
