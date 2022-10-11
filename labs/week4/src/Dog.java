
public class Dog {

    //---------------------------------------
    //	Fields
    //---------------------------------------

    private String name;
    private int boldnessLevel;
    private String breed;
    private Toy toy;

    //---------------------------------------
    //	Constructor
    //---------------------------------------

    public Dog(String n, int bl, String b, boolean s, int r){
        this.name = n;
        this.boldnessLevel = bl;
        this.breed = b;
        this.toy = new Toy(s, r);
    }

    public Dog(String n, int bl, String b, Toy t){
        this.name = n;
        this.boldnessLevel = bl;
        this.breed = b;
        this.toy = t;
    }

    public Dog(Dog d, boolean shallowMode){
        if (shallowMode){
            this.name = d.getName();
            this.boldnessLevel = d.getBoldnessLevel();
            this.breed = d.getBreed();
            this.toy = d.getToy();
        } else {
            this.name = d.getName();
            this.boldnessLevel = d.getBoldnessLevel();
            this.breed = d.getBreed();
            this.toy = new Toy(d.getToy().getSound(), d.getToy().getResistance());
        }
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

    public Toy getToy() {
        return toy;
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

    public void setToy(Toy toy) {
        this.toy = toy;
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
        System.out.println("woof ".repeat(happinessLevel));
    }

}
