package com.task.locationservice.mapping;

import com.task.locationservice.dto.UserDto;
import com.task.locationservice.persistance.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class UserDtoMapper {

    public abstract UserDto map(UserEntity source);
}