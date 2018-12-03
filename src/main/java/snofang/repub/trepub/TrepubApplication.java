package snofang.repub.trepub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EntityScan("snofang.repub.trepub.entity")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class TrepubApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrepubApplication.class, args);
	}
}
