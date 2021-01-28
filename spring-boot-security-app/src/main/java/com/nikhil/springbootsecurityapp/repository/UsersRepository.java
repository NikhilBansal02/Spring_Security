package com.nikhil.springbootsecurityapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nikhil.springbootsecurityapp.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByusername(String username);

}
