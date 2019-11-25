package com.wbdv.projectbackend.serives;

import com.google.common.collect.Streams;
import com.wbdv.projectbackend.model.Item;
import com.wbdv.projectbackend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService extends BaseService<Item, Integer> {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public CrudRepository getRepository() {
        return itemRepository;
    }

    public List<Item> getByFulltext(String searchText) {
        return Streams.stream(itemRepository.findAll())
                .filter(item ->
                        (item.getDescription().contains(searchText)
                                || item.getTitle().contains(searchText)))
                .collect(Collectors.toList());

    }
}