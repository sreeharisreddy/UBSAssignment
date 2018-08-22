package com.ubs.assignment.accumelator;

import java.util.Arrays;

import com.ubs.assignment.exception.NegativeNumbersException;

public class StringAccumelator {

	
	public static void main(String[] args)  {
		
		try{
		new StringAccumelator().add("“//***\n1***-2***3”");
		}catch(Exception e){
		}
	}
	/**
	 * Takes input a String text which contains numbers in the middle of the text 
	 * extract the numbers from text and print the suym of the numers.
	 * If the text contain any -ve number
	 * @param numbers
	 * @return integer
	 * @throws Exception 
	 */
	int add(String numbers) throws Exception{
		
		try {
			
		UBSRegUtil.validateNegativeNumbers(numbers); 
		
		String extrctedNumbers = numbers.replaceAll("\\D+",",");
		String[] numbersArray = extrctedNumbers.split(",");
		Integer sum = Arrays.stream(numbersArray)
		 .filter(t->t.trim().length()>0)
		 .mapToInt(Integer::valueOf)
		 .filter(num -> num <= 1000)	
		 .sum();
   
		System.out.println(sum);
		return sum;
		}catch(Exception e){
			if ( e instanceof NegativeNumbersException){
				System.out.println(e.getMessage());
			}
			throw e;
		}
}

}