package com.example.demo.repository;

import com.example.demo.entity.Book;
import com.example.demo.entity.Merchandise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long>, JpaSpecificationExecutor<Book > {
    @Query("from Book where title=?1")
    List<Book> findByTitle(String title);

    @Query("from Book where bookId=?1")
    Book findById(long id);
}
