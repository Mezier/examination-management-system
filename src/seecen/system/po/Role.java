package seecen.system.po;

public class Role {
	private int id;                 //����
	private String name;           //��ɫ��
	private String  status;
	
	
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	} 
	
	

}