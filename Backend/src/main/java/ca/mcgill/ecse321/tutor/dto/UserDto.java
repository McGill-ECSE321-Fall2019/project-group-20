package ca.mcgill.ecse321.cooperator.dto;

import java.util.Collections;
import java.util.List;

public class UserDto {

	private String name;
	private String password;
	private String email;
	

	public UserDto() {
	}

	/*@SuppressWarnings("unchecked")
	public UserDto(String name) {
		this(name, Collections.EMPTY_LIST);
	}*/

	public UserDto(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
		
	}

	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

}