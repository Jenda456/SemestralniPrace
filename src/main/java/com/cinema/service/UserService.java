package com.cinema.service;


import com.cinema.entity.User;
import com.cinema.entity.UserDto;
import com.cinema.exceptions.EmailExistsException;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User registerNewUserAccount(UserDto userDto) throws EmailExistsException;

    public User findById(int theId);

    public void save(User theEmployee);

    public void deleteById(int theId);
}
