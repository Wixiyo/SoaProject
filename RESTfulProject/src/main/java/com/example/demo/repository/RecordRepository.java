package com.example.demo.repository;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RecordRepository extends JpaRepository<Record,Long>, JpaSpecificationExecutor<Record > {
}
