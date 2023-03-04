package com.bank.exchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling  //по крону загружается в БД актуальный курс валют
public class ExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeApplication.class, args);

	}

}
