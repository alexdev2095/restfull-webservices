package com.sprintboot.restfull_webservices.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.sprintboot.restfull_webservices.dto.UserDto;
import com.sprintboot.restfull_webservices.models.entity.User;

@Mapper
public interface IAutoUserMapper {

    IAutoUserMapper MAPPER = Mappers.getMapper(IAutoUserMapper.class);

    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);
}
