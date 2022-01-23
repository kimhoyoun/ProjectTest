package org.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;

import org.db.ConnectionDB;

public class UserDao {
	// user table의 모든 데이터 갖고오기
	public static final String SELECT_ALL = "SELECT * FROM USER";
	// user table에서 한명의 모든 정보를 가져옴
	public static final String SELECT_ONE = "SELECT * FROM USER WHERE ID = ?";
	// 새로운 user가 회원가입을 하면 새로운 유저값을 user table에 저장
	public static final String INSERT = "INSERT INTO USER (NAME, ID, PASSWORD, AGE) VALUES(?,?,?,?)";
	// user data를 수정할 경우 id는 변경할 수 없으므로 id로 검색하여 각각의 값을 수정
	public static final String UPDATE_NAME = "UPDATE USER SET NAME =? WHERE ID = ?";
	public static final String UPDATE_AGE = "UPDATE USER SET AGE =? WHERE ID = ?";
	public static final String UPDATE_PASSWORD = "UPDATE USER SET PASSWORD =? WHERE ID = ?";
	// 회원탈퇴를 할 경우 table에서 데이터 삭제
	public static final String DELETE = "DELETE FROM USER WHERE ID = ?";
	
	// gamedata table에서 userID로 검색하여 해당 유저의 모든 게임 데이터를 가져옴.
	public static final String SELECT_DATA_ALL = "SELECT GAME1, GAME2, GAME3, GAME4, GAME5, DAY FROM GAMEDATA WHERE ID = ?";
	// game을 종료할 때 모든 당일의 게임 정답률 data를 gamedata table에 저장.
	public static final String INSERT_DATA = "INSERT INTO GAMEDATA (NAME, GAME1, GAME2, GAME3, GAME4, GAME5, DAY) VALUES(?,?,?,?,?,?,?)";

	public static Connection conn = null;
	public static ResultSet rs = null;
	public static Statement stmt = null;
	public static PreparedStatement pstmt = null;
	// 모든 user의 정보를 저장할 Vector
	public static Vector<UserDto> userVector = new Vector<>();
	// key : userID, value : 날짜로 구분한 game별 정답률 저장할 HashMap
	public static HashMap<String, Vector<GameDataDto>> userData = null;

	public void roadUser() {
		userVector = new Vector<>();
		conn = ConnectionDB.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_ALL);
			while (rs.next()) {
				UserDto user = null;
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String id = rs.getString(3);
				String password = rs.getString(4);
				int age = rs.getInt(5);

				user = new UserDto(no, name, id, password, age);
				userVector.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					ConnectionDB.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void roadGameData() {
		userData = new HashMap<>();
		conn = ConnectionDB.getConnection();

		for (int i = 0; i < userVector.size(); i++) {
			Vector<GameDataDto> vector = new Vector<>();
			try {
				pstmt = conn.prepareStatement(SELECT_DATA_ALL);
				pstmt.setString(1, userVector.get(i).getId());
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					GameDataDto data = null;
					double game1 = rs.getDouble(1);
					double game2 = rs.getDouble(2);
					double game3 = rs.getDouble(3);
					double game4 = rs.getDouble(4);
					double game5 = rs.getDouble(5);
					String day = rs.getString(6);
					// GameDataDto 객체 만들고
					data = new GameDataDto(game1, game2, game3, game4, game5, day);
					// 벡터에 저장
					vector.add(data);
				}
				// userVector의 목록에서 userID를 key로하여 game별 data가 담긴 Vector를 HashMap userData에 저장. 
				userData.put(userVector.get(i).getId(), vector);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
