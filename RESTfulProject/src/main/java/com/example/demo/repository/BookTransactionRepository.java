package com.example.demo.repository;

import com.example.demo.entity.BookTransaction;
import com.example.demo.entity.Merchandise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookTransactionRepository extends JpaRepository<BookTransaction,Long>, JpaSpecificationExecutor<BookTransaction > {
}
