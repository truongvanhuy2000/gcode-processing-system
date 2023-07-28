package com.huy.gcodeWebsite;

import com.huy.gcodeWebsite.Service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GcodeWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(GcodeWebsiteApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService){
		return runner -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

}
