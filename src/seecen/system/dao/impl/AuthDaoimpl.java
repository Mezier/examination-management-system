package seecen.system.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import seecen.system.dao.AuthDao;
import seecen.system.po.Auth;
import seecen.utils.DBUtil;
import seecen.utils.JDBCResource;

public class AuthDaoimpl implements AuthDao {

	public boolean addAuth(Auth auth) {
		String sql="insert into t3_auths(id,name,url,levels,parentId) values(t3_auths_seq.nextval,?,?,?,?)";
		return DBUtil.executeSql(sql, auth.getName(),auth.getUrl(),auth.getLevels(),auth.getParentId());
	}

	public boolean delAuth(int id) {
		String sql="delete from t3_auths where id=?";
		return DBUtil.executeSql(sql, id);
	}
	public boolean updateAuth(Auth auth) {
		String sql="update t3_auths set name=?,url=?,levels=?,parentId=?,status=? where id=?";
		return DBUtil.executeSql(sql, auth.getName(),auth.getUrl(),auth.getLevels(),auth.getParentId(),auth.getStatus(), auth.getId());
	}

	public List<Auth> findAuthByLevels(String levels) {
		String sql="select * from t3_auths where levels=?";
		JDBCResource source=DBUtil.executeSelect(sql, levels);
		 List<Auth> auths=new ArrayList<Auth>();
		 ResultSet rs=null;
		 try{
			 rs=source.getRs();
			 while(rs.next()){
				 Auth auth=new Auth();
				 auth.setId(rs.getInt("id"));
				 auth.setName(rs.getString("name"));
				 auth.setUrl(rs.getString("url"));
				 auth.setParentId(rs.getInt("parentId"));
				 auth.setStatus(rs.getString("status"));
				 auth.setLevels(rs.getString("levels"));
				 auths.add(auth);
				 
			 }
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 DBUtil.close(rs, source.getStm(), source.getConn());
		 }
		 
		 
		return auths;
	}

	public List<Auth> findAuthByRole(int roleId) {
		 String sql="select * from t3_auths  where id in(select authid from t3_roleAuths where roleId=?)";
		 JDBCResource source =DBUtil.executeSelect(sql, roleId);
			 List<Auth> auths=new ArrayList<Auth>();
			 ResultSet rs=null;
			 try{
				 rs=source.getRs();
				while(rs.next()){
					Auth auth=new Auth();
					auth.setId(rs.getInt("id"));
					auth.setName(rs.getString("name"));
					auth.setUrl(rs.getString("url"));
					auth.setParentId(rs.getInt("parentId"));
					auth.setStatus(rs.getString("status"));
					auth.setLevels(rs.getString("levels"));
					auths.add(auth);
				}			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DBUtil.close(rs, source.getStm(), source.getConn());
			}
			return auths;
	}

	public Auth getAuthById(int id) {
		String sql="select * from t3_auths where id=?";
		JDBCResource source=DBUtil.executeSelect(sql, id);
		Auth auth=null;
		 ResultSet rs=null;
		 try{
			 rs=source.getRs();
			 while(rs.next()){
				 auth=new Auth();
				 auth.setId(rs.getInt("id"));
				 auth.setName(rs.getString("name"));
				 auth.setUrl(rs.getString("url"));
				 auth.setParentId(rs.getInt("parentId"));
				 auth.setStatus(rs.getString("status"));
				 auth.setLevels(rs.getString("levels"));
				 
			 }
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 DBUtil.close(rs, source.getStm(), source.getConn());
		 }
		 
		 
		return auth;
	}
	
	public static void main(String[] args) {
		AuthDao dao=new AuthDaoimpl();
		List<Auth> auths=new ArrayList<Auth>();
		auths=dao.findAuthByLevels("1");
		
		System.out.println(auths);
	}
	}

	


