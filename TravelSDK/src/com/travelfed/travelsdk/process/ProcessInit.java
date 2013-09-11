package com.travelfed.travelsdk.process;

import com.travelfed.travelsdk.bean.Result;

/**
 * Process initialization of TravelSDK.
 */
public abstract class ProcessInit extends ProcessWS<Result> {

	private String client;
	private String username;
	private String password;
	private String email;
	private String securityToken;
	
	/**
	 * 
	 * @param client - client (agency) ID
	 * @param username - login username
	 * @param pass - login password
	 * @param email - Email associated with security token from administration
	 *            web site
	 * @param securityToken - security token associated with the given email
	 *            from administration web site
	 */
	public ProcessInit(String client, String username, String pass, String email, String securityToken) {
		this.client = client;
		this.username = username;
		this.password = pass;
		this.setEmail(email);
		this.setSecurityToken(securityToken);
	}

	/**
	 * This is called by the API.
	 * @param errorCode
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? "" : email;
	}

	public String getSecurityToken() {
		return securityToken;
	}

	public void setSecurityToken(String securityToken) {
		this.securityToken = securityToken == null ? "" : securityToken;
	}
	
	
}
