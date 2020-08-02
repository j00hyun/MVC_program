package manage.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import manage.exception.NotExistException;
import manage.model.ItemDB;
import manage.model.dto.Item;
import manage.view.EndView;
import manage.view.FailView;

public class DataInput {
	
	public ArrayList<Item> Readfile(String newitemList){
		BufferedReader in = null;
		String data = null;
		String[] a = new String[6];
		ArrayList<Item> im = new ArrayList<>();
		
		try {
			in = new BufferedReader(new FileReader(newitemList));
			while((data=in.readLine()) != null) {
				a = data.split(",");
				im.add(new Item(a[0], a[1], Integer.parseInt(a[2]), Integer.parseInt(a[3]), a[4], ++ItemDB.count));
			}
		} catch (FileNotFoundException e) {
			FailView.failMessageView("검색한 파일이 존재하지 않습니다.");
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) {
					EndView.messageView(" 저장 성공");
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return im;
	}

}
