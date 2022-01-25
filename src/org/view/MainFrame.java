package org.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static org.view.Vr.*;

public class MainFrame extends JFrame{
	Container contentPane;
	public MainFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1080,720);
		contentPane = getContentPane();
//		contentPane.setSize(1040, 780);
//		ImageIcon backgroundImg = new ImageIcon("mainBack.png");
//		JLabel background = new JLabel(backgroundImg);
		LoginView lv = new LoginView();
		
		
		contentPane.setLayout(null);
		lv.setBounds(0,0,1080,720);
		contentPane.add(lv);
//		background.setBounds(0,0,1080,720);
//		contentPane.add(background);
		
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}


}
