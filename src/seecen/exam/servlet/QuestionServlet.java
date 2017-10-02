package seecen.exam.servlet;




import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seecen.exam.dao.QuestionDao;
import seecen.exam.dao.SubjectDao;
import seecen.exam.imp.QuestionDaoImp;
import seecen.exam.imp.SubjectDaoImp;
import seecen.exam.po.Question;
import seecen.exam.po.QuestionOption;
import seecen.exam.po.Subject;
import seecen.utils.IsNull;
import seecen.utils.PageUtil;


public class QuestionServlet extends HttpServlet {
	private QuestionDao qdao;
    private SubjectDao subDao;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		qdao=new QuestionDaoImp();
		subDao=new SubjectDaoImp();
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
		request.getRequestDispatcher("addQuestion.jsp").forward(request, response);
	}
	protected void list(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		PageUtil page=new PageUtil();
		int currPage=1;
		String currPageStr=request.getParameter("currPage");
		if(!IsNull.isNullS(currPageStr)){
			currPage=Integer.parseInt(currPageStr);
		}
		int totalRecord=qdao.QuestionCount();
		page.setCurrPage(currPage);
		page.setPageSize(10);
		page.setTotalPage(totalRecord);
		page.setTotalRecord(totalRecord);
		List<Question> list=new ArrayList<Question>();
		list=qdao.findAllQustion(page);
		request.setAttribute("questions",list);
		request.setAttribute("page",page);
		request.getRequestDispatcher("listQuestion.jsp").forward(request, response);
		
	}
	protected void save(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String subjectIdstr=request.getParameter("subjectId");
		int subjectId=0;
		if(!IsNull.isNullS(subjectIdstr)&&!"0".equals(subjectIdstr)){
			subjectId=Integer.parseInt(subjectIdstr);
		}
		String title=request.getParameter("questionName");
		String type=request.getParameter("qtype");
		String answers[]=request.getParameterValues("answer");
		String contents[]=request.getParameterValues("content");
		String answerFill=request.getParameter("answerFill");
		String answer="";
		   if(answers!=null){
			   for(String ans:answers){
				   answer+=ans;
			   }
			   
		   }else{
			   answer=answerFill;
		   }
		String content[]=new String[5];
		int i=0;
		for(String con:contents){
			if(!IsNull.isNullS(con)){
			content[i]=con;
			i++;
			}
		}
		Question q=new Question();
		q.setAnswer(answer);
		q.setSubjectId(subjectId);
		q.setTitle(title);
		q.setType(type);
		q.setStatus("1");
		List<QuestionOption> options=new ArrayList<QuestionOption>();
		if(answers!=null){
			for(int j=0;j<content.length;j++){
				if(!IsNull.isNullS(content[j])){
					QuestionOption op=new QuestionOption();
					op.setContent(content[j]);
					options.add(op);
				}
			}
		}
		boolean f=qdao.addQuestion(q, options);
		if(f){
			response.sendRedirect("question?method=list");
		}else{
			response.sendRedirect("error.jsp");
		}
	}
	
      
}
