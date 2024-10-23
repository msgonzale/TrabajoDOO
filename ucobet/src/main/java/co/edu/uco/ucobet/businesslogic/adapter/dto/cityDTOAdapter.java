package co.edu.uco.ucobet.businesslogic.adapter.dto;

import co.edu.uco.ucobet.businesslogic.adapter.Adapter;
import co.edu.uco.ucobet.domain.CityDomain;
import co.edu.uco.ucobet.dto.CityDTO;

public final class cityDTOAdapter implements Adapter<CityDomain, CityDTO> {
	
	private static final Adapter<CityDomain, CityDTO> instance =  new cityDTOAdapter();
	
	private cityDTOAdapter() {
		
	}

	@Override
	public CityDomain adaptSource(CityDTO data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityDTO adaptTarget(CityDomain data) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
