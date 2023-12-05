package com.projects.praticandoAPI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"com.projects.praticandoAPI"})
@SpringBootTest
@AutoConfigureMockMvc


public class AlunoApiApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testCreateAlunoDefault() throws Exception{
    	final String expectedNome = "Livia Spinardi";
    	final String expectedEmail = "191051@facens.br";
        final String expectedRA = "191051";
        mockMvc
            .perform(MockMvcRequestBuilders.post("/alunos").contentType(MediaType.APPLICATION_JSON).content("{\"email\":\"191051@facens.br\",\"nome\":\"Livia Spinardi\",\"ra\":\"191051\"}"))
            .andExpect(MockMvcResultMatchers.status().is(201))
            .andExpect((ResultMatcher) jsonPath("nome").value(expectedNome))
            .andExpect((ResultMatcher) jsonPath("email").value(expectedEmail))
            .andExpect((ResultMatcher) jsonPath("ra").value(expectedRA));
    }
    
}
