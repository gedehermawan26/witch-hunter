package geekseat.interfaces;

import geekseat.exception.NegativeNumberException;
import geekseat.exception.YearBornNotValidException;

public interface WitchInterface {
	public int countDiedVillagers(int year) throws NegativeNumberException;
	public double averagePeopleDead(int firstYear,int age1, int year1, int age2, int year2) throws NegativeNumberException, YearBornNotValidException;
}
