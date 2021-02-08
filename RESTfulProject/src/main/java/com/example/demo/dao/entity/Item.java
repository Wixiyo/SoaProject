package com.example.demo.dao.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class Item {
    private int Barcode;
    private double Prize;
    private int Stock;
}
