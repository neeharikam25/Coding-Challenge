package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.UserHandler;
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
public class UserController {

    private UserHandler UserService;

    @Autowired
    public UserController(UserHandler ds)
    {
        UserService = ds;
    }

    @GetMapping("/user")
    public List<User> getAllUser() {
        return UserService.getAllUser();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity< User > getEmployeeById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        User User = UserService.gettheUserById(id);
        return ResponseEntity.ok().body(User);
    }

    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User User) {
        return UserService.addUser(User);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity < User > updateUser(@PathVariable(value = "id") Long id,
                                              @Valid @RequestBody User UserDetails) throws ResourceNotFoundException {

        final User updatedUser = UserService.updateUserDetails(UserDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/user/{id}")
    public Map< String, Boolean > deleteUser(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        boolean removed = UserService.removeUser(id);

        Map < String, Boolean > response = new HashMap<>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }
}
