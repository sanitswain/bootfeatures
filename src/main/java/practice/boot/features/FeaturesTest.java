package practice.boot.features;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import practice.boot.features.ConfigurationPropertiesTest.Technology;

/**
 * This is just a runner class to execute spring boot features.
 */
@Component
@Configuration
public class FeaturesTest implements ApplicationRunner {

	@Autowired
	private ConfigurationPropertiesTest config;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(config);
		System.out.println("\n==>> technology" + technology());
	}

	/*
	 * ConfigurationProperties object can be used as @Autowired or as @Bean
	 */
	@Bean
	@ConfigurationProperties(prefix = "project.technology")
	public Technology technology() {
		return new Technology();
	}

}
