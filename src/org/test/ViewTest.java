package org.test;

import static org.Resource.FRAME_HEIGHT;
import static org.Resource.FRAME_WIDTH;
import static org.Resource.*;

import java.awt.Container;

import javax.swing.JFrame;

import org.view.GameContainer;

public class ViewTest extends JFrame{
	Container contentPane;
	public ViewTest() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		contentPane = getContentPane();
		contentPane.setLayout(null);
	}
	
	public void displayView(GameContainer gc) {
		
		gc.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		contentPane.add(gc);
		NowView = gc;
		this.setVisible(true);
	}
	
	
	public void changeView(GameContainer gc) {
		contentPane.remove(NowView);
		contentPane.add(gc);
		NowView = gc;
		gc.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		revalidate();
		repaint();
	}
}
