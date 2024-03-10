package com.task.locationservice.mapping;

import com.task.locationservice.dto.CityDto;
import com.task.locationservice.persistance.CityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CityEntityMapper {

    public abstract CityEntity map(CityDto source);
}
