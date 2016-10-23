package com.websystique.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.User;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository{

	
	private JdbcTemplate jdbcTemplate;
 
    public UserRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

//	 public DataSource getDataSource() {
//	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//	        dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
//	        dataSource.setUsername("root");
//	        dataSource.setPassword("P@ssw0rd");
//	         
//	        return dataSource;
//    }
	 
	 public List<User> findAllUsers(){
		 String sql = "SELECT * FROM user";
		
		return  jdbcTemplate.query(sql, 
			new RowMapper() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
	            user.setId(rs.getInt("id"));
	            user.setUsername(rs.getString("name"));
	            user.setEmail(rs.getString("email"));
	            user.setAddress(rs.getString("address"));
	            return user;
			}
			}
		);
	 }
	 
	 public User findById(long id) {
			
			String sql = "SELECT * FROM user WHERE id=" + id;
			
			return (User) jdbcTemplate.query(sql, new ResultSetExtractor() {

				@Override
				public User extractData(ResultSet rs) throws SQLException,
						DataAccessException {
					if (rs.next()) {
						User user = new User();
						user.setId(rs.getInt("id"));
						user.setUsername(rs.getString("name"));
						user.setEmail(rs.getString("email"));
						user.setAddress(rs.getString("address"));
						return user;
					}
					return null;
				}
				
			});
		}
		
	 
	 @Override
	public int saveUser(User user) {
		 // insert
        String sql = "INSERT INTO user (name, email, address )"
                    + " VALUES ( ?, ?, ?)";
        return jdbcTemplate.update(sql, new Object[]{ user.getUsername(), user.getEmail(), user.getAddress()});
	}
	 
	 @Override
	public int updateUser(User user) {
		// update
		String sql = "UPDATE user SET name=?, email=?, address=? WHERE id=?";
		return jdbcTemplate.update(sql, new Object[]{user.getUsername(), user.getEmail(), user.getAddress(),user.getId()});
	}
	 
	 @Override
	public int deleteUserById(long id) {
		 String sql = "DELETE FROM user WHERE id=?";
		 return jdbcTemplate.update(sql, new Object[]{id});
	}
	 
	 @Override
	public int deleteAllUser() {
		 String sql = "DELETE FROM user WHERE";
		 return jdbcTemplate.update(sql);
	}

	 @Override
	public User findByName(String username) {
		 String sql = "SELECT * FROM user WHERE name=?";
		 return (User) jdbcTemplate.query(sql, new Object[]{username}, new ResultSetExtractor() {

				@Override
				public User extractData(ResultSet rs) throws SQLException,
						DataAccessException {
					if (rs.next()) {
						User user = new User();
						user.setId(rs.getInt("id"));
						user.setUsername(rs.getString("name"));
						user.setEmail(rs.getString("email"));
						user.setAddress(rs.getString("address"));
						return user;
					}
					return null;
				}
				
			});
	}
	
}
