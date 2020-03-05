/**
 * 
 * @author arberbilalli
 *
 */

import java.util.*;
import java.io.*;

public class hauptcode {
	
	//characters used in bases
	private static String container = "0123456789ABCDEF";
	
	static boolean tester(String input, int base) {
		int counter = 0;
		for(int i=0; i<input.length(); i++) {
			for(int j=0; j<base; j++) {
				if(input.charAt(i) == container.charAt(j)) {
					counter++;
				}
			}
		}
		
		if(counter == input.length()) {
			return true;
		} else {
			return false;
		}
	}
	
	static int decimal(String number, int base) {
		int decimal = 0;
		int power = 1;
		
		for(int i=number.length()-1; i>=0; i--) {
			int tmp = container.indexOf(number.charAt(i));
			tmp *= power;
			decimal += tmp;
			power *= base;
		}
		
		return decimal;
	}
	
	static String output(int number, int base) {
		String reversed = "";
		while(number != 0) {
			int times = number/base;
			int remainder = number - times*base;
			reversed += container.charAt(remainder);
			number = times;
		}
		
		String Number = "";
		for(int i=reversed.length()-1; i>=0; i--) {
			Number += reversed.charAt(i);
		}
		
		return Number;
	}
	
	public static void main(String[] args) throws IOException {
		
		int base1 = 0; 
		int base2 = 0;
		String firstNumber = "";
		
		BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome! This programm is used to transform number from base 2 to 16");
		System.out.println("to any other base between 2 and 16!");
		System.out.println("Allowed characters are: " + container);
		
		System.out.println("Please type the base of your primary number: ");
		boolean b1 = false;
		while(b1 == false) {
			base1 = Integer.parseInt(consoleInput.readLine());
			if (base1 >= 2 && base1 <=16) {
				b1 = true;
			} else {
				System.out.println("The base you entered is not supported!");
				System.out.println("Please type the base(0 to 16) of your primary number: ");
			}
		}
		
		System.out.println("Now please enter the number you want to convert: ");
		boolean b2 = false;
		while(b2 == false) {
			firstNumber = consoleInput.readLine();
			
			if(hauptcode.tester(firstNumber, base1)) {
				b2 = true;
			} else {
				System.out.println("The number you have entered is not valid! Please try again: ");
			}
			
		}
		
		System.out.println("Please select your base to convert: ");
		boolean b3 = false;
		while(b3 == false) {
			base2 = Integer.parseInt(consoleInput.readLine());
			if (base2 >= 2 && base2 <=16) {
				b3 = true;
			} else {
				System.out.println("The base you entered is not supported!");
				System.out.println("Please select your base(0 to 16) to convert: ");
			}
		}
		
		String number = hauptcode.output(hauptcode.decimal(firstNumber, base1), base2);
		
		System.out.println("Number you are looking for is: " + number);
		
	}

}
