package com.om.springboot.financer_api.resource;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
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
	public ResponseEntity<List<String>> getFarmExpense(@PathVariable int id){
		Optional<Users> users = userRepository.findById(id);
		
		List<Farm> farm = users.get().getFarm();
		
		// Initialize total variables
	    float totalLabour = 0;
	    float totalFertilizer = 0;
	    float totalPesticides = 0;
	    float totalSeeds = 0;
	    
	    // Sum up each expense type across all farm entries
	    for (Farm farms : farm) {
	        totalLabour += farm.get(0).getLabour();
	        totalFertilizer += farm.get(0).getFertilizer();
	        totalPesticides += farm.get(0).getPesticides();
	        totalSeeds += farm.get(0).getSeeds();
	    }
	    
	    float totalExpense = totalLabour + totalFertilizer + totalPesticides + totalSeeds;
	    
	    final DecimalFormat df = new DecimalFormat("0.00");
	    df.setRoundingMode(RoundingMode.UP);
	    
	    // Calculate percentage for each type
	    String labourPercentage = (df.format((totalLabour / totalExpense) * 100));
	    String fertilizerPercentage = df.format((totalFertilizer / totalExpense) * 100);
	    String pesticidesPercentage = df.format((totalPesticides / totalExpense) * 100);
	    String seedsPercentage = df.format((totalSeeds / totalExpense) * 100); 
		
		return ResponseEntity.ok(Arrays.asList(labourPercentage, fertilizerPercentage, pesticidesPercentage, seedsPercentage));
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
