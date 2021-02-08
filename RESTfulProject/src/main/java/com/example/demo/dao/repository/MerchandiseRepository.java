package com.example.demo.dao.repository;


import com.example.demo.dao.entity.Merchandise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MerchandiseRepository extends JpaRepository<Merchandise,Long>, JpaSpecificationExecutor<Merchandise > {
    Merchandise findById(long id);

    @Query("from Merchandise where title=?1")
    List<Merchandise> findByTitle(String title);

}
