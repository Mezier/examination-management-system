package seecen.system.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seecen.system.dao.RoleDao;
import seecen.system.dao.impl.RoleDaoimpl;
import seecen.system.po.Role;

public class RoleSystemServlet extends HttpServlet {
	private RoleDao roleDao ;
	
	public void init() throws ServletException {
		roleDao = new RoleDaoimpl();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		if ("save".equals(method)) {
			save(request, response);
		}
		if ("list".equals(method)) {
			list(request, response);
		}
		
	}
	protected void save(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {	
		String name=request.getParameter("name");
		String status=request.getParameter("status");
		Role role=new Role();
		role.setName(name);
		role.setStatus(status);
		boolean result=roleDao.addRole(role);
		if(result){
			response.sendRedirect("role?method=list");
		}else{
			response.sendRedirect("addRole.jsp");
		}
		
	}
	protected void list(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {	
		 List<Role> roles=roleDao.findAll();
		 request.setAttribute("roles", roles);
		 request.getRequestDispatcher("listRole.jsp").forward(request, response);
	

		
		
	}
	public static void main(String[] args) {
		RoleDao roleDao= new RoleDaoimpl();
		 List<Role> roles=roleDao.findAll();
		 
		 
		 System.out.println(roles);
	}
	
}
