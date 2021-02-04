package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

@Autowired

	UserService userService;

	@Test
	public void testAllUsers() {
		List<User> users =userService.getAllUser();
		assertEquals(3,users.size());
		
	}
	
	public void testSingleUser()
	{
		User user = userService.getAllUser();
		assertTrue(user.getUsername().contains("david"));
		
	}
}
