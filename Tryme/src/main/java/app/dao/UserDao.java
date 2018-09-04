package app.dao;

import java.util.Map;

import app.dto.UserDto;

public interface UserDao {
	@SuppressWarnings("rawtypes")
	public Map checkUser(UserDto user);
}
