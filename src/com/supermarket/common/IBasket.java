package com.supermarket.common;

import com.supermarket.beans.Item;

public interface IBasket {

	void addItem(Item item);

	double getTotalPrice();

	double getSubtotalItemPrice(String itemName);

}
