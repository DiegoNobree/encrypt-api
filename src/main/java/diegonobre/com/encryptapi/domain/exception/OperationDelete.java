package diegonobre.com.encryptapi.domain.exception;

public class OperationDelete {
	private String message;
	
	public OperationDelete () {
		this.message = "Operation deleted successfully";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
