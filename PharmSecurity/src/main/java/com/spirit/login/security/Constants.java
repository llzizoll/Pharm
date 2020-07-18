package com.spirit.login.security;
/**
*
* @author Zizo
*/
public class Constants {

    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5*60*60;
    public static final String SIGNING_KEY = "zizo123r";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_STRING = "Authorization";
    public static final String AUTHORITIES_KEY = "scopes";
    public static final String USER_ID = "UserID";
}
