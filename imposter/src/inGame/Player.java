package inGame;

public class Player {
	private String userID;
	private String status;
	private Player job;
	
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

	public Player getJob() {
		return job;
	}

	public void setJob(Player job) {
		this.job = job;
	}
	
	@Override
	public String toString() {
		return "Player" + userID + "�� ������ " + job +"�Դϴ�.";
	}
}

class Mafia extends Player {
	//ų
	public void kill(String userID) {
		
	}
}
class Police extends Player {
	//Ž��
	public String detect(String userID) {
		
		Player p = null;
		return p.toString();
	}
}

class Doctor extends Player {
	public void heal(String userID) {
		
	}
}
