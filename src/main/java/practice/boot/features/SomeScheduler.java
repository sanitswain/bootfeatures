package practice.boot.features;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SomeScheduler {

	@Scheduled(cron = "0 0 0/1 * * ?")
	public void print() {
		System.out.println("====>> print method()...");
	}
}
