package com.hexacoder.stackoverflow.user.mapper;

import org.mapstruct.Mapper;

import com.hexacoder.stackoverflow.user.dto.UserDto;
import com.hexacoder.stackoverflow.user.entity.UserEntity;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    UserEntity postDtoToEntity(UserDto.Post userPostDto);

    UserDto.Response userToUserResponseDto(UserEntity user);

    @Mapping(target = "email", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    UserEntity userPatchDtoToUser(UserDto.Patch userPatchDto);

}