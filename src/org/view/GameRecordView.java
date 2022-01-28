package org.view;

import static org.Resource.FRAME_HEIGHT;
import static org.Resource.FRAME_WIDTH;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GameRecordView extends JPanel{
	ImageIcon backgroundImg;
	JLabel background;
	public void gamePlay() {
		backgroundImg = new ImageIcon("images/cloud.png");
		background = new JLabel(backgroundImg);
		this.setLayout(null);
		this.add(background);
		
		background.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		
	}


}
