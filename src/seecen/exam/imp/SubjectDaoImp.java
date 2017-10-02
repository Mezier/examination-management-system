package seecen.exam.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




import seecen.exam.dao.SubjectDao;

import seecen.exam.po.Subject;
import seecen.utils.DBUtil;
import seecen.utils.JDBCResource;
import seecen.utils.PageUtil;






public class SubjectDaoImp implements SubjectDao{
	
	public boolean addSubject(Subject sub) {
		String sql="insert into t3_subject(id,name,status) values(seq_subject.nextval,?,?)";
		return DBUtil.executeSql(sql, sub.getName(),sub.getStatus());
	}

	public boolean delSubject(int id) {
		String sql="delete from t3_subject where id=?";
		return DBUtil.executeSql(sql, id);
	}

	public boolean updateSubject(Subject sub) {
		String sql="update t3_subject set name=? ,status=? where id=?";
		return DBUtil.executeSql(sql, sub.getName(),sub.getStatus(),sub.getId());
	}

	public int AllSubject() {
		String sql="select count(1) from t3_subject";
		JDBCResource re=DBUtil.executeSelect(sql);
		ResultSet rs=null;
		int count=0;
		try {
			rs=re.getRs();
			while(rs.next()){
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

	public List<Subject> findSubjectByPage(PageUtil page) {
		List<Subject> list=new ArrayList<Subject>();
		String sql="select *from (select t.*,rownum n from t3_subject t where rownum<=?) where n>? order by id";
		JDBCResource re=DBUtil.executeSelect(sql,page.getCurrPage()*page.getPageSize(),(page.getCurrPage()-1)*page.getPageSize());
		ResultSet rs=null;
		
		try {
			rs=re.getRs();
			while(rs.next()){
				Subject s=new Subject();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setStatus(rs.getString("status"));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, re.getStm(),re.getConn());
		}
		return list;
	}

	public List<Subject> findAllSubject() {
		List<Subject> list=new ArrayList<Subject>();
		String sql="select *from t3_subject";
		JDBCResource re=DBUtil.executeSelect(sql);
ResultSet rs=null;
		
		try {
			rs=re.getRs();
			while(rs.next()){
				Subject s=new Subject();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setStatus(rs.getString("status"));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, re.getStm(),re.getConn());
		}
		return list;
	}

	public Subject findSubjectByid(int id) {
		Subject sub=null;
		ResultSet rs=null;
		JDBCResource re=null;
		String sql="select *from t3_subject where id=?";
		re=DBUtil.executeSelect(sql, id);
		
		try {
			rs=re.getRs();
			if(rs.next()){
				sub=new Subject();
				sub.setId(rs.getInt("id"));
				sub.setName(rs.getString("name"));
				sub.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, re.getStm(),re.getConn());
		}
		return sub;
	}


}
