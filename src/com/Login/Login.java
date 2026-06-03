package com.Login;

public interface Login<T> 
{
	void createAccount(String username, String name, long contactno);
	void getLoginCredentials(String username, String Password);
	boolean verifyPassword(String username, String Password);
	T directAccount();	
}
