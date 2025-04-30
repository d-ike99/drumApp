package com.sample.api.controller;

import com.sample.api.model.User;
import com.sample.api.service.UserService;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Tag(name = "ユーザーAPI", description = "ユーザー情報の取得・登録・削除を行う")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
        
    }
    
    @GetMapping
    @Operation(summary = "全ユーザー取得", description = "登録されている全ユーザーのリストを取得する")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    @Operation(summary = "ユーザー登録", description = "新しいユーザーを登録する")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}