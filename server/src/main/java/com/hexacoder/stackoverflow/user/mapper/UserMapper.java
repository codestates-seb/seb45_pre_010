package com.hexacoder.stackoverflow.user.mapper;

import org.mapstruct.Mapper;

import com.hexacoder.stackoverflow.user.dto.UserDto;
import com.hexacoder.stackoverflow.user.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity postDtoToEntity(UserDto.Post userPostDto);
    UserDto.Response userToUserResponseDto(UserEntity user);
    UserEntity userPatchDtoToUser(UserDto.Patch userPatchDto);

}