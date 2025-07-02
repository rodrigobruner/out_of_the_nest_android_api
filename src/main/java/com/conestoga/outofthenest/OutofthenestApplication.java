package com.conestoga.outofthenest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.conestoga.outofthenest.mapper")
public class OutofthenestApplication {

	public static void main(String[] args) {
		SpringApplication.run(OutofthenestApplication.class, args);
	}

}
