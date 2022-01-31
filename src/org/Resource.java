package org;

import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.game.PlusMinus;
import org.model.GameDataDto;
import org.model.UserDto;
import org.view.GameContainer;
import org.view.LoginView;
import org.view.MainView;
import org.view.PlusMinusRecordView;
import org.view.RecordView;

public class Resource {
	public static final int FRAME_WIDTH = 1024, FRAME_HEIGHT = 768;
	public static final String LOGIN = "login";
	public static final String NEWLOGIN = "newlogin";
	public static final String SIGNUP = "signup";
	public static final String IDCHECK = "idcheck";
	public static final String LOGOUT = "logout";
	
	public static final String LOGINPAGE = "login";
	public static final String MAINPAGE = "main";
	public static final String PLUSMINUS = "plusminus";
	public static final String CARD = "card";
	public static final String BALL = "ball";
	public static final String LIFE = "life";
	public static final String COLOR = "color";
	public static final String RECORD = "record";
	public static final String PlisMinusRECORD = "plusminusRecord";
	public static final String CardRECORD = "cardRecord";
	public static final String LifeRECORD = "lifeRecord";
	public static final String BallRECORD = "ballRecord";
	public static final String ColorRECORD = "colorRecord";
	
	public static boolean loginSucess =false;
	public static int gameNum =0;
	public static int gametrue=0;
	public static int endGameNum = 2;
	public static UserDto mainUser;
	public static Vector<GameDataDto> mainData;
	
	
	public static JPanel gameResultPane = new JPanel();
	
	
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
	
	// PlusMinusGame
	public static ImageIcon pauseIcon = new ImageIcon("images/pause.png");
	public static JButton pauseBtn =new JButton(pauseIcon);
	
	
	public static JButton goMainBtn = new JButton("메인화면으로");
	public static JButton replayBtn = new JButton("다시시작");
	// View
	
	public static GameContainer NowView;
	public static GameContainer loginView = new LoginView();
	public static GameContainer MAINVIEW = new MainView();
	public static GameContainer RECORDVIEW = new RecordView();
	public static GameContainer PlusMinusGAME = new PlusMinus();
	
	public static GameContainer PlusMinisRecord = new PlusMinusRecordView();
}




