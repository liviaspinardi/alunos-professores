package com.projects.praticandoAPI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.projects.praticandoAPI.controller.BemVindo;



@RunWith(SpringRunner.class)
//@SpringBootTest 
@WebMvcTest(controllers = BemVindo.class) 

public class PraticandoApiApplicationTests {

	@Autowired
    private MockMvc mockMvc;
		
	@Test
    public void testBemVindo() throws Exception {
        
        mockMvc
                .perform(MockMvcRequestBuilders.get("/facens"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Bem vindo(a) a Facens!"));
    }

	
}

