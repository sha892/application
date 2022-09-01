package com.example.demo;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@SpringBootTest
class SpringbootBackendApplicationTests {

	/*
	@Test
	void contextLoads() {
	}
    */
	
	@Autowired
	EmployeeRepository repo;
	
	@Test
	public void testCreate () {
		
		Employee e = new Employee();
		e.setId(1L);
		e.setFirstName("snehalll");
		e.setLastName("chavannnn");
		e.setEmailId("snehallllll@gmail.com");
		repo.save(e);
		assertNotNull(repo.findById(1L).get());
		
		
	}

	private void assertNotNull(Employee employee) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Test
	public void testReadAll () {
		
		List<Employee> list = repo.findAll();
		assertThat(list).size().isGreaterThan(0);
		
		
	}
	
	@Test
	public void testSingleProduct () {
	Employee employee = repo.findById(1L).get();
	assertEquals("rita", employee.getFirstName());	
		
		
		
	}

	private void assertEquals(String string, String firstName) {
		// TODO Auto-generated method stub
		
	}
	
	@Test
	public void testUpdate() {
		Employee e = repo.findById(1L).get();
		e.setFirstName("shitallll");
		repo.save(e);
		assertNotEquals("shamli", repo.findById(1L).get().getFirstName());
		
		
	}

	private void assertNotEquals(String string, String firstName) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	@Test
	public void testDelete () {
		
		repo.deleteById(14L);
		assertThat(repo.existsById(14L)).isFalse();
	}
	
	*/
	
	
	
	
	
	
	
	
	
}
