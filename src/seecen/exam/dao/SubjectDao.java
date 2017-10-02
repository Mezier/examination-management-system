package seecen.exam.dao;

import java.util.List;

import seecen.exam.po.Subject;
import seecen.utils.PageUtil;



public interface SubjectDao {
	public boolean addSubject(Subject sub);
	   public boolean delSubject(int id);
	   public boolean updateSubject(Subject sub);
	   public int AllSubject();
	   public List<Subject> findSubjectByPage(PageUtil page);
	   public List<Subject> findAllSubject();
	   public Subject findSubjectByid(int id);
}
