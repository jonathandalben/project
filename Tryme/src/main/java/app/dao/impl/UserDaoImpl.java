package app.dao.impl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import app.dao.UserDao;
import app.dto.UserDto;
import app.dto.UserInfoDto;

@Repository
public class UserDaoImpl implements UserDao {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map checkUser(UserDto user) {
		
		Map checkMap = new HashMap();
		JSONParser parser = new JSONParser();
		JSONArray userListArray = null;
		
		File file = null;
		
		try {
			file = ResourceUtils.getFile("classpath:static/json/user.json");
			userListArray = (JSONArray) parser.parse(new FileReader(file));
			
			for (Object o : userListArray) {
				JSONObject userObj = (JSONObject) o;
				if( user.getUsername().equals((String) userObj.get("username")) && user.getPassword().equals((String) userObj.get("password")) ) {
					UserInfoDto userInfo = new UserInfoDto();
					userInfo.setLastName((String) userObj.get("lastName"));
					userInfo.setFirstName((String) userObj.get("firstName"));
					userInfo.setMiddleName((String) userObj.get("middleName"));
					userInfo.setCompany((String) userObj.get("company"));
					userInfo.setMotto((String) userObj.get("motto"));
					checkMap.put("isAuthenticate", true);
					checkMap.put("userInfo", userInfo);
					return checkMap;
				}
			}		
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		checkMap.put("isAuthenticate", false);
		return checkMap;
	}

}
