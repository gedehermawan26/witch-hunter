import java.util.InputMismatchException;
import java.util.Scanner;

import geekseat.exception.NegativeNumberException;
import geekseat.exception.YearBornNotValidException;
import geekseat.implementation.WitchImpl;
import geekseat.interfaces.WitchInterface;

public class WitctHunterMain {
	
	public static void main(String[] args) throws NegativeNumberException {
		run();
	}
	
	private static void run() {
		System.out.println("Geekseat Witch Saga: Return of The Coder!\n");
		Scanner scan = new Scanner(System.in);
		try {
			System.out.print("First year the witch take control : ");
			int firstYear = scan.nextInt();
			System.out.print("Age of death person 1 : ");
			int age1 = scan.nextInt();
			System.out.print("Year born of death person 1 : ");
			int year1 = scan.nextInt();
			System.out.print("Age of death person 2 : ");
			int age2 = scan.nextInt();
			System.out.print("Year born of death person 2 : ");
			int year2 = scan.nextInt();
			
			WitchInterface witch = new WitchImpl();
			double averageDeadPeople = witch.averagePeopleDead(firstYear,age1, year1, age2, year2);
			System.out.println("The average number of people the witch killed on year of birth of those people: "+averageDeadPeople);
			
		} catch (NegativeNumberException | YearBornNotValidException e) {
			System.out.println(e.getMessage());
			System.out.println("The average number of people the witch killed on year of birth of those people: -1");
		} catch(InputMismatchException e) {
			System.out.println("Please input only number");
		}
		scan.close();
	}

}
