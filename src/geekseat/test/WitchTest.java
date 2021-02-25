package geekseat.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import geekseat.exception.NegativeNumberException;
import geekseat.exception.YearBornNotValidException;
import geekseat.implementation.WitchImpl;
import geekseat.interfaces.WitchInterface;

public class WitchTest {

	//initialize object
	static WitchInterface witch;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Before
	public void setUp() {
		witch = new WitchImpl();
	}
	
	@Test
	public void testNegativeValueCountDiedVillagers() throws NegativeNumberException {
		int year = -1;
		
		exceptionRule.expect(NegativeNumberException.class);
		exceptionRule.expectMessage("Year Dead must be greater than 0");
		witch.countDiedVillagers(year);
	}
	
	@Test
	public void testOverflowValueCountDiedVillagers(){
		int year = 45;
				
		try {
			int result = witch.countDiedVillagers(year);
			assertTrue(result<0);
		} catch (NegativeNumberException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void testInputOverflowCountDiedVillagers() throws NegativeNumberException {
		int year = Integer.MAX_VALUE;
		
		exceptionRule.expect(NegativeNumberException.class);
		exceptionRule.expectMessage("Year Dead must be greater than 0");
		witch.countDiedVillagers(year+1);
	}
	
	@Test
	public void testZeroInputCountDiedVillagers() throws NegativeNumberException {
		int year = 0;
		
		try {
			int result = witch.countDiedVillagers(year);
			assertTrue(result==0);
		} catch (NegativeNumberException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/*
	 * testing for first iteration shall be return 1, 
	 * because first iteration in the normal fibonacci sequence will return 0 
	 */
	@Test
	public void testOneInputCountDiedVillagers() throws NegativeNumberException {
		int year = 1;
		
		try {
			int result = witch.countDiedVillagers(year);
			assertTrue(result==1);
		} catch (NegativeNumberException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testRightInputCountDiedVillagers() throws NegativeNumberException {
		int year = 5;
		
		try {
			int result = witch.countDiedVillagers(year);
			assertTrue(result==12);
		} catch (NegativeNumberException e) {
			System.out.println(e.getMessage());
		}
	}


	@Test
	public void testNegativeFirstAgeAveragePeopleDead() throws NegativeNumberException, YearBornNotValidException {
		int firstYear = 1;
		int age1 = -1;
		int year1 = 12;
		int age2 = 13;
		int year2 = 17;
		
		exceptionRule.expect(NegativeNumberException.class);
		exceptionRule.expectMessage("Age or Year must be greater than 0");
		witch.averagePeopleDead(firstYear, age1, year1, age2, year2);
	}
	
	@Test
	public void testNegativeFirstYearAveragePeopleDead() throws NegativeNumberException, YearBornNotValidException {
		int firstYear = 1;
		int age1 = 10;
		int year1 = -1;
		int age2 = 13;
		int year2 = 17;
		
		exceptionRule.expect(NegativeNumberException.class);
		exceptionRule.expectMessage("Age or Year must be greater than 0");
		witch.averagePeopleDead(firstYear, age1, year1, age2, year2);
	}
	
	@Test
	public void testNegativeSecondAgeAveragePeopleDead() throws NegativeNumberException, YearBornNotValidException {
		int firstYear = 1;
		int age1 = 10;
		int year1 = 12;
		int age2 = -1;
		int year2 = 17;
		
		exceptionRule.expect(NegativeNumberException.class);
		exceptionRule.expectMessage("Age or Year must be greater than 0");
		witch.averagePeopleDead(firstYear, age1, year1, age2, year2);
	}
	
	@Test
	public void testNegativeSecondYearAveragePeopleDead() throws NegativeNumberException, YearBornNotValidException {
		int firstYear = 1;
		int age1 = 10;
		int year1 = 12;
		int age2 = 13;
		int year2 = -1;
		
		exceptionRule.expect(NegativeNumberException.class);
		exceptionRule.expectMessage("Age or Year must be greater than 0");
		witch.averagePeopleDead(firstYear, age1, year1, age2, year2);
	}
	
	@Test
	public void testNegativeWitchTakeControlAveragePeopleDead() throws NegativeNumberException, YearBornNotValidException {
		int firstYear = -1;
		int age1 = 10;
		int year1 = 12;
		int age2 = 13;
		int year2 = 17;
		
		exceptionRule.expect(NegativeNumberException.class);
		exceptionRule.expectMessage("First Year must be greater than 0");
		witch.averagePeopleDead(firstYear, age1, year1, age2, year2);
	}
	
	@Test
	public void testAgeOneBeforeFirstYearWitchControlAveragePeopleDead() throws NegativeNumberException, YearBornNotValidException {
		int firstYear = 5;
		int age1 = 10;
		int year1 = 12;
		int age2 = 2;
		int year2 = 4;
		
		exceptionRule.expect(YearBornNotValidException.class);
		exceptionRule.expectMessage("Year born must be greater than or equals the witch take control");
		witch.averagePeopleDead(firstYear, age1, year1, age2, year2);
	}
	
	@Test
	public void testAgeTwoBeforeFirstYearWitchControlAveragePeopleDead() throws NegativeNumberException, YearBornNotValidException {
		int firstYear = 15;
		int age1 = 10;
		int year1 = 12;
		int age2 = 13;
		int year2 = 17;
		
		exceptionRule.expect(YearBornNotValidException.class);
		exceptionRule.expectMessage("Year born must be greater than or equals the witch take control");
		witch.averagePeopleDead(firstYear, age1, year1, age2, year2);
	}
	
	@Test
	public void testNegativeDifferenceAgeOneYearOneAveragePeopleDead() throws NegativeNumberException, YearBornNotValidException {
		int firstYear = 1;
		int age1 = 12;
		int year1 = 10;
		int age2 = 13;
		int year2 = 17;
		
		exceptionRule.expect(NegativeNumberException.class);
		exceptionRule.expectMessage("Difference between age and year of dead must be greater than 0");
		witch.averagePeopleDead(firstYear, age1, year1, age2, year2);
	}
	
	@Test
	public void testNegativeDifferenceAgeTwoYearTwoAveragePeopleDead() throws NegativeNumberException, YearBornNotValidException {
		int firstYear = 1;
		int age1 = 10;
		int year1 = 12;
		int age2 = 17;
		int year2 = 13;
		
		exceptionRule.expect(NegativeNumberException.class);
		exceptionRule.expectMessage("Difference between age and year of dead must be greater than 0");
		witch.averagePeopleDead(firstYear, age1, year1, age2, year2);
	}
	
	@Test
	public void testDeadYearOneOverflowAveragePeopleDead(){
		int firstYear = 1;
		int age1 = 1;
		int year1 = 46;
		int age2 = 13;
		int year2 = 17;	
		
		try {
			double result = witch.averagePeopleDead(firstYear, age1, year1, age2, year2);
			assertTrue(result<0);
		} catch (NegativeNumberException | YearBornNotValidException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testDeadYearTwoOverflowAveragePeopleDead() {
		int firstYear = 1;
		int age1 = 10;
		int year1 = 12;
		int age2 = 2;
		int year2 = 50;
		
		try {
			double result = witch.averagePeopleDead(firstYear, age1, year1, age2, year2);
			assertTrue(result<0);
		} catch (NegativeNumberException | YearBornNotValidException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testRightAveragePeopleDead() {
		int firstYear = 1;
		int age1 = 10;
		int year1 = 12;
		int age2 = 13;
		int year2 = 17;
		
		try {
			double result = witch.averagePeopleDead(firstYear, age1, year1, age2, year2);
			assertTrue(result==4.5);
		} catch (NegativeNumberException | YearBornNotValidException e) {
			System.out.println(e.getMessage());
		}
	}

}
