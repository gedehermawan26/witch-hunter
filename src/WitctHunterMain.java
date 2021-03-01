import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import geekseat.entity.Villager;
import geekseat.exception.NegativeNumberException;
import geekseat.exception.YearBornNotValidException;
import geekseat.implementation.WitchImpl;
import geekseat.interfaces.WitchInterface;

public class WitctHunterMain {
	
	public static void main(String[] args) throws NegativeNumberException {
		runList();
	}
	
	/**
	 * 1. add new villager
	 * 2. count average dead people
	 * 0. exit
	 */
	private static void runList() {
		System.out.println("Geekseat Witch Saga: Return of The Coder!\n");
		ArrayList<Villager> villagers = new ArrayList<Villager>();
		WitchInterface witch = new WitchImpl();
		
		Scanner scan = new Scanner(System.in);
		int input = 0;
		
		System.out.print("First year the witch take control : ");
		int firstYear = scan.nextInt();
		
		//initiate input
		try {
			if(firstYear < 0) {
				System.out.println("First Year must be greater than 0");
			}else {
				input = requestInput(scan);
				while(input != 0) {
					System.out.println("Input : "+input);
					if(input != 1 && input != 2) {
						System.out.println("Please input either 0, 1, or 2");
						input = requestInput(scan);
					} else if(input == 1) {
						System.out.print("Age of death person : ");
						int age = scan.nextInt();
						System.out.print("Year born of death person : ");
						int year = scan.nextInt();
						villagers.add(new Villager(age,year));
						System.out.println("villager successfully added. Total Villagers : "+villagers.size());
						input = requestInput(scan);
					} else if(input == 2) {
						double averageDeadPeople = witch.averageListOfPeopleDead(firstYear, villagers);
						if(averageDeadPeople < 0) {
							System.out.println("The average number of people the witch killed on year of birth of those people: "+averageDeadPeople+" (the value may be overflow)");
						}else {
							System.out.println("The average number of people the witch killed on year of birth of those people: "+averageDeadPeople);		
						}
						
						input = requestInput(scan);
					}
				}
				System.out.println("Program terminated. Thank you :D");
			}
		} catch (NegativeNumberException | YearBornNotValidException e) {
			System.out.println(e.getMessage());
			System.out.println("The average number of people the witch killed on year of birth of those people: -1");
		} catch(InputMismatchException e) {
			System.out.println("Please input only number");
		}
		scan.close();
	}
	
	private static int requestInput(Scanner scan) {
		System.out.println("==============================================================================================");
		System.out.println("Input 1 for add new villager");
		System.out.println("Input 2 for count average dead people");
		System.out.println("Input 0 for exit");
		System.out.print("Option : ");
		return scan.nextInt();
	}

}
