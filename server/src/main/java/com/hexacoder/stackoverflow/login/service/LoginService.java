package com.hexacoder.stackoverflow.login.service;


import com.hexacoder.stackoverflow.user.entity.UserEntity;
import com.hexacoder.stackoverflow.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {
    @Autowired
    private final UserService userService;

    public boolean login(UserEntity user) {

        UserEntity findUser = userService.findUser(user.getUserId());

        if(findUser == null){
            return false;

        }

        return findUser.getPassword().equals(user.getPassword());

    }
}
