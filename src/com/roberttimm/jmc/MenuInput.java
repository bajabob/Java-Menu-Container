package com.roberttimm.jmc;
import java.math.BigInteger;


public class MenuInput {

	private String input;
	
	public MenuInput(String input){
		this.input = input;
	}
	
	/**
	 * Get the raw input from the user
	 * @return String
	 */
	public String getInput(){
		return this.input;
	}
	
	/**
	 * Convert this input into an integer
	 * @return int
	 */
	public int toInteger(){
		int i = 0;
		try{
			i = Integer.parseInt(input);
		}catch(NumberFormatException e){
			System.err.println("Input '"+input+"' is not of type Integer");
		}
		return i;
	}
	
	/**
	 * Convert this input into an integer
	 * @return BigInteger
	 */
	public BigInteger toBigInteger(){
		BigInteger i = new BigInteger("0");
		try{
			i = new BigInteger(input);
		}catch(NumberFormatException e){
			System.err.println("Input '"+input+"' is not of type BigInteger");
		}
		return i;
	}
	
}
