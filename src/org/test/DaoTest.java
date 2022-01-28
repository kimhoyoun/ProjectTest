package org.test;

import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import org.model.GameDataDto;
import org.model.UserDao;
import org.model.UserDto;

public class DaoTest {
	public static UserDao dao = new UserDao();
	
	public static void main(String[] args) {
		Vector<GameDataDto> vector = dao.roadOneGameData(new UserDto(0,null,"user2",null,0));
		
		System.out.println(vector.get(0).getId());
		for(GameDataDto dto : vector) {
			System.out.println(dto);
		}
		
	}
	public static void main_deleteTest(String[] args) {
		boolean ok = dao.deleteUser(new UserDto(0, null, "user4", null, 0));
		
		if(ok) {
			System.out.println("user 정보 삭제!");
		}
		
		ok = dao.deleteGameData(new GameDataDto("user4",0,0,0,0,0,0,0,0,0,0,null));
		
		if(ok) {
			System.out.println("gameData 정보 삭제!");
		}
	}
	
	public static void main_updateTest(String[] args) {
		boolean ok = dao.updateUser(new UserDto(0, "saram4_1", "user4", "user4", 78));
		if(ok) {
			System.out.println("수정 성공");
		}
			
//		boolean ok = dao.updateGameData(new GameDataDto("user4",17,20,26,30,17,20,22,30,31,40,"2022-01-13"));
//		if(ok) {
//			System.out.println("수정 성공");
//		}
	}
	
	public static void main_insertTest(String[] args) {
//		boolean ok = dao.insertUser(new UserDto(0, "saram4", "user4", "user4", 77));
//		if(ok) {
//			System.out.println("입력 성공");
//		}
		
		System.out.println("================== roadUser Test ==================");
		dao.roadUser();
		for(UserDto dto : dao.userVector) {
			System.out.println(dto);
		}
		
//		boolean ok = dao.insertGameData(new GameDataDto("user4",8,10,16,20,9,10,15,20,25,30,"2022-01-13"));
//		if(ok) {
//			System.out.println("입력성공");
//		}
		
		System.out.println("================= roadGameData Test =================");
		dao.roadGameData();
		
//		System.out.println(dao.userData);
		
		Set key = dao.userData.keySet();
		Iterator it = key.iterator();
		
		while(it.hasNext()) {
			String id = (String)it.next();
			Vector<GameDataDto> vector = dao.userData.get(id);
			
			System.out.println(id+" data");
			for(GameDataDto dto : vector) {
				System.out.println(dto);
			}
		}
	}
	
	
	public static void main_roadData(String[] args) {
		
		System.out.println("================== roadUser Test ==================");
		dao.roadUser();
		for(UserDto dto : dao.userVector) {
			System.out.println(dto);
		}
		
		
		System.out.println("================= roadGameData Test =================");
		dao.roadGameData();
		
//		System.out.println(dao.userData);
		
		Set key = dao.userData.keySet();
		Iterator it = key.iterator();
		
		while(it.hasNext()) {
			String id = (String)it.next();
			Vector<GameDataDto> vector = dao.userData.get(id);
			
			System.out.println(id+" data");
			for(GameDataDto dto : vector) {
				System.out.println(dto);
			}
		}
	}
}
