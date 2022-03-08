package springboot.project.studentmanagemnet.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.project.studentmanagement.Domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
