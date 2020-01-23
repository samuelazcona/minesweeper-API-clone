package com.samuel.minesweeper;

import com.samuel.minesweeper.config.SpringFoxConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MinesweeperApplication{

	public static void main(String[] args) {
		SpringApplication.run(MinesweeperApplication.class, args);
	}
}
