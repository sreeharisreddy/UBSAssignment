/**
 * An Utility class to have all regular expressions related methods 
 * @author sreeharis

 */
package com.ubs.assignment.accumelator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ubs.assignment.exception.NegativeNumbersException;

public class UBSRegUtil {
	
	/**
	 * A method to find a Negative Numbers in a give Text and throws an NegativeArraySizeException 
	 * with a message of negative numbers .
	 * 
	 * @param numbers
	 * @param regEx
	 * @throws NegativeNumbersException 
	 * @throws Exception
	 */
	public static void validateNegativeNumbers(String numbers ) throws NegativeArraySizeException, NegativeNumbersException {
		
		Pattern negtiveCheck = Pattern.compile(AppConstants.NEGATIVE_PATTERN);
		Matcher matcher = negtiveCheck.matcher(numbers);
		StringBuilder sb = new StringBuilder();
		boolean anyNegative = false;
		while(matcher.find()){
			sb.append(matcher.group()+",");
			anyNegative = true;
		}
		if(anyNegative)
			throw new NegativeNumbersException("Negatives notallowed "+sb.substring(0,sb.toString().length()-1));
	}


}
