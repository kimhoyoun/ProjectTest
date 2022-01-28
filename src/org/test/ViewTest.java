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
		displayView(MAINVIEW);
	}
	
	public void displayView(GameContainer gc) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		contentPane = getContentPane();
		
		contentPane.setLayout(null);
		gc.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		contentPane.add(gc);

		this.setVisible(true);
	}
	public static void main(String[] args) {
		new ViewTest();
	}
}
