package org.game;

import static org.Resource.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.RoundJButton;
import org.model.MainFrame;
import org.test.ViewTest;
import org.view.GameContainer;

public class PlusMinus extends GameContainer {
	GamePlayMain gp;
	JLabel bgLabel; // 가장 밑배경(초록잔디)
	JLabel pmbgLabel; // 게임 배경(하얀색 메모장)
	JLabel quizLabel; // 문제 나오는 곳 라벨( num + num ) 

//	JPanel gameResultPane;
	JLabel gametruelbl;
	JLabel gameNumlbl;
	JLabel gameEndmsg;
//	JButton replayBtn;
	
	JButton[] choiceBtn; // 4개의 선지
	JLabel checkLabel; // 정답일 경우 나오는 체크표시
	JLabel xLabel; // 오답일 경우 나오는 엑스표시
//	JButton pauseBtn; // 멈춤 버튼
	
	Timer timer;
//	int gameNum =0;
//	int gametrue=0;
//	int endGameNum = 2;
	public PlusMinus() {
	
		gamePlay();
	}

	@Override
	public void gamePlay() {
		gp = new GamePlayMain();
		
		this.setLayout(null);
		
		
		this.add(gameResultPane);
		gameResultPane.setBounds(FRAME_WIDTH/2-300/2, FRAME_HEIGHT/2-350/2, 300, 350);
		gameResultPane.setVisible(false);
		
		
		ImageIcon bgicon = new ImageIcon("images/backgroundImg.png");
		bgLabel = new JLabel(bgicon);
		bgLabel.setBounds(0, 0, 1024, 768);

		ImageIcon pmicon = new ImageIcon("images/gamebackImg.png");
		pmbgLabel = new JLabel(pmicon);
		pmbgLabel.setBounds(210, 100, 600, 500);

		quizLabel = new JLabel(gp.question);
		quizLabel.setFont(new Font("Gothic", Font.BOLD, 115));
		quizLabel.setForeground(Color.ORANGE);
		quizLabel.setBounds(330, 150, 400, 200);

		choiceBtn = new JButton[4];
		for (int i = 0; i < gp.answerArr.length; i++) {
			choiceBtn[i] = new RoundJButton();
			choiceBtn[i].setText(Integer.toString(gp.answerArr[i]));
			choiceBtn[i].setBackground(Color.orange);
			choiceBtn[i].setFont(new Font("Gothic", Font.BOLD, 70));
			choiceBtn[i].setForeground(Color.WHITE);
		}
		
		choiceBtn[0].setBounds(330, 350, 150, 70);
		choiceBtn[1].setBounds(550, 350, 150, 70);
		choiceBtn[2].setBounds(330, 450, 150, 70);
		choiceBtn[3].setBounds(550, 450, 150, 70);

		ImageIcon checkIcon = new ImageIcon("images/checked.png");
		checkLabel = new JLabel(checkIcon);
		ImageIcon xIcon = new ImageIcon("images/x.png");
		xLabel = new JLabel(xIcon);
		

//		pauseBtn = new JButton(pauseIcon);
		pauseBtn.setBounds(920, 30, 50, 50);
		pauseBtn.setBorderPainted(false);    // 버튼의 외곽 투명하게 
		pauseBtn.setContentAreaFilled(false);  // 만들어 주는 것

		checkLabel.setBounds(670, 65, 150, 150);
		this.add(checkLabel);
		checkLabel.setVisible(false);
		xLabel.setBounds(670, 65, 150, 150);
		this.add(xLabel);
		xLabel.setVisible(false);

		
//		gameResultPane = new JPanel();
		
//		gameResultPane.setBounds(FRAME_WIDTH/2-300/2, FRAME_HEIGHT/2-350/2, 300, 350);
//		gameResultPane.setVisible(false);
		
		this.add(pauseBtn);
//		this.add(gameResultPane);
		
		this.add(choiceBtn[0]);
		this.add(choiceBtn[1]);
		this.add(choiceBtn[2]);
		this.add(choiceBtn[3]);

		this.add(quizLabel);

		this.add(pmbgLabel);

		this.add(bgLabel);

		choiceBtn[0].addActionListener(this);
		choiceBtn[1].addActionListener(this);
		choiceBtn[2].addActionListener(this);
		choiceBtn[3].addActionListener(this);
		pauseBtn.addActionListener(this);
	}
	
	@Override
	public void reGame() {
		gp = new GamePlayMain();
		
		quizLabel.setText(gp.question);
		for (int i = 0; i < gp.answerArr.length; i++) {
			choiceBtn[i].setText(Integer.toString(gp.answerArr[i]));
			choiceBtn[i].setBackground(Color.orange);
		}
		checkLabel.setVisible(false);
		xLabel.setVisible(false);
	}
	
//	public void endGame() {
//		gameResultPane.setLayout(null);
//		gameNumlbl = new JLabel("총 도전 횟수 : "+gameNum);
//		gametruelbl = new JLabel("정답 : "+gametrue);
//		gameEndmsg = new JLabel("게임결과");
//		
//		gameEndmsg.setFont(new Font("맑은 고딕", Font.BOLD, 30));
//		gameNumlbl.setFont(new Font("맑은 고딕", Font.BOLD, 20));
//		gametruelbl.setFont(new Font("맑은 고딕", Font.BOLD, 20));
//		
//		
//		gameResultPane.add(gameEndmsg);
//		gameResultPane.add(gameNumlbl);
//		gameResultPane.add(gametruelbl);
//		gameResultPane.add(replayBtn);
//		gameResultPane.add(goMainBtn);
//		
//		replayBtn.setBounds(10,290,120,50);
//		goMainBtn.setBounds(160,290,120,50);
//		
//		gameEndmsg.setBounds(95, 20, 200, 30);
//		gameNumlbl.setBounds(85, 90, 200, 30);
//		gametruelbl.setBounds(120, 150, 100, 30);
//		
//		gameResultPane.setVisible(true);
//		
//	}
	@Override
	public void actionPerformed(ActionEvent e) { 
		
		if (e.getSource() == choiceBtn[0]) {
			gameNum++;
			choiceBtn[0].setBackground(Color.RED);
			
			if (gp.answer == Integer.parseInt(choiceBtn[0].getText())) {
				gametrue++;
				checkLabel.setVisible(true);
				revalidate();
				repaint();
				
			} else {
				xLabel.setVisible(true);
				revalidate();
				repaint();
			}
		}
		if (e.getSource() == choiceBtn[1]) {
			gameNum++;
			choiceBtn[1].setBackground(Color.RED);
			if (gp.answer == Integer.parseInt(choiceBtn[1].getText())) {
				gametrue++;
				checkLabel.setVisible(true);
				revalidate();
				repaint();
			} else {
				xLabel.setVisible(true);
				revalidate();
				repaint();
			}
		}
		if (e.getSource() == choiceBtn[2]) {
			gameNum++;
			choiceBtn[2].setBackground(Color.RED);
			if (gp.answer == Integer.parseInt(choiceBtn[2].getText())) {
				gametrue++;
				checkLabel.setVisible(true);
				revalidate();
				repaint();
			} else {
				xLabel.setVisible(true);
				revalidate();
				repaint();
			}
		}
		if (e.getSource() == choiceBtn[3]) {
			gameNum++;
			choiceBtn[3].setBackground(Color.RED);
			if (gp.answer == Integer.parseInt(choiceBtn[3].getText())) {
				gametrue++;
				checkLabel.setVisible(true);
				revalidate();
				repaint();
			} else {
				xLabel.setVisible(true);
				revalidate();
				repaint();
			}
		}
		
//		if(e.getSource() == replayBtn) {
//			gameNum--;
//			endGameNum += 2;
//			gameResultPane.setVisible(false);
//			gameResultPane.removeAll();
//		}
		
		// 딜레이 1.5초 주고 다음게임 시작
		timer = new Timer(1500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(gameNum>=endGameNum) {
					endGame();
				}else {
					reGame();					
				}
				timer.stop();
			}
		});
		timer.start();
	}
}
