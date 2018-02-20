package practice.boot.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty("enable.aop.test")
public class AOPTest implements ApplicationRunner {

	@Autowired
	private ApplicationContext ctx;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		AppService appService = ctx.getBean("appService", AppService.class);
		// appService.showOpenTickets();
		// appService.showThreadDump();
		// appService.setPerson(new Person());
		// appService.createUUID();
		// appService.throwException();
		appService.getLowestInterestRate();
		appService.sendMessage("you r a**hole");
	}

}
