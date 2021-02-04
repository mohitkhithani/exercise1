package com.example.demo.services;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.services.UserService;
import com.example.demo.model.User;
@Service
public class UserServiceImpl implements UserService {
	
	public List<User> getAllUsers(){
		return this.users;
		
	}
	@Override
	public User getUser(Integer userid) {
		return users.stream()
				.filter(x ->x.getUserid()==userid)
			     .findAny()
			     .orElse(new User(0,"not available"));
	}
@Override
	public void createUser(Integer userid,String username)
{
	User user=new User(userid,username);
	this.users.add(user);
}
@Override
public void updateUser(Integer userid,String username) {
	 users.stream()
			.filter(x ->x.getUserid()==userid)
		     .findAny()
		     .orElseThrow(()-> new RuntimeException("item not found"))
             .setUsername(username);
}

public void deleteUser(Integer userid) {
	
	users.removeIf((User u)->u.getUserid()==userid);
}

public static List<User> users;
public UserServiceImpl() {
	users=new LinkedList<>();
	users.add(new User(100,"david"));
	users.add(new User(101,"peter"));
}
@Override
public List<User> getAllUser() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public void deleteUser(Integer userid, String username) {
	// TODO Auto-generated method stub
	
}

}
