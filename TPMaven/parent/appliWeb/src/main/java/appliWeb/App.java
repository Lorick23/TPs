package appliWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class App {
	public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication(App.class);
		// ... customize application settings here
		application.run(args);
	}
}
