package com.Login;

public interface Login<T> 
{
	void createAccount(String username);
	void getLoginCredentials(String username, String Password);
	boolean verifyPassword(String username, String Password);
	T directAccount();	
}
