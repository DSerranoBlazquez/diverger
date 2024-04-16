package com.starwars.service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.starwars.dto.FilmDto;
import com.starwars.dto.PersonInfoDto;
import com.starwars.dto.PlanetDto;
import com.starwars.dto.StarshipsDto;
import com.starwars.dto.VehiclesDto;
import com.starwars.model.PersonInfo;
import com.starwars.repository.ApiConnect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarSwarsServiceImpl implements StarWarsService{

	@Autowired
	private ApiConnect apiConnect;
	
	@Autowired
	private MapperUtils mapper;
	
	
    public List<PersonInfoDto> getPersonInfoDto(String name) throws Exception {
        // Convertir el JSON de respuesta a un objeto Persona
    	String personInfoResponse = apiConnect.getPersonInfo(name);

        List<PersonInfo> listPersonInfo = mapper.getPersonInfo(personInfoResponse);
        
        List<PersonInfoDto>listPersonInfoDto = new ArrayList<>();
        
        for(PersonInfo personInfo : listPersonInfo) {
        	List<FilmDto> filmsDto = apiConnect.getFilms(personInfo.getFilms());
        	List<VehiclesDto> vehiclesDto = apiConnect.getVehicles(personInfo.getVehicles());
        	List<StarshipsDto> starshipsDto = apiConnect.getStarships(personInfo.getStarships());
        	PlanetDto homeworld = apiConnect.getPlanet(personInfo.getHomeworld());
        	String fastestVehicleDriven = this.getFastestVehicle(vehiclesDto,starshipsDto);
        	PersonInfoDto personInfoDto = mapper.getPersonInfoDto(personInfo, filmsDto,fastestVehicleDriven, homeworld);
        	listPersonInfoDto.add(personInfoDto);
        }
      
        return listPersonInfoDto;

    }


	private String getFastestVehicle(List<VehiclesDto> vehiclesDto, List<StarshipsDto> starshipsDto) {
		String name = null;
		Integer speed=0;
		Integer maxspeed = 0;
		for(VehiclesDto vehicle: vehiclesDto) {
			speed = Integer.parseInt(vehicle.getMaxAtmospheringSpeed());
			if (speed>maxspeed) {
				maxspeed = speed;
				name = vehicle.getName();
			}
		}
		
		for(StarshipsDto starship: starshipsDto) {
			speed = Integer.parseInt(starship.getMaxAtmospheringSpeed());
			if (speed>maxspeed) {
				maxspeed = speed;
				name = starship.getName();
			}
		}

		return name;
	}
}
    