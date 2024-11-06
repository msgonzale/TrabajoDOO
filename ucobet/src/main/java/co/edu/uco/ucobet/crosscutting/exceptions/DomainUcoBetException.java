package co.edu.uco.ucobet.crosscutting.exceptions;

import co.edu.uco.crosscutting.exceptions.enums.Layer;

public class DomainUcoBetException extends UcoBetException{

	public DomainUcoBetException(String userMessage, String technicalMessage, Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.DOMAIN);
		// TODO Auto-generated constructor stub
	}
	
	public static final DomainUcoBetException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new DomainUcoBetException(userMessage, technicalMessage, rootException);
	}

	public static final DomainUcoBetException crear(final String userMessage) {
		return new DomainUcoBetException(userMessage, userMessage, new Exception());
	}

	public static final DomainUcoBetException crear(final String userMessage, final String technicalMessage) {
		return new DomainUcoBetException(userMessage, technicalMessage, new Exception());
	}
	
}