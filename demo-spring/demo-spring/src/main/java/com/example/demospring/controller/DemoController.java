package com.example.demospring.controller;

import com.example.demospring.dto.UsersDTO;
import com.example.demospring.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class DemoController {

    private final UsersService usersService;

    @Autowired
    public DemoController(UsersService usersService) {
        this.usersService = usersService;
    }

    // 모든 사용자 목록 조회
    @GetMapping
    public String getAllUsers(Model model) {
        List<UsersDTO> users = usersService.getAllUsers();
        System.out.println("Users: " + users);
        model.addAttribute("users", users);

        return "user-list";
    }


    // 사용자 추가 폼 보기
    @GetMapping("/add")
    public String showAddUserForm(UsersDTO usersDTO, Model model) {
        model.addAttribute("usersDTO", new UsersDTO());
        return "add-user";
    }


    // 사용자 추가 처리
    @PostMapping("/add")
    public String addUser(UsersDTO usersDTO) {
        usersService.addUser(usersDTO);
        return "redirect:/users";
    }

    // 사용자 수정 폼 보기
    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable Long id, Model model) {
        UsersDTO usersDTO = usersService.getUserById(id);
        model.addAttribute("user", usersDTO);
        return "edit-user";
    }

    // 사용자 수정 처리
    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") UsersDTO usersDTO) {
        usersService.updateUser(usersDTO.getId(), usersDTO);
        return "redirect:/users";
    }

    // 사용자 삭제 처리
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
        return "redirect:/users";
    }
}
