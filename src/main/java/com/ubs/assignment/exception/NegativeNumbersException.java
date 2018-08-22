package com.ubs.assignment.exception;

public class NegativeNumbersException extends Exception{

		private static final long serialVersionUID = 8905766515905282935L;

		public NegativeNumbersException() {
	    }

	    public NegativeNumbersException(String message) {
	        super(message);
	    }

	    public NegativeNumbersException(Throwable cause) {
	        super(cause);
	    }

	    public NegativeNumbersException(String message, Throwable cause) {
	        super(message, cause);
	    }

}
