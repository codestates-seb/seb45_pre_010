package com.hexacoder.stackoverflow.user.mapper;

import com.hexacoder.stackoverflow.user.dto.UserDto;
import com.hexacoder.stackoverflow.user.entity.UserEntity;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-21T18:00:19+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity postDtoToEntity(UserDto.Post userPostDto) {
        if ( userPostDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setEmail( userPostDto.getEmail() );
        userEntity.setPassword( userPostDto.getPassword() );
        userEntity.setNickname( userPostDto.getNickname() );

        return userEntity;
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

        UserEntity userEntity = new UserEntity();

        userEntity.setUserId( userPatchDto.getUserId() );
        userEntity.setPassword( userPatchDto.getPassword() );
        userEntity.setNickname( userPatchDto.getNickname() );

        return userEntity;
    }
}
