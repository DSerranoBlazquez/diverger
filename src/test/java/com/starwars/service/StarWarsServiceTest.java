package com.starwars.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.starwars.dto.PersonInfoDto;
import com.starwars.model.PersonInfo;
import com.starwars.repository.ApiConnect;

public class StarWarsServiceTest {

    @Mock
    private ApiConnect apiConnectMock;

    @Mock
    private MapperUtils mapperMock;

    @InjectMocks
    private StarWarsService starWarsService;

   
    @Test
    public void testGetPersonInfoDto() throws Exception {
        // JSON de respuesta simulado
        String personInfoResponse = "{ \"name\": \"Luke Skywalker\", \"films\": [\"https://swapi.dev/api/films/1/\"] }";

        // Crear objetos simulados para los métodos de la clase MapperUtils
        List<PersonInfo> listPersonInfo = Arrays.asList(new PersonInfo());
        when(mapperMock.getPersonInfo(personInfoResponse)).thenReturn(listPersonInfo);

        // Mock de la respuesta de la llamada a apiConnect.getPersonInfo
        when(apiConnectMock.getPersonInfo("Luke Skywalker")).thenReturn(personInfoResponse);

        // Ejecutar el método a testear
        List<PersonInfoDto> result = starWarsService.getPersonInfoDto("Luke Skywalker");

        //Habría que mockear cada una de las conexiones de appiConnectMock
        
        // Verificar que se llamaron a los métodos correspondientes
        assertEquals(1, result.size());
    }
}
