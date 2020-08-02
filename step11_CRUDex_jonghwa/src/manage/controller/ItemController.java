package manage.controller;

import java.util.ArrayList;
import java.util.List;

import manage.exception.DuplicateException;
import manage.exception.NotExistException;
import manage.model.dto.Item;
import manage.model.dto.NoIdItem;
import manage.service.ItemService;
import manage.view.EndView;
import manage.view.FailView;

public class ItemController {
	
	private static ItemController instance = new ItemController();
	private ItemService service = ItemService.getInstance();
	
	private ItemController() {}
	
	public static ItemController getInstance() {
		return instance;
	}
	
	public void getItemList() {
		ArrayList<Item> itemList = service.getItemList();
		if(itemList.size() != 0) {
			EndView.itemListView(itemList);
		}else {
			FailView.failMessageView("저장된 물품이 없습니다.");
		}
	}
	
	public void getItem(String productName) {
		if (productName == null) {
			FailView.failMessageView("입력한 제품이름이 올바르지 않습니다.");
		}else {
			List<Item> productList = service.getItem(productName);
			if(!productList.isEmpty()) {
				EndView.ItemView(productList);
			}else {
				FailView.failMessageView("입력한 물품이 존재하지 않습니다.");
			}
		}
	}
	
	public void getSeItemList(String seller) {
		if (seller == null) {
			FailView.failMessageView("판매자이름이 올바르지 않습니다.");
		}else {
			try {
				ArrayList<Item> list = service.getSeItemList(seller);
				EndView.itemListView(list);
			}catch(NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}
		}
	}
	
	public void consumeItem(int id, int count) {
		if(id != 0) {
			try {
				service.consume(id, count);
			} catch(NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}
		}else {
			FailView.failMessageView("입력하신 제품번호가 올바르지 않습니다.");
		}
	}
	
	public void insertItem(NoIdItem newItem) {
		if(newItem != null) {
			service.insertItem(newItem);
			EndView.messageView(" 저장 성공");
		}else {
			FailView.failMessageView("입력한 제품정보가 올바르지 않습니다.");
		}
	}
	
	public void insertItemList(String newList) {
		if(newList != null) {
			EndView.messageView("시도중...");
			service.insertList(newList);
		}
		else {
			FailView.failMessageView("저장하려는 파일명이 올바르지 않습니다.");
		}
	}
	
	public void deleteItem(int idNo) {
		if (idNo > 0) {
			try {
				service.itemDelete(idNo);
				EndView.messageView(idNo + "번 삭제 성공");
			}catch(NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}
		}else {
			FailView.failMessageView("입력하신 고유번호가 올바르지 않습니다.");
		}
	}
	
	
}
