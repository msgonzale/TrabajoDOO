package co.edu.uco.ucobet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.crosscutting.exceptions.UcoApplicationException;
import co.edu.uco.ucobet.businesslogic.facade.city.impl.RegisterNewCityFacadeImpl;
import co.edu.uco.ucobet.controller.response.GenerateResponse;
import co.edu.uco.ucobet.controller.response.ResponseWithData;
import co.edu.uco.ucobet.controller.response.concrete.CityResponse;
import co.edu.uco.ucobet.controller.response.concrete.GenericResponse;
import co.edu.uco.ucobet.crosscutting.exceptions.UcoBetException;
import co.edu.uco.ucobet.dto.CityDTO;

@RestController
@RequestMapping("/api/v1/cities")
public final class CityController {
	
	@GetMapping ("/dummy")
	public CityDTO getDummy() {
		return CityDTO.create();
		}
	
	@PostMapping
	public ResponseEntity<GenericResponse>create(@RequestBody CityDTO city) {
		var messages = new ArrayList<String>();
		
		messages.add("la cuidad se registro de manera satisfactoria");
		return new ResponseEntity<>(null);
		
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<GenericResponse> update(@PathVariable String id,@RequestBody CityDTO city) {
		var messages = new ArrayList<String>();
		
		try {
			var registerNewCityFacade = new RegisterNewCityFacadeImpl();
			registerNewCityFacade.execute(city);
			messages.add("la cuidad se registro de forma satisfactoria");
			return GenerateResponse.generateSucessResponse(messages);
		} catch (final UcoBetException exception) {
			messages.add(exception.getUserMessage());
			exception.printStackTrace();
			
			return GenerateResponse.generateFailedResponse(messages);
		}catch (final UcoApplicationException exception) {
			messages.add(exception.getUserMessage());
			exception.printStackTrace();
			
			return GenerateResponse.generateFailedResponse(messages);
		
		}catch (final Exception exception) {
			messages.add("se ha presentado un problema inesperado tratando de llevar a cabo el registro de la cuidad de forma satisdactpria ...");
			exception.printStackTrace();
			
			return GenerateResponse.generateFailedResponse(messages);
		
		messages.add("la cuidad se actualizo de manera satisfactoria");
	
		   return GenerateResponse.generateFailedResponse(messages)
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<GenericResponse> delete(@PathVariable String id) {
		var messages = new ArrayList<String>();
		
		messages.add("la cuidad se elimino de manera satisfactoria");
		return GenerateResponse.generateSucessResponse(messages);
		
	}
	
	@GetMapping
	public ResponseEntity<CityResponse>retrieveAll() {
		ResponseWithData<CityDTO> responseWithData = new CityResponse();
		
		
		var messeges = new ArrayList<String>();
		
		messeges.add("la cuidad se consultaron de forma satisfactoria");
		var list =new ArrayList<CityDTO>();
		list.add(getDummy());
		list.add(getDummy());
		list.add(getDummy());
		list.add(getDummy());
		
		responseWithData.setData(list);
		responseWithData.setMessages(messages);
		
		return ((new GenerateResponse<>()).generateSucessResponse(responseWithData));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CityResponse> retrieveById(@PathVariable String id) {
		return getDummy().setId(id);
		
	}
}
