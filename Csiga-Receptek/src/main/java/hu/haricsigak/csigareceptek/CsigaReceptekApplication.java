package hu.haricsigak.csigareceptek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CsigaReceptekApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsigaReceptekApplication.class, args);
	}

}
