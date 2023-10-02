package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insert(Student student) {
        String query = "insert into student(id,name,city) values(?,?,?)";
        int res = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return res;
    }

    @Override
    public int update(Student student) {
        String query = "update student set name=?,city=? where id=?";
        int res = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
        return res;
    }

    @Override
    public int delete(Student student) {
        // delete operation
        String query = "delete from student where id=?";
        int res = this.jdbcTemplate.update(query,student.getId());
        return res;
    }

    @Override
    public Student getStudent(int studentId) {
        // selecting single student data
        String query = "select * from student where id=?";
        RowMapper<Student>rowMapper = new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        // selecting multiple student
        String query = "select * from student";
        List<Student>  students = this.jdbcTemplate.query(query,new RowMapperImpl());
        return students;
    }
}
