package com.fendo.mybatis.plus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@SpringBootApplication
public class MybatisPlusApplication{

	public static void main(String[] args) {
		SpringApplication.run(MybatisPlusApplication.class, args);
	}
}
