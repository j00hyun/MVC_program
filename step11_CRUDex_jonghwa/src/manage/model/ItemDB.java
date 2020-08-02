//@version 1.0
/*
 * PROJECT  : 재고 정리 프로젝트
 * NAME  : ItemDB.java
 * DESC  : 재고 DB 클래스
 * 
 * @author  
*/

package manage.model;

import java.util.ArrayList;

import manage.model.dto.Item;
import manage.reader.DataInput;

public class ItemDB {
	public static int count = 0;
	
	private static ItemDB instance = new ItemDB();
	private ArrayList<Item> itemList = new ArrayList<Item>(); 
	
	public static ItemDB getInstance() {
		return instance;
	}
	
	public ArrayList<Item> getItemList() {
		return itemList;
	}
	
	public void insertItem(Item newItem) {
		itemList.add(newItem);
	}
	
	public void insertItemList(String newitemList) {
		DataInput di = new DataInput();
		itemList.addAll(di.Readfile(newitemList));
	}
}
