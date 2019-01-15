package com.sample.shopping;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sample.shopping.inventory.item.Item;

public class ApplicationTest {

	public static void main(String[] args) {
		RestTemplate template = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());
		headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString());
		
		HttpEntity<Item> entity = new HttpEntity<Item>(headers);
		ResponseEntity<Item> response = template.exchange("http://127.0.01:8080/item/fetch/1", HttpMethod.GET, entity, Item.class);
		Item item = response.getBody();
		System.out.println(item.toString());
	}

}
