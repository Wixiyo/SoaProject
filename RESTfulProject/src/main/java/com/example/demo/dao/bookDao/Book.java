package com.example.demo.dao.bookDao;

import com.example.demo.dao.Item;
import lombok.Data;

import javax.persistence.*;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: Artitcle
 * Author:   longzhonghua
 * Date:     3/24/2019 9:13 AM
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 备注姓名           修改时间           版本号              描述
 */

@Entity
@Table(name = "book")
@Data
public class Book extends Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;
    private String title;
    private String author;
    private String body;

}
