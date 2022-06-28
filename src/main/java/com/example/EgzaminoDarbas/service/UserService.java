package com.example.EgzaminoDarbas.service;

import com.example.EgzaminoDarbas.entity.User;

public interface UserService {

    User findUserFromDB(String username, String password);
}
