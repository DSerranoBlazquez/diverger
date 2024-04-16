package com.starwars.service;

import java.util.List;

import com.starwars.dto.PersonInfoDto;
import com.starwars.model.PersonInfo;

public interface StarWarsService {

	  public List<PersonInfoDto> getPersonInfoDto(String jsonResponse) throws Exception;
}
