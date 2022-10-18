import java.util.Random;

/**
 * Our first child class for the inheritance lab<br>.
 */

public class Dog extends Animal {

    //---------------------------------------
    //	Fields
    //---------------------------------------

    protected int boldnessLevel;
    protected DogToy myToy;


    //---------------------------------------
    //	Constructor
    //---------------------------------------

    public Dog(String _name, int _age, int _boldnessLevel){
        super(_name, _age);
        this.boldnessLevel = _boldnessLevel;
        this.myToy = null;
    }

    public Dog(String _name, int _age, int _boldnessLevel, DogToy _myToy){
        super(_name, _age);
        this.boldnessLevel = _boldnessLevel;
        this.myToy = _myToy;
    }

    //---------------------------------------
    //	Get Methods
    //---------------------------------------

    public int getBoldnessLevel() {
        return boldnessLevel;
    }
    public DogToy getMyToy() {
        return myToy;
    }


    //---------------------------------------
    //	Set Method
    //---------------------------------------

    public void setBoldnessLevel(int boldnessLevel) {
        this.boldnessLevel = boldnessLevel;
    }
    public void setMyToy(DogToy myToy) {
        this.myToy = myToy;
    }


    //---------------------------------------
    //	Extra Functionality
    //---------------------------------------

    public void playWithToy(){
        Random ran = new Random();
        int coin = ran.nextInt(2)+1;
        if (coin==1){
            if (this.boldnessLevel < 10){
                this.boldnessLevel++;
            }
        }
    }

    public void bark(int happinessLevel){
        System.out.println("woof ".repeat(happinessLevel));
    }

}
