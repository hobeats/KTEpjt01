package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MainController implements Initializable {
	@FXML
	private Button initServerBtn;
	@FXML
	private TextArea txtArea;
	
	ServerSocket server;
	ExecutorService threadPool;
	public static HashMap<Integer, List<Client>> clients;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initServerBtn.setOnAction(event -> {
			if (initServerBtn.getText().equals("Start")) {
				initServerBtn.setText("Stop");
				initServer();
			} else {
				initServerBtn.setText("Start");

			}
		});
	}
	public void initServer() {
		clients = new HashMap<>();
		threadPool = Executors.newCachedThreadPool();
		List<Client> list = new ArrayList<>();
		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					txtArea.appendText("���� ����\n");
					server = new ServerSocket(8001);
					while (true) {
						txtArea.appendText("��������...\n");
						Socket client = server.accept();
						txtArea.appendText(client.getInetAddress().getHostAddress() + " ���� �Ϸ�\n");
						list.add(new Client(client));
						clients.put(0, list);
					}
				} catch (IOException e) {
					System.out.println("��������");
				}
			}
		};
		threadPool.submit(task);
	}
	
	class Client{
		Socket client;

		public Client(Socket client) {
			this.client = client;
		}
		
	}

}
