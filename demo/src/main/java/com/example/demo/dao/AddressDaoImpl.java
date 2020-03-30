package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Address;

@Repository
public class AddressDaoImpl implements AddressDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Address address) {
		String query = "insert into Address values(?,?)";
		return jdbcTemplate.update(query, address.getHouseNo(), address.getCity());
	}

	@Override
	public List<Address> findAll() {
		String query = "select * from address";
		return jdbcTemplate.query(query, (rs, rowNum) -> new Address(rs.getString(1), rs.getString(2)));
	}

	@Override
	public int update(Address address) {
		String query = "update address set city = ? where houseno = ?";
		return jdbcTemplate.update(query, address.getCity(), address.getHouseNo());
	}

	@Override
	public int delete(Address address) {
		String query = "delete from address where houseno = ?";
		return jdbcTemplate.update(query, address.getHouseNo());
	}

}