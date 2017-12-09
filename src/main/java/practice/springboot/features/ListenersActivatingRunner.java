package practice.springboot.features;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Sanit
 *
 *         ApplicationRunner / CommandLineRunner is used to run specific task
 *         right after SpringApplication is started. This is same as task is
 *         called before run() method completes. The difference between
 *         ApplicationRunner and CommandLineRunner is the way it receives the
 *         arguments passed to start boot application. CommandLineRunner
 *         receives arguments as simple string array where as ApplicationRunner
 *         receives ApplicationArguments object it self. We can also use @Order
 *         to define their order of running.
 */
@Component
@Order(2)
public class ListenersActivatingRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("==> Activating all listeners...");
	}

}
