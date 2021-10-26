package br.com.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String sms) {
		super(sms);
	}

}
