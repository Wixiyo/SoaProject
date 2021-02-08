package com.example.demo.dao.repository;

import com.example.demo.dao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long>, JpaSpecificationExecutor<Book > {
    @Query("from Book where title=?1")
    List<Book> findByTitle(String title);

    @Query("from Book where bookId=?1")
    Book findById(long id);

    @Modifying
    @Query("UPDATE Book SET stock=stock-1 WHERE bookId=?1")
    void updateStock(long bookId);
}
