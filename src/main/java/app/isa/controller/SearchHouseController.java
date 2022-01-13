package app.isa.controller;

import app.isa.domain.dto.DTO.SearchHousesDTO;
import app.isa.service.SearchHousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/houses")
public class SearchHouseController {

    @Autowired
    private SearchHousesService searchHousesService;



}
