package com.example.demospring.dao;

import com.example.demospring.dto.UsersDTO;

import java.util.List;

public interface UsersDAO {
    UsersDTO getUserById(Long id);
    void addUser(UsersDTO usersDTO);
    void updateUser(Long id, UsersDTO usersDTO);
    void deleteUser(Long id);

    List<UsersDTO> findAll();
}