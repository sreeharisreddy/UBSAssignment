package com.ubs.assignment.accumelator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UBSRegExpUtilTest {
	
	@Test
	public void testWithNegativeNumbersWithExceptionMessage(){
		try{
			UBSRegUtil.validateNegativeNumbers("-1,-2");
		}catch(Exception e){
			assertEquals("Negatives notallowed -1,-2", e.getMessage());
		}
	}
	
	@Test
	public void testWithNegativeNumbersWithExceptionMessageWithPosiveNumber(){
		try{
			UBSRegUtil.validateNegativeNumbers("-1,-2,3");
		}catch(Exception e){
			assertEquals("Negatives notallowed -1,-2", e.getMessage());
		}
	}
	
	@Test
	public void testWithNegativeNumbersWithExceptionMessageWithPosiveNumberWith0(){
		try{
			UBSRegUtil.validateNegativeNumbers("0 -1,-2,3");
		}catch(Exception e){
			assertEquals("Negatives notallowed -1,-2", e.getMessage());
		}
	}
	
	@Test
	public void testWithNegativeNumbersWithExceptionMessageWithSpecialChars(){
		try{
			UBSRegUtil.validateNegativeNumbers("//-1,**-2,&&&3");
		}catch(Exception e){
			assertEquals("Negatives notallowed -1,-2", e.getMessage());
		}
	}

}
