package com.example.demospring.dao;

import com.example.demospring.dto.UsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDAOImpl implements UsersDAO {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersDAOImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UsersDTO getUserById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    public void addUser(UsersDTO usersDTO) {
        usersRepository.save(usersDTO);
    }

    @Override
    public void updateUser(Long id, UsersDTO usersDTO) {
        UsersDTO existingUser = usersRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(usersDTO.getUsername());
            existingUser.setEmail(usersDTO.getEmail());
            usersRepository.save(existingUser);
        }
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public List<UsersDTO> findAll() {
        return usersRepository.findAll();
    }
}
