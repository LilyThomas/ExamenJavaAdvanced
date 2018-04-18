package edu.ap.spring;

import edu.ap.spring.view.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EightBallApplication {
	@Autowired
	UI ui;

	@Bean
	CommandLineRunner runOnStartup() { return (args) -> {ui.setupUI();};}

	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return (args) -> {};
    }

	public static void main(String[] args) {
		new SpringApplicationBuilder(EightBallApplication.class).headless(false).run(args);
	}
}