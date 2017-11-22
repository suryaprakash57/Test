package com.supermarket.beans;

import java.util.HashMap;
import java.util.Map;

import com.supermarket.common.IDataStore;

public class DataStore implements IDataStore<Item>{

	private Map<Long, Item> itemsMap = new HashMap<>();
	
	@Override
	public void addItem(Item item) {
		itemsMap.put(item.getBarCode(), item);
	}
	
	@Override
	public void removeItem(Item item) {
		itemsMap.remove(item.getBarCode());
	}
	
	@Override
	public Item getItem(long barCode) {
		return itemsMap.get(barCode);
	}

	@Override
	public void removeItemByCode(long barCode) {
		itemsMap.remove(barCode);
	}
}
