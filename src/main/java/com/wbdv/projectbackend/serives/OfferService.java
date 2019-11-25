package com.wbdv.projectbackend.serives;

import com.google.common.collect.Streams;
import com.wbdv.projectbackend.model.Offer;
import com.wbdv.projectbackend.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferService extends BaseService<Offer, Integer> {

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public CrudRepository getRepository() {
        return offerRepository;
    }


    public List<Offer> getByFulltext(String searchText) {
        return Streams.stream(offerRepository.findAll())
                .filter(offer ->
                        (offer.getItem().getDescription().contains(searchText)
                                || offer.getItem().getTitle().contains(searchText)))
                .collect(Collectors.toList());

    }
}