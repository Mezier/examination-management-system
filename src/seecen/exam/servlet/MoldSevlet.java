package seecen.exam.servlet;




import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seecen.exam.dao.SubjectDao;
import seecen.exam.dao.TestMoldDao;
import seecen.exam.imp.SubjectDaoImp;
import seecen.exam.imp.TestMoldDaoImp;
import seecen.exam.po.ModelDetail;
import seecen.exam.po.Subject;
import seecen.exam.po.TestMold;
import seecen.utils.IsNull;
import seecen.utils.PageUtil;



public class MoldSevlet extends HttpServlet {
	private SubjectDao subDao;
	private TestMoldDao mDao;
	@Override
	public void init() throws ServletException {
		subDao=new SubjectDaoImp();
		mDao=new TestMoldDaoImp();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		if("add".equals(method)){
			add(request,response);
		}
		if("list".equals(method)){
			list(request,response);
		}
		if("save".equals(method)){
			save(request,response);
		}
	}

	protected void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Subject> subjects=new ArrayList<Subject>();
		subjects=subDao.findAllSubject();
		request.setAttribute("subjects", subjects);
		request.getRequestDispatcher("addMold.jsp").forward(request, response);
	}

	protected void save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TestMold mold=new TestMold();
		String name=request.getParameter("name");
		String subjectIds=request.getParameter("subjectId");
		String summary=request.getParameter("descriptions");
		String types[]=request.getParameterValues("type");
		String nums[]=request.getParameterValues("num");
		String scores[]=request.getParameterValues("score");
		int subjectId=0;
		if(!IsNull.isNullS(subjectIds)&&!"0".equals(subjectIds)){
			subjectId=Integer.parseInt(subjectIds);
		}
		int totalScore=0;
		List<ModelDetail> details=new ArrayList<ModelDetail>();
		for(int i=0;i<nums.length;i++){
			String n=nums[i];
			if(!IsNull.isNullS(n)){
				ModelDetail det=new ModelDetail();
				det.setType(types[i]);
				det.setNum(Integer.parseInt(n));
				det.setScore(Integer.parseInt(scores[i]));
				details.add(det);
				totalScore+=Integer.parseInt(n)*Integer.parseInt(scores[i]);
			}
		}
		//mold
		mold.setDescriptions(summary);
		mold.setName(name);
		mold.setSubjectId(subjectId);
		mold.setScore(totalScore);
		boolean f=mDao.addTestModel(mold, details);
		if(f){
			response.sendRedirect("mold?method=list");
		}else{
			response.sendRedirect("error.jsp");
		}
	}

	protected void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          PageUtil page=new PageUtil();
          int currPage=1;
  		String currPageStr=request.getParameter("currPage");
  		if(!IsNull.isNullS(currPageStr)){
  			currPage=Integer.parseInt(currPageStr);
  		}
  		int totalRecord=mDao.MoldCount();
  		page.setCurrPage(currPage);
  		page.setPageSize(10);
  		page.setTotalPage(totalRecord);
  		page.setTotalRecord(totalRecord);
  		List<TestMold> list=new ArrayList<TestMold>();
  		list=mDao.findAllMoldByPage(page);
  		request.setAttribute("testMolds",list);
  		request.setAttribute("page",page);
  		request.getRequestDispatcher("listMold.jsp").forward(request, response);
	}
}
