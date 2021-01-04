package com.example.demo.dao.repository;

import com.example.demo.dao.entity.BookTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookTransactionRepository extends JpaRepository<BookTransaction,Long>, JpaSpecificationExecutor<BookTransaction > {
}
