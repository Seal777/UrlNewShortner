package com.UrlShort.Url;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.UrlShort.Url.repo.UrlRepository;
//@ComponentScan({"UrlController","UrlRepository"})
//@ComponentScan
//@Configuration
//@ComponentScan(basePackages="com.UrlShort.Url")
//@EnableAutoConfiguration
//@EnableJpaRepositories
//@EnableJpaRepositories(UrlRepository.class)

//@SpringBootApplication(scanBasePackages="com.UrlShort.Url")
@SpringBootApplication
public class UrlApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlApplication.class, args);
	}

}
