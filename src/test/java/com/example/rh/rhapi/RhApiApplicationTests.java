package com.example.rh.rhapi;

import com.example.rh.rhapi.model.Employe;
import com.example.rh.rhapi.repository.EmployeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RhApiApplicationTests {


	@Test
	void contextLoads() {
	}
	/*@Test
	public void testAjoutEmploye(){
		Employe E1= new Employe("Arame", "Mboup","mboup0@gmail.com","arame1234");
		//Employe E2 = new Employe("Maty", "Mboup","mboup0@gmail.com","pa1234");

		employeRepos.save(E1);
		//employeRepos.save(E2);

		System.out.println(E1);
		//System.out.println(E2);


	}
	/*
	@Test
	public void testFindEmploye(){
		Employe a = employeRepos.findById(2L).get();
		System.out.println(a);

	}
	@Test
	public void nombreEmploye(){
		long x= employeRepos.count();
		System.out.println(x);
	}
	@Test
	public void testFindAllEmployes(){
		List <Employe> a = (List<Employe>) employeRepos.findAll();
		for (Employe p:a){
			System.out.println(p);
		}


	}
	@Test
	public void testUpdateEmploye(){
		Employe a = employeRepos.findById(3L).get();
		a.setPrenom("Fatou");
		a.setNomDeFamille("Fall");
		a.setMail("Fatou@gmail.com");
		a.setPassword("Fatou1234");
		employeRepos.save(a);
		System.out.println(a);

	}
	@Test
	public void testDeleteEmploye(){
		employeRepos.deleteById(4L);
		System.out.println("supression reussi");


	}

*/
}
