package co.edu.uco.ucobet.businesslogic.facade.city.impl;

import java.util.List;

import co.edu.uco.ucobet.businesslogic.adapter.Adapter;
import co.edu.uco.ucobet.businesslogic.adapter.dto.CityDTOAdapter;
import co.edu.uco.ucobet.businesslogic.facade.city.FindCityFacade;
import co.edu.uco.ucobet.businesslogic.usecase.city.impl.FindCityImpl;
import co.edu.uco.ucobet.crosscutting.exceptions.DataUcoBetException;
import co.edu.uco.ucobet.crosscutting.exceptions.UcoBetException;
import co.edu.uco.ucobet.data.dao.DAOFactory;
import co.edu.uco.ucobet.data.dao.enums.DAOSource;
import co.edu.uco.ucobet.domain.CityDomain;
import co.edu.uco.ucobet.dto.CityDTO;

public final class FindCityFacadeImpl implements FindCityFacade{

	@SuppressWarnings("unchecked")
	@Override
	public List<CityDTO> execute(CityDTO data) {
      var factory = DAOFactory.getFactory(DAOSource.SQLSERVER);
		
		try {
			var findCityUseCase = new FindCityImpl(factory);
			
			var cityDomain = CityDTOAdapter.getCityDTOAdapter().adaptSource(data);
			
			var resultsAsDto = CityDTOAdapter.getCityDTOAdapter().adaptTarget(findCityUseCase.execute(cityDomain));
			
			return ((Adapter<CityDomain,CityDTO>) resultsAsDto).adaptTarget(findCityUseCase.execute(cityDomain));
			
		}catch(final UcoBetException exception) {
			
			throw exception;
		}catch(final Exception exception) {
			
			var userMessage = "se ha presentado un problema tratando de consultar la informacion de las nuevas  ciudadades.";
			var technicalMessage = " se ha presentado n problema inesperado registrando la informacion de la cuidad.porfavor revisar";
			throw DataUcoBetException.crear(userMessage, technicalMessage, exception);
		}finally {
			factory.closeConnection();
		}
	}

}

