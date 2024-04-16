package com.starwars.starwars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestStarwarsApplication {

	public static void main(String[] args) {
		SpringApplication.from(StarwarsApplication::main).with(TestStarwarsApplication.class).run(args);
	}

}
