package logic;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> orderItemList;
	private static int totalOrderCount = 0;
	private int orderNumber;
	
	public Order() {
		orderItemList = new ArrayList<OrderItem>();
		orderNumber = totalOrderCount;
		totalOrderCount++;
	}

	public OrderItem addItem(Item item, int amount) {
		for (OrderItem o : orderItemList) {
			if (o.getItem() == item) {
				o.increaseItemAmount(amount);
				return o;
			}
		}
		
		OrderItem newOrderItem = new OrderItem(item, amount);
		orderItemList.add(newOrderItem);
		return newOrderItem;
		
		// TODO
		// Loop the orderItemList to find if item of any orderItem equals to the given item
		// if there is orderItem with given item, increase that orderItem itemAmount with amount
		// and return that orderItem

		// else create new orderItem with given item and amount, then return the new orderItem
	}

	public int calculateOrderTotalPrice() {
		int sum = 0;
		for (OrderItem o : orderItemList) {
			sum += o.calculateTotalPrice();
		}
		return sum;
		// TODO
		// Calculate total price of the order by summing total price of each orderItem in orderItemList
		
	}

	public static int getTotalOrderCount() {
		return totalOrderCount;
	}
	
	public static void resetTotalOrderCount() {
		totalOrderCount = 0;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	
	
}
