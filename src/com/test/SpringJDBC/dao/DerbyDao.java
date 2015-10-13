package com.test.SpringJDBC.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.test.SpringJDBC.dao.mapper.PersonRowMapper;
import com.test.SpringJDBC.domainmodel.Person;

public class DerbyDao implements IDao {

	private DataSource dataSource;
	
	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
	}

	@Override
	public void create(String firstName, String lastName) {
		JdbcTemplate insert = new JdbcTemplate(dataSource);
	    insert.update("INSERT INTO PERSON (FIRSTNAME, LASTNAME) VALUES(?,?)",
	        new Object[] { firstName, lastName });
	}

	@Override
	public List<Person> select(String firstname, String lastname) {
		JdbcTemplate select = new JdbcTemplate(dataSource);
	    return select
	        .query("select  FIRSTNAME, LASTNAME from PERSON where FIRSTNAME = ? AND LASTNAME= ?",
	            new Object[] { firstname, lastname },
	            new PersonRowMapper());
	}

	@Override
	public List<Person> selectAll() {
		JdbcTemplate select = new JdbcTemplate(dataSource);
	    return select.query("select FIRSTNAME, LASTNAME from PERSON",
	        new PersonRowMapper());
	}

	@Override
	public void deleteAll() {
		JdbcTemplate delete = new JdbcTemplate(dataSource);
	    delete.update("DELETE from PERSON");
	}

	@Override
	public void delete(String firstName, String lastName) {
		JdbcTemplate delete = new JdbcTemplate(dataSource);
	    delete.update("DELETE from PERSON where FIRSTNAME= ? AND LASTNAME = ?",
	        new Object[] { firstName, lastName });
	}

}
