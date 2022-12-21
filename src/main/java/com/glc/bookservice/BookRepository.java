package com.glc.bookservice;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository implements IBookRepository<Book>{
    private Map<Integer, Book> repository;

    public BookRepository() {
        this.repository = new HashMap<>();
    }

    @Override
    public void save(Book book){
        repository.put(book.getId(), book);
    }

    @Override
    public Collection<Book> getAllBooks(){
        return repository.values();
    }

    @Override
    public Book getBook(int id){
        return repository.get(id);
    }

    @Override
    public void deleteBook(int id){
        repository.remove(id);
    }

    @Override
    public Book updateBook(int id, Book book){
        repository.replace(id, book);
        return repository.get(id);
    }

   
    
}
