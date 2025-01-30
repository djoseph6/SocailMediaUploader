
public class CustomExceptions extends Exception {
	   
	public EmptyStringException() {
	        super("The string cannot be empty.");
	    }

	    public EmptyStringException(String message) {
	        super(message);
	    }
	    
	public IllegalArgumentException(String fileExtension) {
		super("Unsupported video format: " + fileExtension);
	}
}

