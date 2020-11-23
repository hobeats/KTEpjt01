package inGame;

public class Player {
	private String userID;
	private boolean status;
	private Player job;
	private boolean getReady;
	
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Player getJob() {
		return job;
	}

	public void setJob(Player job) {
		this.job = job;
	}
	
	@Override
	public String toString() {
		return "Player" + userID + "의 직업은 " + job +"입니다.";
	}
}
