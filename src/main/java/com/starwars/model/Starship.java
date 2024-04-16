package com.starwars.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Starship {
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("model")
    private String model;
    
    @JsonProperty("manufacturer")
    private String manufacturer;
    
    @JsonProperty("cost_in_credits")
    private String costInCredits;
    
    @JsonProperty("length")
    private String length;
    
    @JsonProperty("max_atmosphering_speed")
    private String maxAtmospheringSpeed;
    
    @JsonProperty("crew")
    private String crew;
    
    @JsonProperty("passengers")
    private String passengers;
    
    @JsonProperty("cargo_capacity")
    private String cargoCapacity;
    
    @JsonProperty("consumables")
    private String consumables;
    
    @JsonProperty("hyperdrive_rating")
    private String hyperdriveRating;
    
    @JsonProperty("MGLT")
    private String mglt;
    
    @JsonProperty("starship_class")
    private String starshipClass;
    
    @JsonProperty("pilots")
    private List<String> pilots;
    
    @JsonProperty("films")
    private List<String> films;
    
    @JsonProperty("created")
    private String created;
    
    @JsonProperty("edited")
    private String edited;
    
    @JsonProperty("url")
    private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCostInCredits() {
		return costInCredits;
	}

	public void setCostInCredits(String costInCredits) {
		this.costInCredits = costInCredits;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getMaxAtmospheringSpeed() {
		return maxAtmospheringSpeed;
	}

	public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
		this.maxAtmospheringSpeed = maxAtmospheringSpeed;
	}

	public String getCrew() {
		return crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public String getPassengers() {
		return passengers;
	}

	public void setPassengers(String passengers) {
		this.passengers = passengers;
	}

	public String getCargoCapacity() {
		return cargoCapacity;
	}

	public void setCargoCapacity(String cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}

	public String getConsumables() {
		return consumables;
	}

	public void setConsumables(String consumables) {
		this.consumables = consumables;
	}

	public String getHyperdriveRating() {
		return hyperdriveRating;
	}

	public void setHyperdriveRating(String hyperdriveRating) {
		this.hyperdriveRating = hyperdriveRating;
	}

	public String getMglt() {
		return mglt;
	}

	public void setMglt(String mglt) {
		this.mglt = mglt;
	}

	public String getStarshipClass() {
		return starshipClass;
	}

	public void setStarshipClass(String starshipClass) {
		this.starshipClass = starshipClass;
	}

	public List<String> getPilots() {
		return pilots;
	}

	public void setPilots(List<String> pilots) {
		this.pilots = pilots;
	}

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getEdited() {
		return edited;
	}

	public void setEdited(String edited) {
		this.edited = edited;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}

