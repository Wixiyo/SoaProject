package com.example.demo.service.undone.repository;

import com.example.demo.service.undone.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RecordRepository extends JpaRepository<Record,Long>, JpaSpecificationExecutor<Record > {
}
