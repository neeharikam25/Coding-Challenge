package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.service.BookUserHandler;
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
public class BookUserController {
    private BookUserHandler BookUserService;

    @Autowired
    public BookUserController(BookUserHandler ds)
    {
        BookUserService = ds;
    }

    @GetMapping("/bookuser")
    public List<BookUser> getAllBookUser() {
        return BookUserService.getAllBookUser();
    }

    @GetMapping("/bookuser/{id}")
    public ResponseEntity< BookUser > getEmployeeById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        BookUser BookUser = BookUserService.getBookUserById(id);
        return ResponseEntity.ok().body(BookUser);
    }

    @GetMapping("/bookuser/books/{id}")
    public List<Integer> getBooksByUserId(@PathVariable(value = "id") int id)
            throws ResourceNotFoundException {
        List<Integer> BookUser = BookUserService.getBookIDUserById(id);
        return BookUser;
    }

    @PostMapping("/bookuser")
    public BookUser createBookUser(@Valid @RequestBody BookUser BookUser) {
        return BookUserService.addBookUser(BookUser);
    }

    @PutMapping("/bookuser/{id}")
    public ResponseEntity < BookUser > updateBookUser(@PathVariable(value = "id") Long id,
                                              @Valid @RequestBody BookUser BookUserDetails) throws ResourceNotFoundException {

        final BookUser updatedBookUser = BookUserService.updateBookUserDetails(BookUserDetails);
        return ResponseEntity.ok(updatedBookUser);
    }

    @DeleteMapping("/bookuser/{id}")
    public Map< String, Boolean > deleteBookUser(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        boolean removed = BookUserService.removeBookUser(id);

        Map < String, Boolean > response = new HashMap<>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }
}
