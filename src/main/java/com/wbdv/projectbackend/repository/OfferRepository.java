package com.wbdv.projectbackend.repository;

import com.wbdv.projectbackend.model.Item;
import com.wbdv.projectbackend.model.Offer;
import org.springframework.data.repository.CrudRepository;

public interface OfferRepository extends CrudRepository<Offer, Integer> {
}
