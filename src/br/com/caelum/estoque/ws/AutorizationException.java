package br.com.caelum.estoque.ws;

import javax.xml.ws.WebFault;

@WebFault(name = "AutorizationFault")
public class AutorizationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AutorizationException(String message) {
		super(message);
	}
	
}
