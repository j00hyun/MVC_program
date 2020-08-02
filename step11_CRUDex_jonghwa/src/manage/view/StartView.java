//@version 1.1
/*
 * PROJECT  : 재고 정리 프로젝트
 * NAME  : StartView.java
 * DESC  : 사용자 입력 클래스
 * 
 * @author  
*/

package manage.view;

import manage.controller.ItemController;
import manage.model.dto.NoIdItem;

public class StartView {
	
	
	public static void main(String[] args) {
		ItemController controller = ItemController.getInstance();
		
		System.out.println("\n*** 01. Data 파일 불러오기 전 존재하지 않는 제품 삭제 요청 ***");
		controller.deleteItem(33); 
		System.out.println("\n*** 01-1. Data 파일 불러오기 전 고유번호를 음성으로 삭제 요청 ***");
		controller.deleteItem(-5); 
		
		
		System.out.println("\n*** 02. Data 파일 불러오기 전 존재하지 않는 제품 재고 수정 요청 ***");
		controller.consumeItem(30, 20); //제품번호와 일치하는 정보가 없습니다.
		System.out.println("\n*** 02-1. Data 파일 불러오기 전 고유번호 0번 제품 재고 수정 요청 ***");
		controller.consumeItem(0, 20); //입력하신 제품명이 올바르지 않습니다.
		
		
		System.out.println("\n*** 03. null값의 파일 불러오기 시도 ***");
		controller.insertItemList(null); //저장하려는 재고정보가 올바르지 않습니다.
		System.out.println("\n*** 03-1. 존재하지 않는 Data 파일 불러오기 ***");
		controller.insertItemList("qqq.csv");
		System.out.println("\n*** 03-2. 올바른 Data 파일 불러오기 ***");
		controller.insertItemList("data.csv");
		
		
		System.out.println("\n*** 04. 제품명 null값으로 제품 검색하기 ***");
		controller.getItem(null);
		System.out.println("\n*** 04-1. 존재하지 않는 제품명으로 제품 검색 ***");
		controller.getItem("sss");
		System.out.println("\n*** 04-2. 올바른 제품명으로 제품 검색 ***");
		controller.getItem("침대");
		
		
		System.out.println("\n*** 05. 전체 정보 불러오기 ***");
		controller.getItemList();
		
		
		System.out.println("\n*** 06. 판매자명 null값으로 제품 검색하기 ***");
		controller.getSeItemList(null);
		System.out.println("\n*** 06-1. 존재하지 않는 판매자명으로 제품 검색하기 ***");
		controller.getSeItemList("sss");
		System.out.println("\n*** 06-2. 올바른 판매자명으로 제품 검색하기 ***");
		controller.getSeItemList("박아무개");
		 
		
		System.out.println("\n*** 07. null값의 제품 재고 정보 입력하기 ***");
		controller.insertItem(null);
		System.out.println("\n*** 07-1. 새로운 제품 정보 입력하기 ***");
		controller.insertItem(new NoIdItem("dd", "dd", 3333, 22, "ddd"));
		System.out.println("\n*** 07-2. 중복되는 제품 정보 입력하기 ***");
		controller.insertItem(new NoIdItem("dd", "dd", 3333, 22, "ddd"));
		controller.getItemList();
		
		
		System.out.println("\n*** 08. 고유번호로 제품 정보 삭제하기 ***");
		controller.deleteItem(72);
		controller.getItem("dd");
		System.out.println("\n");
		
		
		System.out.println("\n*** 김아무개의 장롱 재고 수정하기 ***");
		controller.getItem("장롱");
		System.out.println("\n*** 09. 음수의 수량만큼 제품 재고 판메 요청 ***");
		controller.consumeItem(1, -5); //잘못된 수량입니다.
		System.out.println("\n*** 09-1. 현재 수량보다 더 큰 수량만큼 재고 판메 요청 ***");
		controller.consumeItem(1, 50); //수량이 부족합니다. 
		System.out.println("\n*** 09-2. 올바른 수량만큼 재고 판메 요청 ***");
		controller.consumeItem(1, 3); 
		controller.getItem("장롱");
	}

}