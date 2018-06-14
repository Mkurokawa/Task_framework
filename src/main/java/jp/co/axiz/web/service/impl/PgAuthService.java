package jp.co.axiz.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.web.dao.impl.PgLoginDao;
import jp.co.axiz.web.entity.Login;
import jp.co.axiz.web.service.AuthService;

@Service
public class PgAuthService implements AuthService{

	@Autowired
	private PgLoginDao adi;

	public Login Admin_name(String admin_id,String password) {
		Login l = adi.Admin_name(admin_id, password);

		if(l == null) {
			return null;
		}

		return l;

	}
}
