package jbr.springmvc.test;


import jbr.springmvc.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	
	private static final Logger log = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
     
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	    UserDao obj = (UserDao) context.getBean("UserDao");
	    
	    log.debug("Result : {}", obj.getList("1"));
	    log.debug("Result : {}", obj.getList("1"));
	    //log.debug("Result : {}", obj.getList("dummy"));
	    

	    ((ConfigurableApplicationContext)context).close();
	    
	}
}