package dao;

public class RiskDAO {

	int id;
	String content="";
	String possiblity="";
	String affect="";
	int threshold;
	int submitterId;
	int followerId;
	String createTime="";
	String endTime="";
	String projectName="";
	int isEnded;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPossiblity() {
		return possiblity;
	}
	public void setPossiblity(String possiblity) {
		this.possiblity = possiblity;
	}
	public String getAffect() {
		return affect;
	}
	public void setAffect(String affect) {
		this.affect = affect;
	}
	public int getThreshold() {
		return threshold;
	}
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	public int getSubmitterId() {
		return submitterId;
	}
	public void setSubmitterId(int submitterId) {
		this.submitterId = submitterId;
	}
	public int getFollowerId() {
		return followerId;
	}
	public void setFollowerId(int followerId) {
		this.followerId = followerId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getIsEnded() {
		return isEnded;
	}
	public void setIsEnded(int isEnded) {
		this.isEnded = isEnded;
	}
	
	
}
