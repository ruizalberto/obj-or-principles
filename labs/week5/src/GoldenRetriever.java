import java.util.Random;

/**
 * Our granchild class for the inheritance lab<br>.
 */

public class GoldenRetriever extends Dog {

    //---------------------------------------
    //	Fields
    //---------------------------------------

    protected int lazinessLevel;


    //---------------------------------------
    //	Constructor
    //---------------------------------------

    public GoldenRetriever(String _name, int _age, int _boldnessLevel, int _lazinessLevel){
        super(_name, _age, _boldnessLevel);
        this.lazinessLevel = _lazinessLevel;
    }
    public GoldenRetriever(String _name, int _age, int _boldnessLevel, DogToy _myToy, int _lazinessLevel){
        super(_name, _age, _boldnessLevel, _myToy);
        this.lazinessLevel = _lazinessLevel;
    }


    //---------------------------------------
    //	Get Methods
    //---------------------------------------

    public int getLazinessLevel() {
        return lazinessLevel;
    }


    //---------------------------------------
    //	Set Method
    //---------------------------------------

    public void setLazinessLevel(int lazinessLevel) {
        this.lazinessLevel = lazinessLevel;
    }


    //---------------------------------------
    //	Extra Functionality
    //---------------------------------------

    public int hoursLazy(){
        Random ran = new Random();
        return ran.nextInt(24)+1;
    }
}
