package com.tgreenidge.songr.SongApplication;

import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class SongApplicationTests {
	@Autowired
	HelloWorldController helloWorldController;

	@Autowired
	MockMvc mockMvc;


	@Test
	public void contextLoads() {
	}

	@Test
	public void testControllerIsAutowired() {
		assertNotNull(helloWorldController);
	}

	@Test
	public void testRequestToRootGivesHello() throws Exception {
		mockMvc.perform(get("/hello")).andExpect(content().string(containsString("hello")));
	}

	@Test
	public void testRequestToCapitalizeGivesCapitalization() throws Exception {
		mockMvc.perform(get("/capitalize/hello")).andExpect(content().string(containsString("HELLO")));
	}

	@Test
	public void testRequestToReverseGivesReversed() throws Exception {
		mockMvc.perform(get("/reverse?sentence=Hello world")).andExpect(content().string(containsString("world Hello")));
	}

}




