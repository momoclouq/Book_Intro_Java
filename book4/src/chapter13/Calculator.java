/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter13;

/**
 *
 * @author cis2mye
 */
public class Calculator {
    /*main method*/
	public static void main(String[] args){
		if (args.length > 1){
		if (args.length != 3){
			System.out.println(
			"Usage:  java Calculator operand1 operator operand2");
		System.exit(1);
		}

		//determine the operator
		try {
			Rational result = new Rational(0,0);
			switch(args[1].charAt(0)){
				case '+': result = getRational(args[0]).add(getRational(args[2]));
				break;
				case '-': result =  getRational(args[0]).subtract(getRational(args[2]));
				break;
				case '*': result = getRational(args[0]).multiply(getRational(args[2]));
				break;
				case '/': if (getRational(args[2]).getDenominator() != 0) result = getRational(args[0]).divide(getRational(args[2]));
					break;
				default: break;
			}
                                if (result.isValid())
			System.out.println(args[0] + ' ' + args[1] + ' ' + args[2] + " = " + result);
                                else System.out.println("Result is invalid");
		} catch(Exception ex){
			System.out.println("error" + ex.getMessage());
		}
		
                }
                
               
        }
        
        public static Rational getRational(String x){
               try{
                   String[] Rs = x.split("/", 0);
                   if (Rs.length < 2) throw new Exception("Wrong input value");
                   
                   long numerator  = Long.parseLong(Rs[0]);
                   long denominator = Long.parseLong(Rs[1]);
                   
                   return new Rational(numerator, denominator);
               }
               catch (NumberFormatException ex){
                   System.out.println("Error in the numbers");
               }
               catch (Exception ex){
                   System.out.println("Error: " + ex.getMessage());
               }
               
               return new Rational(0,0);
       }
}
