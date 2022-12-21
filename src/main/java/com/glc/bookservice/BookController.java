package com.glc.bookservice;

import java.util.Collection;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")  // Any address like https://localhost:8080/books
public class BookController {
    private final BookRepository repository;

    public BookController(BookRepository repository){
        this.repository = repository;
    }

    @PostMapping("")  // (POST) https://localhost:8080/books
    public void createBook(@RequestBody Book book) {
        this.repository.save(book);
    }

    @GetMapping("/all") // (GET) https://localhost:8080/books/all
    public Collection<Book> getAllBooks(){
        return this.repository.getAllBooks();
    }
    @GetMapping("/{id}") // (GET) https://localhost:8080/books/{id}
    public Book getBook(@PathVariable int id){
        return this.repository.getBook(id);
    }
    
    @DeleteMapping("/{id}") // (DELETE) https://localhost:8080/books/{id}
    public void deleteBook(@PathVariable int id){
        this.repository.deleteBook(id);        
    }

    @PutMapping("/{id}") // (PUT) https://localhost:8080/books/{id}
    public Book updateBook(@PathVariable int id, @RequestBody Book book){
        return this.repository.updateBook(id, book);
    }


}
