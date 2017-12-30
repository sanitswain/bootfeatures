package practice.boot.features;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

/**
 * @author Sanit
 *
 *         To see what are the arguments passed while running the application
 */
@Component
public class LogApplicationArgs {

	@Autowired
	public LogApplicationArgs(ApplicationArguments args) {
		System.out.println("==>  getNonOptionArgs:" + args.getNonOptionArgs());
		System.out.println("==>  getOptionNames:" + args.getOptionNames());
	}
}
