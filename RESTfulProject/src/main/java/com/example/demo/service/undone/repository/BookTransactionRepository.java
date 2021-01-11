package com.example.demo.service.undone.repository;

import com.example.demo.service.undone.entity.BookTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookTransactionRepository extends JpaRepository<BookTransaction,Long>, JpaSpecificationExecutor<BookTransaction > {
}
