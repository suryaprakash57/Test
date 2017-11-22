package com.supermarket;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.supermarket.beans.Item;
import com.supermarket.common.IBasket;

import java.util.Set;

public class Basket implements IBasket{

	

	Map<String, ItemWisePriceHolder> basketMap = new HashMap<>();
	
	@Override
	public void addItem(Item item) {
		if(basketMap.containsKey(item.getName())) {
			ItemWisePriceHolder holder= basketMap.get(item.getName());
			holder.incrementItemCount();		
		}
		else {
			basketMap.put(item.getName(), new ItemWisePriceHolder(item));
		}
	}
	
	@Override
	public double getTotalPrice() {
		double totalPrice = 0.0;
		Set<Entry<String, ItemWisePriceHolder>> items = basketMap.entrySet();
		for(Entry<String, ItemWisePriceHolder> item : items) {
			totalPrice += item.getValue().getItemTotalPrice();
		}
		return (double) Math.round(totalPrice * 100) / 100;  //rounding it to 2 decimal places
	}
	
	@Override
	public double getSubtotalItemPrice(String itemName) {
		if(basketMap.containsKey(itemName)) {
		return basketMap.get(itemName).getItemTotalPrice();
		}
		return 0.0;
	}
	
	
	
	
	private class ItemWisePriceHolder {

		private int quantity = 0;
		private double totalPrice =0.0;
		private Item item;
		
		public ItemWisePriceHolder(Item item) {
			this.item = item;
			incrementItemCount();		//initial item increment
		}

		public void incrementItemCount() {
			quantity++;
			calculatePrice();
		}

		private void calculatePrice() {
			if( item.isOnOffer() && quantity >= item.getOfferQuantity()) {
				totalPrice = ((int)quantity/item.getOfferQuantity()) * item.getSplPrice() + ((quantity % item.getOfferQuantity())* item.getPrice());
			}
			else {
				totalPrice = quantity * item.getPrice();
			}
		}
		
		public double getItemTotalPrice() {
			return (double) Math.round(totalPrice * 100) / 100;  //rounding it to 2 decimal places
		}
		
	}
}
