package com.shinhan.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
 *  * 
 * @EntityScan("com.shinhan")
 * 
 * 
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.shinhan"})
@EnableJpaRepositories({"com.shinhan"})
public class SpringBootPjtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPjtApplication.class, args);
	}
}
