package seecen.system.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seecen.system.dao.AuthDao;
import seecen.system.dao.impl.AuthDaoimpl;
import seecen.system.po.Auth;
import seecen.utils.DBUtil;

public class AuthSystemServlet extends HttpServlet {
	   private AuthDao authDao;

	   
		@Override
	   public void init() throws ServletException {
			authDao=new AuthDaoimpl();
	    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		if("add".equals(method)){
			add(request,response);
		}
		if("save".equals(method)){
			save(request,response);
		}
		if("list".equals(method)){
			list(request,response);
		}
		if("grantAuth".equals(method)){
			grantAuth(request,response);
		}
		
		if("saveAuth".equals(method)){
			saveAuth(request,response);
		}
		if("update".equals(method)){
			update(request,response);
		}
		if("get".equals(method)){
			get(request,response);
		}
	}
	protected void get(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String id=request.getParameter("id");
		int idd=0;
		if(id!=null&&!"".equals(id)&&!"0".equals(id)){
			idd=Integer.parseInt(id);
		}
		Auth auth=authDao.getAuthById(idd);
		request.setAttribute("auth", auth);
		List<Auth> auths=authDao.findAuthByLevels("1");
		 request.setAttribute("auths", auths);
	
		request.getRequestDispatcher("addAuths.jsp").forward(request, response);
		
		
	
		
	}
	
	
	protected void add(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		 List<Auth> auths=authDao.findAuthByLevels("1");
		 request.setAttribute("auths", auths);
		 request.getRequestDispatcher("addAuths.jsp").forward(request, response);
		 
	
	}
	protected void save(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		 String name=request.getParameter("name");
		 String url=request.getParameter("url");
		 String levels=request.getParameter("levels");
		 String parentId=request.getParameter("parentId");
		 String status=request.getParameter("status");
		 Integer pid=null;
		 if(parentId!=null&&!"".equals(parentId)&&!"0".equals(parentId)){
			 pid=new Integer(parentId);
		 }
		 Auth auth=new Auth(name,url,levels,pid,status);
		 boolean result=authDao.addAuth(auth);
		if(result){
				response.sendRedirect("auth?method=list");
		}else{
				response.sendRedirect("auth?method=add");
		}
	
	}
	protected void list(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		 List<Auth> parentAuths=authDao.findAuthByLevels("1");
		 List<Auth> sonAuths=authDao.findAuthByLevels("2");
		 request.setAttribute("parentAuths", parentAuths);
		 request.setAttribute("sonAuths", sonAuths);
		 request.getRequestDispatcher("listAuth.jsp").forward(request, response);
		 
	
	}
	protected void update(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String id=request.getParameter("id");
		int idd=0;
		if(id!=null&&!"".equals(id)&&!"0".equals(id)){
			idd=Integer.parseInt(id);
		}
		
		Auth auth=authDao.getAuthById(idd);
		request.setAttribute("auth", auth);
		request.getRequestDispatcher("addAuths.jsp").forward(request, response);
		
		
	}
	
	protected void grantAuth(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
	}
	protected void saveAuth(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

