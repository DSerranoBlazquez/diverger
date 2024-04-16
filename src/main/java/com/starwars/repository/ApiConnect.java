package com.starwars.repository;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.starwars.dto.FilmDto;
import com.starwars.dto.PlanetDto;
import com.starwars.dto.StarshipsDto;
import com.starwars.dto.VehiclesDto;

public interface ApiConnect {

	public String getPersonInfo(String name) throws Exception;
	
	public List<StarshipsDto> getStarships(List<String> listStarships) throws JsonMappingException, JsonProcessingException;
	
	public List<FilmDto> getFilms(List<String> listFilms) throws JsonMappingException, JsonProcessingException;

	public List<VehiclesDto> getVehicles(List<String> listVehicles) throws JsonMappingException, JsonProcessingException;

	public PlanetDto getPlanet(String homeworld) throws JsonMappingException, JsonProcessingException;
}
