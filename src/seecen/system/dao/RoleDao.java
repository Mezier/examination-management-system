package seecen.system.dao;

import java.util.List;

import seecen.system.po.Role;

public interface RoleDao {
	public boolean addRole(Role role);
	 public boolean updateRole(Role role);
	 public boolean delRole(int id);
	 public Role getRoleById(int id);
	 public List<Role> findAll();
	 public boolean addRoleAuth(int roleId,int[]authIds);
	 public boolean delRoleAuth(int roleId);

}
