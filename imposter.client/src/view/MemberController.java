package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MemberController implements Initializable {
	@FXML
	private AnchorPane loginAnchor, joinAnchor, findAnchor;
	@FXML
	private Button memberLoginBtn, nonMemberLoginBtn, btnJoin, btnBack, btnFind, btnBack2;
	@FXML
	private TextField loginID, joinID, joinName, findPWA, findName, findEmail, findID, findA;
	@FXML
	private PasswordField loginPW, joinPW, joinRePW;
	@FXML
	private Hyperlink findLinkBtn, joinLinkBtn;
	@FXML
	private ComboBox<String> findPWQ, findQ;

	public void setHyperLink() {
		joinLinkBtn.setOnAction(event -> {
			Platform.runLater(() -> {
				loginAnchor.setVisible(false);
				joinAnchor.setVisible(true);
				joinID.requestFocus();
			});
		});

		findLinkBtn.setOnAction(event -> {
			Platform.runLater(() -> {
				loginAnchor.setVisible(false);
				findAnchor.setVisible(true);
				findName.requestFocus();
			});
		});
		
		btnBack.setOnAction(event -> {
			Platform.runLater(() -> {
				loginAnchor.setVisible(true);
				joinAnchor.setVisible(false);
				loginID.requestFocus();
			});
		});
		
		btnBack2.setOnAction(event -> {
			Platform.runLater(() -> {
				loginAnchor.setVisible(true);
				findAnchor.setVisible(false);
				loginID.requestFocus();
			});
		});
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setHyperLink();
	}

}
