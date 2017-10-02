package seecen.utils;

public class PageUtil {
	private int currPage;
	private int pageSize;
	private int totalPage;
	private int totalRecord;

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalRecord) {
		if(totalRecord%this.pageSize==0){
			this.totalPage =totalRecord/this.pageSize;
		}else{
			this.totalPage =totalRecord/this.pageSize+1;
		}
		
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

}
