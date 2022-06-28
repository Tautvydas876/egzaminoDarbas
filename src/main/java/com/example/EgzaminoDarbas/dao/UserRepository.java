package com.example.EgzaminoDarbas.dao;

import com.example.EgzaminoDarbas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


    User findUserByUsernameAndPassword(String username, String password);
}
