package main;
	
import java.net.Socket;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Socket server;
	@Override
	public void start(Stage primaryStage) {
		try {
			initClient();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/login.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initClient() {
		try {
			server = new Socket("192.168.1.106", 8001);
			System.out.println("연결성공");
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
