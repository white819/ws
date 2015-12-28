package com.common;

public class AuthenticationException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthenticationException(String message, String realm) {
        super(message);
        this.realm = realm;
    }

    private String realm = null;

    public String getRealm() {
        return this.realm;
    }

}
