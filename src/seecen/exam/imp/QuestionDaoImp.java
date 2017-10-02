package seecen.exam.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import seecen.exam.dao.QuestionDao;
import seecen.exam.po.Question;
import seecen.exam.po.QuestionOption;
import seecen.utils.DBUtil;
import seecen.utils.JDBCResource;
import seecen.utils.PageUtil;



public class QuestionDaoImp implements QuestionDao{

	public boolean addQuestion(Question q, List<QuestionOption> option) {
		boolean f=true;
		String sql1="insert into t3_question(id,subjectId,type,title,answer,status)" +
				" values(seq3_question.nextval,?,?,?,?,?)";
		String sql2="insert into t3_questionOption(id,questionId,content) values(seq3_questionOption.nextval,seq3_question.currval,?)";
		Connection conn=null;
		PreparedStatement pst=null;
		if(option!=null&&option.size()>0){
		try {
			conn=DBUtil.getConnection();
			conn.setAutoCommit(false);
			pst=conn.prepareStatement(sql1);
			pst.setInt(1,q.getSubjectId());
			pst.setString(2,q.getType());
			pst.setString(3,q.getTitle());
			pst.setString(4,q.getAnswer());
			pst.setString(5,q.getStatus());
			pst.executeUpdate();
			pst=conn.prepareStatement(sql2);
			for(QuestionOption op:option){
				
				pst.setString(1,op.getContent());
				pst.addBatch();
			}
			pst.executeBatch();
		} catch (SQLException e) {
			f=false;
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			
		}finally{
			try {
				conn.commit();
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				f=false;
			}
			DBUtil.close(null, pst, conn);
		}
		
		}else{
			
			
			try {
				conn=DBUtil.getConnection();
				pst=conn.prepareStatement(sql1);
				pst.setInt(1,q.getSubjectId());
				pst.setString(2,q.getType());
				pst.setString(3,q.getTitle());
				pst.setString(4,q.getAnswer());
				pst.setString(5,q.getStatus());
				pst.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				f=false;
			}finally{
				DBUtil.close(null, pst, conn);
			}
			
		}
		return f;
	}

	public boolean delQuestion(Question q, List<QuestionOption> option) {
		boolean f=true;
		Connection conn=null;
		PreparedStatement pst=null;
		String sql1="delete from t3_question where id=?";
		String sql2="delete from t3_questionOption where questionId=?";
		
		try {
			conn=DBUtil.getConnection();
			conn.setAutoCommit(false);
			pst=conn.prepareStatement(sql1);
			pst.setInt(1,q.getId());
			pst.executeUpdate();
			pst=conn.prepareStatement(sql2);
			for(QuestionOption o:option){
				pst.setInt(1,o.getQuestionId());
			}
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pst, conn);
		}
		return f;
	}

	public boolean updateQustion(Question q, List<QuestionOption> option) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Question> findQuesByRandom(int subjectId, String type,
			int num) {
		List<Question> list=new ArrayList<Question>();
		Question q=null;
		String sql="select * from (select *from t3_question where subjectId=? and type=? order by dbms_random.random) where rownum<=?";
		
		ResultSet rs=null;
		JDBCResource re=null;
		re=DBUtil.executeSelect(sql, subjectId,type,num);
		
		try {
			rs=re.getRs();
			while(rs.next()){
				q=new Question();
				q.setId(rs.getInt("Id"));
				q.setAnswer(rs.getString("answer"));
				q.setStatus(rs.getString("status"));
				q.setSubjectId(rs.getInt("subjectId"));
				q.setTitle(rs.getString("title"));
				q.setType(rs.getString("type"));
				list.add(q);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, re.getStm(),re.getConn());
		}
		
		return list;
	}

	public List<QuestionOption> findOptionByQue(int questionId) {
		List<QuestionOption> list=new ArrayList<QuestionOption>();
		QuestionOption op=null;
		ResultSet rs=null;
		JDBCResource re=null;
		String sql="select * from t3_questionOption where questionId=?";
		re=DBUtil.executeSelect(sql, questionId);
		try {
			rs=re.getRs();
			while(rs.next()){
				op=new QuestionOption();
				op.setId(rs.getInt("id"));
				op.setContent(rs.getString("content"));
				op.setQuestionId(rs.getInt("questionId"));
				list.add(op);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, re.getStm(),re.getConn());
		}
		return list;
	}

	public List<Question> findAllQustion(PageUtil page) {
		List<Question> list=new ArrayList<Question>();
		String sql="select * from (select t.*,rownum n from t3_question t where rownum<=?)where n>? order by id ";
		
		Question q=null;
		JDBCResource re=null;
		ResultSet rs=null;
		re=DBUtil.executeSelect(sql,page.getCurrPage()*page.getPageSize(),(page.getCurrPage()-1)*page.getPageSize());
		
		try {
			rs=re.getRs();
			while(rs.next()){
				q=new Question();
				q.setId(rs.getInt("Id"));
				q.setAnswer(rs.getString("answer"));
				q.setStatus(rs.getString("status"));
				q.setSubjectId(rs.getInt("subjectId"));
				q.setTitle(rs.getString("title"));
				q.setType(rs.getString("type"));
				list.add(q);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, re.getStm(),re.getConn());
		}
		return list;
	}

	public int QuestionCount() {
		int count=0;
		ResultSet rs=null;
		String sql="select count(1) from t3_question";
		JDBCResource re=DBUtil.executeSelect(sql);
		
		try {
			rs=re.getRs();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, re.getStm(),re.getConn());
		}
		
		return count;
	}

	public int AllQueByTypeSubject(int subjectId, int type) {
		int count=0;
		ResultSet rs=null;
		String sql="select count(1) from t3_question where type=? and subjectId=?";
		JDBCResource re=DBUtil.executeSelect(sql,type,subjectId);
		
		try {
			rs=re.getRs();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, re.getStm(),re.getConn());
		}
		
		return count;
	}

}
