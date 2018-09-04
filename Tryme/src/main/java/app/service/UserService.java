package app.service;

import java.util.Map;

import app.dto.UserDto;

public interface UserService {
	@SuppressWarnings("rawtypes")
	public Map checkUser(UserDto user);
}
