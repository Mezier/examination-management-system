package seecen.exam.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seecen.exam.dao.SubjectDao;
import seecen.exam.imp.SubjectDaoImp;
import seecen.exam.po.Subject;
import seecen.utils.IsNull;
import seecen.utils.PageUtil;



public class subjectServlet extends HttpServlet {
	private SubjectDao subjectDao;
    @Override
	public void init() throws ServletException {
	   subjectDao=new SubjectDaoImp();	
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		 if("updateSave".equals(method)){
			 updateSave(request,response);
		 }
		 if("list".equals(method)){
			 list(request,response);
		 }
		 if("save".equals(method)){
			 save(request,response);
		 }
		 if("update".equals(method)){
			 update(request,response);
		 }
		 if("del".equals(method)){
			 del(request,response);
		 }
	}

	
	protected void save(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
     String subject=request.getParameter("subject");
     String status=request.getParameter("status");
     Subject sub=new Subject();
     sub.setName(subject);
     sub.setStatus(status);
     boolean f=subjectDao.addSubject(sub);
     if(f){
   	  response.sendRedirect("subject?method=list");
     }else{
   	  response.sendRedirect("addSubject");
     }
}
	protected void list(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		List<Subject> list=new ArrayList<Subject>();
		PageUtil page=new PageUtil();
		int currPage=1;
		String currPagestr=request.getParameter("currPage");
		if(!IsNull.isNullS(currPagestr)){
			currPage=Integer.parseInt(currPagestr);
		}
		int totalRecord=subjectDao.AllSubject();
		page.setCurrPage(currPage);
		page.setPageSize(10);
		page.setTotalPage(totalRecord);
		page.setTotalRecord(totalRecord);
		list=subjectDao.findSubjectByPage(page);
		request.setAttribute("subjects",list);
		request.setAttribute("page",page);
		request.getRequestDispatcher("listSubject.jsp").forward(request, response);
}
	protected void updateSave(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String idStr=request.getParameter("id");
		String name=request.getParameter("subject");
		String status=request.getParameter("status");
		   int id=0;
		   if(!IsNull.isNullS(idStr)){
			   id=Integer.parseInt(idStr);
		   }
		   Subject sub=subjectDao.findSubjectByid(id);
		   sub.setId(id);
		   sub.setName(name);
		   sub.setStatus(status);
		   boolean f=subjectDao.updateSubject(sub);
		   if(f){
			   response.sendRedirect("subject?method=list");
		   }else{
			   response.sendRedirect("error.jsp");
		   }
}
	protected void update(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String idStr=request.getParameter("id");
		   int id=0;
		   if(!IsNull.isNullS(idStr)){
			   id=Integer.parseInt(idStr);
		   }
		   Subject sub=subjectDao.findSubjectByid(id);
		   request.setAttribute("subjectOld",sub);
		   request.getRequestDispatcher("updateSubject.jsp").forward(request, response);
	}
	protected void del(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	   String idStr=request.getParameter("id");
	   int id=0;
	   if(!IsNull.isNullS(idStr)){
		   id=Integer.parseInt(idStr);
	   }
	   boolean f=subjectDao.delSubject(id);
	   if(f){
		   response.sendRedirect("subject?method=list");
	   }else{
		   response.sendRedirect("error.jsp");
	   }
	   //Ë¢ÐÂµÄ
	}
}
