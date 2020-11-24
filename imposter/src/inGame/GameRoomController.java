package inGame;

import java.net.URL;
import java.util.ResourceBundle;

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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		chatField.requestFocus();
		getStart();
	}
	
	public void getStart() {
		btnStart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(btnStart.getText().equals("준비완료")) {
					btnStart.setText("준비");
					
				}else {
					btnStart.setText("준비완료");
				}
				
			}
		});
	}
	public void getOut() {
		btnOut.setOnAction(event->{
			
		});
	}
	
	public void sendMsg() {
		sendBtn.setOnAction(event->{
			
		});
	}
	
}
