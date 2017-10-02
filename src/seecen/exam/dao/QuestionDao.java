package seecen.exam.dao;

import java.util.List;

import seecen.exam.po.Question;
import seecen.exam.po.QuestionOption;
import seecen.utils.PageUtil;



public interface QuestionDao {
    public boolean addQuestion(Question q,List<QuestionOption> option);
    public boolean delQuestion(Question q,List<QuestionOption> option);
    public boolean updateQustion(Question q,List<QuestionOption> option);
    public int QuestionCount();
    public List<Question> findAllQustion(PageUtil page);
    public List<Question> findQuesByRandom(int subjectId,String type,int num);
    
    public List<QuestionOption> findOptionByQue(int questionId);
    public int AllQueByTypeSubject(int subjectId,int type);
}
