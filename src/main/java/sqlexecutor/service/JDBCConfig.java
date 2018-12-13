package sqlexecutor.service;

import java.sql.DriverManager;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("sqlexecutor")
public class JDBCConfig {
	

	    @Bean
	    public DataSource mysqlDataSource() {
	        DriverManager dataSource = new DriverManager();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
	        dataSource.setUsername("guest_user");
	        dataSource.setPassword("guest_password");
	 
	        return dataSource;
	    }
	}
