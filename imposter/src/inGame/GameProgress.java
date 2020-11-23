package inGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameProgress {

	private static ArrayList<Boolean> voteList;
	private static ArrayList<String> selUserList;
	private static GameRoom gr;

	public static void main(String[] args) {
		startGame();
	}

	// ���� ����
	private static void startGame() {
		gr = new GameRoom();
		gr.setDayOrNight(false);
		switchDay();
		setJob();
	}

	// �� �� �� ��ȯ
	private static void switchDay() {
		Thread sd = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					if (gr.isDayOrNight()) {
						Thread.sleep(180000);
						gr.setDayOrNight(false);
						System.out.println("��");
					} else {
						Thread.sleep(180000);
						gr.setDayOrNight(true);
						System.out.println("��");
						Thread.sleep(120000);
						vote();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		sd.start();
	}

	// �������ϱ�
	private static void setJob() {

	}

	// ��ǥ
	private static void vote() {
		switchDay();
		// ���õ� ���� ���
		selUserList = new ArrayList<>();
		// ���� �� ���
		Set<String> selUser = new HashSet<String>(selUserList);
		Map<String, Integer> selResult = new HashMap<>();
		for (String u : selUser) {
			int numOfSel = Collections.frequency(selUser, u);
			selResult.put(u, numOfSel);
		}
		Map.Entry<String, Integer> maxEntry = null;
		ArrayList<String> list = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : selResult.entrySet()) {
			if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) >= 0) {
				maxEntry = entry;
				list.add(maxEntry.getKey());
			}
		}
		if (list.size() >= 2) {
			gr.setDayOrNight(false);
			switchDay();
		} else {
			// ���� �� ���
			voteList = new ArrayList<>();
			Set<Boolean> result = new HashSet<Boolean>(voteList);
			int numOfTrue = Collections.frequency(voteList, true);
			if (numOfTrue > (int) (gr.getNumOfLife() / 2)) {

			}
		}
	}
}