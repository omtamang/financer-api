package com.om.springboot.financer_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.om.springboot.financer_api.users.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	public List<Users> findByName(String name);
}
