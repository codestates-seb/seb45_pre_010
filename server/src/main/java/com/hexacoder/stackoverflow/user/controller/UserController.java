package com.hexacoder.stackoverflow.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Positive;

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

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto.Response postUser(@Valid @RequestBody UserDto.Post requestDto) throws Exception {
        UserEntity user = mapper.postDtoToEntity(requestDto);
        UserEntity createdUser = userService.createUser(user);
        return mapper.userToUserResponseDto(createdUser);
    }


    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto.Response getUser(@PathVariable("userId") long userId) {
        UserEntity user = userService.findUser(userId);
        return mapper.userToUserResponseDto(user);
    }

    @PatchMapping("/update/{userId}")
    public ResponseEntity patchMember(@PathVariable("userId") @Positive long userId,
                                      @Valid @RequestBody UserDto.Patch userPatchDto) {
        userPatchDto.setUserId(userId);
        UserEntity user = mapper.userPatchDtoToUser(userPatchDto);
        UserEntity updatedUser = userService.updateUser(user);

        return new ResponseEntity<>(mapper.userToUserResponseDto(updatedUser), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") @Positive long memberId) {
        userService.removeUser(memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
