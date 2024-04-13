package com.tni.edu.sample.DemoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);
	}

}


//=================
//ImplicitNamingStrategyиспользуется, когда явно не указывается имя базы данных, имя таблицы, имя столбца в определении сущности. Т.е. когда не используется аннотация @Table или если есть аннотация @Column, но свойство name не задано.
//
//PhysicalNamingStrategyстратегия вступае в работу, когда явно задано имя БД, имя таблицы, имя столбца, например @Column(name = "camelCase"). Вот тогда Hibernate уже будет работать со значением параметра name.
//
//Задаются свойства в application.properties:


//spring.jpa.hibernate.naming.implicit-strategy=org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy
//spring.jpa.hibernate.naming.physical-strategy=org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy

//==========
//org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy
// which has been deprecated since Spring Boot 2.6 and removed in Spring Boot 3 in favor of the CamelCaseToUnderscoresNamingStrategy.
// See here: https://docs.spring.io/spring-boot/docs/2.7.1/api/index.html?org/springframework/boot/orm/jpa/hibernate/SpringPhysicalNamingStrategy.html