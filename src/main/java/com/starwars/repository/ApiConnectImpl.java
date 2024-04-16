package com.starwars.repository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.starwars.dto.FilmDto;
import com.starwars.dto.PlanetDto;
import com.starwars.dto.StarshipsDto;
import com.starwars.dto.VehiclesDto;
import com.starwars.model.Film;
import com.starwars.model.Vehicle;
import com.starwars.model.PersonInfo;
import com.starwars.model.Planet;
import com.starwars.model.Starship;
import com.starwars.service.MapperUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiConnectImpl implements ApiConnect {

	@Autowired
	private MapperUtils mapper;
	
	private static final String SWAPI_PEOPLE_URL = "https://swapi.dev/api/people/?search=";

    public String getPersonInfo(String name) throws Exception {
    	String url = SWAPI_PEOPLE_URL + name;
    	
    	RestTemplate restTemplate = new RestTemplate();
    	
    	String swapiResponse = restTemplate.getForObject(url, String.class);
    	
    	return swapiResponse;

    }
    
	public List<FilmDto> getFilms(List<String> listFilms) throws JsonMappingException, JsonProcessingException {
		
		List<FilmDto> filmsDto = new ArrayList<>();
		RestTemplate restTemplate = new RestTemplate();

		for(String filmUrl : listFilms) {
	    	
	    	String filmResponse = restTemplate.getForObject(filmUrl, String.class);
	    	Film film = mapper.filmResponseToFilm(filmResponse);//map filmResponse to Film
	    	FilmDto filmDto = mapper.filmToFilmDto(film); //map film to FilmDto
	    	filmsDto.add(filmDto);
		}
    	
    	return filmsDto;
				
	}
/*
	public List<VehiclesDto> getVehicles(List<String> listVehicles) {
		
		String url = SWAPI_VEHICLES_URL + name;
    	
    	RestTemplate restTemplate = new RestTemplate();
    	
    	String swapiResponse = restTemplate.getForObject(url, String.class);
    	
    	return swapiResponse;
				
	}*/
@Override
public List<StarshipsDto> getStarships(List<String> listStarships) throws JsonMappingException, JsonProcessingException {
	List<StarshipsDto> starShipsDto = new ArrayList<>();
	RestTemplate restTemplate = new RestTemplate();

	for(String starShipsUrl : listStarships) {
	    String starShipsResponse = restTemplate.getForObject(starShipsUrl, String.class);
	    Starship starShip = mapper.starShipsResponseToStarShip(starShipsResponse); //mapear la respuesta de las starShips a un objeto StarShip
	    StarshipsDto starShipDto = mapper.starShipToStarShipDto(starShip); //mapear el objeto StarShip a un DTO de StarShip
	    starShipsDto.add(starShipDto);
	}

	return starShipsDto;

}

@Override
public List<VehiclesDto> getVehicles(List<String> listVehicles) throws JsonMappingException, JsonProcessingException {
	List<VehiclesDto> vehiclesDto = new ArrayList<>();
	RestTemplate restTemplate = new RestTemplate();

	for(String vehiclesUrl : listVehicles) {
    	
    	String vehiclesResponse = restTemplate.getForObject(vehiclesUrl, String.class);
    	Vehicle vehicle = mapper.vehiclesResponseToVehicle(vehiclesResponse);//map filmResponse to Film
    	VehiclesDto vehicleDto = mapper.vehiclesToVehiclesDto(vehicle); //map film to FilmDto
    	vehiclesDto.add(vehicleDto);
	}
	
	return vehiclesDto;
}
@Override
public PlanetDto getPlanet(String homeworld) throws JsonMappingException, JsonProcessingException {
	RestTemplate restTemplate = new RestTemplate();

	String planetResponse = restTemplate.getForObject(homeworld, String.class);
	Planet planet = mapper.planetResponseToPlanet(planetResponse);//map filmResponse to Film
	PlanetDto planetDto = mapper.planetToPlanetDto(planet); //map film to FilmDto
	
	return planetDto;
}
}