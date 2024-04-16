package com.starwars.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.starwars.dto.PersonInfoDto;
import com.starwars.excepcions.ResourceNotFoundException;
import com.starwars.model.PersonInfo;
import com.starwars.repository.ApiConnect;
import com.starwars.service.StarWarsService;

@RestController
@RequestMapping("/swapi-proxy")
public class PersonInfoController {
    
    @Autowired
    private StarWarsService jsonService;
    
    @Autowired
	private ApiConnect apiConnect;
    
    @GetMapping("/person-info")
    public List<PersonInfoDto> getPersonInfo(@RequestParam (name="name", required =true) String name) throws Exception {
    	
    	List<PersonInfoDto> listPersonInfo = jsonService.getPersonInfoDto(name);
    	
    	if (listPersonInfo.isEmpty()) {
    	    throw new ResourceNotFoundException("No se encontraron recursos");
    	}
        return listPersonInfo;
    }
}
