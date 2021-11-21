package Reto4;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

    
@SpringBootApplication

@EnableConfigurationProperties
@EntityScan(basePackages = {"Reto4.Entidades"})
public class Reto4RentCaroApplication {

	public static void main(String[] args) {
		SpringApplication.run(Reto4RentCaroApplication.class, args);
	}
}
