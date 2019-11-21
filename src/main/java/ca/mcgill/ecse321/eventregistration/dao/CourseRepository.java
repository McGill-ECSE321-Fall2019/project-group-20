package ca.mcgill.ecse321.eventregistration.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.eventregistration.model.Course;

public interface CourseRepository extends CrudRepository<Course, String> {

	Course findCourseByNumber(int number);

}
