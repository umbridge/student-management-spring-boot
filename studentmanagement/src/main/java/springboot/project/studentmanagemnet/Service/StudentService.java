package springboot.project.studentmanagemnet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.project.studentmanagement.Domain.Student;
import springboot.project.studentmanagemnet.Repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
    private StudentRepository repo;
	
	public List<Student> listAll() 
	{
		System.out.println(repo.findAll());
        return repo.findAll();
    }
     

    public void save(Student std) {
        repo.save(std);
    }
     
    public Student get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }

}