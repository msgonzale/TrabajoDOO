package co.edu.uco.ucobet.data.dao.impl.sql.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.ucobet.data.dao.StateDAO;
import co.edu.uco.ucobet.entity.StateEntity;


public class StateSqlServerDAO extends SqlDAO implements StateDAO {

	public StateSqlServerDAO(final Connection connection) {
		super(connection);
}
	@Override
	public StateEntity findByID(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateEntity> findByFilter(StateEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
