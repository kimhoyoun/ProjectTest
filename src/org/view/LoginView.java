package org.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static org.view.Vr.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JPanel implements ActionListener{
//	JButton LoginBtn;
	int w = 1080;
	int h = 720;
	boolean flag = false;
	public LoginView() {
		
//		JButton btn = new JButton("btn");
		ImageIcon backgroundImg = new ImageIcon("images/mainBack.png");
		JLabel background = new JLabel(backgroundImg);
		
		this.setLayout(null);
//		LoginBtn = new JButton("Login");
		background.setBounds(0, 0, 1080, 720);
		this.add(AppleFrame);
		this.add(LoginBtn);
		LoginBtn.addActionListener(this);
		AppleFrame.setBounds(w/2-150/2,h/2-150,200,150);
//		AppleFrame.setVisible(true);
		LoginBtn.setBounds(w/2-150/2,h/2+70/2,150,70);
//		this.add(btn);
		this.add(background);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(LoginBtn.equals(e.getSource())) {
			if(!flag) {
				AppleFrame.setVisible(true);				
				flag = true;
			}else {
				AppleFrame.setVisible(false);
				flag = false;
			}
			
		}
		
	}
}
