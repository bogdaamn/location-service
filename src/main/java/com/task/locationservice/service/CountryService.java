package com.task.locationservice.service;

import com.task.locationservice.dto.CountryDto;
import com.task.locationservice.exceptions.CountryNotFoundException;
import com.task.locationservice.mapping.CountryDtoMapper;
import com.task.locationservice.persistance.CountryEntity;
import com.task.locationservice.persistance.CountryRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class CountryService {

    private final CityService cityService;
    private final CountryDtoMapper countryDtoMapper;
    private final CountryRepository countryRepository;

    public CountryService(CityService cityService, CountryDtoMapper countryDtoMapper, CountryRepository countryRepository) {
        this.cityService = cityService;
        this.countryDtoMapper = countryDtoMapper;
        this.countryRepository = countryRepository;
    }


    public List<CountryDto> getAllCountries() {
        return countryDtoMapper.map(countryRepository.findAll());
    }

    public CountryDto getCountryById(Long id) {
        var country = countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException("No country with id %s were found".formatted(id)));

        var cities = cityService.findAllByCountryId(id);
        return countryDtoMapper.map(country, cities);
    }

    public void addCountry(String countryName) {
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setName(countryName);
        countryRepository.save(countryEntity);
    }

    @Transactional
    @Modifying
    public void deleteCountry(String countryName) {
        var country = countryRepository.findByName(countryName);
        countryRepository.delete(country);
    }
}
