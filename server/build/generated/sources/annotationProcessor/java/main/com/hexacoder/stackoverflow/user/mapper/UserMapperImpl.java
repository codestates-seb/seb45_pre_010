package com.hexacoder.stackoverflow.user.mapper;

import com.hexacoder.stackoverflow.user.dto.UserDto;
import com.hexacoder.stackoverflow.user.entity.UserEntity;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-22T03:26:47+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 17.0.8 (IBM Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity postDtoToEntity(UserDto.Post userPostDto) {
        if ( userPostDto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.email( userPostDto.getEmail() );
        userEntity.password( userPostDto.getPassword() );
        userEntity.nickname( userPostDto.getNickname() );

        return userEntity.build();
    }

    @Override
    public UserDto.Response userToUserResponseDto(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        long userId = 0L;
        String nickname = null;
        String email = null;
        LocalDateTime createdAt = null;

        if ( user.getUserId() != null ) {
            userId = user.getUserId();
        }
        nickname = user.getNickname();
        email = user.getEmail();
        createdAt = user.getCreatedAt();

        UserDto.Response response = new UserDto.Response( userId, nickname, email, createdAt );

        return response;
    }

    @Override
    public UserEntity userPatchDtoToUser(UserDto.Patch userPatchDto) {
        if ( userPatchDto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.userId( userPatchDto.getUserId() );
        userEntity.password( userPatchDto.getPassword() );
        userEntity.nickname( userPatchDto.getNickname() );

        return userEntity.build();
    }
}
