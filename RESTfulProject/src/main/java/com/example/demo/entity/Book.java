package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: Artitcle
 * Author:   longzhonghua
 * Date:     3/24/2019 9:13 AM
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

@Entity
@Table(name = "book")
@Data
public class Book extends Item{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;
    private String title;
    private String author;
    private String body;

}
