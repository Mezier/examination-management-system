package seecen.learning.dao.imp;

import java.util.List;

import seecen.learning.Student;
import seecen.learning.dao.StudentDao;
import seecen.utils.DBUtil;

public class StudentDaoImp implements StudentDao{

	public boolean addStudent(Student s) {
		String sql="insert into t3_student(id,name,pass,age,sex,classes,tel,address,photo) values(seq3_student.nextval,?,?,?,?,?,?,?,?)";
		return DBUtil.executeSql(sql, s.getName(),s.getPass(),s.getAge(),s.getSex(),s.getClasses(),s.getTel(),s.getAddress(),s.getPhoto());
	}

	public boolean delStudent(int stuId) {
        String sql="delete from t3_student where id=?";
		return DBUtil.executeSql(sql, stuId);
	}

	public boolean updateStudent(Student s) {
		String sql="update t3_student set name=?,pass=?,age=?,sex=?,classes=?,tel=?,address=?,photo=? where id=?";
		return DBUtil.executeSql(s.getName(),s.getPass(),s.getAge(),s.getSex(),s.getClass(),s.getTel(),s.getAddress(),s.getPhoto(),s.getId());
	}

	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

}
