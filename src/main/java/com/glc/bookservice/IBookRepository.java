package com.glc.bookservice;

import java.util.Collection;

public interface IBookRepository<T> {
    public void save(T t);

    public Collection<T> getAllBooks();

    public Book getBook(int id);

    public void deleteBook(int id);

    public Book updateBook(int id, T t);
}
