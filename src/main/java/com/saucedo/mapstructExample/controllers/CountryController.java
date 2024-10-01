package com.saucedo.mapstructExample.controllers;

import com.saucedo.mapstructExample.Service.CountryService;
import com.saucedo.mapstructExample.dto.CountryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "country")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<CountryDto> getById(@PathVariable UUID id){

        return ResponseEntity.ok(this.countryService.readById(id));
    }


}
