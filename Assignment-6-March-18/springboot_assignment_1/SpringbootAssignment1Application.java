package com.example.springboot_assignment_1;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot_assignment_1.entities.Trainee;
import com.example.springboot_assignment_1.services.ITraineeService;

@SpringBootApplication
public class SpringbootAssignment1Application implements CommandLineRunner {

	
	@Autowired
	ITraineeService iTraineeService;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootAssignment1Application.class, args);
		
	}
	public void run(String ...args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("\n1. Insert trainee\n2. Find trainee by ID\n3. Find all trainees\n4. Update trainee\n5. Delete trainee by ID\n6. Exit");
			int ch = sc.nextInt();
			
			switch(ch) {
			case 1:
				System.out.println("Enter trainee ID: ");
				int id = sc.nextInt();
				if(iTraineeService.findById(id) != null) {
					System.out.println("Trainee with ID: " + id + "already exists.");
					break;
				}
				
				System.out.println("Enter trainee name: ");
				String name = sc.next();
						
				System.out.println("Enter trainee domain: ");
				String domain = sc.next();
				
				System.out.println("Enter trainee location: ");
				String location = sc.next();
				
				iTraineeService.insert(new Trainee(id, name, domain, location));
				break;
				
			case 2:
				System.out.println("Enter trainee ID: ");
				System.out.println(iTraineeService.findById(sc.nextInt()));
				break;				
				
			case 3:
				List<Trainee> trainees = iTraineeService.findAll();
				for(Trainee t : trainees) System.out.println(t);
				break;
				
			case 4:
				System.out.println("Enter trainee ID: ");
				int updateId = sc.nextInt();
				if(iTraineeService.findById(updateId) == null) {
					System.out.println("Trainee with ID: " + updateId + "does not exists.");
					break;
				}
				
				System.out.println("Enter trainee name: ");
				String updateName = sc.next();
						
				System.out.println("Enter trainee domain: ");
				String updateDomain = sc.next();
				
				System.out.println("Enter trainee location: ");
				String updateLocation = sc.next();
				
				iTraineeService.update(new Trainee(updateId, updateName, updateDomain, updateLocation));
				break;
				
			case 5:
				System.out.println("Enter ID: ");
				int deleteId = sc.nextInt();
				if(iTraineeService.findById(deleteId) != null) {
					iTraineeService.delete(deleteId);
				} else {
					System.out.println("Trainee with ID: " + deleteId + " does not exist");
				}
				break;
				
			case 6:
				System.out.println("Thank you for using our application");
				break;
			}
		}
	}

}
