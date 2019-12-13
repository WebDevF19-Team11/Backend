package com.wbdv.projectbackend.controller;

import com.wbdv.projectbackend.model.Transaction;
import com.wbdv.projectbackend.serives.BaseService;
import com.wbdv.projectbackend.serives.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("transaction")
public class TransactionController extends BaseController<Transaction, Integer> {

    @Autowired
    private TransactionService service;

    @Override
    public BaseService<Transaction, Integer> getService() {
        return service;
    }


}