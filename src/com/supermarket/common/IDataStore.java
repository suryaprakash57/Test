package com.supermarket.common;

public interface IDataStore<T> {

	
	void addItem(T t);
	
	void removeItem(T t);
	
	void removeItemByCode(long barCode);
	
	T getItem(long barCode);
	
	
}
