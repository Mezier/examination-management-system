package seecen.learning.servlet;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import seecen.learning.Student;
import seecen.learning.dao.StudentDao;
import seecen.learning.dao.imp.StudentDaoImp;
import seecen.utils.IsNull;

public class RegStudentServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DiskFileItemFactory df=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(df);
		Student s=new Student();
		StudentDao dao=new StudentDaoImp();
		try {
			List<FileItem> items=upload.parseRequest(request);
			for(FileItem i:items){
				if(i.isFormField()){
					String name=i.getFieldName();
					String value=i.getString("utf-8");
					
					if("userName".equals(name)){
						s.setName(value);
					}
					if("pass".equals(name)){
		    			s.setPass(value);
		    		}
		    		if("tel".equals(name)){
		    			s.setTel(value);
		    		}
		    		if("classes".equals(name)){
						s.setClasses(value);
					}
					if("age".equals(name)){
						int intValue=0;
						if(!IsNull.isNullS(value)){
						   intValue=Integer.parseInt(value);	
						}
		    			s.setAge(intValue);
		    		}
		    		if("sex".equals(name)){
		    			s.setSex(value);
		    		}
		    		if("address".equals(name)){
		    			s.setAddress(value);
		    		}
				}else{
					String fileName=i.getName();
					String realFileName=fileName.substring(fileName.lastIndexOf("\\")+1);
					String path=request.getRealPath("/fileUpload/");
					Date dt=new Date();
					SimpleDateFormat dft=new SimpleDateFormat("yyyyMMddHHmmss");
					String name=dft.format(dt);
					String fileType=realFileName.substring(realFileName.lastIndexOf("."));
					File f=new File(path,name+fileType);
					try {
						i.write(f);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					s.setPhoto("fileUpload/"+name+fileType);
				}
				
			}
			boolean f=dao.addStudent(s);
			if(f){
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
}
