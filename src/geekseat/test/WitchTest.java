package geekseat.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import geekseat.entity.Villager;
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
			System.out.println("testOverflowValueCountDiedVillagers : "+e.getMessage());
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
			System.out.println("testZeroInputCountDiedVillagers : "+e.getMessage());
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
			System.out.println("testOneInputCountDiedVillagers : "+e.getMessage());
		}
	}
	
	@Test
	public void testRightInputCountDiedVillagers() throws NegativeNumberException {
		int year = 5;
		
		try {
			int result = witch.countDiedVillagers(year);
			assertTrue(result==12);
		} catch (NegativeNumberException e) {
			System.out.println("testRightInputCountDiedVillagers : "+e.getMessage());
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
			System.out.println("testDeadYearOneOverflowAveragePeopleDead : "+e.getMessage());
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
			System.out.println("testDeadYearTwoOverflowAveragePeopleDead : "+e.getMessage());
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
			System.out.println("testRightAveragePeopleDead : "+e.getMessage());
		}
	}
	
	@Test
	public void testNegativeAgeAverageListOfPeopleDead() throws NegativeNumberException, YearBornNotValidException {
		int firstYear = 1;
		ArrayList<Villager> villagers = new ArrayList<Villager>();
		villagers.add(new Villager(-2,4));
		villagers.add(new Villager(2,5));
		villagers.add(new Villager(2,6));
		
		exceptionRule.expect(NegativeNumberException.class);
		exceptionRule.expectMessage("Age or Year (Age : "+villagers.get(0).getAge()+", Year : "+villagers.get(0).getYear()+")");
		witch.averageListOfPeopleDead(firstYear, villagers);
	}
	
	@Test
	public void testNegativeYearAverageListOfPeopleDead() throws NegativeNumberException, YearBornNotValidException {
		int firstYear = 1;
		ArrayList<Villager> villagers = new ArrayList<Villager>();
		villagers.add(new Villager(2,4));
		villagers.add(new Villager(2,-5));
		villagers.add(new Villager(2,6));
		
		exceptionRule.expect(NegativeNumberException.class);
		exceptionRule.expectMessage("Age or Year (Age : "+villagers.get(1).getAge()+", Year : "+villagers.get(1).getYear()+")");
		witch.averageListOfPeopleDead(firstYear, villagers);
	}
	
	@Test
	public void testNegativeDifferenceAgeYearAverageListOfPeopleDead() throws NegativeNumberException, YearBornNotValidException {
		int firstYear = 1;
		ArrayList<Villager> villagers = new ArrayList<Villager>();
		villagers.add(new Villager(2,4));
		villagers.add(new Villager(2,5));
		villagers.add(new Villager(6,2));
		
		exceptionRule.expect(NegativeNumberException.class);
		exceptionRule.expectMessage("Difference between age and year of dead (Age : "+villagers.get(2).getAge()+", Year : "+villagers.get(2).getYear()+")");
		witch.averageListOfPeopleDead(firstYear, villagers);
	}
	
	@Test
	public void testNegativeFirstYearWitchTakeControllAverageListOfPeopleDead() throws NegativeNumberException, YearBornNotValidException {
		int firstYear = -1;
		ArrayList<Villager> villagers = new ArrayList<Villager>();
		villagers.add(new Villager(2,4));
		villagers.add(new Villager(2,5));
		villagers.add(new Villager(2,6));
		
		exceptionRule.expect(NegativeNumberException.class);
		exceptionRule.expectMessage("First Year must be greater than 0");
		witch.averageListOfPeopleDead(firstYear, villagers);
	}
	
	@Test
	public void testDeadYearOverflowAverageListOfPeopleDead() {
		int firstYear = 1;
		ArrayList<Villager> villagers = new ArrayList<Villager>();
		villagers.add(new Villager(2,4));
		villagers.add(new Villager(2,5));
		villagers.add(new Villager(2,47));
				
		try {
			double result = witch.averageListOfPeopleDead(firstYear, villagers);
			assertTrue(result<0);
		} catch (NegativeNumberException | YearBornNotValidException e) {
			System.out.println("testDeadYearOverflowAverageListOfPeopleDead : "+e.getMessage());
		}
	}
	
	@Test
	public void testAgeBeforeFirstYearWitchControlAverageListOfPeopleDead() throws NegativeNumberException, YearBornNotValidException {
		int firstYear = 10;
		ArrayList<Villager> villagers = new ArrayList<Villager>();
		villagers.add(new Villager(2,4));
		villagers.add(new Villager(11,17));
		villagers.add(new Villager(2,47));
		
		exceptionRule.expect(YearBornNotValidException.class);
		exceptionRule.expectMessage("Year born must be greater than or equals the witch take control");
		witch.averageListOfPeopleDead(firstYear, villagers);
	}
	
	@Test
	public void testRightInputAverageListOfPeopleDead() {
		int firstYear = 1;
		ArrayList<Villager> villagers = new ArrayList<Villager>();
		villagers.add(new Villager(2,5));
		villagers.add(new Villager(2,6));
		villagers.add(new Villager(2,7));
		villagers.add(new Villager(2,8));
				
		try {
			double result = witch.averageListOfPeopleDead(firstYear, villagers);
			assertTrue(result==10.75);
		} catch (NegativeNumberException | YearBornNotValidException e) {
			System.out.println("testRightInputAverageListOfPeopleDead : "+e.getMessage());
		}
	}

	
}
