package com.example.firstrestapi.service;


import com.example.firstrestapi.exception.UserNotFoundException;
import com.example.firstrestapi.model.User;
import com.example.firstrestapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService
{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)
     {
        this.userRepository = userRepository;
    }

    public User save(User user)
      {
        return userRepository.save(user);
    }

    public List<User> findAll()
     {
        return  userRepository.findAll();
    }

    public User findById(Long id)
    {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }


    public User update(Long id, User updatedUser)
     {
         User user = findById(id);
        user.setName(updatedUser.getName());
         user.setEmail(updatedUser.getEmail());
        return userRepository.save(user);
    }


    public void delete(Long id)
     {
         User user = findById(id);
        userRepository.delete(user);
    }


}
