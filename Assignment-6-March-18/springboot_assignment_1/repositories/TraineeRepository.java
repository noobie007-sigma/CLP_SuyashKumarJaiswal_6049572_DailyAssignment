package com.example.springboot_assignment_1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_assignment_1.entities.Trainee;

public interface TraineeRepository extends JpaRepository<Trainee, Integer> {
	
}
