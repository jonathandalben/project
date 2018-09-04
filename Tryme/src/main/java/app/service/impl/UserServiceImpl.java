package app.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.UserDao;
import app.dto.UserDto;
import app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@SuppressWarnings("rawtypes")
	@Override
	public Map checkUser(UserDto user) {
		return userDao.checkUser(user);
	}

}
