package com.example.demo.dao;


import com.example.demo.entity.Article;
import com.example.demo.entity.Merchandise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MerchandiseDao extends JpaRepository<Merchandise,Long>, JpaSpecificationExecutor<Merchandise > {
    Merchandise findById(long id);

    @Query("from Merchandise where title=?1")
    List<Merchandise> findByTitle(String title);

}
