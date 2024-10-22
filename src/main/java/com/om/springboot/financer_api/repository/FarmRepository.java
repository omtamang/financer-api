package com.om.springboot.financer_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.om.springboot.financer_api.expenses.Farm;

public interface FarmRepository extends JpaRepository<Farm, Integer>{

}
