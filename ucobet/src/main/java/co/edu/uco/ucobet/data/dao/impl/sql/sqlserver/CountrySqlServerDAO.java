package co.edu.uco.ucobet.data.dao.impl.sql.sqlserver;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.data.dao.CountryDAO;
import co.edu.uco.ucobet.entity.CountryEntity;

public final class CountrySqlServerDAO extends SqlDAO implements CountryDAO {

	public CountrySqlServerDAO(final Connection connection) {
		super(connection);
		
	}

	@Override
	public CountryEntity findByID(final UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountryEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountryEntity> findByFilter(final CountryEntity filter) {
		
		final var statement = new  StringBuilder();
		final var parameters = new ArrayList<>();
		
		createSelect(statement);
		createFrom(statement);
		createWhere(statement, filter, parameters);
		createOrderBy(statement);
		
		return null;
	}
	private void createSelect(final StringBuilder statement) {
		statement.append("SELECT id, name ");
	}
	private void createFrom(final StringBuilder statement) {
		statement.append("FROM Country ");
	}
	
	private void createWhere(final StringBuilder statement,
			final CountryEntity filter,
			final List<Object> parameters) {
		
		if(!ObjectHelper.isNull(filter)) {
			
			if(UUIDHelper.isDefault(filter.getId())) {
				statement.append("WHERE id = ?");
				parameters.add(filter.getId());
			}
			
			if(!TextHelper.isEmptyApplyingTrim(filter.getName()));{
				statement.append((parameters.isEmpty()) ? "WHERE " : "AND ");
				statement.append("name = ?");
				parameters.add(filter.getName());
			}
		}
	}
	
	private void createOrderBy(final StringBuilder statement) {
		statement.append("ORDER BY name ASC ");
	}
	
}
