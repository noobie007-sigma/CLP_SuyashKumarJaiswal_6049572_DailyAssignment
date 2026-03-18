package com.example.springboot_assignment_1.services;

import java.util.List;

import com.example.springboot_assignment_1.entities.Trainee;

public interface ITraineeService {
	void insert(Trainee t);
	Trainee findById(Integer id);
	List<Trainee> findAll();
//	List<Trainee> findByName(String name);
	void delete(Integer id);
	void update(Trainee t);
}
