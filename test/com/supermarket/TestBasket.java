package com.supermarket;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.supermarket.beans.Item;

public class TestBasket {

	private Basket basket;
	private Item itemA;
	private Item itemB;
	private Item itemC;
	private Item itemD;
	private Item itemE;
	private Item itemF;
	private Item itemG;

	@Before
	public void setUp() {
		basket = new Basket();
		itemA = new Item(1001, 20.99, "Apple", true, 50.00, 3);
		itemB = new Item(1002, 40.15, "FaceWash", false, 0.00, 0);
		itemC = new Item(1003, 10.50, "Eggs", false, 0, 0);
		itemD = new Item(1004, 30.43, "Pasta", true, 40, 2);
		itemE = new Item(1005, 50.10, "Sauce", false, 0, 0);
		itemF = new Item(1006, 60.89, "Toothbrush", false, 0, 0);
		itemG = new Item(1007, 70.56, "Detergent", false, 0, 0);
	}
	
	@Test
	public void testTotalPrice() {
		basket.addItem(itemA);	
		basket.addItem(itemB);
		basket.addItem(itemC);
		basket.addItem(itemD);		
		basket.addItem(itemE);
		basket.addItem(itemF);
		basket.addItem(itemG);
		
		double totalPrice = itemA.getPrice() + itemB.getPrice() + itemC.getPrice() + itemD.getPrice() + itemE.getPrice() + itemF.getPrice() + itemG.getPrice();
		
		Assert.assertEquals(totalPrice, basket.getTotalPrice(), 0.0); 
	}
	
	@Test
	public void testTotalPrice_with_onOfferItem() {
		basket.addItem(itemA);		//itemA is on offer and 3 is for 50.00
		basket.addItem(itemA);
		basket.addItem(itemA);
		basket.addItem(itemB);		//itemB cost 40.15  
		Assert.assertEquals(itemA.getSplPrice() + itemB.getPrice() /*total price 40.15+50 = 90.15*/, basket.getTotalPrice(), 0.0); 
	}

	@Test
	public void subTotalPriceByItem() {
		basket.addItem(itemA);	
		basket.addItem(itemA);
		basket.addItem(itemA);
		basket.addItem(itemA);
		
		basket.addItem(itemB);
		basket.addItem(itemB);
		
		basket.addItem(itemC);
		basket.addItem(itemC);
		basket.addItem(itemC);
		basket.addItem(itemC);
		
		basket.addItem(itemD);		
		basket.addItem(itemE);
		
		
		double subTotalPriceItemA = itemA.getPrice() + itemA.getSplPrice(); //Offer quantity is 3, e.i, 50.00+20.99
		double subTotalPriceItemB = itemB.getPrice()*2;
		double subTotalPriceItemC = itemC.getPrice()*4;
		double subTotalPriceItemD = itemD.getPrice();
		double subTotalPriceItemE = itemE.getPrice();
		
		Assert.assertEquals(subTotalPriceItemA, basket.getSubtotalItemPrice(itemA.getName()), 0.0); 
		Assert.assertEquals(subTotalPriceItemB, basket.getSubtotalItemPrice(itemB.getName()), 0.0); 
		Assert.assertEquals(subTotalPriceItemC, basket.getSubtotalItemPrice(itemC.getName()), 0.0); 
		Assert.assertEquals(subTotalPriceItemD, basket.getSubtotalItemPrice(itemD.getName()), 0.0); 
		Assert.assertEquals(subTotalPriceItemE, basket.getSubtotalItemPrice(itemE.getName()), 0.0); 
	}
	
}
