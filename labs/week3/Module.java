
public class Module {

    //---------------------------------------
    //	Fields
    //---------------------------------------

    String title;
    int CRN;
    boolean isCA;

    //---------------------------------------
    //	Constructor
    //---------------------------------------

    public Module(String s, int i, boolean b){
        this.title = s;
        this.CRN = i;
        this.isCA = b;
    }

    //---------------------------------------
    //	Get Methods
    //---------------------------------------

    public int getCRN() {
        return this.CRN;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean getIsCA() {
        return this.isCA;
    }

    //---------------------------------------
    //	Set Methods
    //---------------------------------------

    public void setIsCA(boolean b) {
        this.isCA = b;
    }

    public void setCRN(int i) {
        this.CRN = i;
    }

    public void setTitle(String s) {
        this.title = s;
    }

    //---------------------------------------
    //	Extra Functionality
    //---------------------------------------

    public void printModuleInfo(int option){
        if (option == 1){
            System.out.println(getTitle());
        } else if (option == 2){
            System.out.println(getCRN());
        } else if (option == 3){
            if (getIsCA()){
                System.out.println("Assignment-based");
            } else {
                System.out.println("Exam-based");
            }
        }
    }

    public int numVowelsOnTitle() {
        int count = 0;
        for (int i=0 ; i<this.title.length(); i++){
            char ch = this.title.charAt(i);
            if(Character.toString(ch).matches("[AEIOaeiou]")){
               count++;
            }
         }
         return count;
    }

    public int sumOfCRNDigits() {
        int num = this.CRN;
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }    
}
