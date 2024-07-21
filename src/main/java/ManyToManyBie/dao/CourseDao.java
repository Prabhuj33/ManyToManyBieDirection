package ManyToManyBie.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ManyToManyBie.dto.Course;
import ManyToManyBie.dto.Student;

public class CourseDao {






	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}

	public void updateCourse(int id,Course course ) {
		EntityManager  entityManager=getEntityManager();
		Course dbCourse=entityManager.find(Course.class, id);
		if(dbCourse!=null) {
//			id is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			course.setId(id);
			course.setStudent(dbCourse.getStudent());
			entityManager.merge(course);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry Id is not present");
		}	
	}
	public void findCourse(int id) {
		EntityManager  entityManager=getEntityManager();
		Course dbCourse=entityManager.find(Course.class, id);
		if(dbCourse!=null) {
//			id is present
			System.out.println(dbCourse);
		}else {
			System.out.println("Sorry Id is not present");
		}	
	}
	
	public void deleteCourse(int id) {
		EntityManager  entityManager=getEntityManager();
		Course dbCourse=entityManager.find(Course.class, id);
		if(dbCourse!=null) {
//			id is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			
			List<Student> students=dbCourse.getStudent();
			for(Student student:students) {
				List<Course> courses=student.getCourses();
				courses.remove(dbCourse);
				student.setCourses(courses);
			}			
			entityManager.remove(dbCourse);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry Id is not present");
		}	
	}
	
	
	
	
	
	
	
	
}


