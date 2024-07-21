package ManyToManyBie.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Course {

	@Id
	private int id;
	private String name;
	private double fees;
	
	
	@ManyToMany(mappedBy = "courses")
	List<Student> student;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getfees() {
		return fees;
	}


	public void setfees(double fees) {
		this.fees = fees;
	}


	public List<Student> getStudent() {
		return student;
	}


	public void setStudent(List<Student> student) {
		this.student = student;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", fees=" + fees + ", student=" + student + "]";
	}
	


}
