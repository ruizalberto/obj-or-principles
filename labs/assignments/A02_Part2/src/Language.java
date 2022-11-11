public class Language {
    //---------------------------------------
    //	Fields
    //---------------------------------------

    private boolean alphabetBased;
    private int numWorldSpeakers;

    //---------------------------------------
    //	Constructor
    //---------------------------------------

    public Language(){
        this.alphabetBased = false;
        this.numWorldSpeakers = 0;
    }

    public Language(boolean _alphabetBased, int _numWorldSpeakers){
        this.alphabetBased = _alphabetBased;
        this.numWorldSpeakers = _numWorldSpeakers;
    }

    //---------------------------------------
    //	Get Methods
    //---------------------------------------

    public boolean getAlphabetBased() {
        return this.alphabetBased;
    }

    public int getNumWorldSpeakers() {
        return this.numWorldSpeakers;
    }

    //---------------------------------------
    //	Set Methods
    //---------------------------------------

    public void setAlphabetBased(boolean alphabetBased) {
        this.alphabetBased = alphabetBased;
    }

    public void setNumWorldSpeakers(int numWorldSpeakers) {
        this.numWorldSpeakers = numWorldSpeakers;
    }

    //---------------------------------------
    //	Extra Functionality
    //---------------------------------------

    public int computeSalary() {
        if (!getAlphabetBased()){
            return 40000;
        } else {
            int result = 60000 - (1000*getNumWorldSpeakers());
            if (result < 30000){
                return 30000;
            }
            return result;
        }
    }

    public final int computeSalary(int _numYearsExperience) {
        return 5000*_numYearsExperience;
    }
}