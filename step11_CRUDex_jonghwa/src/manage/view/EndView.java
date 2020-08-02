//@version 1.1
/*
 * PROJECT  : 재고 정리 프로젝트
 * NAME  : EndView.java
 * DESC  : 재고 정리 정보 출력 클래스
 * 
 * @author  
*/

package manage.view;

import java.util.ArrayList;
import java.util.List;

import manage.model.dto.Item;

public class EndView {

	// 진행중인 특정 프로젝트 출력
	public static void ItemView(Item item) {
			System.out.println(item);
			//////////////////////수정 - 경우 삭제 
	}

	public static void ItemView(List<Item> productList) {
		productList.forEach(System.out::println);
		//System.out.println(productList);
		
	}
	
	// 진행중인 모든 프로젝트 출력
	public static void itemListView(ArrayList<Item> allProbonoProject) {
		for (Item item : allProbonoProject) {
			System.out.println(item);
		}
	}

	// 예외가 아닌 단순 메세지 출력
	public static void messageView(String message) {
		System.out.println(message);
	}


}