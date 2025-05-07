package com.stoliar.usersubscriptionservice.mapper;

import com.stoliar.usersubscriptionservice.dto.UserDto;
import com.stoliar.usersubscriptionservice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    public User toEntity(UserDto dto) {
        User user = new User();
        user.setId(dto.id());
        user.setName(dto.name());
        user.setEmail(dto.email());
        return user;
    }

    public void updateEntity(User user, UserDto dto) {
        user.setName(dto.name());
        user.setEmail(dto.email());
    }
}
