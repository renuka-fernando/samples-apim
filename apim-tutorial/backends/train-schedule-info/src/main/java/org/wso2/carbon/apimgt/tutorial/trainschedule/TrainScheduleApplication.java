package org.wso2.carbon.apimgt.tutorial.trainschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TrainScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainScheduleApplication.class, args);
	}

	@PostConstruct
	public void setProperty() {
		System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
	}
}
