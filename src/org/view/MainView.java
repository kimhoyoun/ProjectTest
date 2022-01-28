package org.view;

import static org.Resource.FRAME_HEIGHT;
import static org.Resource.FRAME_WIDTH;
import static org.Resource.*;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


//JButton pulusminusGameBtn = new JButton("PlusMinus");
//	public static JButton cardGameBtn = new JButton("Card");
//	public static JButton ballGameBtn = new JButton("Ball");
//	public static JButton lifeGameBtn = new JButton("Life");
//	public static JButton colorGameBtn = new JButton("Color");
//	public static JButton recordBtn = new JButton("Record");
//	public static JButton exitBtn = new JButton("Exit");
public class MainView extends GameContainer{
	ImageIcon backgroundImg;
	JLabel background;
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
	
	public void init() {
		
	}
	
	public void displaySetting() {
		JLabel title = new JLabel("메인화면");
		title.setFont(new Font("Gothic", Font.BOLD, 40));
		
		background.add(pulusminusGameBtn);
		background.add(cardGameBtn);
		background.add(ballGameBtn);
		background.add(lifeGameBtn);
		background.add(colorGameBtn);
		background.add(recordBtn);
		background.add(exitBtn);
		background.add(title);
		
		title.setBounds(30, 20, 200,40);
		pulusminusGameBtn.setBounds(FRAME_WIDTH/2-150/2-380, FRAME_HEIGHT/2-160,150,256);
		cardGameBtn.setBounds(FRAME_WIDTH/2-150/2-190, FRAME_HEIGHT/2-160,150,256);
		ballGameBtn.setBounds(FRAME_WIDTH/2-150/2, FRAME_HEIGHT/2-160,150,256);
		lifeGameBtn.setBounds(FRAME_WIDTH/2-150/2+190, FRAME_HEIGHT/2-160,150,256);
		colorGameBtn.setBounds(FRAME_WIDTH/2-150/2+380, FRAME_HEIGHT/2-160,150,256);
		
		recordBtn.setBounds(FRAME_WIDTH-180, 10,150,80);
		exitBtn.setBounds(FRAME_WIDTH-180, FRAME_HEIGHT-130,150,80);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
