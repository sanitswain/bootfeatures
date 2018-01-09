package practice.boot.features;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

/**
 * ApplicationArguments is used to access the application arguments that were
 * passed to run the application. It provides access to both the raw String[]
 * arguments as well as parsed option and non-option arguments.
 * 
 */
@Component
public class LogApplicationArgs {

	@Autowired
	public LogApplicationArgs(ApplicationArguments args) {
		System.out.println("==>  getNonOptionArgs:" + args.getNonOptionArgs());
		System.out.println("==>  getOptionNames:" + args.getOptionNames());
	}
}
