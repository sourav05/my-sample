package com.sample.shopping.inventory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sample.shopping.inventory.item.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{

}
