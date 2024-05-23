package diegonobre.com.encryptapi.domain.exception;

public class OperationNotFound extends RuntimeException {
	public OperationNotFound () {
		super("Operation not found");
	}
}
