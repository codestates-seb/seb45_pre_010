package com.hexacoder.stackoverflow.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import com.hexacoder.stackoverflow.user.dto.UserDto;
import com.hexacoder.stackoverflow.user.entity.UserEntity;
import com.hexacoder.stackoverflow.user.mapper.UserMapper;
import com.hexacoder.stackoverflow.user.service.UserService;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto.Response postUser(@Valid @RequestBody UserDto.Post requestDto) throws Exception {
        UserEntity user = mapper.postDtoToEntity(requestDto);
        UserEntity createdUser = userService.createUser(user);
        return mapper.userToUserResponseDto(createdUser);
    }

    @GetMapping("/{user-id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto.Response getUser(@PathVariable("user-id") Long userId) {
        UserEntity user = userService.findUser(userId);
        return mapper.userToUserResponseDto(user);
    }


}
