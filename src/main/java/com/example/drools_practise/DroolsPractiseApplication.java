package com.example.drools_practise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class DroolsPractiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroolsPractiseApplication.class, args);
		System.out.println("Hello WOrld");

		Map<String, String> student1 = new HashMap<>();
		student1.put("id", String.valueOf(1));
		student1.put("name", "Usman");
		student1.put("salaries", String.valueOf(10));
		student1.put("class", "Masters");
		student1.put("subject", "Data Science");

		Map<String, String> student2 = new HashMap<>();
		student2.put("id", String.valueOf(1));
		student2.put("name", "Salman");
		student2.put("salaries", String.valueOf(15));
		student2.put("class", "Masters");
		student2.put("subject", "Data Science");

		List<Map<String, String>> listofStudent= new ArrayList<>();

		listofStudent.add(student1);
		listofStudent.add(student2);

		List list =  listofStudent.stream().map(i-> i.get("name").equalsIgnoreCase("Usman")).collect(Collectors.toList());
		System.out.println(list.size());
		//

		System.out.println(listofStudent);
	}
}