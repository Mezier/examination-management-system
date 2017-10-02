package seecen.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCResource {
	 private Connection conn;
	    private Statement stm;
	    private ResultSet rs;
		public Connection getConn() {
			return conn;
		}
		public void setConn(Connection conn) {
			this.conn = conn;
		}
		public Statement getStm() {
			return stm;
		}
		public void setStm(Statement stm) {
			this.stm = stm;
		}
		public ResultSet getRs() {
			return rs;
		}
		public void setRs(ResultSet rs) {
			this.rs = rs;
		}
		public JDBCResource(Connection conn, Statement stm, ResultSet rs) {
			
			this.conn = conn;
			this.stm = stm;
			this.rs = rs;
		}
	    
}
