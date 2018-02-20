package practice.boot.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty("enable.transaction.test")
public class TransactionTest implements ApplicationRunner {

	@Autowired
	private ApplicationContext ctx;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		CustomerService custService = ctx.getBean(CustomerService.class);
		Customer c = new Customer();
		c.setCid(109);
		c.setCname("Vijay");

		Address addr = new Address("Orissa", "India");
		c.setAddress(addr);

		custService.addCustomer(c);
	}

}
