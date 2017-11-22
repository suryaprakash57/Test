package com.supermarket.beans;

public final class Item {

	private final long barCode;		//product number
	private double price;
	private String name;
	private boolean onOffer;
	private double splPrice;
	private int offerQuantity;
	
	public Item(long barCode, double price, String name, boolean onOffer, double splPrice, int offerQuantity) {
		super();
		this.barCode = barCode;
		this.price = price;
		this.name = name;
		this.onOffer = onOffer;
		this.splPrice = splPrice;
		this.offerQuantity = offerQuantity;
	}

	public long getBarCode() {
		return barCode;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public boolean isOnOffer() {
		return onOffer;
	}

	public double getSplPrice() {
		return splPrice;
	}

	public int getOfferQuantity() {
		return offerQuantity;
	}

	
	
}
