package com.srini.programing.springmongodb;

import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongock
public class SpringMongodbApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringMongodbApplication.class, args);
	}

}
