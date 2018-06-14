package jp.co.axiz.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.LoginDao;
import jp.co.axiz.web.entity.Login;

@Repository
public class PgLoginDao implements LoginDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_SELECT_ID_PASS = "SELECT * FROM admin WHERE admin_id = ? AND password = ?";

	@Override
	public Login Admin_name(String admin_id, String password) {
		List<Login> list = jdbcTemplate.query(SQL_SELECT_ID_PASS,new BeanPropertyRowMapper<Login>(Login.class),admin_id,password);

		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}
}