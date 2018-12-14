package sqlexecutor.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch.qos.logback.core.net.SyslogOutputStream;
import sqlexecutor.model.JdbcTextAreaDAO;
import sqlexecutor.model.TextAreaDAO;

public class SQLService {
	
	public static String submitToDatabase(String sql) {
	String[] tokenizedSQL = sql.split("[\r\n]");
	/*for(String s : tokenizedSQL) {
		System.out.println(s);
	}*/
	ArrayList<String> removeEmptyIndexes = new ArrayList<>();
	
	for(String sqlStatement : tokenizedSQL) {
		if(!sqlStatement.isEmpty() ) {
			removeEmptyIndexes.add(sqlStatement);
		/*	for(char ch : sqlStatement.toCharArray() )
					System.out.println(Integer.toHexString(ch));*/
		}
		//System.out.println("***************");
	}
	
	for(String nonEmptyString : removeEmptyIndexes) {
		System.out.println(nonEmptyString);
	}
		
	ApplicationContext context = 
    		new ClassPathXmlApplicationContext("Spring-TextArea.xml");
    JdbcTextAreaDAO textAreaDAO = (JdbcTextAreaDAO) context.getBean("TextAreaDAO"); 
    try {
		Connection conn = textAreaDAO.getDataSource().getConnection();
		Statement statement = conn.createStatement();
		for(String s : removeEmptyIndexes) {
		    statement.addBatch(s);
	    }
		statement.executeBatch();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
    /*Customer customer = new Customer(1, "mkyong",28);
    customerDAO.insert(customer);
	
    Customer customer1 = customerDAO.findByCustomerId(1);*/
    //System.out.println(customer1);
    return removeEmptyIndexes.toString();
	}

}
