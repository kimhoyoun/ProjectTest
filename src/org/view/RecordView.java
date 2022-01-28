package org.view;

import static org.Resource.FRAME_HEIGHT;
import static org.Resource.FRAME_WIDTH;
import static org.Resource.backBtn;
import static org.Resource.ballRecordBtn;
import static org.Resource.cardRecordBtn;
import static org.Resource.colorRecordBtn;
import static org.Resource.lifeRecordBtn;
import static org.Resource.pulusminusRecordBtn;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class RecordView extends GameContainer{
	ImageIcon backgroundImg;
	JLabel background;
	public RecordView() {
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
		JLabel title = new JLabel("성적확인");
		title.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		background.add(pulusminusRecordBtn);
		background.add(cardRecordBtn);
		background.add(ballRecordBtn);
		background.add(lifeRecordBtn);
		background.add(colorRecordBtn);
		background.add(backBtn);
		background.add(title);
//		pulusminusGameBtn.setBounds(getVisibleRect());
		
		title.setBounds(30, 20, 200,40);
		pulusminusRecordBtn.setBounds(FRAME_WIDTH/2-150/2-380, FRAME_HEIGHT/2-160,150,256);
		cardRecordBtn.setBounds(FRAME_WIDTH/2-150/2-190, FRAME_HEIGHT/2-160,150,256);
		ballRecordBtn.setBounds(FRAME_WIDTH/2-150/2, FRAME_HEIGHT/2-160,150,256);
		lifeRecordBtn.setBounds(FRAME_WIDTH/2-150/2+190, FRAME_HEIGHT/2-160,150,256);
		colorRecordBtn.setBounds(FRAME_WIDTH/2-150/2+380, FRAME_HEIGHT/2-160,150,256);
		
		backBtn.setBounds(30, FRAME_HEIGHT-130,150,80);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
