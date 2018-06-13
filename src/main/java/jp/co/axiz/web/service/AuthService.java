package jp.co.axiz.web.service;

import java.util.List;

import jp.co.axiz.web.entity.Login;
import jp.co.axiz.web.entity.User;

public interface AuthService {	//DBからidとpassを探すメソッド
	
	public Login findByIdAndPass(String admin_id, String password);
	public static List<Login> findAll() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	public User getAdmin_name(String id, String pass);
}

