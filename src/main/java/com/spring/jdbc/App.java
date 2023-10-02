package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Spring Application Started....." );
        // spring jdbc => JdbcTemplate
//        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-config.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDaoImpl studentDao = (StudentDaoImpl) context.getBean("studentDao",StudentDaoImpl.class);


//        Inserting into student
//        Student student = new Student();
//        student.setId(105);
//        student.setName("Rohan Konkatti");
//        student.setCity("Pune");
//        int result = studentDao.insert(student);
//        System.out.println("student added : "+result);

        /*
        updating the student
        Student student = new Student();
        student.setId(555);
        student.setName("Hardik Pandya");
        student.setCity("Baroda");
        int result = studentDao.update(student);
        System.out.println("student updated successfully ... : "+result);
         */

        /*
        // Delete
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id to delete student : ");
        int id = sc.nextInt();
        Student student = new Student();
        student.setId(id);
        int result = studentDao.delete(student);
        System.out.println("student deleted successfully ... : "+result);

         */

        /*
        selecting single row using id
        Student student = studentDao.getStudent(103);
        System.out.println(student);
         */

        // selecting multiple rows
        List<Student>students = studentDao.getAllStudent();
        for(Student s : students)
        {
            System.out.println(s);
        }
    }
}
