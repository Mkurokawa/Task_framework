package jp.co.axiz.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.web.dao.LoginDao;
import jp.co.axiz.web.entity.Login;

@Service
public class PgAuthService {

	@Autowired
	private LoginDao login;

	//全件表示
	public List<Login> findAll (){
		return login.findAll();
	}


	//IDとPASSを基にadminテーブルに該当するレコードを返す
	public Login getAdmin_name (String id, String pass) {
		return login.findByIdAndPass(id, pass);
	}


}
