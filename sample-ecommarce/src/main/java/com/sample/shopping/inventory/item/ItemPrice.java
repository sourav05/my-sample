package com.sample.shopping.inventory.item;

import java.util.Currency;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemPrice {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column
	private long value;
	
	@Column
	private String currency;
	
	@Column
	private String symbol;
	
	public ItemPrice(){
		Currency curr = Currency.getInstance(Locale.US);
		this.currency = curr.getCurrencyCode();
		this.symbol = curr.getSymbol();
	}
	
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
