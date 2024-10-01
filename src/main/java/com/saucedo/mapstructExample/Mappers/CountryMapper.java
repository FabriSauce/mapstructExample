package com.saucedo.mapstructExample.Mappers;

import com.saucedo.mapstructExample.dto.CountryDto;
import com.saucedo.mapstructExample.dto.LanguageDto;
import com.saucedo.mapstructExample.models.Country;
import com.saucedo.mapstructExample.models.Language;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {

    CountryMapper mapper = Mappers.getMapper(CountryMapper.class);

    @Mapping(target = "continent", source = "location.continent")
    CountryDto toCountryDto(Country country);

    @Mapping(target = "isOfficialLanguage", source = "isOfficial")
    @Mapping(target = "speakersTotal", source = "speakersCount")
    LanguageDto toLanguageDto(Language language);


}
