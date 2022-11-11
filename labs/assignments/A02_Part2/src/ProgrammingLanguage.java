public class ProgrammingLanguage extends Language{

    //---------------------------------------
    //	Fields
    //---------------------------------------

    private int learningMonths;

    //---------------------------------------
    //	Constructor
    //---------------------------------------

    public ProgrammingLanguage(int _learningMonths) {
        super(true, 0);
        this.learningMonths = _learningMonths;
    }

    public ProgrammingLanguage(int _numWorldSpeakers, int _learningMonths) {
        super(true, _numWorldSpeakers);
        this.learningMonths = _learningMonths;
    }


    //---------------------------------------
    //	Get Methods
    //---------------------------------------

    public int getLearningMonths() {
        return this.learningMonths;
    }

    //---------------------------------------
    //	Set Methods
    //---------------------------------------

    public void setLearningMonths(int learningMonths) {
        this.learningMonths = learningMonths;
    }

    @Override
    public void setAlphabetBased(boolean _alphabetBased){
        super.setAlphabetBased(_alphabetBased);
    }

    //---------------------------------------
    //	Extra Functionality
    //---------------------------------------

    @Override
    public int computeSalary(){
        return super.computeSalary() + (1000*getLearningMonths());
    }

}