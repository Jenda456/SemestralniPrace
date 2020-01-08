package com.cinema.service;


import com.cinema.entity.User;
import com.cinema.entity.UserDto;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User registerNewAccount(UserDto userDto);

    public User findById(int theId);

    public void save(User theEmployee);

    public void deleteById(int theId);
}
