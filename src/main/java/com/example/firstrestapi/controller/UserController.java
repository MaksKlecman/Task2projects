package com.example.firstrestapi.controller;

import com.example.firstrestapi.model.User;
import com.example.firstrestapi.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{

    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user)
     {
        return userService.save(user);
    }

    @GetMapping
    public List<User> getUsers()
    {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id)
      {
        return userService.findById(id);
     }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user)
     {
        return userService.update(id, user);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id)
      {
         userService.delete(id);
    }


}
