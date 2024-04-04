package model.vo;

public class Detail {

	private int detailNo;
	private int planNo;
	private String detailName;
	private String contents;
	private char completion;
	private String progressTime;
	
	
	public Detail() {}
	
	public Detail(int detailNo, int planNo, String detailName, String contents, char completion, String progressTime) {
		super();
		this.detailNo = detailNo;
		this.planNo = planNo;
		this.detailName = detailName;
		this.contents = contents;
		this.completion = completion;
		this.progressTime = progressTime;
	}

	public int getDetailNo() {
		return detailNo;
	}

	public void setDetailNo(int detailNo) {
		this.detailNo = detailNo;
	}

	public int getPlanNo() {
		return planNo;
	}

	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}

	public String getDetailName() {
		return detailName;
	}

	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public char getCompletion() {
		return completion;
	}

	public void setCompletion(char completion) {
		this.completion = completion;
	}

	public String getProgressTime() {
		return progressTime;
	}

	public void setProgressTime(String progressTime) {
		this.progressTime = progressTime;
	}

	@Override
	public String toString() {
		return "Detail [detailNo=" + detailNo + ", planNo=" + planNo + ", detailName=" + detailName + ", contents="
				+ contents + ", completion=" + completion + ", progressTime=" + progressTime + "]";
	}
	
	
	
	
}
