package inGame;

class GameRoomInfo {
	private int numOfUser;
	private int numOfMafia;
	private int numOfPolice;
	private boolean dayOrNight;

	public int getNumOfUser() {
		return numOfUser;
	}

	public void setNumOfUser(int numOfUser) {
		this.numOfUser = numOfUser;
	}

	public int getNumOfMafia() {
		return numOfMafia;
	}

	public void setNumOfMafia(int numOfMafia) {
		this.numOfMafia = numOfMafia;
	}

	public int getNumOfPolice() {
		return numOfPolice;
	}

	public void setNumOfPolice(int numOfPolice) {
		this.numOfPolice = numOfPolice;
	}

	public boolean isDayOrNight() {
		return dayOrNight;
	}

	public void setDayOrNight(boolean dayOrNight) {
		this.dayOrNight = dayOrNight;
	}
}
