package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entity.Student;


@Component("studentImpl3")
public class StudentDaoImpl implements StudentDao
{
	@Autowired
	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int insert(Student student) {
		String query="insert into student(id,name,city) values (?,?,?)";
		
		return this.template.update(query,student.getId(),student.getName(),student.getCity());
	}

	public int change(Student student) {
		//System.out.println(student.getId()+" "+student.getName()+" "+student.getCity());
		String sql="UPDATE student SET name=?, city=? WHERE id=?";
		int r=this.template.update(sql,student.getName(),student.getCity(),student.getId());
	    return r;
	}

	public int delete(int studentId) {
		String sql="delete from student where id=?";
		
		return this.template.update(sql,studentId);
	}

	public Student fetch(int studentId) {
		String query="select *from student where id=?";
		RowMapper<Student> mapper=new RowMapperImpl();
		return this.template.queryForObject(query,mapper,studentId);
	}

	public List<Student> fetchAll() {
		String query="select *from student";
		
		List<Student>  students=this.template.query(query,new RowMapperImpl());
	    return students;
	}
 
	
}
