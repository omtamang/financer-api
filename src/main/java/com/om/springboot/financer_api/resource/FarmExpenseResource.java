package com.om.springboot.financer_api.resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.om.springboot.financer_api.expenses.Farm;
import com.om.springboot.financer_api.repository.FarmRepository;

@RestController
public class FarmExpenseResource {
	
	private FarmRepository farmRepository;

	public FarmExpenseResource(FarmRepository farmRepository) {
		super();
		this.farmRepository = farmRepository;
	}
	
	@PostMapping("/addExpense")
	public void addFarmExpense(@RequestBody Farm farm) {
		farmRepository.save(farm);
	}
}
