package com.wbdv.projectbackend.repository;

import com.wbdv.projectbackend.model.Item;
import com.wbdv.projectbackend.model.Offer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfferRepository extends CrudRepository<Offer, Integer> {
    List<Offer> findAllBySellerUsername(String username);
}
