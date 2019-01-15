package com.sample.shopping.inventory.service;

import java.util.List;

import com.sample.shopping.inventory.item.Item;

public interface ItemService {
	
	public List<Item> fetchAllItem();

	public Item fetchItem(long id);
	
	public Item addItem(Item item);
	
	public boolean deleteItem(long id);
	
	public Item updateItem(Item item);
}
