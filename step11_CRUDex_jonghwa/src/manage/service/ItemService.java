package manage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import manage.exception.DuplicateException;
import manage.exception.NotExistException;
import manage.model.ItemDB;
import manage.model.dto.Item;
import manage.model.dto.NoIdItem;
import manage.view.EndView;
import manage.view.FailView;

public class ItemService {
	
	private static ItemService instance = new ItemService();
	
	private ItemDB itemData = ItemDB.getInstance();
	
	private ItemService() {}
	
	public static ItemService getInstance() {
		return instance;
	}
	
	//전체 검색
	public ArrayList<Item> getItemList() {
		return itemData.getItemList();
	}
	
	//이름 검색
	//@ParameterizedTest
	//@ValueSource(strings = {"장롱", ".."})
	public List<Item> getItem(String productName) {
		ArrayList<Item> productList = itemData.getItemList();
		
		return productList.stream().filter(i -> i.getProduct().equals(productName))
				.map(i -> new Item(i.getProduct(), i.getSeller(), i.getPrice(), i.getStock(), i.getIndate(), i.getId()))
				.collect(Collectors.toList());
		/*for (Item product : productList) {
			if (product.getProduct().equals(productName)) {
				return product;
			}
		}
		return null; */
	}
	
	//고유번호 검색
		public Item getItemNo(int idNo) {
			ArrayList<Item> productList = itemData.getItemList();
			
			for (Item product : productList) {
				if (product.getId() == idNo) {
					return product;
				}
			}
			return null;
		}
	
	//판매자 제품 검색
	public ArrayList<Item> getSeItemList(String Seller) throws NotExistException{
		ArrayList<Item> productList = itemData.getItemList();
		ArrayList<Item> list1 = new ArrayList<>();
		if (productList == null) {
			throw new NotExistException("저장된 물품이 없습니다.");
		}else {
			for (Item product : productList) {
				if(product.getSeller().equals(Seller)) {
					list1.add(product);
				}
			}
			if(list1.size() == 0) {
				throw new NotExistException("판매자와 일치하는 제품이 없습니다.");
			}
		return list1;
		}
	}
	//상품 개수 감소 
	public void consume(int id, int count) throws NotExistException {
		Item product = getItemNo(id);
		if (product == null) {
			throw new NotExistException("제품번호와 일치하는 정보가 없습니다.");
		}
		
		int t;
		t = product.getStock();
		
		if (count < 0) {
			FailView.failMessageView("잘못된 수량입니다");
		} else if (count > t) {
			FailView.failMessageView("수량이 부족합니다");
		} else {
			t -= count;
			product.setStock(t);
			EndView.messageView(count + "개 구매");
		}
	}
	
	
	//상품 1개 추가
	public void insertItem(NoIdItem newItem){
		Item item = new Item(newItem, ++ItemDB.count);
		itemData.insertItem(item);
	}
	
	//상품 리스트 추가
	public void insertList(String newList) {
		itemData.insertItemList(newList);
	}
	
	//상품 삭제
	public void itemDelete(int idNo) throws NotExistException{
		Item product = getItemNo(idNo);
		if (product == null) {
			throw new NotExistException("입력하신 번호의 제품이 존재하지 않습니다.");
		} else {
			getItemList().remove(product);
		}
	}

	
	
	
	
}
