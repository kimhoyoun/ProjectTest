package org.view;

import static org.Resource.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginView extends GameContainer {
	boolean flag = false;
	ImageIcon backgroundImg;
	JLabel background;
	
	JPanel login;
	JPanel newUserPane;
	
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
				
		background.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		login.setBounds(FRAME_WIDTH/2-300/2, FRAME_HEIGHT/2-350/2, 300, 350);
		newUserPane.setBounds(FRAME_WIDTH/2-300/2, FRAME_HEIGHT/2-350/2, 300, 350);
		
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
		
		login = new JPanel();
		login.setBackground(new Color(255,255,255,150));
		login.setLayout(null);

		JLabel loginLabel = new JLabel("로그인");
		JLabel loginID = new JLabel("I D");
		JLabel loginPW = new JLabel("PW");

		loginLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		loginID.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		loginPW.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		login.add(loginLabel);
		login.add(loginID);
		login.add(loginPW);

		loginLabel.setBounds(300/2-50,20,100,40);
		loginID.setBounds(300/2-120, 350/2-80,40,40);
		loginPW.setBounds(300/2-120, 350/2-20,40,40);

		inputID.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		inputPW.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		login.add(inputID);
		login.add(inputPW);
		login.add(LoginBtn);
		login.add(signupBtn);
		
		LoginBtn.setBounds(300/2-140,350-60,120,50);
		signupBtn.setBounds(300/2+10,350-60,120,50);
		inputID.setBounds(300/2-70, 350/2-80,180,40);
		inputPW.setBounds(300/2-70, 350/2-20,180,40);
	}
	
	public void setCreateBox() {
		newUserPane = new JPanel();
		
		JLabel newUserTitle = new JLabel("회원가입");
		JLabel lblName = new JLabel("이름 : ");
		JLabel lblId = new JLabel("아이디 : ");
		JLabel lblPass = new JLabel("비밀번호 : ");
		JLabel lblAge = new JLabel("나이 : ");
		
		newUserPane.setLayout(null);
		newUserPane.setBackground(new Color(255,255,255,150));

		newUserPane.add(newUserTitle);
		newUserPane.add(lblName);
		newUserPane.add(lblId);
		newUserPane.add(lblPass);
		newUserPane.add(lblAge);
		
		newUserTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblId.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblPass.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblAge.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		
		newUserTitle.setBounds(90,20,150,40);
		lblName.setBounds(48,100, 60, 20);
		lblId.setBounds(28,140, 80, 20);
		lblPass.setBounds(10,180, 100, 20);
		lblAge.setBounds(48,220, 60, 20);

		newUserPane.add(textname);
		newUserPane.add(textid);
		newUserPane.add(idcheck);
		newUserPane.add(textpass);
		newUserPane.add(textage);
		newUserPane.add(signup);
		newUserPane.add(cancel);

		textname.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		textid.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		textpass.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		textage.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		textname.setBounds(100,100, 120, 25);
		textid.setBounds(100,140, 120, 25);
		idcheck.setBounds(225,140,70,25);
		textpass.setBounds(100,180, 120, 25);
		textage.setBounds(100,220, 120, 25);
		
		signup.setBounds(10,290,120,50);
		cancel.setBounds(160,290,120,50);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == signupBtn) {
			background.remove(login);
			background.add(newUserPane);
			revalidate();
			repaint();
		}
		
		if(e.getSource() == cancel) {
			textname.setText("");
			textid.setText("");
			textpass.setText("");
			textage.setText("");
			background.remove(newUserPane);
			background.add(login);
			revalidate();
			repaint();
		}
		
	}

}
