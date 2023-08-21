package com.hexacoder.stackoverflow.user.service;

import com.hexacoder.stackoverflow.exception.BusinessLogicException;
import com.hexacoder.stackoverflow.exception.ExceptionCode;
import com.hexacoder.stackoverflow.user.entity.UserEntity;
import com.hexacoder.stackoverflow.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserEntity user) throws Exception {

        //검증
        verifyExistsEmail(user.getEmail());
        verifyExistsNickname(user.getNickname());
        user.setCreatedAt(LocalDateTime.now());

        // 등록
        return userRepository.save(user);
    }

    /*
      <회원 정보 수정>
      회원 정보는 닉네임, 비밀번호만 변경 가능
      1. 회원 검증(존재O or 존재X)
      2. 수정
     */
    public UserEntity updateUser(UserEntity user) {

        UserEntity findUser = findUser(user.getUserId());

        if (!Objects.equals(user.getUserId(), findUser.getUserId())) {
            throw new BusinessLogicException(ExceptionCode.USER_NOT_FOUND);
        }

        verifyExistsNickname(user.getNickname());

        Optional.ofNullable(user.getNickname())
                .ifPresent(nickname -> findUser.setNickname(nickname));
        Optional.ofNullable(user.getPassword())
                .ifPresent(password -> findUser.setPassword(password));

        System.out.println("nickname : " + findUser.getNickname());

        return userRepository.save(findUser);

    }

    public UserEntity findUser(long userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));
    }

    public UserEntity findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));
    }


    /*
    <회원 정보 삭제>
    1. 회원 검증(존재O or 존재X)
    2. 삭제
     */
    public void removeUser(long userId) {
        UserEntity findUser = findUser(userId);
        userRepository.delete(findUser);
    }

    private void verifyExistsEmail(String email) throws Exception {
        Optional<UserEntity> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.EMAIL_EXISTS);
        }
    }

    private void checkEmail(String email) {
        Optional<UserEntity> optionalUser = userRepository.findByEmail(email);
        if (!optionalUser.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.USER_NOT_FOUND);
        }
    }
    // 중복 닉네임
    private void verifyExistsNickname(String nickname) {
        Optional<UserEntity> optionalUser = userRepository.findByNickname(nickname);
        if (optionalUser.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.NICKNAME_EXISTS);
        }
    }
}