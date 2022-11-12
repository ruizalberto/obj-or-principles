public class OOPLanguage extends ProgrammingLanguage {
    //---------------------------------------
    //	Fields
    //---------------------------------------

    private boolean isCompiled;

    //---------------------------------------
    //	Constructor
    //---------------------------------------

    public OOPLanguage(int _numWorldSpeakers, int _learningMonths, boolean _isCompiled){
        super(_numWorldSpeakers, _learningMonths);
        this.isCompiled = _isCompiled;
    }

    //---------------------------------------
    //	Get Methods
    //---------------------------------------

    public boolean getIsCompiled(){
        return this.isCompiled;
    }

    //---------------------------------------
    //	Set Methods
    //---------------------------------------

    public void setIsCompiled(boolean isCompiled) {
        this.isCompiled = isCompiled;
    }

    //---------------------------------------
    //	Extra Functionality
    //---------------------------------------

    @Override
    public int computeSalary(){
        if (!getIsCompiled()){
            return 50000;
        }
        return super.computeSalary();
    }

}