package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
    	StudentDao sdao=context.getBean("studentImpl3",StudentDaoImpl.class);
  	
    	List<Student> slist=sdao.fetchAll();
    	for(Student S: slist)
    	{
    		System.out.println(S);
    	}
    	
    	Student obj3=new Student();
    	obj3.setId(198);
    	obj3.setName("Sai Ganesh");
    	obj3.setCity("Hyderbad");
    	
    	//System.out.println(sdao.insert(obj3));
    	
    	//System.out.println(sdao.delete(203));
    	
    	System.out.println(sdao.fetch(112));
    	
    	
//    	ApplicationContext con=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
//    	StudentDao sdao=con.getBean("studentImpl",StudentDaoImpl.class);
//    	System.out.println(sdao.fetch(112));
//    	Student newobj=new Student();
//    	newobj.setId(2234);
//    	newobj.setName("Rajesh");
//    	newobj.setCity("Warangal");
//    	System.out.println(sdao.insert(newobj));
    	
    	// XML Based Configuration & Works
    	/*
        ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
         StudentDaoImpl sdao=context.getBean("studentImpl",StudentDaoImpl.class);     
			/*
			 * Student obj1=new Student(); obj1.setId(232); obj1.setCity("Lucknow");
			 * obj1.setName("Srivastav");
			 * System.out.println("row inserted.."+sdao.insert(obj1)); Student obj2=new
			 * Student();
			 */
			/*
			 * Student obj2=new Student(); obj2.setId(232); obj2.setName("Saurabh");
			 * obj2.setCity("Lucknow"); System.out.println("Updated :"+sdao.change(obj2));
			 */
        // int sid=231;
         //System.out.println("deleted :"+sdao.delete(sid));
        // Student s=sdao.fetch(sid);
         //System.out.println(s);
         /*
         List<Student> student=sdao.fetchAll();
         for(Student st:student)
         {
        	 System.out.println(st);
         }
		
		 * JdbcTemplate template=context.getBean("jdbcTemplate",JdbcTemplate.class);
		 * //Insert Query String
		 * query="insert into student(id,name,city) values (?,?,?)";
		 * 
		 * //Fire Query int result=template.update(query,"203","Sharma","Sitamadhi");
		 * System.out.println("Row affected: "+result);
		 */
        
    }
}
