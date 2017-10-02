package seecen.exam.servlet;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seecen.exam.dao.QuestionDao;
import seecen.exam.dao.TestMoldDao;
import seecen.exam.imp.QuestionDaoImp;
import seecen.exam.imp.TestMoldDaoImp;
import seecen.exam.po.ModelDetail;
import seecen.exam.po.Question;
import seecen.exam.po.TestMold;
import seecen.exam.vo.QuestionVo;
import seecen.utils.IsNull;
import seecen.utils.PageUtil;


public class ExamServlet extends HttpServlet {
	private QuestionDao qDao;
	private TestMoldDao mDao;
	@Override
	public void init() throws ServletException {
		mDao=new TestMoldDaoImp();
		qDao=new QuestionDaoImp();
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		if("join".equals(method)){
			join(request,response);
		}
		if("subm".equals(method)){
			subm(request,response);
		}
		if("findModl".equals(method)){
			findModl(request,response);
		}
	}
	protected void findModl(HttpServletRequest request, HttpServletResponse response)
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
		request.getRequestDispatcher("ExamMold.jsp").forward(request, response);
}
	protected void join(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
          String idstr=request.getParameter("id");  //Ä£°åid
          int id=0;
          if(!IsNull.isNullS(idstr)){
        	  id=Integer.parseInt(idstr);
        	  
          }
          TestMold mold=mDao.getTestMoldById(id);
          List<ModelDetail> details=new ArrayList<ModelDetail>();
          details=mDao.findDetailsByModelId(id);
          List<Question> question1=new ArrayList<Question>();
          List<Question> question2=new ArrayList<Question>();
          List<Question> question3=new ArrayList<Question>();
          List<Question> question4=new ArrayList<Question>();
          List<Question> question5=new ArrayList<Question>();
          List<QuestionVo> questionVo1=new ArrayList<QuestionVo>();
          List<QuestionVo> questionVo2=new ArrayList<QuestionVo>();
          for(ModelDetail rule:details){
        	  String type=rule.getType();
        	  if("1".equals(type)){
        		  question1=qDao.findQuesByRandom(mold.getSubjectId(), type,rule.getNum());
        		  for(Question q:question1){
        			  QuestionVo qvo=new QuestionVo();
        			  qvo.setQuestion(q);
        			  qvo.setOptions(qDao.findOptionByQue(q.getId()));
        			  questionVo1.add(qvo);
        		  }
        	  }
        	  if("2".equals(type)){
        		  question2=qDao.findQuesByRandom(mold.getSubjectId(), type,rule.getNum());
        		  for(Question q:question2){
        			  QuestionVo qvo=new QuestionVo();
        			  qvo.setQuestion(q);
        			  qvo.setOptions(qDao.findOptionByQue(q.getId()));
        			  questionVo2.add(qvo);
        		  }
        	  }
        	  if("3".equals(type)){
        		  question3=qDao.findQuesByRandom(mold.getSubjectId(), type,rule.getNum());
        	  }
        	  if("4".equals(type)){
        		  question4=qDao.findQuesByRandom(mold.getSubjectId(), type,rule.getNum());
        	  }
        	  if("5".equals(type)){
        		  question5=qDao.findQuesByRandom(mold.getSubjectId(), type,rule.getNum());
        	  }
          }
          request.setAttribute("question1", questionVo1);
          request.setAttribute("question2", questionVo2);
          request.setAttribute("question3",question3);
          request.setAttribute("question4",question4);
          request.setAttribute("question5",question5);
          request.setAttribute("mold",mold);
          request.getRequestDispatcher("exam.jsp").forward(request, response);
}
	protected void subm(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

}
	
}
