package io.saud.vendingmachine.service.impl;

import io.saud.vendingmachine.repo.TransactionRepo;
import io.saud.vendingmachine.service.AdminService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private final TransactionRepo transactionRepo;

    public AdminServiceImpl(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @Override
    public ResponseEntity<Object> getAllTransactionReport(Pageable pageable) {
        var transactions = transactionRepo.findAll(pageable);
        return ResponseEntity.ok(transactions);
    }
}
