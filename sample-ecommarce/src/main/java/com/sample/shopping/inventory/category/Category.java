package com.sample.shopping.inventory.category;

import java.util.List;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sample.shopping.inventory.item.Item;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column
	private String categoryName;

	@Column
	private String categoryDescription;

	@OneToMany
	private List<Category> subcategory;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="itemCategory")
	private List<Item> items;
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public List<Category> getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(List<Category> subcategory) {
		this.subcategory = subcategory;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
}
