package com.sample.shopping.inventory.item;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.sample.shopping.inventory.category.Category;

@Entity
public class Item {
	
	@Id
	private long id;
	
	@Column
	private String itemName;
	
	@Column
	private String itemDescription;
	
	@OneToOne
	private ItemPrice itemPrice;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Category itemCategory;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public ItemPrice getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(ItemPrice itemPrice) {
		this.itemPrice = itemPrice;
	}
	public Category getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(Category itemCategory) {
		this.itemCategory = itemCategory;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String toString(){
		{
		return "ID : " + id + " :: " + "Name: " + itemName + " :: " 
					+ "Description : " + itemDescription + " :: " + "Category : " + itemCategory.getCategoryName();
		}
	}
}
