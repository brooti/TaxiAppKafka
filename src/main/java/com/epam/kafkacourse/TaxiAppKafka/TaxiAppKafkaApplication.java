package com.epam.kafkacourse.TaxiAppKafka;

import com.epam.kafkacourse.TaxiAppKafka.service.TaxiConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaxiAppKafkaApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaxiAppKafkaApplication.class, args);
	}
}
