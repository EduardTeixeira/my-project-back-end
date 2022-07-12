package com.projectname.backend.constants;

public interface SecurityConstants {
	
	  String SECRET = "dRgUkXp2s5v8y/B?E(H+KbPeShVmYq3t";
	  
	  long EXPIRATION_TIME = 900_000; // 15 mins
	  
	  String TOKEN_PREFIX = "Bearer ";
	  
	  String HEADER_STRING = "Authorization";
	  
	  String SIGN_UP_URL = "/api/auth/signup";
	  
	  String SIGN_IN_URL = "/api/auth/signin";

}
