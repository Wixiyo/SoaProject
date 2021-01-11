package com.example.demo.service.undone.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * @author longzhonghua
 * @data 2018/11/04 22:30
 */

/**
 * Description: ENTITY基类,让实体类去继承时间字段
 * 1.实体头加注解@EntityListeners(AuditingEntityListener.class)
 * 2.启动类加@EnableJpaAuditing
 * 3.
 * @CreatedDate
 * @Column(name = "createTime")
 * private Date createTime;
 * @LastModifiedDate
 * @Column(name = "updateTime")
 * private Date updateTime;
 * 数据库添加相应控制也可以CURRENT_TIMESTAMP ， CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class BaseMerchandiseEntity {
    /*    @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        protected Integer id;*/
/*
创建时间
*/
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime;

    /*    最后修改时间*/
    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String updateTime;

    /*
     * 商家
     */
    @Column(name = "merchant")
    @CreatedBy
    private Long merchant;

}