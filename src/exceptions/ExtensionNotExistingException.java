package exceptions;

public class ExtensionNotExistingException extends Exception{
	
	public ExtensionNotExistingException() {
		super("ERROR 020: Extension does not exist");
	}

}
