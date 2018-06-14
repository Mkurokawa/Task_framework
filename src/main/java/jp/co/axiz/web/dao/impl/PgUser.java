package jp.co.axiz.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import jp.co.axiz.web.entity.User;

public class PgUser {
	@SuppressWarnings("unused")
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private Connection con;

	//検索
	private static final String SQL_SELECT_ALL="SELECT "
			+ "* "
			+ "FROM "
			+ "user_info";
	private static final String SQL_SELECT_BY_NAME_AND_TEL="SELECT "
			+ "* "
			+ "FROM "
			+ "user_info "
			+ "WHERE "
			+ "user_name= ? "
			+ "AND "
			+ "telephone=? "
			+ "ORDER "
			+ "BY "
			+ "user_id" ;
	private static final String SQL_SELECT_BY_ID_AND_TEL="SELECT "
			+ "* "
			+ "FROM "
			+ "user_info  "
			+ "WHERE "
			+ "user_id= ? "
			+ "AND "
			+ "telephone=? "
			+ "ORDER "
			+ "BY "
			+ "user_id";
	private static final String SQL_SELECT_BY_ID_AND_NAME="SELECT "
			+ "* "
			+ "FROM "
			+ "user_info  "
			+ "WHERE "
			+ "user_id= ? "
			+ "AND "
			+ "user_name= ? "
			+ "ORDER "
			+ "BY "
			+ "user_id";
	private static final String SQL_SELECT_BY_ID="SELECT "
			+ "* "
			+ "FROM "
			+ "user_info "
			+ "WHERE "
			+ "user_id= ? "
			+ "ORDER "
			+ "BY "
			+ "user_id";
	private static final String SQL_SELECT_BY_NAME="SELECT "
			+ "* "
			+ "FROM "
			+ "user_info  "
			+ "WHERE "
			+ "user_name= ? "
			+ "ORDER "
			+ "BY "
			+ "user_id";
	private static final String SQL_SELECT_BY_TEL="SELECT "
			+ "* "
			+ "FROM "
			+ "user_info "
			+ "WHERE "
			+ "telephone= ? "
			+ "ORDER "
			+ "BY "
			+ "user_id";
	private static final String SQL_SELECT_COMPLETE="SELECT "
			+ "* "
			+ "FROM "
			+ "user_info "
			+ "WHERE "
			+ "user_id= ? "
			+ "AND "
			+ "user_name=? "
			+ "AND "
			+ "telephone= ? "
			+ "ORDER "
			+ "BY "
			+ "user_id";

	//登録
	private static final String SQL_INSERT="INSERT "
			+ "INTO "
			+ "user_info "
			+ "(user_name, "
			+ "telephone, "
			+ "password) "
			+ "VALUES "
			+ "(?,?,?)";

	//更新
	private static final String SQL_UPDATE="UPDATE "
			+ "user_info "
			+ "SET "
			+ "user_name=?, "
			+ "telephone=?, "
			+ "password=? "
			+ "WHERE "
			+ "user_id=?";

	//削除
	private static final String SQL_DELETE="DELETE "
			+ "FROM "
			+ "user_info "
			+ "WHERE "
			+ "user_id = ?";
	//MAXID+1
	private static final String SQL_MAX= "SELECT "
			+ "MAX(user_id) "
			+ "from "
			+ "user_info";


	public PgUser(Connection con){
		this.con=con;
	}

	//MAXID
	public int Id() {//idだけ
		try (PreparedStatement stmt = con.prepareStatement(SQL_MAX)){
			List<User> list = new ArrayList<User>();
			ResultSet rs = stmt.executeQuery();
			int userI = 0;
			if(rs.next()) {
				userI = (rs.getInt("max"));
			}
			return userI;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//検索
	public List<User> selectAll() {
		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ALL)){//未入力時全表示
			List<User> list = new ArrayList<User>();
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				User userI = new User(rs.getInt("user_id"),rs.getString("user_name"),rs.getString("telephone"),rs.getString("password"));
				list.add(userI);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<User> selectByNameAndTel(String name,String tel) {//名前とtel
		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_BY_NAME_AND_TEL)){
			List<User> list = new ArrayList<User>();
			stmt.setString(1, name);
			stmt.setString(2, tel);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				User userI = new User(rs.getInt("user_id"),rs.getString("user_name"),rs.getString("telephone"),rs.getString("password"));
				list.add(userI);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<User> selectByIdAndTel(Integer id,String tel) {//idとtel
		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_BY_ID_AND_TEL)){
			List<User> list = new ArrayList<User>();
			stmt.setInt(1, id);
			stmt.setString(2, tel);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				User userI = new User(rs.getInt("user_id"),rs.getString("user_name"),rs.getString("telephone"),rs.getString("password"));
				list.add(userI);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<User> selectByIdAndName(Integer id,String name) {//idと名前
		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_BY_ID_AND_NAME)){
			List<User> list = new ArrayList<User>();
			stmt.setInt(1, id);
			stmt.setString(2, name);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				User userI = new User(rs.getInt("user_id"),rs.getString("user_name"),rs.getString("telephone"),rs.getString("password"));
				list.add(userI);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<User> selectById(Integer id) {//idだけ
		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_BY_ID)){
			List<User> list = new ArrayList<User>();
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				User userI = new User(rs.getInt("user_id"),rs.getString("user_name"),rs.getString("telephone"),rs.getString("password"));
				list.add(userI);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<User> selectByName(String name) {//nameだけ
		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_BY_NAME)){
			List<User> list = new ArrayList<User>();
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				User userI = new User(rs.getInt("user_id"),rs.getString("user_name"),rs.getString("telephone"),rs.getString("password"));
				list.add(userI);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<User> selectByTel(String tel) {//telだけ
		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_BY_TEL)){
			List<User> list = new ArrayList<User>();
			stmt.setString(1, tel);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				User userI = new User(rs.getInt("user_id"),rs.getString("user_name"),rs.getString("telephone"),rs.getString("password"));
				list.add(userI);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<User> selectComplete(Integer id,String name,String tel) {//全入力
		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_COMPLETE)){
			List<User> list = new ArrayList<User>();
			stmt.setString(1, tel);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				User userI = new User(rs.getInt("user_id"),rs.getString("user_name"),rs.getString("telephone"),rs.getString("password"));
				list.add(userI);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//登録
	
	public int insert(User user) {
		try (PreparedStatement stmt = con.prepareStatement(SQL_INSERT)) {
			stmt.setString(1, user.getUser_name());
			stmt.setString(2, user.getTelephone());
			stmt.setString(3, user.getPassword());

			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//更新
	public void update(Integer u_id, String name, String tel, String pass) {
		try (PreparedStatement stmt = con.prepareStatement(SQL_UPDATE)){
			stmt.setString(1, name);
			stmt.setString(2, tel);
			stmt.setString(3, pass);
			stmt.setInt(4, u_id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//削除
	public void delete(Integer id) {
		try (PreparedStatement stmt = con.prepareStatement(SQL_DELETE)){
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}	
}