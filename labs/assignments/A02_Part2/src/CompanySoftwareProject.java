public class CompanySoftwareProject {
    //---------------------------------------
    //	Fields
    //---------------------------------------

    private int numProgrammers;
    private ProgrammingLanguage myProgrammingLanguage;

    //---------------------------------------
    //	Constructor
    //---------------------------------------

    public CompanySoftwareProject(int _numProgrammers, ProgrammingLanguage _myProgrammingLanguage){
        this.numProgrammers = _numProgrammers;
        this.myProgrammingLanguage = _myProgrammingLanguage;
    }

    //---------------------------------------
    //	Get Methods
    //---------------------------------------

    public ProgrammingLanguage getMyProgrammingLanguage() {
        return this.myProgrammingLanguage;
    }

    public int getNumProgrammers() {
        return this.numProgrammers;
    }

    //---------------------------------------
    //	Set Methods
    //---------------------------------------

    public void setMyProgrammingLanguage(ProgrammingLanguage myProgrammingLanguage) {
        this.myProgrammingLanguage = myProgrammingLanguage;
    }

    public void setNumProgrammers(int numProgrammers) {
        this.numProgrammers = numProgrammers;
    }

    //---------------------------------------
    //	Extra Functionality
    //---------------------------------------

    public int computeProjectCost(){
        return getNumProgrammers()*getMyProgrammingLanguage().computeSalary();
    }

}