package com.imaginea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author ishaks
 * 
 *         The Class Application launches the application with inbuilt tomcat
 *         starting at port 8080. The same class loads all the
 *         required @configuration for the application to run including
 *         connection to Mongo DB server as well.
 */
@SpringBootApplication
public class Application {
	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
