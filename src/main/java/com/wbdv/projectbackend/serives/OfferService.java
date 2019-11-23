package com.wbdv.projectbackend.serives;

import com.wbdv.projectbackend.model.Offer;
import com.wbdv.projectbackend.repository.OfferRepository;
import com.wbdv.projectbackend.repository.TransactionRepository;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class OfferService extends BaseService<Offer, Integer> {

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public CrudRepository getRepository() {
        return offerRepository;
    }
}