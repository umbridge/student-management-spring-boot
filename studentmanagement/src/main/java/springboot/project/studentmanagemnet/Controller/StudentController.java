package springboot.project.studentmanagemnet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springboot.project.studentmanagement.Domain.Course;
import springboot.project.studentmanagement.Domain.Student;
import springboot.project.studentmanagemnet.Service.CourseService;
import springboot.project.studentmanagemnet.Service.StudentService;

@Controller
@RequestMapping("/Student")

public class StudentController {
	
	
	 @Autowired
	    private StudentService studentservice;
	 
	 @Autowired
	 private CourseService courseservice;

	    @GetMapping("/addstudent")
	    public String add(Model model) {
	    	List<Student> liststudent = studentservice.listAll();
	    	List<Course> listcourse = courseservice.listAll();
		    model.addAttribute("listcourse", listcourse);
	        model.addAttribute("liststudent", liststudent);
	        model.addAttribute("student", new Student());
	        return "addstudent";
	    }
	    
	    
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveStudent(@ModelAttribute("student") Student std) 
	    {
	        studentservice.save(std);
	        return "redirect:/student";
	    }
	    

	    @RequestMapping("/edit/{id}")
	    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id, Model model) {
	    	List<Course> listcourse = courseservice.listAll();	
	        ModelAndView mav = new ModelAndView("addstudent");
	        model.addAttribute("listcourse", listcourse);
	        
	        Student std = studentservice.get(id);
	        mav.addObject("student", std);
	        return mav;
	        
	    }
	    @RequestMapping("/delete/{id}")
	    public String deleteStudentPage(@PathVariable(name = "id") int id) {
	    	studentservice.delete(id);
	        return "student";
	    }
	
	

}