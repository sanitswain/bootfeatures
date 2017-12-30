package practice.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	private MessageProvider msgProvider;

	@Autowired
	public MyService(MessageProvider msgProvider) {
		this.msgProvider = msgProvider;
	}

	public String invokeService() {
		return msgProvider.giveMessage();
	}

	public MessageProvider msgProvider() {
		return new MessageProvider();
	}
}
