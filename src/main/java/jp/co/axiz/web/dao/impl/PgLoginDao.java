
package jp.co.axiz.web.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.entity.Login;

@Repository
public class PgLoginDao {
	private Connection con;
	private static final String SQL_SELECT_ID_AND_PASS ="SELECT"
			+ " admin_id,"
			+ " admin_name,"
			+ " password"
			+ " FROM"
			+ " admin"
			+ " WHERE"
			+ " admin_id = ?"
			+ " AND"
			+ " password = ?";
	
	private static final String SQL_SELECT_ALL=" SELECT"
			+" *"
			+" FROM"
			+" admin";
	
	@SuppressWarnings("unused")
	@Autowired
    private JdbcTemplate jdbcTemplate;

	public PgLoginDao(Connection con){
		this.con=con;
	}

	//DBからidとpassを探すメソッド
	public Login findByIdAndPass(String admin_id, String password) {
		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ID_AND_PASS)){
			stmt.setString(1, admin_id);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				return new Login(rs.getString("admin_id"),rs.getString("admin_name"),rs.getString("password"));
			}else{
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Login> findAll() {
		List<Login> list = new ArrayList<Login>();

		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ALL)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Login u = new Login(rs.getString("admin_id"), rs.getString("admin_name"), rs.getString("password"));
				list.add(u);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

}