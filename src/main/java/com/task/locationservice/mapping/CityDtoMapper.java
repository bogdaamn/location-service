package com.task.locationservice.mapping;

import com.task.locationservice.dto.CityDto;
import com.task.locationservice.persistance.CityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CityDtoMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "logoName", target = "fileUrl", qualifiedByName = "logoNameToLogoUrl")
    public abstract CityDto map(CityEntity source);

    public abstract List<CityDto> map(List<CityEntity> source);

    @Named("logoNameToLogoUrl")
    protected String logoNameToLogoUrl(String logoName){
        return "/logos/" + logoName;
    }

}
