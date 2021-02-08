package com.example.demo.dao.repository;

import com.example.demo.dao.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RecordRepository extends JpaRepository<Record,Long>, JpaSpecificationExecutor<Record > {
}
