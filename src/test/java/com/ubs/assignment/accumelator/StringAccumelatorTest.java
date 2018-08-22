/**
 * A test class for StringAccumelator
 * @author sreeharis
 */
package com.ubs.assignment.accumelator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.ubs.assignment.exception.NegativeNumbersException;


public class StringAccumelatorTest {
	
	private StringAccumelator accumelator;
	
	@Before
	public void setup(){
		accumelator = new StringAccumelator();
	}
	
	@Test
	public void testEmptyString() throws Exception{
		int add = accumelator.add("");
		assertEquals(0, add);
	}
	
	@Test
	public void testWithTwoNumbers() throws Exception{
		int add = accumelator.add("1,2");
		assertEquals(3, add);
	}
	
	@Test
	public void testWithUnKnowAmountOfNumbers() throws Exception{
		int randNumber = new Double(Math.random()*10).intValue();
		
		List<Integer> numbers = new ArrayList<>();  
		for (int i = 0; i <= randNumber; i++) {
			numbers.add(i);
		}
		
		String numbersText = numbers
		.stream()
		.map(Object::toString)
        .collect( Collectors.joining( "," ) );
		
		int sum = (randNumber*(randNumber+1))/2;
		assertEquals(sum, accumelator.add(numbersText));
	}
	
	@Test(expected = NegativeNumbersException.class)
	public void testWithNegativeNumbers() throws Exception{
		accumelator.add("-1,-2");
	}
	
	@Test
	public void testWithNegativeNumbersWithExceptionMessage(){
		
		try{
		accumelator.add("-1,-2");
		}catch(Exception e){
			assertEquals("Negatives notallowed -1,-2", e.getMessage());
		}
	}
	
	@Test
	public void testWithNewLineCharcters() throws Exception{
		int add = accumelator.add("1\n2,3");
		assertEquals(6, add);
	}
	
	@Test
	public void testWithEndingNewLineCharacter() throws Exception{
		int add = accumelator.add("1\n2,3\n");
		assertEquals(6, add);
	}
	
	@Test
	public void testWithStartingDoubleSlash() throws Exception{
		int add = accumelator.add("//;\n1\n2,3\n");
		assertEquals(6, add);
	}
	
	@Test
	public void testWithNumbersBiggerThan1000() throws Exception{
		int add = accumelator.add("2+1001");
		assertEquals(2, add);
	}
	
	@Test
	public void testWithMultipleDelimeterRepeated() throws Exception{
		int add = accumelator.add("//***\n1***2***3");
		assertEquals(6, add);
	}
	
	@Test
	public void testWithMultipleDelimeter() throws Exception{
		int add = accumelator.add("//delim1|delim2\n");
		assertEquals(3, add);
		int sum = accumelator.add("//*|%\n1*2%3");
		assertEquals(6, sum);
	}
	
	@Test
	public void testWithMultipleDelimeterWithLongerThanOneCharacter() throws Exception{
		int add = accumelator.add("//n1*\n.2*@$&*(*3");
		assertEquals(6, add);
	}
}
