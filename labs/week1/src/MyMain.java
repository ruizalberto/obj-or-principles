
import java.lang.Math;

/**
 * The class tests the 8 functions of Lab01.
 * @author Ignacio.Castineiras
 *
 */
public class MyMain {

	//----------------------------------------------
	// ex1
	//----------------------------------------------
	/**
	 * The function prints your name by the screen.<br>
	 * Example: In my case it will print Nacho Castineiras
	 */
	public static void ex1(){
		//----------------------------
		// COMPLETE YOUR CODE HERE
		//----------------------------

		System.out.println("Alberto Ruiz");

		//----------------------------
	}

	//----------------------------------------------
	// ex2
	//----------------------------------------------
	/**
	 * The function declares a new variable res, assigns it to the logarithm of base 'a' of number 'b' and returns res.<br>
	 * Example: If a = 2.0 and b = 8.0 then it returns 3.0 (which is log base2 of number 8.0)
	 * Note: You will need to import a library to be able to use logarithms.
	 * @param a: Logarithm base
	 * @param b: Number to apply the logarithm to
	 * @return Logarithm in base a of number b
	 */
	public static double ex2(double a, double b){
		double res = 0;

		//----------------------------
		// COMPLETE YOUR CODE HERE
		//----------------------------

		res = Math.log10(b)/Math.log10(a);

		//----------------------------

		return res;
	}

	//----------------------------------------------
	// ex3
	//----------------------------------------------
	/**
	 * The function receives 3 numbers and prints by screen the second biggest of them all.<br>
	 * Example: If a = 3, b = 7 and c = 5, then it prints 5 (which is the second biggest of the 3 numbers).
	 * @param a: First number
	 * @param b: Second number
	 * @param c: Third number
	 *
	 */
	public static void ex3(int a, int b, int c){
		//----------------------------
		// COMPLETE YOUR CODE HERE
		//----------------------------

		if (a>b && a<c){System.out.println(a);}
		else if (b>a && b<c){System.out.println(b);}
		else {System.out.println(c);}

		//----------------------------
	}

	//----------------------------------------------
	// ex4
	//----------------------------------------------
	/**
	 * The function returns the sum of all numbers from 1 to n.<br>
	 * Example: If n = 5, the function returns 15 (which is 1 + 2 + 3 + 4 + 5).
	 * @param n: Number we want to stop adding at
	 * @return Sum of all integers in [1..n]
	 *
	 */
	public static int ex4(int n){
		int res = 0;

		//----------------------------
		// COMPLETE YOUR CODE HERE
		//----------------------------

		for (int i = 1; i<n+1; i++){
			res+=i;
		}

		//----------------------------

		return res;
	}

	//----------------------------------------------
	// ex5
	//----------------------------------------------
	/**
	 * NOTE: This exercise has been taken from CodeWars:<br>
	 * https://www.codewars.com/kata/514b92a657cdc65150000006/train/java<br>
	 * Description:<br>
	 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.<br>
	 * Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in. Additionally, if the number is negative, return 0 (for languages that do have them).<br>
	 * Note: If the number is a multiple of both 3 and 5, only count it once.<br><br>
	 * Example 1:<br>
	 * ex8(10)<br>
	 * 3 + 5 + 6 + 9<br>
	 * 23<br><br>
	 *
	 * Example 1:<br>
	 * ex8(20)<br>
	 * 3 + 5 + 6 + 9 + 10 + 12 + 15 + 18<br>
	 * 78<br>
	 * Note: Please note that 15 is multiple of both 3 and 5, but we only count it once.<br><br>
	 *
	 * @param n: Number to apply its digital root to.
	 * @return res: Digital result of the number.
	 */
	public static int ex5(int n) {
		int res = 0;

		//----------------------------
		// COMPLETE YOUR CODE HERE
		//----------------------------

		for (int i = 0; i<n; i++){
			if (i % 3 == 0 || i % 5 == 0){
				res+=i;
			}
		}

		//----------------------------

		return res;
	}

	//----------------------------------------------
	// ex6
	//----------------------------------------------
	/**
	 * The function prints a pattern by screen.<br>
	 * Example1: If n = 3, then it prints<br>
	 * *<br>
	 * **<br>
	 * ***<br>
	 * Example2: If n = 5, then it prints<br>
	 * *<br>
	 * **<br>
	 * ***<br>
	 * ****<br>
	 * *****<br>
	 *
	 * @param n: Number of lines to be printed
	 *
	 */
	public static void ex6(int n){
		//----------------------------
		// COMPLETE YOUR CODE HERE
		//----------------------------



		//----------------------------
	}

	//--------------------------------------------------
	// ex7
	//--------------------------------------------------
	/***
	 *
	 * The function reverses a String and returns the String reversed. If also flips any upper case character into lower case and viceversa<br>
	 * Example: If the String "HellO" is received, then it returns "oLLEh"
	 *
	 * @param s: String to be scanned.
	 * @return The reversed String and with the upper case and lower case characters flipped.
	 *
	 */
	public static String ex7(String s){
		String res = "";

		//----------------------------
		// COMPLETE YOUR CODE HERE
		//----------------------------



		//----------------------------

		return res;
	}

	//----------------------------------------------
	// ex8
	//----------------------------------------------
	/**
	 * NOTE: This exercise has been taken from CodeWars:<br>
	 * https://www.codewars.com/kata/sum-of-digits-slash-digital-root<br>
	 * Description:<br>
	 * A digital root is the recursive sum of all the digits in a number.<br>
	 * Given n, take the sum of the digits of n.<br>
	 * If that value has still more than one digit, continue reducing in this way until a single-digit number is produced.<br><br>
	 * Example 1:<br>
	 * ex7(16)<br>
	 * 1 + 6<br>
	 * 7<br><br>
	 *
	 * Example 2:<br>
	 * ex7(942)<br>
	 * 9 + 4 + 2<br>
	 * 15<br>
	 * However, as 15 still contains more than one digit, we iterate again<br>
	 * 1 + 5<br>
	 * 6
	 *
	 * @param n: Number to apply its digital root to.
	 * @return res: Digital result of the number.
	 */
	public static int ex8(int n) {
		int res = 0;

		//----------------------------
		// COMPLETE YOUR CODE HERE
		//----------------------------



		//----------------------------

		return res;
	}

	/**
	 * This function is used to test the exam functions.
	 */
	public static void test(){
		//1. We create extra variables for the results
		int res1;
		String res2;
		double res3;

		//---------------------
		// TESTS
		//---------------------

		//ex1
		System.out.println("----------- ex1 -----------");
		ex1();

		//ex2
		System.out.println("----------- ex2 -----------");
		res3 = ex2(2.0, 8.0);
		System.out.println(res3);

		res3 = ex2(5.0, 7.0);
		System.out.println(res3);

		//ex3
		System.out.println("----------- ex3 -----------");
		ex3(3, 7, 5);
		ex3(1, 2, 3);

		//ex4
		System.out.println("----------- ex4 -----------");
		res1 = ex4(5);
		System.out.println(res1);

		res1 = ex4(10);
		System.out.println(res1);

		//ex5
		System.out.println("----------- ex5 -----------");
		res1 = ex5(10);
		System.out.println(res1);

		res1 = ex5(20);
		System.out.println(res1);

		//ex6
		System.out.println("----------- ex6 -----------");
		ex6(3);

		ex6(5);

		//ex6
		System.out.println("----------- ex7 -----------");
		res2 = ex7("Hello");
		System.out.println(res2);

		res2 = ex7("Goodbye");
		System.out.println(res2);

		//ex7
		System.out.println("----------- ex8 -----------");
		res1 = ex8(16);
		System.out.println(res1);

		res1 = ex8(942);
		System.out.println(res1);
	}

	/**
	 * Main Method.
	 * @param args: We will run the program parameter free, so do not worry about it.
	 */
	public static void main(String[] args) {
		test();
	}

}
