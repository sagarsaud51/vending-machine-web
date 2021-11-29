package io.saud.vendingmachine.service;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface AdminService {

    ResponseEntity<Object> getAllTransactionReport(Pageable pageable);
}
