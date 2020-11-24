package inGame;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GameRoomController implements Initializable {
	@FXML
	private Button btnStart, sendBtn, btnOut;
	@FXML
	private TextArea roomLogArea, roomChatArea;
	@FXML
	private TextField chatField;
	@FXML
	private TableView<String> deadInfo, roomUser;
//	private Stage primaryStage;

	static List<Player> userList;
	static List<Player> deadList;
	static List<Boolean> voteList;
	static List<String> selUserList;
	static GameRoomInfo gr;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		getStart();
		startGame();

	}

	public void getStart() {
		btnStart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// 일반 유저라면..
				if (btnStart.getText().equals("준비완료")) {
					btnStart.setText("준비");

				} else {
					btnStart.setText("준비완료");
				}
				// 일반 유저가 모두 준비되었을때
				startGame();
			}
		});
	}

	public void getOut() {
		btnOut.setOnAction(event -> {

		});
	}

	public void sendMsg() {
		sendBtn.setOnAction(event -> {

		});
	}

	public void startGame() {
		gr = new GameRoomInfo();
		gr.setDayOrNight(false);
		switchDay();
//		setJob();
	}

	// 낮 과 밤 전환
	public void switchDay() {
		Thread sd = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						if (gr.isDayOrNight()) {
							Thread.sleep(10000);
							// 60초 남았다는 메세지 로그에 전송
							roomLogArea.appendText("10초\n");
							Thread.sleep(10000);
							gr.setDayOrNight(false);
							System.out.println("밤");
						} else {
							Thread.sleep(10000);
							// 60초 남았다는 메세지 로그에 전송
							roomLogArea.appendText("10초\n");
							Thread.sleep(10000);
							gr.setDayOrNight(true);
							System.out.println("낮");
							// 60초 투표 시작 로그 전송
							roomLogArea.appendText("투표까지 10초\n");
							Thread.sleep(10000);
//							vote();
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		sd.setDaemon(true);
		sd.start();
	}

	// 직업정하기
	public static void setJob() {
		int numOfUser = gr.getNumOfUser();
		for (int i = 1; i <= gr.getNumOfMafia(); i++) {
			int rNum = (int) (Math.random() * numOfUser) - 1;
			Player p = userList.get(rNum);
			if (p.getJob().equals("Player")) {
				p.setJob("Mafia");
			}
		}
		for (int i = 1; i <= gr.getNumOfPolice(); i++) {
			int rNum = (int) (Math.random() * numOfUser) - 1;
			Player p = userList.get(rNum);
			if (p.getJob().equals("Player")) {
				p.setJob("Police");
			}
		}
	}

	// 투표
	public void vote() {
		switchDay();
		// 선택된 유저 담기
		selUserList = new ArrayList<>();
		// 유저 수 계산
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
			// 찬반 수 계산
			voteList = new ArrayList<>();
//			Set<Boolean> result = new HashSet<Boolean>(voteList);
			int numOfTrue = Collections.frequency(voteList, true);
			if (numOfTrue > (int) (userList.size() / 2)) {

			}
		}
	}
//	public void setPrimaryStage(Stage primaryStage) {
//		this.primaryStage = primaryStage;
//		KeyCombination kc = new KeyCharacterCombination("r",KeyCombination.CONTROL_DOWN);
//		Mnemonic mn = new Mnemonic(btnStart, kc);
//		primaryStage.getScene().addMnemonic(mn);
//	}

}
