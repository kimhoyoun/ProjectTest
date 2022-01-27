package org.server;

import static org.view.Vr.loginView;
import static org.view.Vr.mainData;
import static org.view.Vr.mainUser;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame implements ActionListener {
	public static final String LOGIN = "login";
	public static final String NEWLOGIN = "newlogin";
	public static final String SIGNUP = "signup";
	public static final String IDCHECK = "idcheck";
	public static final String LOGOUT = "logout";
	int width = 1024, height = 768;
	Container contentPane;
	private Socket socket = null;
	public ObjectInputStream ois;
	public ObjectOutputStream oos;
	public String req;
	public String resp;
	public String msg;
	boolean signup = false;
	public MainFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(width, height);
		contentPane = getContentPane();

		contentPane.setLayout(null);
		loginView.setBounds(0, 0, width, height);
		contentPane.add(loginView);

		this.setVisible(true);

		loginView.idcheck.addActionListener(this);
		loginView.signup.addActionListener(this);
		loginView.LoginBtn.addActionListener(this);

		connectServer();

		ClientThread th = new ClientThread();
		th.start();

	}

	public void connectServer() {
		try {
			// localHost ip, 9999 port에 접속
			socket = new Socket(InetAddress.getLocalHost(), 9999);

			// 서버에 접속하고 입출력 스트림 생성
			// 반드시 oos 부터 생성해줘야한다.
			// ois먼저 생성하면 에러발생
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class ClientThread extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					// 서버로부터 메세지가 오면 클라이언트의 어떤 요청에 대한 결과인지 먼저 판단하기위해
					// resp에 저장하고 switch로 어떤 요청인지 판단.
					resp = ois.readUTF();
					System.out.println("server response >> " + resp);
					switch (resp) {
					case LOGIN:
						login();
						break;
					case NEWLOGIN:
						newlogin();
						break;
					case SIGNUP:
						signup();
						break;
					case IDCHECK:
						idCheck();
						break;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		private void newlogin() {
			try {
				UserDto user = (UserDto)ois.readObject();
				
				if(user.getNo() != -1) {
					mainUser = user;
					mainData = new Vector<GameDataDto>();
					System.out.println(mainUser);
					System.out.println("vector size >> "+mainData.size());
					JOptionPane.showMessageDialog(loginView, "로그인 성공!");
				}else {
					mainUser = null;
					JOptionPane.showMessageDialog(loginView, "로그인 실패!");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private void login() {
			try {
				UserDto user = (UserDto)ois.readObject();
				if(user.getNo() != -1) {
					Vector<GameDataDto> vector = (Vector)ois.readObject();
					mainUser = user;
					mainData = vector;
					System.out.println(mainUser);
					for(GameDataDto data : vector) {
						System.out.println(data);
					}
					JOptionPane.showMessageDialog(loginView, "로그인 성공!");
					
				}else {
					mainUser = null;
					JOptionPane.showMessageDialog(loginView, "로그인 실패!");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private void signup() {
			try {
				String result = ois.readUTF();
				if("complete".equals(result)) {
					JOptionPane.showMessageDialog(loginView, "회원가입이 완료되었습니다!");
				}else {
					JOptionPane.showMessageDialog(loginView, "회원가입에 실패햇습니다!");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void idCheck() {
			try {
				String tf = ois.readUTF();
				if("approval".equals(tf)) {
					JOptionPane.showMessageDialog(loginView, "사용할 수 있는 ID입니다!");
					signup = true;
				}else {
					JOptionPane.showMessageDialog(loginView, "사용할 수 없는 ID입니다...");
					signup = false;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new MainFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginView.LoginBtn) {
			req = LOGIN;
			String id = loginView.inputID.getText();
			String pw = loginView.inputPW.getText();
			
			loginView.inputID.setText("");
			loginView.inputPW.setText("");
			UserDto user = new UserDto(0,null,id,pw,0);
			
			try {
				oos.writeUTF(req);
				oos.flush();
				oos.writeObject(user);
				oos.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == loginView.signup) {
			if(signup) {
				req = SIGNUP;
				String name = loginView.name.getText();
				String id = loginView.id.getText();
				String pw = loginView.pass.getText();
				int age = Integer.parseInt(loginView.age.getText());

				loginView.name.setText("");
				loginView.id.setText("");
				loginView.pass.setText("");
				loginView.age.setText("");
				
				UserDto user = new UserDto(0, name, id, pw, age);
				try {
					oos.writeUTF(req);
					oos.flush();
					oos.writeObject(user);
					oos.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(loginView, "ID 중복체크를 해주세요!");				
			}
		}
		
		
		if (e.getSource() == loginView.idcheck) {
			// id 중복확인데 대한 요청임을 나타내는 req변수
			req = IDCHECK;
			// loginView의 회원가입에서 id를 입력하는 TextField의 값을 가져옴.
			String userId = loginView.id.getText();
			System.out.println("userId : "+userId);
			System.out.print("userid check");
			if("".equals(userId)) {
				System.out.println("ok");
			}else {
				System.out.println("no");
			}
			try {
				// 요청하는 것을 서버에 알려주기위해 req를 먼저 보낸다.
				oos.writeUTF(req);
				oos.flush();
				
				// 서버에 req를 보낸 후 실제 쓰일 값을 보냄.
				oos.writeUTF(userId);
				oos.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
