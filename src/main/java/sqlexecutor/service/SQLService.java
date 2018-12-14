package sqlexecutor.service;

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
	ArrayList<String> noEmptyIndexes = new ArrayList<>();
	
	for(String sqlStatement : tokenizedSQL) {
		if(!sqlStatement.isEmpty() ) {
			noEmptyIndexes.add(sqlStatement);
		/*	for(char ch : sqlStatement.toCharArray() )
					System.out.println(Integer.toHexString(ch));*/
		}
		//System.out.println("***************");
	}
	
	for(String nonEmptyString : noEmptyIndexes) {
		System.out.println(nonEmptyString);
	}
		
	ApplicationContext context = 
    		new ClassPathXmlApplicationContext("Spring-TextArea.xml");
    JdbcTextAreaDAO textAreaDAO = (JdbcTextAreaDAO) context.getBean("TextAreaDAO"); 
    /*Customer customer = new Customer(1, "mkyong",28);
    customerDAO.insert(customer);
	
    Customer customer1 = customerDAO.findByCustomerId(1);*/
    //System.out.println(customer1);
    return "";
	}

}
