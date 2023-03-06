package com.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
