package seecen.system.dao;

import java.util.List;

import seecen.system.po.Auth;

public interface AuthDao {
	public boolean addAuth(Auth auth);
	   public boolean updateAuth(Auth auth);
	   public boolean delAuth(int id);
	   public Auth getAuthById(int id);
	   public List<Auth> findAuthByLevels(String levels);
	   public List<Auth> findAuthByRole(int roleId);

}
