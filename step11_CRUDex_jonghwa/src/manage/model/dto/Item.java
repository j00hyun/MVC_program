package manage.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Item {
	private String product;
	private String seller;
	private int price;
	private int stock;
	private String indate;
	private int id;
	
	public Item(NoIdItem item, int id) {
		product = item.getProduct();
		seller = item.getSeller();
		stock = item.getStock();
		price = item.getPrice();
		indate = item.getIndate();
		this.id = id;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[상품명]");
		builder.append(product);
		builder.append(", [판매자]");
		builder.append(seller);
		builder.append(", [가격]");
		builder.append(price);
		builder.append(", [수량]");
		builder.append(stock);
		builder.append(", [등록일]");
		builder.append(indate);
		builder.append(", [고유번호]");
		builder.append(id);
		return builder.toString();
	}
}
