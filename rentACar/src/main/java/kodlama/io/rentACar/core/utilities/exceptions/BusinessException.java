package kodlama.io.rentACar.core.utilities.exceptions;

public class BusinessException extends RuntimeException {
	public BusinessException(String message) { //our custom RuntimeException
		super(message);
	}
}
