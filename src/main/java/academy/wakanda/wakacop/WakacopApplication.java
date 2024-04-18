package academy.wakanda.wakacop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RequestMapping("/")
@RestController
public class WakacopApplication {

	public static void main(String[] args) {
		SpringApplication.run(WakacopApplication.class, args);
	}

}
