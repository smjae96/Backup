package model.vo;

import java.sql.Date;

public class Planner {

	private int planNo;
	private int writerNo;
	private String title;
	private Date startDate;
	private Date endDate;
	private Date remindDate;
	private int planPriority;
	private char repeatTask;
	
	public Planner() {}
	
	public Planner(int planNo, int writerNo, String title, Date startDate, Date endDate, Date remindDate,
			int planPriority, char repeatTask) {
		super();
		this.planNo = planNo;
		this.writerNo = writerNo;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.remindDate = remindDate;
		this.planPriority = planPriority;
		this.repeatTask = repeatTask;
	}

	public int getPlanNo() {
		return planNo;
	}

	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}

	public int getWriterNo() {
		return writerNo;
	}

	public void setWriterNo(int writerNo) {
		this.writerNo = writerNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getRemindDate() {
		return remindDate;
	}

	public void setRemindDate(Date remindDate) {
		this.remindDate = remindDate;
	}

	public int getPlanPriority() {
		return planPriority;
	}

	public void setPlanPriority(int planPriority) {
		this.planPriority = planPriority;
	}

	public char getRepeatTask() {
		return repeatTask;
	}

	public void setRepeatTask(char repeatTask) {
		this.repeatTask = repeatTask;
	}

	@Override
	public String toString() {
		return "Planner [planNo=" + planNo + ", writerNo=" + writerNo + ", title=" + title + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", remindDate=" + remindDate + ", planPriority=" + planPriority
				+ ", repeatTask=" + repeatTask + "]";
	}
	
	
	
	
}
