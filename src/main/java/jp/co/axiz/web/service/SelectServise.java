package jp.co.axiz.web.service;

import java.util.List;

import jp.co.axiz.web.entity.User;

public interface SelectServise {
	public List<User> find(User form);
}