package br.com.amadeus.marketplace;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MarketplaceApplication {

	public static final Logger LOGGER = LogManager.getLogger(MarketplaceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MarketplaceApplication.class, args);
	}

}
