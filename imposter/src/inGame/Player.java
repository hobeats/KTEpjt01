package inGame;

public class Player {
	private String userID;
	private String status;
	private String job = "Player";
	
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String isStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	@Override
	public String toString() {
		return "Player" + userID + "의 직업은 " + job +"입니다.";
	}
	
}


