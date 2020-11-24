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
import javafx.scene.input.KeyCharacterCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
import javafx.stage.Stage;

public class GameRoomController implements Initializable {
	@FXML
	private Button btnStart, sendBtn, btnOut;
	@FXML
	private TextArea roomLogArea, roomChatArea;
	@FXML
	private TextField chatField;
	@FXML
	private TableView<String> deadInfo, roomUser;
	private Stage primaryStage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		getStart();
	}
	
	public void getStart() {
		btnStart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(btnStart.getText().equals("�غ�Ϸ�")) {
					btnStart.setText("�غ�");
					
				}else {
					btnStart.setText("�غ�Ϸ�");
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

//	public void setPrimaryStage(Stage primaryStage) {
//		this.primaryStage = primaryStage;
//		KeyCombination kc = new KeyCharacterCombination("r",KeyCombination.CONTROL_DOWN);
//		Mnemonic mn = new Mnemonic(btnStart, kc);
//		primaryStage.getScene().addMnemonic(mn);
//	}
	
}
