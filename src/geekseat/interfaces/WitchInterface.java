package geekseat.interfaces;

import java.util.ArrayList;

import geekseat.entity.Villager;
import geekseat.exception.NegativeNumberException;
import geekseat.exception.YearBornNotValidException;

public interface WitchInterface {
	public int countDiedVillagers(int year) throws NegativeNumberException;
	public double averagePeopleDead(int firstYear,int age1, int year1, int age2, int year2) throws NegativeNumberException, YearBornNotValidException;
	public double averageListOfPeopleDead(int firstYear,ArrayList<Villager> villagers) throws NegativeNumberException, YearBornNotValidException;
}
