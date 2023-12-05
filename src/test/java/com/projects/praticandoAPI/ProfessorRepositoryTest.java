package com.projects.praticandoAPI;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.projects.praticandoAPI.modelo.Professor;
import com.projects.praticandoAPI.repository.ProfessorRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class ProfessorRepositoryTest {

	 @Autowired
	 private ProfessorRepository repository;

	 @Autowired
	 private TestEntityManager em;

	 	//@Test
	 //	public void testeORM(){
	 		
	 	//}
	   
	 
	 @Test
	    public void deveriaCarregarUmProfessorPeloNome() {
	        String nomeProfessor = "Andreia";

	        Professor python = new Professor();
	        python.setProfessor(nomeProfessor);
	        python.setDisciplina("python");
	        em.persist(python);

	        Professor professor = repository.findByProfessor(nomeProfessor);
	        Assertions.assertNotNull(professor);
	        Assertions.assertEquals(nomeProfessor, professor.getProfessor());
	    }

	    @Test
	    public void NaodeveriaCarregarUmProfessorPeloNome() {
	        String nomeProfessor2 = "Fabio";
	        Professor professor = repository.findByProfessor(nomeProfessor2);
	        Assertions.assertNull(professor);
	        }


	
		
	
   
 }

    
  





