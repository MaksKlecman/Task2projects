package com.example.firstrestapi.repository;


import com.example.firstrestapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository  extends JpaRepository<User, Long>
{
}
