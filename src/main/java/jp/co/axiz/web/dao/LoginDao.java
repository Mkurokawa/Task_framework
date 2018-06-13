package jp.co.axiz.web.dao;

import java.util.List;

import jp.co.axiz.web.entity.Login;

public interface LoginDao {
	//DBからidとpassを探すメソッド
	
	public Login findByIdAndPass(String admin_id, String password);
	public List<Login> findAll();
}
