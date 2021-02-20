package geekseat.exception;

public class YearBornNotValidException extends Exception{
	public YearBornNotValidException(){
		super("Year born must be greater than or equals the witch take control");	
	}
}
