package seecen.system.po;

public class Auth {
	private int id;                 //����
	private String name;           //Ȩ����
	private String url;            //Ȩ�޷��ʵ�ַ
	private String levels;         //�ȼ� �˵�����  1��  2��
	private Integer  parentId;     //���� Id
	private String  status;
	
	public Auth(){}	
	public Auth(String name, String url, String levels, Integer parentId,
			String status) {
		this.name = name;
		this.url = url;
		this.levels = levels;
		this.parentId = parentId;
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return "Auth [id=" + id + ", levels=" + levels + ", name=" + name
				+ ", parentId=" + parentId + ", status=" + status + ", url="
				+ url + "]";
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	} 
	

}
