package com.example.demo.responses;

import java.io.Serializable;


public class JwtResponse implements Serializable  {
	private static final long serialVersionUID = -8091879091924046844L;
	public String jwttoken;
    public String username;
    public String email;
    
    
	public JwtResponse(String jwttoken, String username, String email) {
		super();
		this.email = email;
		this.jwttoken = jwttoken;
		this.username = username;
	}


	public String getJwttoken() {
		return jwttoken;
	}


	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
    
    
    

}


//public class JwtResponse implements Serializable {
//
//	private static final long serialVersionUID = -8091879091924046844L;
//	private final String jwttoken;
//
//	public JwtResponse(String jwttoken) {
//		this.jwttoken = jwttoken;
//	}
//
//	public String getToken() {
//		return this.jwttoken;
//	}
//}