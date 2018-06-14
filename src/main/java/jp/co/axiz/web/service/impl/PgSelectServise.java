package jp.co.axiz.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.UserDao;
import jp.co.axiz.web.entity.User;
import jp.co.axiz.web.service.SelectServise;

@Repository
public class PgSelectServise implements SelectServise{

	@Autowired
	UserDao ud;

	@Override
	public List<User> find(User form) {
		Integer id = form.getUser_id();
		String name = form.getUser_name();
		String tel = form.getTelephone();
		Integer uid = 0;

		boolean isId = false;
		boolean isName = false;
		boolean isTel = false;

		if(!("".equals(id))) {
			isId = true;
			uid = id;
		}
		if(!("".equals(name))) {
			isName = true;
		}
		if(!("".equals(tel))) {
			isTel = true;
		}

		List<User> list = new ArrayList<User>();
		if(isId && isName && isTel) {
			list = ud.selectComplete(uid,name,tel);
		}else if(isId && isName) {
			list = ud.selectByIdAndName(uid, name);
		}else if(isId && isTel) {
			list = ud.selectByIdAndTel(uid, tel);
		}else if(isName && isTel) {
			list = ud.selectByNameAndTel(name, tel);
		}else if(isId) {
			list = ud.selectById(uid);
		}else if(isName) {
			list = ud.selectByName(name);
		}else if(isTel) {
			list = ud.selectByTel(tel);
		}else {
			list = ud.findAll();
		}

		return list;

	}
}