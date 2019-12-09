package com.wbdv.projectbackend.serives;

import com.google.common.collect.Streams;
import com.wbdv.projectbackend.model.Category;
import com.wbdv.projectbackend.model.Offer;
import com.wbdv.projectbackend.repository.CategoryRepository;
import com.wbdv.projectbackend.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService extends BaseService<Category, Integer> {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private OfferRepository offerRepository;

    @Override
    public CrudRepository getRepository() {
        return categoryRepository;
    }

    public List<Offer> getOffersForCategory(Integer categoryId) {
        return Streams.stream(offerRepository.findAll())
                .filter(offer -> offer.getItem().getCategoryList().stream()
                        .map(Category::getCategoryId)
                        .anyMatch(integer -> integer.equals(categoryId)))
                .collect(Collectors.toList());
    }
}