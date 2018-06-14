package jp.co.axiz.web.dao;

import java.util.List;

import jp.co.axiz.web.entity.User;

public interface UserDao {

	public List<User> findAll();
	public int Insert();
	public int Id();
	public List<User> selectAll();
	public List<User> selectByNameAndTel(String name,String tel);
	public List<User> selectByIdAndTel(Integer id,String tel);
	public List<User> selectByIdAndName(Integer id,String name);
	public List<User> selectById(Integer id);
	public List<User> selectByName(String name);
	public List<User> selectByTel(String tel);
	public List<User> selectComplete(Integer id,String name,String tel);
	public int insert(User user);
	public void update(Integer u_id, String name, String tel, String pass);
	public void delete(Integer id);

	public void insert(String name, String tel, String pass);





}
