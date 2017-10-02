package seecen.exam.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import seecen.exam.dao.TestMoldDao;
import seecen.exam.po.ModelDetail;
import seecen.exam.po.TestMold;
import seecen.utils.DBUtil;
import seecen.utils.JDBCResource;
import seecen.utils.PageUtil;



public class TestMoldDaoImp implements TestMoldDao{

	public boolean addTestModel(TestMold model, List<ModelDetail> details) {
		boolean f=true;
		String sql1="insert into t3_testModel(id,subjectId,name,descriptions,score) values(seq3_testModel.nextval,?,?,?,?)";
		String sql2="insert into t3_modelDetail(id,modelId,type,num,score) values(seq3_ModelDetail.nextval,seq3_testModel.currval,?,?,?)";
		Connection conn=null;
		PreparedStatement pst=null;
		
		try {
			conn=DBUtil.getConnection();
			conn.setAutoCommit(false);
			pst=conn.prepareStatement(sql1);
			pst.setInt(1,model.getSubjectId());
			pst.setString(2,model.getName());
			pst.setString(3,model.getDescriptions());
			pst.setInt(4,model.getScore());
			
			pst.executeUpdate();
			pst=conn.prepareStatement(sql2);
			for(ModelDetail d:details){
				pst.setString(1,d.getType());
				pst.setInt(2,d.getNum());
				pst.setInt(3,d.getScore());
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
			}
			DBUtil.close(null, pst, conn);
		}
		return f;
	}

	public boolean delTestModel(int id, List<ModelDetail> details) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateTestModel(TestMold model, List<ModelDetail> details) {
		// TODO Auto-generated method stub
		return false;
	}

	public int MoldCount() {
		String sql="select count(1) from t3_testModel";
		ResultSet rs=null;
		JDBCResource re=null;
		re=DBUtil.executeSelect(sql);
		int n=0;
		try {
			rs=re.getRs();
			if(rs.next()){
				n=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, re.getStm(),re.getConn());
		}
		return n;
	}

	public List<TestMold> findAllMoldByPage(PageUtil page) {
		List<TestMold> list=new ArrayList<TestMold>();
		TestMold mold=null;
		ResultSet rs=null;
		JDBCResource re=null;
		String sql="select * from (select t.* ,rownum n from t3_testModel t where rownum<=?) where n>? order by id";
		re=DBUtil.executeSelect(sql,page.getCurrPage()*page.getPageSize(),(page.getCurrPage()-1)*page.getPageSize());
		
		try {
			rs=re.getRs();
			while(rs.next()){
				mold=new TestMold();
				mold.setId(rs.getInt("id"));
				mold.setName(rs.getString("name"));
				mold.setScore(rs.getInt("score"));
				mold.setSubjectId(rs.getInt("subjectId"));
				mold.setStatus(rs.getString("status"));
				mold.setDescriptions(rs.getString("descriptions"));
				mold.setCreateTime(rs.getDate("createTime"));
				list.add(mold);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, re.getStm(),re.getConn());
		}
		return list;
	}

	

	public TestMold getTestMoldById(int moldId) {
		TestMold mold=new TestMold();
		ResultSet rs=null;
		JDBCResource re=null;
		String sql="select * from t3_testModel where id=?";
		re=DBUtil.executeSelect(sql, moldId);
		
		try {
			rs=re.getRs();
			if(rs.next()){
				mold.setId(rs.getInt("id"));
				mold.setName(rs.getString("name"));
				mold.setScore(rs.getInt("score"));
				mold.setSubjectId(rs.getInt("subjectId"));
				mold.setStatus(rs.getString("status"));
				mold.setDescriptions(rs.getString("descriptions"));
				mold.setCreateTime(rs.getDate("createTime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, re.getStm(),re.getConn());
		}
		return mold;
	}

	public List<ModelDetail> findDetailsByModelId(int id) {
		List<ModelDetail> list=new ArrayList<ModelDetail>();
		ModelDetail d=null;
		ResultSet rs=null;
		JDBCResource re=null;
		String sql="select *from t3_modelDetail where modelId=?";
		re=DBUtil.executeSelect(sql,id);
		
		try {
			rs=re.getRs();
			while(rs.next()){
				d=new ModelDetail();
				d.setId(rs.getInt("id"));
				d.setModelId(rs.getInt("modelId"));
				d.setNum(rs.getInt("num"));
				d.setScore(rs.getInt("score"));
				d.setType(rs.getString("type"));
				list.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, re.getStm(),re.getConn());
		}
		return list;
	}

}
