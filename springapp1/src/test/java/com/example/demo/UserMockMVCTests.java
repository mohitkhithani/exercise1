package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUint4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserMockMVCTests {

	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc=MockMvcBuilders.webAppContextSetup(this.ctx).build();
	}
	
	
	@Test
	public void testBasicMVC() throws Exception{
		MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk()).andExcept(jsonPath("result",
				is("hello"))).andReturn();
		String content=result.getResponse().getContentAsString();
		System.out.println("{testBasicMVC} response:"+content);
	}
		
	@Test
	public void testSingleUser() throws Exception{
		MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/user/100")).andExpect(status().isOk()).andExcept(jsonPath("userid",
				is(100))).andExcept(jsonPath("username",is("david"))).andReturn();
		String content=result.getResponse().getContentAsString();
		System.out.println("{testSingleUser} response:"+content);
	}
	
	}

