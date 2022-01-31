package org.controller;

import static org.Resource.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JOptionPane;

import org.game.PlusMinus;
import org.model.MainFrame;
import org.test.ViewTest;
import org.view.GameContainer;
import org.view.MainView;
import org.view.RecordView;

public class ViewController implements ActionListener {
	public static HashMap<String, GameContainer> viewControll = new HashMap<>();
	public static MainFrame mainFrame = new MainFrame();
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
		viewControll.put(LOGINPAGE, loginView);
		viewControll.put(MAINPAGE, MAINVIEW);
//		viewControll.put(MAINPAGE,new MainView());
		viewControll.put(RECORD, RECORDVIEW);
		viewControll.put(PLUSMINUS, PlusMinusGAME);
//		viewControll.put(PLUSMINUS, new PlusMinus());
//		viewControll.put(MAINPAGE,MAINVIEW);
//		viewControll.put(MAINPAGE,MAINVIEW);
	}

	public ViewController() {
		mainFrame.displayView(viewControll.get(LOGINPAGE));

//		vt.displayView(viewControll.get(MAINPAGE));
		recordBtn.addActionListener(this);
		backBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		pulusminusGameBtn.addActionListener(this);
		pauseBtn.addActionListener(this);
		goMainBtn.addActionListener(this);
		replayBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == recordBtn) {
//		mainFrame.changeView(viewControll.get(RECORD));
			mainFrame.changeView(new RecordView());
//		vt.changeView(viewControll.get(RECORD));
		}

		if (e.getSource() == backBtn) {
//		mainFrame.changeView(viewControll.get(MAINPAGE));
			mainFrame.changeView(MAINVIEW);
//		vt.changeView(viewControll.get(MAINPAGE));
		}
		if (e.getSource() == exitBtn) {
			JOptionPane.showMessageDialog(NowView, "종료합니다!");
			System.exit(0);
		}

		if (e.getSource() == pulusminusGameBtn) {
//		mainFrame.changeView(viewControll.get(PLUSMINUS));			
			mainFrame.changeView(new PlusMinus());
//		vt.changeView(viewControll.get(PLUSMINUS));			
		}

		if (e.getSource() == goMainBtn) {
			gameNum = 0;
			gametrue = 0;
			endGameNum = 2;
			gameResultPane.setVisible(false);
			gameResultPane.removeAll();
			NowView.reGame();
			JOptionPane.showMessageDialog(NowView, "게임을 종료합니다!");
//		vt.changeView(viewControll.get(MAINPAGE));
//		mainFrame.changeView(viewControll.get(MAINPAGE));
			mainFrame.changeView(MAINVIEW);
		}
		if (e.getSource() == replayBtn) {
			endGameNum += 2;
			gameResultPane.setVisible(false);
			gameResultPane.removeAll();
			JOptionPane.showMessageDialog(NowView, "game Replay");
			NowView.reGame();
//		vt.changeView(NowView);
			mainFrame.changeView(NowView);
		}

		if (e.getSource() == pauseBtn) {
			JOptionPane.showMessageDialog(NowView, "Game 종료!");
//		vt.changeView(viewControll.get(MAINPAGE));
//		mainFrame.changeView(viewControll.get(MAINPAGE));
			mainFrame.changeView(MAINVIEW);
		}

	}

	public static void main(String[] args) {
		new ViewController();
	}
}
