package com.example.demospring.service;

import com.example.demospring.dto.UsersDTO;

import java.util.List;

public interface UsersService {
    List<UsersDTO> getAllUsers();
    UsersDTO getUserById(Long id);
    void addUser(UsersDTO usersDTO);
    void updateUser(Long id, UsersDTO usersDTO);
    void deleteUser(Long id);
}