package springboot.project.studentmanagemnet.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springboot.project.studentmanagement.Domain.Course;
import springboot.project.studentmanagement.Domain.StudentDAO;
import springboot.project.studentmanagemnet.Repository.StudentRepository;
import springboot.project.studentmanagemnet.Service.CourseService;


@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private CourseService courseservice;
	

	@Autowired
	private StudentRepository studentrepository;

	@RequestMapping (value = "/student", method = RequestMethod.GET) 
	public String viewStudentPage (Model model) {
		List<StudentDAO> li= new ArrayList<>(); 
		for(Object[] o : studentrepository.findStudent()){
			StudentDAO student =new StudentDAO(); 
			student.setId(Long.parseLong (String.valueOf(o[0])));
			student.setStname ((String) o[1]); 
			student.setCoursename ((String) o[2]);
			li.add(student);
		}
		model.addAttribute("liststudent", li);
		return "student";
	}

	@RequestMapping(value= "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value= "/course", method= RequestMethod.GET)
	public String viewHomePage(Model model) {
		List<Course> listcourse = (List<Course>) courseservice.listAll();
		model.addAttribute("listcourse", listcourse);
		System.out.print("Get /");
		return "course";
	}
	
	
}
