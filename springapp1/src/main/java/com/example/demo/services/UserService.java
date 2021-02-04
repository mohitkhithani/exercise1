package com.example.demo.services;
import com.example.demo.model.User;
import java.util.List;
public interface UserService {
List<User> getAllUser();
	User getUser(Integer userid);
	void createUser(Integer userid,String username);
	void updateUser(Integer userid,String username);
	void deleteUser(Integer userid,String username);
}

