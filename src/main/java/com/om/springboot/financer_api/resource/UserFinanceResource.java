package com.om.springboot.financer_api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.om.springboot.financer_api.expenses.Farm;
import com.om.springboot.financer_api.repository.FarmRepository;
import com.om.springboot.financer_api.repository.UserRepository;
import com.om.springboot.financer_api.users.Users;

@RestController
public class UserFinanceResource {
	
	private UserRepository userRepository;
	private FarmRepository farmRepository;

	public UserFinanceResource(UserRepository userRepository, FarmRepository farmRepository) {
		super();
		this.userRepository = userRepository;
		this.farmRepository = farmRepository;
	}
	
	@GetMapping("/users")
	public List<Users> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}/farm")
	public List<Farm> getFarmExpense(@PathVariable int id){
		Optional<Users> users = userRepository.findById(id);
		return users.get().getFarm();
	}
	
	@GetMapping("/users/{name}")
	public List<Users> findByName(@PathVariable String name){
		return userRepository.findByName(name);
	}
	
	@PostMapping("/addExpense/{id}/farm")
	public ResponseEntity<String> addFarmExpense(@PathVariable int id, @RequestBody Farm farm) {
		Users users = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found"));
		farm.setUsers(users);
		farmRepository.save(farm);
		return ResponseEntity.status(HttpStatus.CREATED).body("Farm expense added successfully");
	}
	
	@PostMapping("/adduser")
	public void addUser(@RequestBody Users users) {
		userRepository.save(users);
	}
	
}
