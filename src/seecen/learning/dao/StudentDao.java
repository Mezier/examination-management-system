package seecen.learning.dao;

import java.util.List;

import seecen.learning.Student;

public interface StudentDao {
    public boolean addStudent(Student s);
    public boolean delStudent(int stuId);
    public boolean updateStudent(Student s);
    public Student findStudentById(int id);
    public List<Student> findAllStudents();
}
