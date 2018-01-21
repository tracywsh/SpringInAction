package config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages={"root"},
          excludeFilters={@Filter(type=FilterType.ANNOTATION, 
          value=EnableWebMvc.class)})
public class RootConfig {
	
	@Bean
	public DataSource dataSource(){
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
			dataSource.setUser("root");
			dataSource.setPassword("landsea");
			dataSource.setMaxPoolSize(100);
			dataSource.setMinPoolSize(20);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	
//	@Bean
//	public JdbcTemplate jdbcTemplate(DataSource dataSource){
//		return new JdbcTemplate(dataSource);
//	}
	
	@Bean
	public NamedParameterJdbcTemplate namedJdbcTemplate(DataSource dataSource){
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
}
