package WeathermapTest.com.weathermap;

import WeathermapTest.com.weathermap.dto.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WeathermapApplication {
	private static final Logger log = LoggerFactory.getLogger(WeathermapApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(WeathermapApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					"http://api.openweathermap.org/data/2.5/weather?lat=-23.660715&lon=-46.459848&appid=47f59783c036e3bf14b789641e463eaa", Quote.class);
			log.info(quote.toString());
		};
	}

}
