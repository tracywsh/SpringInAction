package root;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Component
public class DBConnect {
	
	private final String driverClass = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://127.0.0.1:3306/test123";
	private final String userName = "root";
	private final String password = "landsea";
	
	private ComboPooledDataSource dataSource;
	
	public DBConnect(){
		try {
			initDataSource();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws Exception{
		if (dataSource == null){
			initDataSource();
		}
		return dataSource.getConnection();
	}
	
	private void initDataSource() throws Exception{
		dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(driverClass);
		dataSource.setJdbcUrl(url);
		dataSource.setUser(userName);
		dataSource.setPassword(password);
		dataSource.setMaxPoolSize(20);
		dataSource.setMinPoolSize(2);
	}

	public ComboPooledDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(ComboPooledDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
}
