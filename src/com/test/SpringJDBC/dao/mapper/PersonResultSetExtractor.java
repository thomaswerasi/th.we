package com.test.SpringJDBC.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.test.SpringJDBC.domainmodel.Person;


public class PersonResultSetExtractor implements ResultSetExtractor {

	@Override
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		Person person = new Person();
	    person.setFirstName(rs.getString(1));
	    person.setLastName(rs.getString(2));
	    return person;
	}

}
