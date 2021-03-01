package geekseat.entity;

public class Villager {
	private int age;
	private int year;
	
	public Villager() {
		this.age = 0;
		this.year = 0;
	}
	
	public Villager(int age, int year) {
		this.age = age;
		this.year = year;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
}
