package practice.boot.service;

import org.springframework.stereotype.Component;

@Component
public class MessageProvider {

	public String giveMessage() {
		return "How are you doing ???";
	}
}
