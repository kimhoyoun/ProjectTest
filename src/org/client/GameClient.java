package org.client;

import static org.view.Vr.gc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.server.MainFrame;

public class GameClient{
	private Socket socket = null;		
	public BufferedReader br = null;
	public BufferedWriter bw = null;
	public ObjectInputStream ois = null;
	public ObjectOutputStream oos = null;
	public String msg;
	public String req;
	public GameClient() {
		connectServer();
		
		ClientThread th = new ClientThread();
		th.start();
	}
	public void connectServer() {
		try {
			// localHost ip, 9999 port에 접속
			socket = new Socket(InetAddress.getLocalHost(), 9999);
			
			// 서버에 접속하고 입출력 스트림 생성
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	class ClientThread extends Thread{
		@Override
		public void run() {
			try {
				msg = br.readLine();
				
				switch(msg) {
				
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new MainFrame();
		gc = new GameClient();
	}
}
