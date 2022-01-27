package org.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.client.GameClient;

public class LoginView extends GameContainer {
	int width = 1024;
	int height = 768;
	boolean flag = false;
	ImageIcon backgroundImg;
	JLabel background;
	
	public JButton LoginBtn;
	public JButton signupBtn;
	public JPanel login;
	public JLabel loginID;
	public JLabel loginPW;
	public JTextField inputID;
	public JTextField inputPW;

	JPanel newUserPane;
	public JTextField name;
	public JTextField id;
	public JTextField pass;
	public JTextField age;
	public JButton idcheck;
	public JButton signup;
	JButton cancel;
	JLabel loginLabel;
	JLabel newUserTitle;
	JLabel lblName;
	JLabel lblId;
	JLabel lblPass;
	JLabel lblAge;
	GameClient game;
	
	
	public LoginView() {
		gamePlay();
	}
	
	@Override
	public void gamePlay() {
		init();
		
		backgroundImg = new ImageIcon("images/mainBack.png");
		background = new JLabel(backgroundImg);
		
		background.add(login);
		this.setLayout(null);
		this.add(background);
				
		background.setBounds(0, 0, width, height);
		login.setBounds(width/2-300/2,height/2-350/2,300,350);
		newUserPane.setBounds(width/2-300/2,height/2-350/2,300,350);
		
		LoginBtn.addActionListener(this);
		signupBtn.addActionListener(this);
		signup.addActionListener(this);
		cancel.addActionListener(this);
	}
	
	public void init() {
		setLoginBox();
		setCreateBox();
	}
	
	public void setLoginBox() {
		LoginBtn = new JButton("로그인");
		signupBtn = new JButton("회원가입");
		
		login = new JPanel();
		loginLabel = new JLabel("로그인");

		loginID = new JLabel("I D");
		loginPW = new JLabel("PW");
		
		inputID = new JTextField(15);
		inputPW = new JTextField(15);
		
		loginLabel.setFont(new Font("Gothic", Font.BOLD, 30));
		login.setBackground(new Color(255,255,255,150));
		loginID.setFont(new Font("Gothic", Font.BOLD, 20));
		loginPW.setFont(new Font("Gothic", Font.BOLD, 20));
		inputID.setFont(new Font("Gothic", Font.BOLD, 20));
		inputPW.setFont(new Font("Gothic", Font.BOLD, 20));
		
		login.setLayout(null);
		
		login.add(loginLabel);
		login.add(inputID);
		login.add(inputPW);
		login.add(LoginBtn);
		login.add(signupBtn);
		login.add(loginID);
		login.add(loginPW);
		
		loginLabel.setBounds(300/2-50,20,100,40);
		LoginBtn.setBounds(300/2-140,350-60,120,50);
		signupBtn.setBounds(300/2+10,350-60,120,50);
		loginID.setBounds(300/2-120, 350/2-80,40,40);
		loginPW.setBounds(300/2-120, 350/2-20,40,40);
		inputID.setBounds(300/2-70, 350/2-80,180,40);
		inputPW.setBounds(300/2-70, 350/2-20,180,40);
	}
	
	public void setCreateBox() {
		newUserPane = new JPanel();
		name = new JTextField(20);
		id = new JTextField(15);
		pass = new JTextField(15);
		age = new JTextField(15);
		
		idcheck = new JButton("check");
		signup = new JButton("확인");
		cancel = new JButton("취소");
		
		newUserTitle = new JLabel("회원가입");
		
		lblName = new JLabel("이름 : ");
		lblId = new JLabel("아이디 : ");
		lblPass = new JLabel("비밀번호 : ");
		lblAge = new JLabel("나이 : ");
		
		newUserPane.setLayout(null);
		newUserPane.setBackground(new Color(255,255,255,150));
		newUserPane.add(lblName);
		newUserPane.add(name);
		newUserPane.add(lblId);
		newUserPane.add(id);
		newUserPane.add(idcheck);
		newUserPane.add(lblPass);
		newUserPane.add(pass);
		newUserPane.add(lblAge);
		newUserPane.add(age);
		newUserPane.add(signup);
		newUserPane.add(cancel);
		newUserPane.add(newUserTitle);
		
		newUserTitle.setFont(new Font("Gothic", Font.BOLD, 30));
		lblName.setFont(new Font("Gothic", Font.BOLD, 18));
		lblId.setFont(new Font("Gothic", Font.BOLD, 18));
		lblPass.setFont(new Font("Gothic", Font.BOLD, 18));
		lblAge.setFont(new Font("Gothic", Font.BOLD, 18));
		
		name.setFont(new Font("Gothic", Font.BOLD, 20));
		id.setFont(new Font("Gothic", Font.BOLD, 20));
		pass.setFont(new Font("Gothic", Font.BOLD, 20));
		age.setFont(new Font("Gothic", Font.BOLD, 20));
		
		newUserTitle.setBounds(90,20,150,40);
		lblName.setBounds(48,100, 60, 20);
		name.setBounds(100,100, 120, 25);
		lblId.setBounds(28,140, 80, 20);
		id.setBounds(100,140, 120, 25);
		idcheck.setBounds(225,140,70,25);
		lblPass.setBounds(10,180, 100, 20);
		pass.setBounds(100,180, 120, 25);
		lblAge.setBounds(48,220, 60, 20);
		age.setBounds(100,220, 120, 25);
		signup.setBounds(10,290,120,50);
		cancel.setBounds(160,290,120,50);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
//		if(LoginBtn.equals(e.getSource())) {
//			String userID = loginID.getText();
//			String userPW = loginPW.getText();
//			UserDto user = new UserDto(0,null,userID,userPW,0);
//		}
		
		if(e.getSource() == signupBtn) {
			background.remove(login);
			background.add(newUserPane);
			revalidate();
			repaint();
		}
		
//		if(e.getSource() == signup) {
//			background.remove(newUserPane);
//			background.add(login);
//			revalidate();
//			repaint();
//		}
		
		if(e.getSource() == cancel) {
			background.remove(newUserPane);
			background.add(login);
			revalidate();
			repaint();
		}
		
	}

}
