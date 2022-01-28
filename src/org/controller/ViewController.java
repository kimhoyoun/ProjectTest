package org.controller;

import static org.Resource.LOGINPAGE;
import static org.Resource.MAINPAGE;
import static org.Resource.MAINVIEW;
import static org.Resource.NowView;
import static org.Resource.RECORD;
import static org.Resource.RECORDVIEW;
import static org.Resource.backBtn;
import static org.Resource.exitBtn;
import static org.Resource.loginView;
import static org.Resource.recordBtn;
import static org.Resource.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JOptionPane;

import org.game.PlusMinus;
import org.model.MainFrame;
import org.test.ViewTest;
import org.view.GameContainer;

public class ViewController implements ActionListener{
public static HashMap<String,GameContainer> viewControll =new HashMap<>();
//public static MainFrame mainFrame = new MainFrame();
public static ViewTest vt = new ViewTest();

//public static final String MAINPAGE = "main";
//public static final String PLUSMINUS = "plusminus";
//public static final String CARD = "card";
//public static final String BALL = "ball";
//public static final String LIFE = "life";
//public static final String COLOR = "color";
//public static final String RECORD = "record";
//public static final String PlisMinusRECORD = "plusminusRecord";
//public static final String CardRECORD = "cardRecord";
//public static final String LifeRECORD = "lifeRecord";
//public static final String BallRECORD = "ballRecord";
//public static final String ColorRECORD = "colorRecord";
	
	static {
		viewControll.put(LOGINPAGE,loginView);
		viewControll.put(MAINPAGE,MAINVIEW);
		viewControll.put(RECORD,RECORDVIEW);
		viewControll.put(PLUSMINUS,PlusMinusGAME);
//		viewControll.put(MAINPAGE,MAINVIEW);
//		viewControll.put(MAINPAGE,MAINVIEW);
	}
	public ViewController() {
//		mainFrame.displayView(viewControll.get(LOGINPAGE));
		
		vt.displayView(viewControll.get(MAINPAGE));
		recordBtn.addActionListener(this);
		backBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		pulusminusGameBtn.addActionListener(this);
		pauseBtn.addActionListener(this);
	}
	
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource() == recordBtn) {
//		mainFrame.changeView(viewControll.get(RECORD));
		vt.changeView(viewControll.get(RECORD));
	}
	
	if(e.getSource() == backBtn) {
//		mainFrame.changeView(viewControll.get(MAINPAGE));
		vt.changeView(viewControll.get(MAINPAGE));
	}
	if(e.getSource() == exitBtn) {
		JOptionPane.showMessageDialog(NowView, "종료합니다!");
		System.exit(0);
	}
	
	if(e.getSource() == pulusminusGameBtn) {
		vt.changeView(new PlusMinus());			
	}
	
	if(e.getSource() == pauseBtn) {
		JOptionPane.showMessageDialog(NowView, "Game 종료!");
		vt.changeView(viewControll.get(MAINPAGE));
	}
	}

public static void main(String[] args) {
	new ViewController();
}
}
