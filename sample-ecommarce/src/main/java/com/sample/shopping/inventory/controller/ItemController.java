package com.sample.shopping.inventory.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.shopping.inventory.item.Item;
import com.sample.shopping.inventory.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping(value="/fetch", produces=MediaType.APPLICATION_JSON)
	public List<Item> fetchAllItem(){
		return itemService.fetchAllItem();
	}

	@GetMapping(value="/fetch/{id}", produces=MediaType.APPLICATION_JSON)
	public Item fetchItem(@PathVariable(name="id") long id){
		return itemService.fetchItem(id);
	}
	
	@PostMapping(value="/add", consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
	public Item addItem(@RequestBody Item item){
		item = itemService.addItem(item);
		return item;
	}
	
	@DeleteMapping(value="/delete/{id}")
	public boolean deleteItem(@PathVariable(name="id") long id){
		boolean deleted = itemService.deleteItem(id);
		return deleted;
	}
	
	@PutMapping(value="/update", produces=MediaType.APPLICATION_JSON)
	public Item updateItem(@RequestBody Item item){
		return itemService.updateItem(item);
	}
}
