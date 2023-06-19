package com.kaly7dev.backendblogapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.kaly7dev.backendblogapp")
@ImportAutoConfiguration({FeignAutoConfiguration.class})
@EnableConfigurationProperties
public class BackendBlogAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendBlogAppApplication.class, args);
	}

}
