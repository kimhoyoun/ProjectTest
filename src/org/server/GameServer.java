package org.server;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.model.UserDao;
import org.model.UserDto;

public class GameServer extends JFrame {
	static HashMap hm = new HashMap();
	public static UserDao dao = new UserDao();
	public static UserDto dto;
	private JTextArea serverState;
	private ConnectClient cc;

	public GameServer() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("서버");
		setSize(300, 400);

		Container contentPane = getContentPane();
		serverState = new JTextArea();
		serverState.setEditable(false);
		contentPane.add(new JScrollPane(serverState), BorderLayout.CENTER);
		setVisible(true);
		this.setLocation(500, 200);

		// 서버 쓰레드 동작
		ConnectClient connect = new ConnectClient();
		connect.start();
	}

	public static void main(String[] args) {
		new GameServer();
	}

	class ConnectClient extends Thread {
		private ServerSocket listener = null;
		private Socket socket = null;

		@Override
		public void run() {
			try {
				// 서버는 한번만 생성
				listener = new ServerSocket(9999);
				serverState.append("접속대기중...\n");
				while (true) {
					// 접속은 계속 유지해야되므로 wile문 안에서 무한반복
					socket = listener.accept();
					serverState.append("클라이언트 접속 완료...\n");

					// 클라이언트가 서버에 접속 시 해당 클라이언트와 메세지를 주고 받을 쓰레드 생성
//					ServerThread sth = new ServerThread(socket);
//					sth.start();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class ServerThread extends Thread {
		Socket socket = null;
		private BufferedReader br = null;
		private BufferedWriter bw = null;
		private String userID;
		private ObjectInputStream ois = null;
		private ObjectOutputStream oos = null;
		private String guest = "guest" + (int) (Math.random() * 100 + 1);

		// 생성자에 socket을 받아 서버에 접속한 클라이언트의 socket정보를 받아옴.
		public ServerThread(Socket socket) {
			this.socket = socket;
			try {
				// 클라이언트와 메세지를 주고받기위해 입출력 스트림 생성
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				ois = new ObjectInputStream(socket.getInputStream());
				oos = new ObjectOutputStream(socket.getOutputStream());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// 쓰레드가 시작되면 반복할 코드
		@Override
		public void run() {
			while (true) {
				try {
					// 클라이언트로부터 메세지를 받을때까지 대기하면 받으면 msg 변수에 저장
					String msg = br.readLine();
					serverState.append(guest + " >> " + msg + "\n");
					// 중복검사,회원가입, 로그인, 종료
					switch (msg) {
					case "login":
						login();
						break;
					case "signup":
						userSignUp();
						break;
					case "idCheck":
						idCheck();
						break;
					case "exit":
						logout();
						break;
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		private void login() {
			try {
				dto = (UserDto) ois.readObject();
				boolean approval = dao.loginApproval(dto);
				
				if (approval) {
						dto = dao.selectOneUser(dto);
					if (dto != null) {
						bw.write("success" + "\n");
						bw.flush();
						oos.writeObject(dto);
						oos.flush();
						serverState.append(guest + " >> Login Success! \n");
					}
				} else {
					bw.write("fail" + "\n");
					bw.flush();
					serverState.append(guest + " >> Login Fail \n");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		private void userSignUp() {
			try {
				
				dto = (UserDto) ois.readObject();
				boolean state = dao.insertUser(dto);
				if (state) {
					bw.write("complete" + "\n");
					bw.flush();
					serverState.append(guest + " >> Sign Up Complete \n");
				} else {
					bw.write("fail" + "\n");
					bw.flush();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private void idCheck() {
			try {
				String userID = br.readLine();
				boolean check = dao.checkID(userID);
				if (check) {
					bw.write("approval" + "\n");
					bw.flush();
					serverState.append(guest + " >> ID Check Complete \n");
				} else {
					bw.write("fail" + "\n");
					bw.flush();
					serverState.append(guest + " >> ID Check Complete \n");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private void logout() {
		}

	}

}
