package org.test;

import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import org.model.GameDataDto;
import org.model.UserDao;
import org.model.UserDto;

public class DaoTest {
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		
		dao.roadUser();
		
		for(UserDto dto : dao.userVector) {
			System.out.println(dto);
		}
		
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
