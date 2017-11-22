package com.supermarket;

import com.supermarket.beans.DataStore;
import com.supermarket.beans.Item;

public class CheckoutTotalApp {

	private DataStore ds;
	private Basket basket;
	private Item itemA;
	private Item itemB;
	private Item itemC;
	private Item itemD;
	private Item itemE;
	private Item itemF;
	private Item itemG;

	public static void main(String[] args) {
		CheckoutTotalApp scanner = new CheckoutTotalApp();
		scanner.init();
		scanner.initDataStore();
		scanner.scanItems();
		scanner.displayTotalBill();
	}

	public void init() {
		ds = new DataStore();
		basket = new Basket();
	}

	public void addItemsToBasket(long barCode) {
		basket.addItem(ds.getItem(barCode));
	}

	public void addItemsToBasket(Item item) {
		basket.addItem(item);
	}

	public double getTotalPrice() {
		return basket.getTotalPrice();
	}

	// Add initial item details
	public void addItemDetails(Item item) {
		ds.addItem(item);
	}

	// Dummy data
	private void initDataStore() {
		itemA = new Item(1001, 20.99, "Apple", true, 50.00, 3);
		itemB = new Item(1002, 40.15, "FaceWash", false, 0.00, 0);
		itemC = new Item(1003, 10.50, "Eggs", false, 0, 0);
		itemD = new Item(1004, 30.43, "Pasta", true, 40, 2);
		itemE = new Item(1005, 50.10, "Sauce", false, 0, 0);
		itemF = new Item(1006, 60.89, "Toothbrush", false, 0, 0);
		itemG = new Item(1007, 70.56, "Detergent", false, 0, 0);
		
		ds.addItem(itemA);	
		ds.addItem(itemB);
		ds.addItem(itemC);
		ds.addItem(itemD);		
		ds.addItem(itemE);
		ds.addItem(itemF);
		ds.addItem(itemG);
	}

	private void scanItems() {
		this.addItemsToBasket(ds.getItem(1001));
		this.addItemsToBasket(ds.getItem(1001));
		this.addItemsToBasket(ds.getItem(1001));
		this.addItemsToBasket(ds.getItem(1001));
		this.addItemsToBasket(ds.getItem(1002));
		this.addItemsToBasket(ds.getItem(1003));
		this.addItemsToBasket(ds.getItem(1004));
		this.addItemsToBasket(ds.getItem(1004));
		this.addItemsToBasket(ds.getItem(1004));
		this.addItemsToBasket(ds.getItem(1005));
		this.addItemsToBasket(ds.getItem(1006));
		this.addItemsToBasket(ds.getItem(1007));
	}
	
	private void displayTotalBill() {
		System.out.println(itemA.getName()+":"+basket.getSubtotalItemPrice(itemA.getName()));
		System.out.println(itemB.getName()+":"+basket.getSubtotalItemPrice(itemB.getName()));
		System.out.println(itemC.getName()+":"+basket.getSubtotalItemPrice(itemC.getName()));
		System.out.println(itemD.getName()+":"+basket.getSubtotalItemPrice(itemD.getName()));
		System.out.println(itemE.getName()+":"+basket.getSubtotalItemPrice(itemE.getName()));
		System.out.println(itemF.getName()+":"+basket.getSubtotalItemPrice(itemF.getName()));
		System.out.println(itemG.getName()+":"+basket.getSubtotalItemPrice(itemG.getName()));
		System.out.println("Total Price:" + this.getTotalPrice());
	}
}
