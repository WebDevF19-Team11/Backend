package com.wbdv.projectbackend.serives;

import com.wbdv.projectbackend.repository.TransactionRepository;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService extends BaseService<Transaction, Integer> {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public CrudRepository getRepository() {
        return transactionRepository;
    }
}