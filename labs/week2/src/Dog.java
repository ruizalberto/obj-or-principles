
public class Dog {

    //---------------------------------------
    //	Fields
    //---------------------------------------

    String name;
    int boldnessLevel;
    String breed;

    //---------------------------------------
    //	Constructor
    //---------------------------------------

    public Dog(String myName, int myBoldnessLevel, String myBreed) {
        this.name = myName;
        this.boldnessLevel = myBoldnessLevel;
        this.breed = myBreed;
    }

    //---------------------------------------
    //	Get Methods
    //---------------------------------------

    public int getBoldnessLevel() {
        return boldnessLevel;
    }

    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    //---------------------------------------
    //	Set Methods
    //---------------------------------------

    public void setBoldnessLevel(int boldnessLevel) {
        this.boldnessLevel = boldnessLevel;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    //---------------------------------------
    //	Extra Functionality
    //---------------------------------------


    public void increaseBoldnessLevel(){
        if (this.boldnessLevel != 10){
            this.boldnessLevel++;
        }
    }

    public void bark(int happinessLevel){
        System.out.println("woof".repeat(happinessLevel));
    }
}
