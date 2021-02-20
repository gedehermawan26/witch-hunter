package geekseat.exception;

public class NegativeNumberException  extends Exception{
	public NegativeNumberException(String obj) {
		super(obj+" must be greater than 0");
	}
}
