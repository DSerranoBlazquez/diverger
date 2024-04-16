package com.starwars.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.starwars.dto.FilmDto;
import com.starwars.dto.PersonInfoDto;
import com.starwars.dto.PlanetDto;
import com.starwars.dto.StarshipsDto;
import com.starwars.dto.VehiclesDto;
import com.starwars.model.Film;
import com.starwars.model.PersonInfo;
import com.starwars.model.Planet;
import com.starwars.model.Starship;
import com.starwars.model.Vehicle;
import com.starwars.repository.ApiConnect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapperUtils{


	
    public PersonInfoDto getPersonInfoDto(PersonInfo personInfo, List<FilmDto> filmsDto, String fastestVehicleDriven, PlanetDto homeworld) throws Exception {
       
    	PersonInfoDto personInfoDto = new PersonInfoDto();
    	personInfoDto.setName(personInfo.getName());
    	personInfoDto.setBirthYear(personInfo.getBirthYear());
    	personInfoDto.setGender(personInfo.getGender());
    	personInfoDto.setPlanetName(homeworld.getName());
    	personInfoDto.setFastestVehicleDriven(fastestVehicleDriven);
    	personInfoDto.setFilms(filmsDto);
       
        return personInfoDto;

    }

    public List<PersonInfo> getPersonInfo(String jsonResponse) throws Exception {
    	ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonResponse);
        JsonNode resultsNode = rootNode.get("results");
        String resultsJson = objectMapper.writeValueAsString(resultsNode);
        
        List<PersonInfo> listPersonInfo = objectMapper.readValue(
        		resultsJson,
                objectMapper.getTypeFactory().constructCollectionType(List.class, PersonInfo.class)
        );
        return listPersonInfo;
    }

	public Film filmResponseToFilm(String filmResponse) throws JsonMappingException, JsonProcessingException {
    	ObjectMapper objectMapper = new ObjectMapper();

		Film film= objectMapper.readValue(filmResponse, Film.class);
	
		return film;
		
	}
	
	public FilmDto filmToFilmDto(Film film)			 {
		FilmDto filmDto= new FilmDto();
		filmDto.setTitle(film.getTitle());
		filmDto.setReleaseDate(film.getReleaseDate());

		return filmDto;
	}


	public Vehicle vehiclesResponseToVehicle(String vehiclesResponse) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		Vehicle vehicle= objectMapper.readValue(vehiclesResponse, Vehicle.class);
      
	
	return vehicle;
	}

	public VehiclesDto vehiclesToVehiclesDto(Vehicle vehicle) {
		VehiclesDto vehicleDto= new VehiclesDto();
		vehicleDto.setName(vehicle.getName());
		vehicleDto.setMaxAtmospheringSpeed(vehicle.getMaxAtmospheringSpeed());

		return vehicleDto;
	}

	public Starship starShipsResponseToStarShip(String starShipsResponse) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		Starship starship= objectMapper.readValue(starShipsResponse, Starship.class);
      
	
	return starship;
	}

	public StarshipsDto starShipToStarShipDto(Starship starShip) {
		StarshipsDto starshipDto = new StarshipsDto();
		starshipDto.setName(starShip.getName());
		starshipDto.setMaxAtmospheringSpeed(starShip.getMaxAtmospheringSpeed());

		return starshipDto;
	}

	public Planet planetResponseToPlanet(String planetResponse) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		Planet planet= objectMapper.readValue(planetResponse, Planet.class);
      
	
	return planet;
	}

	public PlanetDto planetToPlanetDto(Planet planet) {
		PlanetDto planetDto = new PlanetDto();
		planetDto.setName(planet.getName());
		return planetDto;
	}

}
    