package com.hibernate.cruddemo;

import com.hibernate.cruddemo.dao.StudentDAO;
import com.hibernate.cruddemo.dao.StudentDAOImpl;
import com.hibernate.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			System.out.println();
			//To create a single student
			createStudent(studentDAO);

			//To get a single student
			//selectStudentById(studentDAO);

			//To get list of all students
			//getAllStudents(studentDAO);

			//To get students with matching last name;
			//findStudentByLastName(studentDAO);

			//To update values
			//updateStudent(studentDAO);

			//To update using query
			//updateStudentUsingQuery(studentDAO);

			//delete student
			//deleteStudent(studentDAO);

			//delete all student
			//deleteAllStudent(studentDAO);




			System.out.println();
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println();
		System.out.println("******** NO OF ROWS DELETED ************* "+studentDAO.deleteAll());
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.deleteStudent(3);
	}

	private void updateStudentUsingQuery(StudentDAO studentDAO) {
		studentDAO.updateStudentUsingQuery();
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.find(2);
		student.setFirstName("Joseph");
		student.setLastName("Fernandez");
		student.setEmail("joseph@gmail.com");
		studentDAO.update(student);
	}

	private void findStudentByLastName(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findStudentByLastName("Su");
		for(Student student:studentList){
			System.out.println(student);
		}

	}

	private void getAllStudents(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAll();
		for(Student student:studentList){
			System.out.println(student);
		}
	}

	private void selectStudentById(StudentDAO studentDAO) {
		Student student = new Student("Naveen","Kumar","naveen@gmail.com");
		studentDAO.save(student);
		System.out.println("The selected record is"+studentDAO.find(2));
	}

	private void createStudent(StudentDAO studentDAO) {
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("Karthick","Velu","karthick_velu@gmail.com"));
		studentList.add(new Student("Naveen","Kumar","naveen@gmail.com"));
		studentList.add(new Student("Vishnu","Menon","vishnu@gmail.com"));
		studentList.add(new Student("Keerthi","Perumal","keerthi@gmail.com"));
		studentList.add(new Student("Gal","Gadot","gal@gmail.com"));
		studentList.add(new Student("Scarlett","Johanson","scarlett@gmail.com"));
		studentList.add(new Student("Dua","Lipa","dua@gmail.com"));
		studentList.add(new Student("Robert","Downey","robert@gmail.com"));
		studentList.add(new Student("Leo","DiCaprio","leo@gmail.com"));
		studentList.add(new Student("Christopher","Nolan","chris@gmail.com"));
		for(Student tempStudent:studentList) {
			studentDAO.save(tempStudent);
		}
	}

}
