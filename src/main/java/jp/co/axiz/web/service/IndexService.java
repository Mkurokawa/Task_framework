package jp.co.axiz.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.web.dao.LoginDao;
import jp.co.axiz.web.entity.Login;

@Service
public class IndexService {
	
	@Autowired
	private LoginDao Admin_name;

	public Login getAdmin (String admin_id,String password) {
		return Admin_name.Admin_name(admin_id, password);
	}

}
