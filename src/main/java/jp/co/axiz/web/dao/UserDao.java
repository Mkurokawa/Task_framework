package jp.co.axiz.web.dao;

import java.util.List;

import jp.co.axiz.web.entity.User;

public interface UserDao {

	public List<User> findAll();

}
