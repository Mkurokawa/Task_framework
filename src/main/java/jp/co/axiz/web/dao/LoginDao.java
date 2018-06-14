package jp.co.axiz.web.dao;

import jp.co.axiz.web.entity.Login;

public interface LoginDao {
	public Login Admin_name(String admin_id, String password) ;
}
