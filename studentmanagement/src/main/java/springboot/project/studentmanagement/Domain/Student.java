package springboot.project.studentmanagement.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String stname;
private int course;
private int fee;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getStname() {
	return stname;
}
public void setStname(String stname) {
	this.stname = stname;
}
public int getCourse() {
	return course;
}
public void setCourse(int course) {
	this.course = course;
}
public int getFee() {
	return fee;
}
public void setFee(int fee) {
	this.fee = fee;
}



}