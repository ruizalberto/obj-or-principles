/**
 * Our parent class for the inheritance lab<br>.
 */

public class Animal {

    //---------------------------------------
    //	Fields
    //---------------------------------------

    protected int age;
    protected String name;


    //---------------------------------------
    //	Constructor
    //---------------------------------------

    public Animal(String s, int i){
        this.name = s;
        this.age = i;
    }


    //---------------------------------------
    //	Get Methods
    //---------------------------------------

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }


    //---------------------------------------
    //	Set Method
    //---------------------------------------

    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }


    //---------------------------------------
    //	Extra Functionality
    //---------------------------------------
    

}
