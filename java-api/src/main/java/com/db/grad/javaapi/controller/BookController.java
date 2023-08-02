package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.service.BookHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {
    private BookHandler BookService;

    @Autowired
    public BookController(BookHandler ds)
    {
        BookService = ds;
    }

    @GetMapping("/book")
    public List<Book> getAllBook() {
        return BookService.getAllBook();
    }

    @GetMapping("/book/{id}")
    public ResponseEntity< Book > getEmployeeById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Book Book = BookService.getBookById(id);
        return ResponseEntity.ok().body(Book);
    }

    @PostMapping("/book")
    public Book createBook(@Valid @RequestBody Book Book) {
        return BookService.addBook(Book);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity < Book > updateBook(@PathVariable(value = "id") Long id,
                                            @Valid @RequestBody Book BookDetails) throws ResourceNotFoundException {

        final Book updatedBook = BookService.updateBookDetails(BookDetails);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/book/{id}")
    public Map< String, Boolean > deleteBook(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        boolean removed = BookService.removeBook(id);

        Map < String, Boolean > response = new HashMap<>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }
}
