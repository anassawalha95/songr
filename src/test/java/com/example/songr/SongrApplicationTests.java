package com.example.songr;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class SongrApplicationTests {


	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testHomePage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testHelloWorldPage() throws Exception {
		this.mockMvc.perform(get("/helloworld")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testCapitalize() throws Exception {
		this.mockMvc.perform(get("/capitalize/anas")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("<h1>wow Capitalized: <span>ANAS</span>!!</h1>")));
	}
	@Test
	public void testAlbumsRoute() throws Exception {
		this.mockMvc.perform(get("/albums")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testSongsRoute() throws Exception {
		this.mockMvc.perform(get("/songs")).andDo(print()).andExpect(status().isOk());
	}
}
