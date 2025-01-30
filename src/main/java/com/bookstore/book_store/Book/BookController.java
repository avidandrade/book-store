package com.bookstore.book_store.Book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("/books")
    public List<Book> createBooks(@Validated @RequestBody List<Book> books){
        return bookService.createBooks(books);
    }
    @PostMapping("/book")
    public Book createBook(@Validated @RequestBody Book book){
        return bookService.createBook(book);
    }
    
    @GetMapping("/books/{id}")
    public Optional<Book> getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }
    
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id){
         bookService.deleteBook(id);
    }

    @PatchMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book){
        return bookService.updateBook(id, book);
    }

    @GetMapping("/searchbooks")
    public String getBookFromAPI(@RequestParam String query){
        return bookService.fetchBooks(query);  
    }


}