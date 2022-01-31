package org.view;

import static org.Resource.FRAME_HEIGHT;
import static org.Resource.FRAME_WIDTH;
import static org.Resource.ballGameBtn;
import static org.Resource.cardGameBtn;
import static org.Resource.colorGameBtn;
import static org.Resource.exitBtn;
import static org.Resource.idcheck;
import static org.Resource.lifeGameBtn;
import static org.Resource.loginView;
import static org.Resource.pulusminusGameBtn;
import static org.Resource.recordBtn;
import static org.Resource.textage;
import static org.Resource.textid;
import static org.Resource.textname;
import static org.Resource.textpass;
import static org.Resource.*;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class MainView extends GameContainer{
	ImageIcon backgroundImg;
	JLabel background;
	JButton settingBtn = new JButton("!");
	JButton updateBtn = new JButton("!");
	JButton profileCancelBtn = new JButton("돌아가기");
	String userId = "유저000";
	String userName = "홍길동";
	String userPass = "비밀번호";
	int userAge = 74; 
	
	
	JPanel profile = new JPanel();
//	JLabel idtag = new JLabel(userId);
//	JLabel infotag = new JLabel("이름 : "+userNamedb+" 나이 : "+userAgedb);
	JLabel idtag;
	JLabel infotag;
	
	boolean updateBtnState = false;
	JPanel profileUpdate;
	
	public MainView() {
		gamePlay();
	}
	
	@Override
	public void gamePlay() {
		
		backgroundImg = new ImageIcon("images/mainBack.png");
		background = new JLabel(backgroundImg);
		
		this.setLayout(null);
		this.add(background);
		
		background.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		
		displaySetting();
	}
	
	public void displaySetting() {
		setCreateBox();
		JLabel title = new JLabel("메인화면");
		title.setFont(new Font("맑은 고딕", Font.BOLD, 40));
//		idtag.setFont(new Font("맑은 고딕", Font.BOLD, 15));
//		infotag.setFont(new Font("맑은 고딕", Font.BOLD, 13));

		idtagdb.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		infotagdb.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		
		profile.setLayout(null);
		
//		profile.add(idtag);
//		profile.add(infotag);
		profile.add(idtagdb);
		profile.add(infotagdb);
		profile.add(settingBtn);
//		idtag.setBounds(75,5,150,40);
//		infotag.setBounds(25,35,170,40);
		idtagdb.setBounds(75,5,150,40);
		infotagdb.setBounds(25,35,170,40);
		settingBtn.setBounds(160,10,30,30);
		
		background.add(profileUpdate);
		background.add(profile);
		background.add(pulusminusGameBtn);
		background.add(cardGameBtn);
		background.add(ballGameBtn);
		background.add(lifeGameBtn);
		background.add(colorGameBtn);
		background.add(recordBtn);
		background.add(exitBtn);
		background.add(title);
		
		title.setBounds(30, 20, 200,40);
		profile.setBounds(FRAME_WIDTH/2-100, 10, 200, 80);
		profileUpdate.setBounds(FRAME_WIDTH/2-300/2, FRAME_HEIGHT/2-350/2, 300, 350);
		profileUpdate.setVisible(false);
		
		pulusminusGameBtn.setBounds(FRAME_WIDTH/2-150/2-380, FRAME_HEIGHT/2-160,150,256);
		cardGameBtn.setBounds(FRAME_WIDTH/2-150/2-190, FRAME_HEIGHT/2-160,150,256);
		ballGameBtn.setBounds(FRAME_WIDTH/2-150/2, FRAME_HEIGHT/2-160,150,256);
		lifeGameBtn.setBounds(FRAME_WIDTH/2-150/2+190, FRAME_HEIGHT/2-160,150,256);
		colorGameBtn.setBounds(FRAME_WIDTH/2-150/2+380, FRAME_HEIGHT/2-160,150,256);
		
		recordBtn.setBounds(FRAME_WIDTH-180, 10,150,80);
		exitBtn.setBounds(FRAME_WIDTH-180, FRAME_HEIGHT-130,150,80);
		
		settingBtn.addActionListener(this);
		profileOkBtn.addActionListener(this);
		profileCancelBtn.addActionListener(this);
		updateBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == settingBtn) {
			
			pulusminusGameBtn.setEnabled(false);
			cardGameBtn.setEnabled(false);
			ballGameBtn.setEnabled(false);
			lifeGameBtn.setEnabled(false);
			colorGameBtn.setEnabled(false);
			recordBtn.setEnabled(false);
			exitBtn.setEnabled(false);
			settingBtn.setEnabled(false);
			
			textname.setText(userNamedb);
			textid.setText(userIddb);
			textpass.setText(userPassdb);
			textage.setText(userAgedb+"");
			
			profileUpdate.setVisible(true);
			
			revalidate();
			repaint();
		}
		
		if(e.getSource() == updateBtn) {
			if(!updateBtnStatedb) {
				textname.setEditable(true);
				textpass.setEditable(true);
				textage.setEditable(true);
				updateBtnStatedb = true;
			}else {
				textname.setEditable(false);
				textpass.setEditable(false);
				textage.setEditable(false);
				updateBtnStatedb = false;
			}
		}
		
//		if(e.getSource() == profileOkBtn) {
//			int yn = JOptionPane.showConfirmDialog(this, "프로필을 수정하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
//				
//			if(yn == 0) {
//				userName = textname.getText();
//				userPass = textpass.getText();
//				try {
//					userAge = Integer.parseInt(textage.getText());
//				}catch(NumberFormatException e0) {
//					JOptionPane.showMessageDialog(this, "나이는 숫자만 입력하세요!");
//					textage.setText(userAge+"");
//					return;
//				}
//				
//				infotag.setText("이름 : "+userName+" 나이 : "+userAge);
//				textname.setEditable(false);
//				textpass.setEditable(false);
//				textage.setEditable(false);
//				updateBtnState = false;
//			}
//		}
		
		if(e.getSource() == profileCancelBtn) {
			pulusminusGameBtn.setEnabled(true);
			cardGameBtn.setEnabled(true);
			ballGameBtn.setEnabled(true);
			lifeGameBtn.setEnabled(true);
			colorGameBtn.setEnabled(true);
			recordBtn.setEnabled(true);
			exitBtn.setEnabled(true);
			settingBtn.setEnabled(true);
			
			profileUpdate.setVisible(false);
			
			revalidate();
			repaint();
		}
	}
	public void setCreateBox() {
		profileUpdate = new JPanel();
		
		userIddb = mainUser.getId();
		userNamedb = mainUser.getName();
		userPassdb = mainUser.getPassword();
		userAgedb = mainUser.getAge(); 
		
		idtagdb = new JLabel(userIddb);
		infotagdb = new JLabel("이름 : "+userNamedb+" 나이 : "+userAgedb);
		
		JLabel newUserTitle = new JLabel("프로필");
		JLabel lblName = new JLabel("이름 : ");
		JLabel lblId = new JLabel("아이디 : ");
		JLabel lblPass = new JLabel("비밀번호 : ");
		JLabel lblAge = new JLabel("나이 : ");
		
		profileUpdate.setLayout(null);
		profileUpdate.setBackground(new Color(255,255,255,255));
		
		profileUpdate.add(newUserTitle);
		profileUpdate.add(lblName);
		profileUpdate.add(lblId);
		profileUpdate.add(lblPass);
		profileUpdate.add(lblAge);
		
		newUserTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblId.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblPass.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblAge.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		
		newUserTitle.setBounds(110,10,100,40);
		lblName.setBounds(48,100, 60, 20);
		lblId.setBounds(28,140, 80, 20);
		lblPass.setBounds(10,180, 100, 20);
		lblAge.setBounds(48,220, 60, 20);

		profileUpdate.add(textname);
		profileUpdate.add(textid);
		profileUpdate.add(textpass);
		profileUpdate.add(textage);
		profileUpdate.add(profileOkBtn);
		profileUpdate.add(profileCancelBtn);
		profileUpdate.add(updateBtn);
		
		textname.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		textid.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		textpass.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		textage.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
//		textname.setText(userName);
//		textid.setText(userId);
//		textpass.setText(userPass);
//		textage.setText(userAge+"");
		
		textname.setText(userNamedb);
		textid.setText(userIddb);
		textpass.setText(userPassdb);
		textage.setText(userAgedb+"");

		textname.setEditable(false);
		textid.setEditable(false);
		textpass.setEditable(false);
		textage.setEditable(false);
		
		textname.setBounds(100,100, 120, 25);
		textid.setBounds(100,140, 120, 25);
		idcheck.setBounds(225,140,70,25);
		textpass.setBounds(100,180, 120, 25);
		textage.setBounds(100,220, 120, 25);
		
		updateBtn.setBounds(250,10,40,40);
		profileOkBtn.setBounds(10,290,120,50);
		profileCancelBtn.setBounds(160,290,120,50);
	}
}
