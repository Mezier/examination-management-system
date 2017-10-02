package seecen.system.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import seecen.system.dao.RoleDao;
import seecen.system.po.Role;
import seecen.utils.DBUtil;
import seecen.utils.JDBCResource;

public class RoleDaoimpl implements RoleDao {

	public boolean addRole(Role role) {
		String sql="insert into t3_roles (id,name,status) values(t3_roles_seq.nextval,?,?)";
		return DBUtil.executeSql(sql, role.getName(),role.getStatus());
	}

	public boolean addRoleAuth(int roleId, int[] authIds) {
		boolean result=true;
		Connection conn= null;
		PreparedStatement pstmt=null;
		String sql="insert into t3_roleAuths(roleId,authId) values(?,?)";
		 try{
			 conn= DBUtil.getConnection();
			 pstmt=conn.prepareStatement(sql);
			 for(int authId:authIds){
				 pstmt.setInt(1, roleId);
				 pstmt.setInt(2, authId);
				 pstmt.addBatch();
			 }
			 pstmt.executeBatch();
		   }catch(Exception e){
			    result=false;
				e.printStackTrace();
			}finally{
				DBUtil.close(null,pstmt,conn );
			}
		return result;
	}

	public boolean delRole(int id) {
		String sql="delete from t3_roles where id=?";
		return DBUtil.executeSql(sql,id);
	}

	public boolean delRoleAuth(int roleId) {
		String sql="delete from t3_roleAuths where roleId=?";
		 return DBUtil.executeSql(sql, roleId);
	}

	public List<Role> findAll() {
		String sql="select * from t3_roles";
		JDBCResource source =DBUtil.executeSelect(sql);
		 List<Role> roles=new ArrayList<Role>();
		 ResultSet rs=null;
		 try{
			 rs=source.getRs();
			while(rs.next()){	
				Role role=new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				role.setStatus(rs.getString("status"));
				roles.add(role);
			}			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DBUtil.close(rs, source.getStm(), source.getConn());
			}
			return roles;
	}

	public Role getRoleById(int id) {
		String sql="select * from t3_roles where id=?";
		JDBCResource source =DBUtil.executeSelect(sql);
		ResultSet rs=null;
		Role role=null;
		
		try{
			 rs=source.getRs();
			while(rs.next()){	
				role=new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				role.setStatus(rs.getString("status"));
				
			}			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DBUtil.close(rs, source.getStm(), source.getConn());
			}
		return role;
	}

	public boolean updateRole(Role role) {
		String sql="update t3_roles set name=?,status=?";
		return DBUtil.executeSql(sql, role.getName(),role.getStatus());
	}

}
