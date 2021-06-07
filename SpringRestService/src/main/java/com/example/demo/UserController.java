package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public List<User> list(){
		return service.listAll();
	}
	
	@GetMapping("/users/{id}")
	public User get(@PathVariable Integer id) {
		
		return service.get(id);
	}
	
	
	@PostMapping("/users")
	public void add(@RequestBody User user) {
		service.save(user);
	}
	
	@PutMapping("/users/{id}")
	public void update(@RequestBody User user,@PathVariable Integer id) {
		service.save(user);
	}
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	
}
