package com.wbdv.projectbackend.serives;

import com.wbdv.projectbackend.model.Item;
import com.wbdv.projectbackend.repository.ItemRepository;
import com.wbdv.projectbackend.repository.TransactionRepository;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends BaseService<Item, Integer> {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public CrudRepository getRepository() {
        return itemRepository;
    }
}