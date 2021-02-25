package geekseat.implementation;

import geekseat.exception.NegativeNumberException;
import geekseat.exception.YearBornNotValidException;
import geekseat.interfaces.WitchInterface;

public class WitchImpl implements WitchInterface {

	@Override
	public int countDiedVillagers(int year) throws NegativeNumberException {
		if (year == 0) {
			return 0;
		} else if(year < 0) {
			throw new NegativeNumberException("Year Dead");
		} else{
			int beforeDead = 0;
			int currentDead = 1;
			int nextDead = 0;
			int totalDead = 0;
			for(int y = 1; y<=year; y++) {
				totalDead += currentDead;
				nextDead = currentDead + beforeDead;
				beforeDead = currentDead;
				currentDead = nextDead;
			}
			return totalDead;	
		}	
	}
	
	@Override
	public double averagePeopleDead(int firstYear,int age1, int year1, int age2, int year2) throws NegativeNumberException, YearBornNotValidException {
		if(firstYear < 0) {
			throw new NegativeNumberException("First Year");
		}
		
		if(age1 < 0 || age2 < 0 || year1 < 0 || year2 < 0) {
			throw new NegativeNumberException("Age or Year");
		}
		
		if(year1 < firstYear || year2 < firstYear) {
			throw new YearBornNotValidException();
		}
		
		int deadYearP1 = year1 - age1;
		int deadYearP2 = year2 - age2;
		
		if(deadYearP1 < 0 || deadYearP2 < 0) {
			throw new NegativeNumberException("Difference between age and year of dead");
		}
		int peopleDead1 = countDiedVillagers(deadYearP1);
		int peopleDead2 = countDiedVillagers(deadYearP2);
		double averageDead = (peopleDead1+peopleDead2)*1.0/2;
		return averageDead;
	}

}
