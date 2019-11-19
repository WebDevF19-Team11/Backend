package com.wbdv.projectbackend.repository;

import com.wbdv.projectbackend.model.Offer;
import com.wbdv.projectbackend.model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
}
