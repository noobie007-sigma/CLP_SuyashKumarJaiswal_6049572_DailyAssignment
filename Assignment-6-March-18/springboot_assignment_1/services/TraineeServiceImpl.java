package com.example.springboot_assignment_1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot_assignment_1.entities.Trainee;
import com.example.springboot_assignment_1.repositories.TraineeRepository;

@Service
public class TraineeServiceImpl implements ITraineeService {

	@Autowired
	TraineeRepository traineeRepository;
	
	@Override
	public void insert(Trainee t) {
		traineeRepository.save(t);
	}
	
	@Override
	public Trainee findById(Integer id) {
		return traineeRepository.findById(id).orElse(null);
	}
	
	@Override
	public List<Trainee> findAll() {
		return traineeRepository.findAll();
	}
	
//	@Override
//	public List<Trainee> findByName(String name) {
//		return traineeRepository.findByTraineeName(name);
//	}
//	
	@Override
	public void delete(Integer id) {
		traineeRepository.deleteById(id);
	}
	
	@Override
	public void update(Trainee t) {
		traineeRepository.save(t);
	}
}
