package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "Merchandise")
@Data
public class Merchandise extends BaseMerchandiseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "商品名不能为空")
    private String title;

    @Column(nullable = false, unique = true)
    @NotNull(message = "价格不能为空")
    private int cost;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private String code;
}
