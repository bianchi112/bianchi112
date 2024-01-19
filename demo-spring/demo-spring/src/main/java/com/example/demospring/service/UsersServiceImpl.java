package com.example.demospring.service;

import com.example.demospring.dao.UsersDAO;
import com.example.demospring.dto.UsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    private final UsersDAO usersDAO;

    @Autowired
    public UsersServiceImpl(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Override
    public List<UsersDTO> getAllUsers() {
        return usersDAO.findAll();
    }

    @Override
    public UsersDTO getUserById(Long id) {
        return usersDAO.getUserById(id);
    }

    @Override
    public void addUser(UsersDTO usersDTO) {
        usersDAO.addUser(usersDTO);
    }

    @Override
    public void updateUser(Long id, UsersDTO usersDTO) {
        usersDAO.updateUser(id, usersDTO);
    }

    @Override
    public void deleteUser(Long id) {
        usersDAO.deleteUser(id);
    }
}