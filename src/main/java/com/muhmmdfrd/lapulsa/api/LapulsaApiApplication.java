package com.muhmmdfrd.lapulsa.api;

import com.muhmmdfrd.lapulsa.api.security.JwtAuthenticationFilter;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.convert.Jsr310Converters;

import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = { LapulsaApiApplication.class, Jsr310Converters.class })
public class LapulsaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LapulsaApiApplication.class, args);
	}

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
