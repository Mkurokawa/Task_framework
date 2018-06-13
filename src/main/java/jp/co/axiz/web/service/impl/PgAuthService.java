package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axiz.web.dao.UserDao;
import jp.co.axiz.web.entity.User;
import jp.co.axiz.web.service.AuthService;

@Service //サービス層のクラス（ビジネスロジック等）に付与する。
public class PgAuthService implements AuthService {

	@Autowired
	private UserDao userDao;

	@Override //スーパークラスのメソッドをオーバーライドするという注釈
	public List<User> findAll() {
		return userDao.findAll();
	}

}