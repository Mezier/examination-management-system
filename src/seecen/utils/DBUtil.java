package seecen.utils;

import java.sql.*;




public class DBUtil {
	 private static final String className="oracle.jdbc.OracleDriver";
     private static final String url="jdbc:oracle:thin:@localhost:1521:orcl";
     private static final String user="scott";
     private static final String password="tiger";
     public static Connection getConnection(){
    	 Connection conn=null;
    	  try {
			Class.forName(className);
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  
    	 return conn;
     }
     public static void close(ResultSet rs,Statement stm,Connection conn){
    	 if(rs!=null){
    		 try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }
    	 if(stm!=null){
    		 try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }
    	 if(conn!=null){
    		 try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }
     }
     public static boolean executeSql(String sql,Object... obj){
    	 boolean f=true;
    	 Connection conn=null;
    	 PreparedStatement pst=null;
    	 
    	
    	 try {
    		 conn=getConnection();
			pst=conn.prepareStatement(sql);
			for(int i=0;i<obj.length;i++){
				pst.setObject(i+1,obj[i]);
			}
			int n=pst.executeUpdate();
			if(n!=1){
				f=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			f=false;
		}finally{
			close(null, pst,conn);
		}
    	 
    	 return f;
     }
public static JDBCResource executeSelect(String sql,Object... obj){
           JDBCResource re=null;
           Connection conn=null;
           PreparedStatement pst=null;
           ResultSet rs=null;
           
           try {
        	   conn=getConnection();
			   pst=conn.prepareStatement(sql);
			   for(int i=0;i<obj.length;i++){
				   pst.setObject(i+1,obj[i]);
			   }
			   rs=pst.executeQuery();
			   re=new JDBCResource(conn,pst,rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           return re;
     }

}
