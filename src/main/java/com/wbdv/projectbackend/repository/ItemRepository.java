package com.wbdv.projectbackend.repository;

import com.wbdv.projectbackend.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {
    Item findOneByTitle(String title);
}
