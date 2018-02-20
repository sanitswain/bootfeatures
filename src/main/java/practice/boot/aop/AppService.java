package practice.boot.aop;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service("appService")
public class AppService {

	public void showOpenTickets() {
		System.out.println("Displaying open jira tickets");
	}

	public void showThreadDump() {
		System.out.println("Displaying thread dumps");
	}

	public void setPerson(String person) {
		System.out.println("setting person: " + person);
	}

	public UUID createUUID() {
		return UUID.randomUUID();
	}

	public void throwException() {
		throw new RuntimeException();
	}

	public double getLowestInterestRate() {
		return 9.3;
	}

	@Loggable
	public void sendMessage(String message) {
		System.out.printf("message '%s' is sent\n", message);
	}
}
