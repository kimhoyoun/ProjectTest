package org;

import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.model.GameDataDto;
import org.model.UserDto;
import org.view.GameContainer;
import org.view.LoginView;
import org.view.MainView;
import org.view.RecordView;

public class Resource {
	public static final int FRAME_WIDTH = 1024, FRAME_HEIGHT = 768;
	public static final String LOGIN = "login";
	public static final String NEWLOGIN = "newlogin";
	public static final String SIGNUP = "signup";
	public static final String IDCHECK = "idcheck";
	public static final String LOGOUT = "logout";
	
	
	
	public static UserDto mainUser;
	public static Vector<GameDataDto> mainData;
	
	
	// login View
	
	public static JButton LoginBtn = new JButton("로그인");
	public static JButton signupBtn = new JButton("회원가입");
	public static JTextField inputID = new JTextField(15);
	public static JTextField inputPW = new JTextField(15);
	
	public static JTextField textname = new JTextField(20);
	public static JTextField textid = new JTextField(15);
	public static JTextField textpass = new JTextField(15);
	public static JTextField textage = new JTextField(15);
	public static JButton idcheck = new JButton("check");
	public static JButton signup = new JButton("확인");
	public static JButton cancel = new JButton("취소");

	// MainView
	public static JButton pulusminusGameBtn = new RoundJButton("PlusMinus");
	public static JButton cardGameBtn = new RoundJButton("Card");
	public static JButton ballGameBtn = new RoundJButton("Ball");
	public static JButton lifeGameBtn = new RoundJButton("Life");
	public static JButton colorGameBtn = new RoundJButton("Color");
	public static JButton recordBtn = new RoundJButton("Record");
	public static JButton exitBtn = new RoundJButton("Exit");
	
	// RecordView
	public static JButton pulusminusRecordBtn = new RoundJButton("PlusMinus");
	public static JButton cardRecordBtn = new RoundJButton("Card");
	public static JButton ballRecordBtn = new RoundJButton("Ball");
	public static JButton lifeRecordBtn = new RoundJButton("Life");
	public static JButton colorRecordBtn = new RoundJButton("Color");
	public static JButton backBtn = new RoundJButton("Back");
	
	// View
	public static GameContainer loginView = new LoginView();
	public static GameContainer MAINVIEW = new MainView();
	public static GameContainer RECORDVIEW = new RecordView();
}




