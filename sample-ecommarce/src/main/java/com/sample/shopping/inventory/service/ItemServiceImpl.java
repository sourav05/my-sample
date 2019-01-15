package com.sample.shopping.inventory.service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.shopping.inventory.item.Item;
import com.sample.shopping.inventory.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public List<Item> fetchAllItem(){
		Iterable<Item> itemItr = itemRepository.findAll();
		List<Item> items = new LinkedList<Item>();
		itemItr.forEach(e -> {
			items.add(e);
		});
		Stream<Item> sortedItemList = items.stream().sorted(new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				if(o1.getItemPrice().getValue() > o2.getItemPrice().getValue())
					return 1;
				else if(o1.getItemPrice().getValue() < o2.getItemPrice().getValue())
					return -1;
				else
					return 0;
			}
		});
		return sortedItemList.collect(Collectors.toList());
	}

	@Override
	public Item fetchItem(long id){
		return itemRepository.findById(id).orElse(new Item());
	}

	@Override
	public Item addItem(Item item){
		item = itemRepository.save(item);
		return item;
	}
	
	@Override
	public boolean deleteItem(long id){
		if(id == 0)
			return false;
		itemRepository.deleteById(id);
		return true;
	}
	
	@Override
	public Item updateItem(Item item){
		boolean exists = itemRepository.existsById(item.getId());
		if(exists)
			return itemRepository.save(item);
		else
			return new Item();
	}
}
