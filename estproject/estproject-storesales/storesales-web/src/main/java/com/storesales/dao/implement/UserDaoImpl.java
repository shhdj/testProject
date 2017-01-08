package com.storesales.dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.stereotype.Repository;

import com.storesales.dao.IUserDao;
import com.storesales.query.model.ItemInfoQuery;
import com.storesales.model.User;

@Repository
public class UserDaoImpl implements IUserDao {

//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	
	public void register(User user) {
		String sqlstr = "insert into user(uname,pwd) values(?,?)";
		Object[] params = new Object[]{user.getUserName(),user.getPassword()};
//		jdbcTemplate.update(sqlstr,params);
	}

	
	public User findUserByUserName(String name) {
		String sqlstr = "select id,uname,pwd from user where uname=?";
		final User user = new User();
//		jdbcTemplate.query(sqlstr, new Object[]{name}, new RowCallbackHandler() {
//
//			public void processRow(ResultSet rs) throws SQLException {
//				user.setId(rs.getInt("id"));
//				user.setUserName(rs.getString("uname"));
//				user.setPassword(rs.getString("pwd"));
//			}
//		});
		return user;
	}
	
	public <T> List<T> getResultList(Class<T> clz,String sql){
//		List<ItemInfoQuery> iilist = jdbcTemplate.query(sql, new BeanPropertyRowMapper(clz));
//		return jdbcTemplate.queryForList(sql, clz);
		return new ArrayList<T>();
	}

}
