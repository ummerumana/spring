package com.users.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}
}


//to run

//docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=customerdocker -d mysql:8

//docker build . -t spring-mysql-docker

//docker run -p 8086:8086 --name spring-mysql-docker --link mysql-standalone -d spring-mysql-docker

//docker logs mysql-standalone

//docker logs spring-mysql-docker

