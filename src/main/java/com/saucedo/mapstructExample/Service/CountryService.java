package com.saucedo.mapstructExample.Service;

import com.saucedo.mapstructExample.Mappers.CountryMapper;
import com.saucedo.mapstructExample.dao.CountryDao;
import com.saucedo.mapstructExample.dto.CountryDto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CountryService {
    private static final Logger log = LoggerFactory.getLogger(CountryService.class);

    public CountryDto readById(UUID id){

        if (CountryDao.db.containsKey(id)){
            return CountryMapper.mapper.toCountryDto(CountryDao.db.get(id));
        } else {
            log.error("Country with id {} not found ", id);
            throw  new RuntimeException("Country with id " + id +  " not found ");
        }
    }
}
