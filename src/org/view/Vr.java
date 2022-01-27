package org.view;

import java.util.Vector;

import org.client.GameClient;
import org.server.GameDataDto;
import org.server.UserDto;

public class Vr {
	
	public static final int LOGIN = 1;
	public static final int SIGNUP = 2;
	public static final int IDCHECK = 3;
	public static final int LOGOUT = 4;
	public static GameClient gc;
	
	public static LoginView loginView = new LoginView();
	
	public static UserDto mainUser;
	public static Vector<GameDataDto> mainData;
}




