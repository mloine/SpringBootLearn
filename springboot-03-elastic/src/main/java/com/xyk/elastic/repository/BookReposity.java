package com.xyk.elastic.repository;

import com.xyk.elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookReposity extends ElasticsearchRepository<Book,Integer>{

    public List<Book> findByBookNameLike(String bookName);
}
