package com.starwars.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class PersonInfoDto {
  
    private String name;
    private String birthYear;
    private String gender;
    private String planetName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fastestVehicleDriven;
    private List<FilmDto> films;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPlanetName() {
		return planetName;
	}
	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}
	public String getFastestVehicleDriven() {
		return fastestVehicleDriven;
	}
	public void setFastestVehicleDriven(String fastestVehicleDriven) {
		this.fastestVehicleDriven = fastestVehicleDriven;
	}
	public List<FilmDto> getFilms() {
		return films;
	}
	public void setFilms(List<FilmDto> films) {
		this.films = films;
	}
}
