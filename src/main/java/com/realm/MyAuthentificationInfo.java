package com.realm;

import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;


public class MyAuthentificationInfo implements SaltedAuthenticationInfo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public PrincipalCollection getPrincipals() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ByteSource getCredentialsSalt() {
		// TODO Auto-generated method stub
		return null;
	}


}
