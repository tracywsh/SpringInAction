package root;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Component;

import entity.Action;
import entity.Spitter;

@Component
public class Dao {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private NamedParameterJdbcOperations jdbcOperations;
	
	public static final String INSERT_SQL = "insert into sys_user(username,password) "
			+ "values(:username, :password)";
	
	public void add(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("username", "admin");
		map.put("password", "123123");
		jdbcOperations.update(INSERT_SQL,map);
	}
	
	public void get(){
//		jdbcOperations.queryForObject("select * from sys_user", new RowMapper<Spitter>(){
//
//			@Override
//			public Spitter mapRow(ResultSet arg0, int arg1) throws SQLException {
//				System.out.println(arg0.getString("username"));
//				System.out.println(arg0.getString("password"));
//				return new Spitter();
//			}
//
//		});
	}
	
	public void addTest(){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(INSERT_SQL);
			stmt.setString(1, "w");
			stmt.setString(2, "1");
			stmt.execute();
		}catch(SQLException es){
			es.printStackTrace();
		}finally{
			try{
				if (stmt != null){
					stmt.close();
				}
				if (conn != null){
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	@Action(name="asdf")
	public void addAnnotation(){}
	
}
