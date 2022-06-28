package com.example.EgzaminoDarbas.service;


import com.example.EgzaminoDarbas.dao.UserRepository;
import com.example.EgzaminoDarbas.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User findUserFromDB(String username, String password) {
        return userRepository.findUserByUsernameAndPassword(username, password);
    }
}
